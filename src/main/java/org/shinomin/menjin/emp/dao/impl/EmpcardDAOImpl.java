package org.shinomin.menjin.emp.dao.impl;

import org.shinomin.commons.db.mybatis.impl.CommonDAOImpl;
import org.shinomin.menjin.emp.dao.IEmpcardDAO;
import org.springframework.stereotype.Repository;

/**
 * 
 * @author huangjin
 * @cratedate 2016-03-20 21:24:06
 * 
 */
@Repository
public class EmpcardDAOImpl extends CommonDAOImpl implements IEmpcardDAO
{

	@Override
	public String getNamespace()
	{
		return "org.shinomin.menjin.mapper.Empcard.";
	}
}
