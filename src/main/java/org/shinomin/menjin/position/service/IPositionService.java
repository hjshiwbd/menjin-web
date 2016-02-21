package org.shinomin.menjin.position.service;

import java.util.List;

import org.shinomin.commons.db.mybatis.Pager;
import org.shinomin.menjin.bean.PositionBean;

/**
 * 
 * @author huangjin
 * @cratedate 2016-02-21 18:03:54
 * 
 */
public interface IPositionService
{
	/**
	 * simple
	 * 
	 * @param position
	 * @return
	 */
	public PositionBean selectOne(PositionBean position);

	/**
	 * simple
	 * 
	 * @param position
	 * @return
	 */
	public List<PositionBean> selectList(PositionBean position);

	/**
	 * simple
	 * 
	 * @param position
	 * @param pager
	 * @return
	 */
	public Pager<PositionBean> selectPage(PositionBean position, Pager<PositionBean> pager);

	/**
	 * simple
	 * 
	 * @return
	 */
	public int insert(PositionBean position);

	/**
	 * simple
	 * 
	 * @param position
	 * @return
	 */
	public int update(PositionBean position);

	/**
	 * simple
	 * 
	 * @param position
	 * @return
	 */
	public int delete(PositionBean position);

}
