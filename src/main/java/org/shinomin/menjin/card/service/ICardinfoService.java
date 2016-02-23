package org.shinomin.menjin.card.service;

import java.util.List;

import org.shinomin.commons.db.mybatis.Pager;
import org.shinomin.menjin.bean.CardinfoBean;

/**
 * 
 * @author huangjin
 * @cratedate 2016-02-23 21:59:57
 * 
 */
public interface ICardinfoService
{
	/**
	 * simple
	 * 
	 * @param cardinfo
	 * @return
	 */
	public CardinfoBean selectOne(CardinfoBean cardinfo);

	/**
	 * simple
	 * 
	 * @param cardinfo
	 * @return
	 */
	public List<CardinfoBean> selectList(CardinfoBean cardinfo);

	/**
	 * simple
	 * 
	 * @param cardinfo
	 * @param pager
	 * @return
	 */
	public Pager<CardinfoBean> selectPage(CardinfoBean cardinfo, Pager<CardinfoBean> pager);

	/**
	 * simple
	 * 
	 * @return
	 */
	public int insert(CardinfoBean cardinfo);

	/**
	 * simple
	 * 
	 * @param cardinfo
	 * @return
	 */
	public int update(CardinfoBean cardinfo);

	/**
	 * simple
	 * 
	 * @param cardinfo
	 * @return
	 */
	public int delete(CardinfoBean cardinfo);

}
