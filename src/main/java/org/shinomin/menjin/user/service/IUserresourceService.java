package org.shinomin.menjin.user.service;

import java.util.List;

import org.shinomin.commons.db.mybatis.Pager;
import org.shinomin.menjin.bean.UserresourceBean;

/**
 * 
 * @author huangjin
 * @cratedate 2016-03-01 20:52:23
 * 
 */
public interface IUserresourceService
{
	/**
	 * simple
	 * 
	 * @param userresource
	 * @return
	 */
	public UserresourceBean selectOne(UserresourceBean userresource);

	/**
	 * simple
	 * 
	 * @param userresource
	 * @return
	 */
	public List<UserresourceBean> selectList(UserresourceBean userresource);

	/**
	 * simple
	 * 
	 * @param userresource
	 * @param pager
	 * @return
	 */
	public Pager<UserresourceBean> selectPage(UserresourceBean userresource, Pager<UserresourceBean> pager);

	/**
	 * simple
	 * 
	 * @return
	 */
	public int insert(UserresourceBean userresource);

	/**
	 * simple
	 * 
	 * @param userresource
	 * @return
	 */
	public int update(UserresourceBean userresource);

	/**
	 * simple
	 * 
	 * @param userresource
	 * @return
	 */
	public int delete(UserresourceBean userresource);

}
