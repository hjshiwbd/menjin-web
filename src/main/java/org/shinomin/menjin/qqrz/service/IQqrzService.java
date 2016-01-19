package org.shinomin.menjin.qqrz.service;

import java.util.List;

import org.shinomin.commons.db.mybatis.Pager;
import org.shinomin.menjin.bean.QqrzBean;

/**
 * 
 * @author huangjin
 * @cratedate 2016-01-19 21:29:33
 * 
 */
public interface IQqrzService
{
	/**
	 * simple
	 * 
	 * @param qqrz
	 * @return
	 */
	public QqrzBean selectOne(QqrzBean qqrz);

	/**
	 * simple
	 * 
	 * @param qqrz
	 * @return
	 */
	public List<QqrzBean> selectList(QqrzBean qqrz);

	/**
	 * simple
	 * 
	 * @param qqrz
	 * @param pager
	 * @return
	 */
	public Pager<QqrzBean> selectPage(QqrzBean qqrz, Pager<QqrzBean> pager);

	/**
	 * simple
	 * 
	 * @return
	 */
	public int insert(QqrzBean qqrz);

	/**
	 * simple
	 * 
	 * @param qqrz
	 * @return
	 */
	public int update(QqrzBean qqrz);

	/**
	 * simple
	 * 
	 * @param qqrz
	 * @return
	 */
	public int delete(QqrzBean qqrz);

}
