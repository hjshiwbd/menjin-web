package org.shinomin.menjin.qqrz.service.impl;

import java.util.List;

import org.shinomin.commons.db.mybatis.Pager;
import org.shinomin.menjin.bean.QqrzBean;
import org.shinomin.menjin.qqrz.dao.IQqrzDAO;
import org.shinomin.menjin.qqrz.service.IQqrzService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 * @author huangjin
 * @cratedate 2016-01-19 21:29:33
 * 
 */
@Service
public class QqrzServiceImpl implements IQqrzService
{
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private IQqrzDAO qqrzDAO;

	@Override
	public QqrzBean selectOne(QqrzBean qqrz)
	{
		return qqrzDAO.selectOne(qqrz);
	}

	@Override
	public List<QqrzBean> selectList(QqrzBean qqrz)
	{
		return qqrzDAO.selectList(qqrz);
	}

	@Override
	public Pager<QqrzBean> selectPage(QqrzBean qqrz, Pager<QqrzBean> pager)
	{
		return qqrzDAO.selectPage(qqrz, pager);
	}

	@Override
	public int insert(QqrzBean qqrz)
	{
		return qqrzDAO.insert(qqrz);
	}

	@Override
	public int update(QqrzBean qqrz)
	{
		return qqrzDAO.update(qqrz);
	}

	@Override
	public int delete(QqrzBean qqrz)
	{
		return qqrzDAO.delete(qqrz);
	}
}
