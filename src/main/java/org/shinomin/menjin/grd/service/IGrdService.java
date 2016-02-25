package org.shinomin.menjin.grd.service;

import java.util.List;

import org.shinomin.commons.db.mybatis.Pager;
import org.shinomin.menjin.bean.GrdBean;

/**
 * 
 * @author huangjin
 * @cratedate 2016-02-25 21:37:56
 * 
 */
public interface IGrdService
{
	/**
	 * simple
	 * 
	 * @param grd
	 * @return
	 */
	public GrdBean selectOne(GrdBean grd);

	/**
	 * simple
	 * 
	 * @param grd
	 * @return
	 */
	public List<GrdBean> selectList(GrdBean grd);

	/**
	 * simple
	 * 
	 * @param grd
	 * @param pager
	 * @return
	 */
	public Pager<GrdBean> selectPage(GrdBean grd, Pager<GrdBean> pager);

	/**
	 * simple
	 * 
	 * @return
	 */
	public int insert(GrdBean grd);

	/**
	 * simple
	 * 
	 * @param grd
	 * @return
	 */
	public int update(GrdBean grd);

	/**
	 * simple
	 * 
	 * @param grd
	 * @return
	 */
	public int delete(GrdBean grd);

}
