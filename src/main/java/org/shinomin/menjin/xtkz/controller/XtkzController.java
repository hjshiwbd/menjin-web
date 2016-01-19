package org.shinomin.menjin.xtkz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 系统控制
 * 
 * @author hjin
 * 
 */
@Controller
@RequestMapping("/xtkz")
public class XtkzController
{

	/**
	 * 综合查询
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/zhcx")
	public ModelAndView zhcx() throws Exception
	{
		ModelAndView model = new ModelAndView();

		model.setViewName("xtkz/xtkz_zhcx");
		return model;
	}
}
