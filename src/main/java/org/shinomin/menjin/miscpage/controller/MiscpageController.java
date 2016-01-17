package org.shinomin.menjin.miscpage.controller;

import org.shinomin.menjin.spring.session.LoginSessionScope;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("")
public class MiscpageController
{
	@Autowired
	private LoginSessionScope loginSessionScope;

	@RequestMapping("/index")
	public ModelAndView index() throws Exception
	{
		ModelAndView model = new ModelAndView();

		model.setViewName("index");
		return model;
	}

	@RequestMapping("/left")
	public ModelAndView left() throws Exception
	{
		ModelAndView model = new ModelAndView();
		if (loginSessionScope.getMenuid1() != null)
		{
			// 设置到页面
			model.addObject("menu1", loginSessionScope.getMenuid1());
			model.addObject("menu2", loginSessionScope.getMenuid2());
			// 清除
			loginSessionScope.setMenuid1(null);
			loginSessionScope.setMenuid2(null);
		}
		model.setViewName("common/left");
		return model;
	}

}
