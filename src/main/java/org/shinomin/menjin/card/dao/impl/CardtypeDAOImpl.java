package org.shinomin.menjin.card.dao.impl;

import org.shinomin.commons.db.mybatis.impl.CommonDAOImpl;
import org.shinomin.menjin.card.dao.ICardtypeDAO;
import org.springframework.stereotype.Repository;

/**
 * 
 * @author huangjin
 * @cratedate 2016-02-21 18:10:06
 * 
 */
@Repository
public class CardtypeDAOImpl extends CommonDAOImpl implements ICardtypeDAO
{

	@Override
	public String getNamespace()
	{
		return "org.shinomin.menjin.mapper.Cardtype.";
	}
}
