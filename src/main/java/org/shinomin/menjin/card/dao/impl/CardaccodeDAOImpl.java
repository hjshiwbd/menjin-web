package org.shinomin.menjin.card.dao.impl;

import org.shinomin.commons.db.mybatis.impl.CommonDAOImpl;
import org.shinomin.menjin.card.dao.ICardaccodeDAO;
import org.springframework.stereotype.Repository;

/**
 * 
 * @author huangjin
 * @cratedate 2016-02-21 23:26:45
 * 
 */
@Repository
public class CardaccodeDAOImpl extends CommonDAOImpl implements ICardaccodeDAO
{

	@Override
	public String getNamespace()
	{
		return "org.shinomin.menjin.mapper.Cardaccode.";
	}
}
