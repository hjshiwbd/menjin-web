package org.shinomin.menjin.menjin.controller;

import org.shinomin.menjin.bean.EmpBean;
import org.shinomin.menjin.menjin.service.IMenjinService;
import org.shinomin.menjin.qqrz.service.IQqrzService;
import org.shinomin.menjin.spring.request.RequestScope;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/menjin")
public class MenjinController {
	@Autowired
	private RequestScope requestScope;
	@Autowired
	private IQqrzService qqrzService;
	@Autowired
	private IMenjinService menjinService;

	/**
	 * 授权页面
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/shouquan")
	public ModelAndView shouquan() throws Exception {
		return menjinService.showShouquan();
	}

	@ResponseBody
	@RequestMapping("/query_hw_person_dg")
	public String queryHwPersonDg(Integer page, Integer rows, EmpBean emp) throws Exception {
		return menjinService.queryHwPersonEudg(page, rows, emp);
	}

	/**
	 * 设置页面
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/shezhi")
	public ModelAndView shezhi() throws Exception {
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
	public ModelAndView yckz() throws Exception {
		ModelAndView model = new ModelAndView();

		model.setViewName("menjin/menjin_yckz");
		return model;
	}

	/**
	 * 查询人员访问码
	 * 
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping("/person_acccode")
	public String personAcccode(EmpBean emp) throws Exception {
		return menjinService.queryPersonAcccode(emp);
	}
}
