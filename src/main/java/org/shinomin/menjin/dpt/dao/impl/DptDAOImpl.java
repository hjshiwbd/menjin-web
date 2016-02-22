package org.shinomin.menjin.dpt.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.shinomin.menjin.bean.DptBean;
import org.shinomin.menjin.dpt.dao.IDptDAO;
import org.shinomin.commons.db.mybatis.ICommonDAOsuport;
import org.shinomin.commons.db.mybatis.impl.CommonDAOImpl;

/**
 * 
 * @author huangjin
 * @cratedate 2016-02-21 17:11:21
 * 
 */
@Repository
public class DptDAOImpl extends CommonDAOImpl implements IDptDAO {
	@Autowired
	private ICommonDAOsuport commonDAOsuport;

	@Override
	public String getNamespace() {
		return "org.shinomin.menjin.mapper.Dpt.";
	}

	@Override
	public Integer selectMaxPrcno(DptBean dpt) {
		return commonDAOsuport.selectOne(getNamespace() + "selectMaxPrcno", dpt);
	}
}
