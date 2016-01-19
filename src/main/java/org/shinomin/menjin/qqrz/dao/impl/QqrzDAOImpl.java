package org.shinomin.menjin.qqrz.dao.impl;

import org.springframework.stereotype.Repository;

import org.shinomin.menjin.qqrz.dao.IQqrzDAO;

import org.shinomin.commons.db.mybatis.impl.CommonDAOImpl;

/**
 * 
 * @author huangjin
 * @cratedate 2016-01-19 21:29:33
 * 
 */
@Repository
public class QqrzDAOImpl extends CommonDAOImpl implements IQqrzDAO
{

	@Override
	public String getNamespace()
	{
		return "org.shinomin.menjin.mapper.Qqrz.";
	}
}
