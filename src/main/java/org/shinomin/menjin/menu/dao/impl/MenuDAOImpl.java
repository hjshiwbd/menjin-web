package org.shinomin.menjin.menu.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.shinomin.menjin.bean.MenuBean;
import org.shinomin.menjin.menu.dao.IMenuDAO;
import org.shinomin.commons.db.mybatis.ICommonDAOsuport;
import org.shinomin.commons.db.mybatis.impl.CommonDAOImpl;

/**
 * 
 * @author huangjin
 * @cratedate 2016-01-17 15:12:48
 * 
 */
@Repository
public class MenuDAOImpl extends CommonDAOImpl implements IMenuDAO {
	@Autowired
	private ICommonDAOsuport commonDAOsuport;

	@Override
	public String getNamespace() {
		return "org.shinomin.menjin.mapper.Menu.";
	}

	@Override
	public List<MenuBean> selectQx(Map<String, Object> param) {
		return commonDAOsuport.selectList(getNamespace() + "selectQx", param);
	}
}
