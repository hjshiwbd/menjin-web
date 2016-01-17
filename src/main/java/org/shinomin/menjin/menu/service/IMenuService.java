package org.shinomin.menjin.menu.service;

import java.util.List;

import org.shinomin.commons.db.mybatis.Pager;
import org.shinomin.menjin.bean.MenuBean;

/**
 * 
 * @author huangjin
 * @cratedate 2016-01-17 15:12:48
 * 
 */
public interface IMenuService
{
	/**
	 * simple
	 * 
	 * @param menu
	 * @return
	 */
	public MenuBean selectOne(MenuBean menu);

	/**
	 * simple
	 * 
	 * @param menu
	 * @return
	 */
	public List<MenuBean> selectList(MenuBean menu);

	/**
	 * simple
	 * 
	 * @param menu
	 * @param pager
	 * @return
	 */
	public Pager<MenuBean> selectPage(MenuBean menu, Pager<MenuBean> pager);

	/**
	 * simple
	 * 
	 * @return
	 */
	public int insert(MenuBean menu);

	/**
	 * simple
	 * 
	 * @param menu
	 * @return
	 */
	public int update(MenuBean menu);

	/**
	 * simple
	 * 
	 * @param menu
	 * @return
	 */
	public int delete(MenuBean menu);

}
