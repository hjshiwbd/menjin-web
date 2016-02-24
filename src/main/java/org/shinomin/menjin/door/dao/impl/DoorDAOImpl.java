package org.shinomin.menjin.door.dao.impl;

import org.springframework.stereotype.Repository;

import org.shinomin.menjin.door.dao.IDoorDAO;

import org.shinomin.commons.db.mybatis.impl.CommonDAOImpl;

/**
 * 
 * @author huangjin
 * @cratedate 2016-02-24 20:56:41
 * 
 */
@Repository
public class DoorDAOImpl extends CommonDAOImpl implements IDoorDAO
{

	@Override
	public String getNamespace()
	{
		return "org.shinomin.menjin.mapper.Door.";
	}
}
