package org.shinomin.menjin.emp.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.shinomin.menjin.emp.dao.IEmpDAO;
import org.shinomin.commons.db.mybatis.ICommonDAOsuport;
import org.shinomin.commons.db.mybatis.impl.CommonDAOImpl;

/**
 * 
 * @author huangjin
 * @cratedate 2016-02-16 20:35:40
 * 
 */
@Repository
public class EmpDAOImpl extends CommonDAOImpl implements IEmpDAO {
	@Autowired
	private ICommonDAOsuport commonDAOsuport;

	@Override
	public String getNamespace() {
		return "org.shinomin.menjin.mapper.Emp.";
	}

	@Override
	public int selectMaxID() {
		return commonDAOsuport.selectOne(getNamespace() + "selectMaxID", null);
	}
}
