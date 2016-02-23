package org.shinomin.menjin.card.dao.impl;

import org.shinomin.commons.db.mybatis.impl.CommonDAOImpl;
import org.shinomin.menjin.card.dao.ICardinfoDAO;
import org.springframework.stereotype.Repository;

/**
 * 
 * @author huangjin
 * @cratedate 2016-02-23 21:59:57
 * 
 */
@Repository
public class CardinfoDAOImpl extends CommonDAOImpl implements ICardinfoDAO
{

	@Override
	public String getNamespace()
	{
		return "org.shinomin.menjin.mapper.Cardinfo.";
	}
}
