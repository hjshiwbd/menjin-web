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

	@ResponseBody
	@RequestMapping("/save_shouquan")
	public String saveShouquan(String json) throws Exception {
		return menjinService.saveShouquan(json);
	}

	/**
	 * 设置页面
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/shezhi")
	public ModelAndView shezhi() throws Exception {
		return menjinService.showShezhi();
	}

	/**
	 * 远程控制
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/yckz")
	public ModelAndView yckz() throws Exception {
		return menjinService.showYckz();
	}

	@ResponseBody
	@RequestMapping("/raeder/qiyong")
	public String qiyong(String readerid) throws Exception {
		return menjinService.readerControl(readerid, 1);
	}

	@ResponseBody
	@RequestMapping("/raeder/sjjs")
	public String sjjs(String readerid) throws Exception {
		return menjinService.readerControl(readerid, 2);
	}

	@ResponseBody
	@RequestMapping("/raeder/jiesuo")
	public String jiesuo(String readerid) throws Exception {
		return menjinService.readerControl(readerid, 3);
	}

	@ResponseBody
	@RequestMapping("/raeder/suo")
	public String suo(String readerid) throws Exception {
		return menjinService.readerControl(readerid, 4);
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
