package org.shinomin.menjin.user.service.impl;

import java.util.List;

import org.shinomin.commons.db.mybatis.Pager;
import org.shinomin.menjin.bean.UserresourceBean;
import org.shinomin.menjin.user.dao.IUserresourceDAO;
import org.shinomin.menjin.user.service.IUserresourceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * 
 * @author huangjin
 * @cratedate 2016-03-01 20:52:23
 * 
 */
@Service
public class UserresourceServiceImpl implements IUserresourceService
{
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private IUserresourceDAO userresourceDAO;

	@Override
	public UserresourceBean selectOne(UserresourceBean userresource)
	{
		return userresourceDAO.selectOne(userresource);
	}

	@Override
	public List<UserresourceBean> selectList(UserresourceBean userresource)
	{
		return userresourceDAO.selectList(userresource);
	}

	@Override
	public Pager<UserresourceBean> selectPage(UserresourceBean userresource, Pager<UserresourceBean> pager)
	{
		return userresourceDAO.selectPage(userresource, pager);
	}

	@Override
	public int insert(UserresourceBean userresource)
	{
		return userresourceDAO.insert(userresource);
	}

	@Override
	public int update(UserresourceBean userresource)
	{
		return userresourceDAO.update(userresource);
	}

	@Override
	public int delete(UserresourceBean userresource)
	{
		return userresourceDAO.delete(userresource);
	}
}
