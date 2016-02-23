package org.shinomin.menjin.author.service.impl;

import java.util.List;

import org.shinomin.commons.db.mybatis.Pager;
import org.shinomin.menjin.author.dao.IAuthorsetDAO;
import org.shinomin.menjin.author.service.IAuthorsetService;
import org.shinomin.menjin.bean.AuthorsetBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * 
 * @author huangjin
 * @cratedate 2016-02-23 21:45:15
 * 
 */
@Service
public class AuthorsetServiceImpl implements IAuthorsetService
{
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private IAuthorsetDAO authorsetDAO;

	@Override
	public AuthorsetBean selectOne(AuthorsetBean authorset)
	{
		return authorsetDAO.selectOne(authorset);
	}

	@Override
	public List<AuthorsetBean> selectList(AuthorsetBean authorset)
	{
		return authorsetDAO.selectList(authorset);
	}

	@Override
	public Pager<AuthorsetBean> selectPage(AuthorsetBean authorset, Pager<AuthorsetBean> pager)
	{
		return authorsetDAO.selectPage(authorset, pager);
	}

	@Override
	public int insert(AuthorsetBean authorset)
	{
		return authorsetDAO.insert(authorset);
	}

	@Override
	public int update(AuthorsetBean authorset)
	{
		return authorsetDAO.update(authorset);
	}

	@Override
	public int delete(AuthorsetBean authorset)
	{
		return authorsetDAO.delete(authorset);
	}
}
