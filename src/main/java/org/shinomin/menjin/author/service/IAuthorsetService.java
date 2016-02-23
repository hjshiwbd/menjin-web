package org.shinomin.menjin.author.service;

import java.util.List;

import org.shinomin.commons.db.mybatis.Pager;
import org.shinomin.menjin.bean.AuthorsetBean;

/**
 * 
 * @author huangjin
 * @cratedate 2016-02-23 21:45:15
 * 
 */
public interface IAuthorsetService
{
	/**
	 * simple
	 * 
	 * @param authorset
	 * @return
	 */
	public AuthorsetBean selectOne(AuthorsetBean authorset);

	/**
	 * simple
	 * 
	 * @param authorset
	 * @return
	 */
	public List<AuthorsetBean> selectList(AuthorsetBean authorset);

	/**
	 * simple
	 * 
	 * @param authorset
	 * @param pager
	 * @return
	 */
	public Pager<AuthorsetBean> selectPage(AuthorsetBean authorset, Pager<AuthorsetBean> pager);

	/**
	 * simple
	 * 
	 * @return
	 */
	public int insert(AuthorsetBean authorset);

	/**
	 * simple
	 * 
	 * @param authorset
	 * @return
	 */
	public int update(AuthorsetBean authorset);

	/**
	 * simple
	 * 
	 * @param authorset
	 * @return
	 */
	public int delete(AuthorsetBean authorset);

}
