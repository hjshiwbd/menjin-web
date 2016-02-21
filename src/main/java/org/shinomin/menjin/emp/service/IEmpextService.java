package org.shinomin.menjin.emp.service;

import java.util.List;

import org.shinomin.commons.db.mybatis.Pager;
import org.shinomin.menjin.bean.EmpextBean;

/**
 * 
 * @author huangjin
 * @cratedate 2016-02-21 16:22:31
 * 
 */
public interface IEmpextService
{
	/**
	 * simple
	 * 
	 * @param empext
	 * @return
	 */
	public EmpextBean selectOne(EmpextBean empext);

	/**
	 * simple
	 * 
	 * @param empext
	 * @return
	 */
	public List<EmpextBean> selectList(EmpextBean empext);

	/**
	 * simple
	 * 
	 * @param empext
	 * @param pager
	 * @return
	 */
	public Pager<EmpextBean> selectPage(EmpextBean empext, Pager<EmpextBean> pager);

	/**
	 * simple
	 * 
	 * @return
	 */
	public int insert(EmpextBean empext);

	/**
	 * simple
	 * 
	 * @param empext
	 * @return
	 */
	public int update(EmpextBean empext);

	/**
	 * simple
	 * 
	 * @param empext
	 * @return
	 */
	public int delete(EmpextBean empext);

}
