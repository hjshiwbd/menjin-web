package org.shinomin.menjin.user.service.impl;

import java.util.List;

import org.shinomin.commons.db.mybatis.Pager;
import org.shinomin.menjin.bean.UserBean;
import org.shinomin.menjin.user.dao.IUserDAO;
import org.shinomin.menjin.user.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 * @author huangjin
 * @cratedate 2016-01-20 21:25:57
 * 
 */
@Service
public class UserServiceImpl implements IUserService
{
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private IUserDAO userDAO;

	@Override
	public UserBean selectOne(UserBean user)
	{
		return userDAO.selectOne(user);
	}

	@Override
	public List<UserBean> selectList(UserBean user)
	{
		return userDAO.selectList(user);
	}

	@Override
	public Pager<UserBean> selectPage(UserBean user, Pager<UserBean> pager)
	{
		return userDAO.selectPage(user, pager);
	}

	@Override
	public int insert(UserBean user)
	{
		return userDAO.insert(user);
	}

	@Override
	public int update(UserBean user)
	{
		return userDAO.update(user);
	}

	@Override
	public int delete(UserBean user)
	{
		return userDAO.delete(user);
	}
}
