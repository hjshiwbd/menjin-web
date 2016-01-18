package org.shinomin.menjin.menjin.controller;

import org.shinomin.menjin.spring.request.RequestScope;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/menjin")
public class MenjinController
{
	private Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private RequestScope requestScope;

	/**
	 * 授权页面
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/shouquan")
	public ModelAndView shouquan() throws Exception
	{
		ModelAndView model = new ModelAndView();

		model.setViewName("menjin/menjin_shouquan");
		return model;
	}

	/**
	 * 设置页面
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/shezhi")
	public ModelAndView shezhi() throws Exception
	{
		ModelAndView model = new ModelAndView();

		model.setViewName("menjin/menjin_shezhi");
		return model;
	}

	/**
	 * 远程控制
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/yckz")
	public ModelAndView yckz() throws Exception
	{
		ModelAndView model = new ModelAndView();

		model.setViewName("menjin/menjin_yckz");
		return model;
	}
}
