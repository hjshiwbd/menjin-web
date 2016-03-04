package org.shinomin.menjin.emp.service.impl;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.shinomin.commons.bean.ExecuteResult;
import org.shinomin.commons.db.mybatis.Pager;
import org.shinomin.commons.utils.DateUtil;
import org.shinomin.commons.utils.JsonUtil;
import org.shinomin.commons.web.util.PageUtil;
import org.shinomin.menjin.bean.CardinfoBean;
import org.shinomin.menjin.bean.CardtypeBean;
import org.shinomin.menjin.bean.DptBean;
import org.shinomin.menjin.bean.EmpBean;
import org.shinomin.menjin.bean.EmpextBean;
import org.shinomin.menjin.bean.GrdBean;
import org.shinomin.menjin.bean.HwCardBean;
import org.shinomin.menjin.bean.HwPersonBean;
import org.shinomin.menjin.bean.PositionBean;
import org.shinomin.menjin.card.service.ICardinfoService;
import org.shinomin.menjin.card.service.ICardtypeService;
import org.shinomin.menjin.dpt.service.IDptService;
import org.shinomin.menjin.emp.dao.IEmpDAO;
import org.shinomin.menjin.emp.service.IEmpService;
import org.shinomin.menjin.emp.service.IEmpextService;
import org.shinomin.menjin.grd.service.IGrdService;
import org.shinomin.menjin.position.service.IPositionService;
import org.shinomin.menjin.spring.session.LoginSessionScope;
import org.shinomin.menjin.webservice.WsQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

/**
 * 
 * @author huangjin
 * @cratedate 2016-02-16 20:35:40
 * 
 */
@Service
public class EmpServiceImpl implements IEmpService {
	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private IEmpDAO empDAO;
	@Autowired
	private LoginSessionScope loginSessionScope;
	@Autowired
	private IDptService dptService;
	@Autowired
	private IPositionService positionService;
	@Autowired
	private ICardtypeService cardtypeService;
	@Autowired
	private IEmpextService empextService;
	@Autowired
	private ICardinfoService cardinfoService;
	@Autowired
	private IGrdService grdService;

	@Override
	public EmpBean selectOne(EmpBean emp) {
		return empDAO.selectOne(emp);
	}

	@Override
	public List<EmpBean> selectList(EmpBean emp) {
		return empDAO.selectList(emp);
	}

	@Override
	public Pager<EmpBean> selectPage(EmpBean emp, Pager<EmpBean> pager) {
		return empDAO.selectPage(emp, pager);
	}

	@Override
	public int insert(EmpBean emp) {
		return empDAO.insert(emp);
	}

	@Override
	public int update(EmpBean emp) {
		return empDAO.update(emp);
	}

	@Override
	public int delete(EmpBean emp) {
		return empDAO.delete(emp);
	}

	@Override
	public String doXinzeng(EmpBean emp, EmpextBean empext) throws Exception {
		logger.info("emp:{}, empext:{}", JsonUtil.toJson(emp), JsonUtil.toJson(empext));
		ExecuteResult e = new ExecuteResult();
		try {
			checkAddParam(emp);
		} catch (Exception ex) {
			e.setResult("0");
			e.setMessage(ex.getMessage());
			return JsonUtil.toJson(e);
		}

		int maxid = empDAO.selectMaxID();
		logger.info("maxid:{}", maxid);
		boolean flag = insertEmp(emp, empext, maxid);
		if (flag) {
			logger.info("add person to c3 finish");
			// 调用hw接口新增人员
			addToHw(emp);

			e.setResult("1");
			e.setMessage("添加成功");
		} else {
			e.setResult("0");
			e.setMessage("添加失败，请稍后重试");
		}
		return JsonUtil.toJson(e);
	}

	/**
	 * 记录c3的emp表
	 * 
	 * @param emp
	 * @param empext
	 * @param maxid
	 * @return
	 */
	private boolean insertEmp(EmpBean emp, EmpextBean empext, int maxid) {
		emp.setEmpid(maxid + "");
		emp.setEmpcrtdby(loginSessionScope.getLoginUser().getUsername());
		int n = insert(emp);
		if (n == 1) {
			logger.info("emp inserted");
			empext.setEmpid(maxid + "");
			// insert emp
			n = empextService.insert(empext);
			if (n == 1) {
				// insert card
				insertCard(emp);
				return true;
			}
		}
		return false;
	}

	private void insertCard(EmpBean emp) {
		CardinfoBean card = new CardinfoBean();
		card.setCardid(emp.getEmpid());
		card.setCardfixno(emp.getEmpcardno().trim());
		card.setCarddispno(emp.getEmpname());
		card.setCardcrtdby(loginSessionScope.getLoginUser().getUsername());
		card.setCardcrtdday(DateUtil.formatDate(new Date()));
		card.setCardmodiby(loginSessionScope.getLoginUser().getUsername());
		card.setCardmodiday(DateUtil.formatDate(new Date()));
		cardinfoService.insert(card);
	}

	/**
	 * 调用hw接口新增人员
	 * 
	 * @param emp
	 * @throws Exception
	 */
	private void addToHw(EmpBean emp) throws Exception {
		try {
			Date today = new Date();
			Date tenYearLater = new Date(today.getTime() + 10 * 365 * 24 * 60 * 60 * 1000);// 10年后

			HwPersonBean person = new HwPersonBean();
			person.setLname(emp.getEmpno());
			person.setFname(encode(emp.getEmpname()));
			person.setIssue_date(DateUtil.formatDate(today, "yyyy-MM-dd"));// 今天为生效时间
			person.setExpire_date(DateUtil.formatDate(tenYearLater, "yyyy-MM-dd"));// 10年为失效时间
			ExecuteResult e = WsQuery.addPerson(person, emp.getBadgeId());
			if (e.getResult().equals("0")) {
				logger.info("add person to hw finish");
				String personid = e.getObject().toString();
				HwCardBean card = new HwCardBean();
				card.setPersonid(personid);
				card.setCardno(emp.getEmpcardno().trim());
				card.setIssue_date(DateUtil.formatDate(today, "yyyy-MM-dd"));
				card.setExpire_date(DateUtil.formatDate(tenYearLater, "yyyy-MM-dd"));
				ExecuteResult cardex = WsQuery.addCard(card, "0x00488a1872d040a54a3882e897327e7955a0");
				if (!"0".equals(cardex.getResult())) {
					logger.error("hw卡号添加失败.请检查卡号是否重复");
					throw new Exception("hw卡号添加失败.请检查卡号是否重复");
				}
			} else {
				logger.info("add person to hw failed:{}", e.getMessage());
				throw new Exception("add person to hw failed");
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new Exception("门禁接口记录人员信息失败");
		}
	}

	private String encode(String empname) {
		try {
			return URLEncoder.encode(empname,"utf-8");
		} catch (UnsupportedEncodingException e) {
			return null;
		}
	}

	/**
	 * 新增时的参数检查
	 * 
	 * @param emp
	 * @throws Exception
	 */
	private void checkAddParam(EmpBean emp) throws Exception {
		if (StringUtils.isEmpty(emp.getEmpno())) {
			logger.info("empno is empty");
			throw new Exception("empno is empty");
		}
		if (StringUtils.isEmpty(emp.getEmpname())) {
			logger.info("empname is empty");
			throw new Exception("empname is empty");
		}

		// 检查唯一性 LNAME/empno唯一
		int n = empDAO.selectCount("hrms_emp", "where empno=?", emp.getEmpno());
		if (n > 0) {
			logger.info("empno already exists");
			throw new Exception("此员工编号已存在");
		}
	}

	@Override
	public ModelAndView showXinzeng() {
		ModelAndView model = new ModelAndView();

		// 部门
		DptBean dpt = new DptBean();
		List<DptBean> dptList = dptService.selectList(dpt);
		model.addObject("dptList", dptList);

		// 职务
		PositionBean position = new PositionBean();
		List<PositionBean> positionList = positionService.selectList(position);
		model.addObject("positionList", positionList);

		// 卡类型
		CardtypeBean cardtype = new CardtypeBean();
		List<CardtypeBean> cardtypeList = cardtypeService.selectList(cardtype);
		model.addObject("cardtypeList", cardtypeList);

		// 级别
		GrdBean grd = new GrdBean();
		List<GrdBean> grdList = grdService.selectList(grd);
		model.addObject("grdList", grdList);

		model.addObject("json_script", PageUtil.create_SCRIPT_PARSE_JSON(model.getModelMap()));
		model.setViewName("emp/emp_xinzeng");
		return model;
	}
}
