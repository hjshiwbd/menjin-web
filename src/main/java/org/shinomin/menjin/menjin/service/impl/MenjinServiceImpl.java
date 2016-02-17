package org.shinomin.menjin.menjin.service.impl;

import java.util.List;

import org.shinomin.commons.bean.ExecuteResult;
import org.shinomin.commons.db.mybatis.Pager;
import org.shinomin.commons.utils.JsonUtil;
import org.shinomin.commons.utils.StringUtil;
import org.shinomin.commons.web.util.PageUtil;
import org.shinomin.menjin.bean.EmpBean;
import org.shinomin.menjin.bean.HwAcccodeBean;
import org.shinomin.menjin.bean.HwPersonBean;
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
		// if (person.getFname() == null) {
		// List<HwPersonBean> persons = WsQuery.getAllPersons();
		// return EasyuiUtil.parseDatagrid(persons);
		// } else {
		// List<HwPersonBean> psersons = WsQuery.queryPersons(person);
		//
		// return "";
		// }

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
					StringUtil.null2Empty(emp.getEmpcardno()));
			if (acccodeList != null) {
				e.setResult("1");
				e.setMessage("ok");
				e.setObject(acccodeList);
			}
		}
		return JsonUtil.toJson(e);
	}
}
