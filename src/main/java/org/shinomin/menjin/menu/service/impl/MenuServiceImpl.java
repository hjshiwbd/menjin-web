package org.shinomin.menjin.menu.service.impl;

import java.util.List;

import org.shinomin.commons.db.mybatis.Pager;
import org.shinomin.menjin.bean.MenuBean;
import org.shinomin.menjin.menu.dao.IMenuDAO;
import org.shinomin.menjin.menu.service.IMenuService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 * @author huangjin
 * @cratedate 2016-01-17 15:12:48
 * 
 */
@Service
public class MenuServiceImpl implements IMenuService
{
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private IMenuDAO menuDAO;

	@Override
	public MenuBean selectOne(MenuBean menu)
	{
		return menuDAO.selectOne(menu);
	}

	@Override
	public List<MenuBean> selectList(MenuBean menu)
	{
		return menuDAO.selectList(menu);
	}

	@Override
	public Pager<MenuBean> selectPage(MenuBean menu, Pager<MenuBean> pager)
	{
		return menuDAO.selectPage(menu, pager);
	}

	@Override
	public int insert(MenuBean menu)
	{
		return menuDAO.insert(menu);
	}

	@Override
	public int update(MenuBean menu)
	{
		return menuDAO.update(menu);
	}

	@Override
	public int delete(MenuBean menu)
	{
		return menuDAO.delete(menu);
	}
}
