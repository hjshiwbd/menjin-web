package org.shinomin.menjin.log.service;

import java.util.List;

import org.shinomin.commons.db.mybatis.Pager;
import org.shinomin.menjin.bean.HwpaeventBean;

/**
 * 
 * @author huangjin
 * @cratedate 2016-02-23 22:52:11
 * 
 */
public interface IHwpaeventService
{
	/**
	 * simple
	 * 
	 * @param hwpaevent
	 * @return
	 */
	public HwpaeventBean selectOne(HwpaeventBean hwpaevent);

	/**
	 * simple
	 * 
	 * @param hwpaevent
	 * @return
	 */
	public List<HwpaeventBean> selectList(HwpaeventBean hwpaevent);

	/**
	 * simple
	 * 
	 * @param hwpaevent
	 * @param pager
	 * @return
	 */
	public Pager<HwpaeventBean> selectPage(HwpaeventBean hwpaevent, Pager<HwpaeventBean> pager);

	/**
	 * simple
	 * 
	 * @return
	 */
	public int insert(HwpaeventBean hwpaevent);

	/**
	 * simple
	 * 
	 * @param hwpaevent
	 * @return
	 */
	public int update(HwpaeventBean hwpaevent);

	/**
	 * simple
	 * 
	 * @param hwpaevent
	 * @return
	 */
	public int delete(HwpaeventBean hwpaevent);

}
