package org.shinomin.menjin.dpt.controller;

import org.shinomin.menjin.bean.DptBean;
import org.shinomin.menjin.dpt.service.IDptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * 
 * @author huangjin
 * @cratedate 2016-02-21 17:11:21
 * 
 */
@Controller
@RequestMapping("/dpt")
public class DptController {
	@Autowired
	private IDptService dptService;

	@RequestMapping("/list")
	public ModelAndView list() throws Exception {
		ModelAndView model = new ModelAndView();

		model.setViewName("dpt/dpt_list");
		return model;
	}

	@ResponseBody
	@RequestMapping("/list_eu")
	public String listEu(Integer page, Integer rows, DptBean dpt) throws Exception {
		return dptService.listEu(page, rows, dpt);
	}
}
