package org.shinomin.menjin.miscpage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("")
public class MiscpageController
{
	@RequestMapping("/index")
	public ModelAndView index() throws Exception
	{
		ModelAndView model = new ModelAndView();

		model.setViewName("index");
		return model;
	}

	@RequestMapping("/left")
	public ModelAndView left(String menuid) throws Exception
	{
		ModelAndView model = new ModelAndView();
		model.addObject("menuid", menuid);
		model.setViewName("common/left");
		return model;
	}

}
