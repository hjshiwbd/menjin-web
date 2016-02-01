package org.shinomin.menjin.menjin.service;

import org.shinomin.menjin.bean.HwPersonBean;
import org.springframework.web.servlet.ModelAndView;

public interface IMenjinService {

	ModelAndView showShouquan();

	/**
	 * hw人员查询,用于eudg
	 * 
	 * @param page
	 * @param rows
	 * @return
	 */
	String queryHwPersonEudg(Integer page, Integer rows, HwPersonBean person);

}
