package org.shinomin.menjin.author.dao.impl;

import org.shinomin.commons.db.mybatis.impl.CommonDAOImpl;
import org.shinomin.menjin.author.dao.IAuthorsetDAO;
import org.springframework.stereotype.Repository;

/**
 * 
 * @author huangjin
 * @cratedate 2016-02-23 21:45:15
 * 
 */
@Repository
public class AuthorsetDAOImpl extends CommonDAOImpl implements IAuthorsetDAO
{

	@Override
	public String getNamespace()
	{
		return "org.shinomin.menjin.mapper.Authorset.";
	}
}
