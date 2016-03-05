package org.shinomin.menjin.menjin.controller;

import org.shinomin.menjin.bean.EmpBean;
import org.shinomin.menjin.bean.HwpaeventBean;
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

	/**
	 * 事件显示
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/event")
	public ModelAndView event() throws Exception {
		ModelAndView model = new ModelAndView();
		model.setViewName("menjin/menjin_event");
		return model;
	}

	/**
	 * 事件dg
	 * 
	 * @param page
	 * @param rows
	 * @param event
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping("/event_list_eu")
	public String eventListEu(Integer page, Integer rows, HwpaeventBean event) throws Exception {
		return menjinService.eventListEu(page, rows, event);
	}

	/**
	 * 显示历史事件
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/history_event")
	public ModelAndView historyEvent() throws Exception {
		ModelAndView model = new ModelAndView();
		model.setViewName("menjin/menjin_history_event");
		return model;
	}

	/**
	 * 历史事件dg
	 * 
	 * @param beginDate
	 * @param endDate
	 * @param isTrigger
	 *            true为事件发生时间, false为事件接收时间
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping("/history_event_list_eu")
	public String historyEventListEu(String beginDate, String endDate, boolean isTrigger) throws Exception {
		return menjinService.historyEventListEu(beginDate, endDate, isTrigger);
	}

}
