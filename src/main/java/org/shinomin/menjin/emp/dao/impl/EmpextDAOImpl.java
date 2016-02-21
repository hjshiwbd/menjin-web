package org.shinomin.menjin.emp.dao.impl;

import org.shinomin.commons.db.mybatis.impl.CommonDAOImpl;
import org.shinomin.menjin.emp.dao.IEmpextDAO;
import org.springframework.stereotype.Repository;

/**
 * 
 * @author huangjin
 * @cratedate 2016-02-21 16:22:31
 * 
 */
@Repository
public class EmpextDAOImpl extends CommonDAOImpl implements IEmpextDAO
{

	@Override
	public String getNamespace()
	{
		return "org.shinomin.menjin.mapper.Empext.";
	}
}
