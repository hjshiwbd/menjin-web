package org.shinomin.menjin.menjin.service;

import java.util.List;

import org.shinomin.commons.bean.ExecuteResult;
import org.shinomin.menjin.bean.EmpBean;
import org.shinomin.menjin.bean.HwpaeventBean;
import org.springframework.web.servlet.ModelAndView;

public interface IMenjinService {

	/**
	 * 显示授权页面
	 * 
	 * @return
	 */
	ModelAndView showShouquan();

	/**
	 * hw人员查询,用于eudg
	 * 
	 * @param page
	 * @param rows
	 * @return
	 */
	String queryHwPersonEudg(Integer page, Integer rows, EmpBean emp);

	/**
	 * 查询人员的访问码
	 * 
	 * @param emp
	 * @return
	 */
	String queryPersonAcccode(EmpBean emp);

	/**
	 * 显示远程控制
	 * 
	 * @return
	 */
	ModelAndView showYckz();

	/**
	 * 保存授权
	 * 
	 * @param json
	 * @return
	 */
	String saveShouquan(String json) throws Exception;

	/**
	 * 读卡器控制
	 * 
	 * @param readerid
	 * @param cmd
	 *            (1:再启用, 2:瞬间解锁, 3:解锁, 4:锁)
	 * @return
	 */
	String readerControl(String readerid, int cmd);

	ModelAndView showShezhi();
	
	public ExecuteResult removeAccodeFromCard(List<String> cards);

	String eventListEu(Integer page, Integer rows, HwpaeventBean event);

	String historyEventListEu(String beginDate, String endDate, boolean isTrigger);
}
