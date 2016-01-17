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

	@RequestMapping("/shouquan")
	public ModelAndView shouquan() throws Exception
	{
		ModelAndView model = new ModelAndView();

		model.setViewName("menjin/menjin_shouquan");
		return model;
	}
}
