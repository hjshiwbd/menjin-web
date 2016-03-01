package org.shinomin.menjin.user.dao.impl;

import org.shinomin.commons.db.mybatis.impl.CommonDAOImpl;
import org.shinomin.menjin.user.dao.IUserresourceDAO;
import org.springframework.stereotype.Repository;

/**
 * 
 * @author huangjin
 * @cratedate 2016-03-01 20:52:23
 * 
 */
@Repository
public class UserresourceDAOImpl extends CommonDAOImpl implements IUserresourceDAO
{

	@Override
	public String getNamespace()
	{
		return "org.shinomin.menjin.mapper.Userresource.";
	}
}
