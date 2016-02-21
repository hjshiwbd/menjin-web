package org.shinomin.menjin.emp.controller;

import org.shinomin.menjin.bean.EmpBean;
import org.shinomin.menjin.bean.EmpextBean;
import org.shinomin.menjin.emp.service.IEmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * 
 * @author huangjin
 * @cratedate 2016-02-16 20:35:40
 * 
 */
@Controller
@RequestMapping("/emp")
public class EmpController {

	@Autowired
	private IEmpService empService;

	/**
	 * 显示人员新增
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/xinzeng")
	public ModelAndView xinzeng() throws Exception {
		return empService.showXinzeng();
	}

	/**
	 * 提交人员新增
	 * 
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping("/do_xinzeng")
	public String doXinzeng(EmpBean emp, EmpextBean empext) throws Exception {
		return empService.doXinzeng(emp, empext);
	}

	/**
	 * 人员修改
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/guanli")
	public ModelAndView xiugai() throws Exception {
		ModelAndView model = new ModelAndView();

		model.setViewName("emp/emp_guanli");
		return model;
	}

}
