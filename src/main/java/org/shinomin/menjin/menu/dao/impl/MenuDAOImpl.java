package org.shinomin.menjin.menu.dao.impl;

import org.springframework.stereotype.Repository;

import org.shinomin.menjin.menu.dao.IMenuDAO;

import org.shinomin.commons.db.mybatis.impl.CommonDAOImpl;

/**
 * 
 * @author huangjin
 * @cratedate 2016-01-17 15:12:48
 * 
 */
@Repository
public class MenuDAOImpl extends CommonDAOImpl implements IMenuDAO
{

	@Override
	public String getNamespace()
	{
		return "org.shinomin.menjin.mapper.Menu.";
	}
}
