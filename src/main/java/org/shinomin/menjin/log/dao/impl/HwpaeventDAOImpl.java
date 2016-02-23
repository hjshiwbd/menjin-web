package org.shinomin.menjin.log.dao.impl;

import org.shinomin.commons.db.mybatis.impl.CommonDAOImpl;
import org.shinomin.menjin.log.dao.IHwpaeventDAO;
import org.springframework.stereotype.Repository;

/**
 * 
 * @author huangjin
 * @cratedate 2016-02-23 22:52:11
 * 
 */
@Repository
public class HwpaeventDAOImpl extends CommonDAOImpl implements IHwpaeventDAO
{

	@Override
	public String getNamespace()
	{
		return "org.shinomin.menjin.mapper.Hwpaevent.";
	}
}
