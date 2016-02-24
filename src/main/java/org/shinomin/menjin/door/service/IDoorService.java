package org.shinomin.menjin.door.service;

import java.util.List;

import org.shinomin.commons.db.mybatis.Pager;
import org.shinomin.menjin.bean.DoorBean;

/**
 * 
 * @author huangjin
 * @cratedate 2016-02-24 20:56:41
 * 
 */
public interface IDoorService
{
	/**
	 * simple
	 * 
	 * @param door
	 * @return
	 */
	public DoorBean selectOne(DoorBean door);

	/**
	 * simple
	 * 
	 * @param door
	 * @return
	 */
	public List<DoorBean> selectList(DoorBean door);

	/**
	 * simple
	 * 
	 * @param door
	 * @param pager
	 * @return
	 */
	public Pager<DoorBean> selectPage(DoorBean door, Pager<DoorBean> pager);

	/**
	 * simple
	 * 
	 * @return
	 */
	public int insert(DoorBean door);

	/**
	 * simple
	 * 
	 * @param door
	 * @return
	 */
	public int update(DoorBean door);

	/**
	 * simple
	 * 
	 * @param door
	 * @return
	 */
	public int delete(DoorBean door);

	public String queryDoorEu(Integer page, Integer rows, DoorBean door);

	public String doAdd(DoorBean door);

	public String doDelete(DoorBean door);

	public String doEdit(DoorBean door);

}
