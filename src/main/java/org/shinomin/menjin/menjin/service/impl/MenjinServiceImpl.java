package org.shinomin.menjin.menjin.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.shinomin.commons.bean.ExecuteResult;
import org.shinomin.commons.db.mybatis.Pager;
import org.shinomin.commons.utils.JsonUtil;
import org.shinomin.commons.utils.StringUtil;
import org.shinomin.commons.web.util.PageUtil;
import org.shinomin.menjin.author.service.IAuthorsetService;
import org.shinomin.menjin.bean.AuthorsetBean;
import org.shinomin.menjin.bean.CardaccodeBean;
import org.shinomin.menjin.bean.EmpBean;
import org.shinomin.menjin.bean.HwAcccodeBean;
import org.shinomin.menjin.bean.HwPersonBean;
import org.shinomin.menjin.bean.HwReaderBean;
import org.shinomin.menjin.card.service.ICardaccodeService;
import org.shinomin.menjin.constant.ErrorConstant;
import org.shinomin.menjin.emp.service.IEmpService;
import org.shinomin.menjin.menjin.service.IMenjinService;
import org.shinomin.menjin.webservice.WsQuery;
import org.shinomin.menjin.xtkz.controller.EasyuiUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

@Service
public class MenjinServiceImpl implements IMenjinService {
	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private IEmpService empService;
	@Autowired
	private ICardaccodeService cardaccodeService;
	@Autowired
	private IAuthorsetService authorsetService;

	@Override
	public ModelAndView showShouquan() {
		ModelAndView model = new ModelAndView();

		List<HwAcccodeBean> acccodeBeans = WsQuery.getAllACCodes("", "");
		model.addObject("acccodeList", acccodeBeans);
		model.addObject("json_script", PageUtil.create_SCRIPT_PARSE_JSON(model.getModelMap()));

		model.setViewName("menjin/menjin_shouquan");
		return model;
	}

	@Override
	public String queryHwPersonEudg(Integer page, Integer rows, EmpBean emp) {
		logger.info("emp:{}", JsonUtil.toJson(emp));

		emp.setIsdeleted("N");
		Pager<EmpBean> pager = new Pager<>();
		pager.setCurtPage(page);
		pager.setCountPerPage(rows);
		empService.selectPage(emp, pager);

		return EasyuiUtil.parseDatagrid(pager);
	}

	@Override
	public String queryPersonAcccode(EmpBean emp) {
		logger.info("emp:{}", JsonUtil.toJson(emp));
		ExecuteResult e = new ExecuteResult("0", ErrorConstant.WS_NO_RESULT_FOUND);
		List<HwPersonBean> personList = WsQuery.queryPersons("LNAME", "=", emp.getEmpno());
		if (personList != null && personList.size() == 1) {
			List<HwAcccodeBean> acccodeList = WsQuery.getAllACCodes(personList.get(0).getId(),
					StringUtil.null2Empty(emp.getEmpcardno().trim()));
			if (acccodeList != null) {
				e.setResult("1");
				e.setMessage("ok");
				e.setObject(acccodeList);
			}
		}
		return JsonUtil.toJson(e);
	}

	@Override
	public ModelAndView showYckz() {
		ModelAndView model = new ModelAndView();

		List<HwReaderBean> readers = WsQuery.getAllReaders("");
		model.addObject("readers", readers);
		model.addObject("json_script", PageUtil.create_SCRIPT_PARSE_JSON(model.getModelMap()));

		model.setViewName("menjin/menjin_yckz");
		return model;
	}

	@SuppressWarnings("unchecked")
	@Override
	public String saveShouquan(String json) {
		logger.info("json:{}", json);
		ExecuteResult e = new ExecuteResult("0", "设置失败，请稍候再试");

		Map<String, Object> map = (Map<String, Object>) JsonUtil.toObj(json);
		List<String> cards = (List<String>) map.get("cards");// 卡
		List<String> accodeIds = (List<String>) map.get("accodeIds");// 访问码

		if (cards.size() == 0) {
			e.setMessage("请求参数有误");
			return JsonUtil.toJson(e);
		}

		// 移除老的绑定
		for (String cardno : cards) {
			List<HwAcccodeBean> acccodeBeans = WsQuery.getAllACCodes("", cardno);
			for (HwAcccodeBean hwAcccodeBean : acccodeBeans) {
				logger.debug("removeACCodeFromCard,cardid:{}, accodeid:{}", cardno, hwAcccodeBean.getId());
				WsQuery.removeACCodeFromCard(cardno, hwAcccodeBean.getId());
			}
			e.setResult("1");
			e.setMessage("设置成功");
		}

		if (accodeIds.size() > 0) {
			e.setResult("0");
			e.setMessage("设置失败，请稍候再试");

			int addCount = 0;
			// 新的绑定
			for (String cardno : cards) {
				for (String accodeid : accodeIds) {
					logger.debug("new bind,cardid:{}, accodeid:{}", cardno, accodeid);
					if (WsQuery.addACCodeToCard(cardno, accodeid)) {
						// 记录c3数据库1
						CardaccodeBean ca = new CardaccodeBean();
						ca.setCardno(cardno);
						ca.setAccodeid(accodeid);
						addCount += cardaccodeService.insert(ca);

						// 记录c3数据库2
						saveToDb2(cardno, accodeid);
					}
				}
			}
			if (cards.size() * accodeIds.size() == addCount) {
				e.setResult("1");
				e.setMessage("设置成功");
			}
		}
		return JsonUtil.toJson(e);
	}

	private void saveToDb2(String cardno, String accodeid) {
		AuthorsetBean authorset = new AuthorsetBean();
		authorset.setCardid(cardno);
		authorset.setDoorid(accodeid);
		authorset.setPassword("0000");
		authorset.setDuedate("2099-10-31 00:00:00.000");
		authorset.setAuthortype("0");
		authorset.setAuthorstatus("0");
		authorset.setUsertimegrp("0");
		authorset.setDownloaded("1");
		authorset.setFirstdownloaded("1");
		logger.debug("save authorset:{}", JsonUtil.toJson(authorset));
		authorsetService.insert(authorset);
	}

	@Override
	public String readerControl(String readerid, int cmd) {
		logger.info("reader:{}, cmd:{}", readerid, cmd);
		ExecuteResult e = new ExecuteResult("0", "请求有误");
		if (StringUtils.isNotBlank(readerid) && cmd >= 1 && cmd <= 4) {
			if (WsQuery.readerControl(readerid, cmd)) {
				e.setResult("1");
				e.setMessage("操作成功");
			} else {
				e.setMessage("操作失败");
			}
		}
		return JsonUtil.toJson(e);
	}
}
