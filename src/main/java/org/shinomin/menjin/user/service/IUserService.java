package org.shinomin.menjin.user.service;

import java.util.List;

import org.shinomin.commons.db.mybatis.Pager;
import org.shinomin.menjin.bean.UserBean;

/**
 * 
 * @author huangjin
 * @cratedate 2016-01-20 21:25:57
 * 
 */
public interface IUserService
{
	/**
	 * simple
	 * 
	 * @param user
	 * @return
	 */
	public UserBean selectOne(UserBean user);

	/**
	 * simple
	 * 
	 * @param user
	 * @return
	 */
	public List<UserBean> selectList(UserBean user);

	/**
	 * simple
	 * 
	 * @param user
	 * @param pager
	 * @return
	 */
	public Pager<UserBean> selectPage(UserBean user, Pager<UserBean> pager);

	/**
	 * simple
	 * 
	 * @return
	 */
	public int insert(UserBean user);

	/**
	 * simple
	 * 
	 * @param user
	 * @return
	 */
	public int update(UserBean user);

	/**
	 * simple
	 * 
	 * @param user
	 * @return
	 */
	public int delete(UserBean user);

}
