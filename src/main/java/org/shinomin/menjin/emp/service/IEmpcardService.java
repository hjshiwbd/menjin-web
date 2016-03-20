package org.shinomin.menjin.emp.service;

import java.util.List;

import org.shinomin.commons.db.mybatis.Pager;
import org.shinomin.menjin.bean.EmpcardBean;

/**
 * 
 * @author huangjin
 * @cratedate 2016-03-20 21:24:06
 * 
 */
public interface IEmpcardService
{
	/**
	 * simple
	 * 
	 * @param empcard
	 * @return
	 */
	public EmpcardBean selectOne(EmpcardBean empcard);

	/**
	 * simple
	 * 
	 * @param empcard
	 * @return
	 */
	public List<EmpcardBean> selectList(EmpcardBean empcard);

	/**
	 * simple
	 * 
	 * @param empcard
	 * @param pager
	 * @return
	 */
	public Pager<EmpcardBean> selectPage(EmpcardBean empcard, Pager<EmpcardBean> pager);

	/**
	 * simple
	 * 
	 * @return
	 */
	public int insert(EmpcardBean empcard);

	/**
	 * simple
	 * 
	 * @param empcard
	 * @return
	 */
	public int update(EmpcardBean empcard);

	/**
	 * simple
	 * 
	 * @param empcard
	 * @return
	 */
	public int delete(EmpcardBean empcard);

}
