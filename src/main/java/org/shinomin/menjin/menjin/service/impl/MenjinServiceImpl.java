package org.shinomin.menjin.menjin.service.impl;

import java.util.List;

import org.shinomin.menjin.bean.HwPersonBean;
import org.shinomin.menjin.menjin.service.IMenjinService;
import org.shinomin.menjin.webservice.WsQuery;
import org.shinomin.menjin.xtkz.controller.EasyuiUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

@Service
public class MenjinServiceImpl implements IMenjinService {
	private Logger logger = LoggerFactory.getLogger(getClass());

	@Override
	public ModelAndView showShouquan() {
		ModelAndView model = new ModelAndView();
		model.setViewName("menjin/menjin_shouquan");
		return model;
	}

	@Override
	public String queryHwPersonEudg(Integer page, Integer rows, HwPersonBean person) {
		if (person == null) {
			List<HwPersonBean> persons = WsQuery.getAllPersons();
			return EasyuiUtil.parseDatagrid(persons);
		} else {
			List<HwPersonBean> psersons = WsQuery.queryPersons(person);
			

			return "";
		}

	}

}
