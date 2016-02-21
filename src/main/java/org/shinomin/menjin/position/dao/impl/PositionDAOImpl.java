package org.shinomin.menjin.position.dao.impl;

import org.springframework.stereotype.Repository;

import org.shinomin.menjin.position.dao.IPositionDAO;

import org.shinomin.commons.db.mybatis.impl.CommonDAOImpl;

/**
 * 
 * @author huangjin
 * @cratedate 2016-02-21 18:03:54
 * 
 */
@Repository
public class PositionDAOImpl extends CommonDAOImpl implements IPositionDAO
{

	@Override
	public String getNamespace()
	{
		return "org.shinomin.menjin.mapper.Position.";
	}
}
