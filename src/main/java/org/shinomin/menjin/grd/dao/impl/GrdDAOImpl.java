package org.shinomin.menjin.grd.dao.impl;

import org.springframework.stereotype.Repository;

import org.shinomin.menjin.grd.dao.IGrdDAO;

import org.shinomin.commons.db.mybatis.impl.CommonDAOImpl;

/**
 * 
 * @author huangjin
 * @cratedate 2016-02-25 21:37:56
 * 
 */
@Repository
public class GrdDAOImpl extends CommonDAOImpl implements IGrdDAO
{

	@Override
	public String getNamespace()
	{
		return "org.shinomin.menjin.mapper.Grd.";
	}
}
