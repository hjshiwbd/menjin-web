package org.shinomin.menjin.user.dao.impl;

import org.springframework.stereotype.Repository;

import org.shinomin.menjin.user.dao.IUserDAO;

import org.shinomin.commons.db.mybatis.impl.CommonDAOImpl;

/**
 * 
 * @author huangjin
 * @cratedate 2016-01-20 21:25:57
 * 
 */
@Repository
public class UserDAOImpl extends CommonDAOImpl implements IUserDAO
{

	@Override
	public String getNamespace()
	{
		return "org.shinomin.menjin.mapper.User.";
	}
}
