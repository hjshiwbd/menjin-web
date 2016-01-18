package org.shinomin.menjin.kapian;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/kapian")
public class KapianController
{
	/**
	 * 卡片新增
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/xinzeng")
	public ModelAndView xinzeng() throws Exception
	{
		ModelAndView model = new ModelAndView();

		model.setViewName("kapian/kapian_xinzeng");
		return model;
	}

	/**
	 * 卡片修改
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/guanli")
	public ModelAndView xiugai() throws Exception
	{
		ModelAndView model = new ModelAndView();

		model.setViewName("kapian/kapian_guanli");
		return model;
	}

}
