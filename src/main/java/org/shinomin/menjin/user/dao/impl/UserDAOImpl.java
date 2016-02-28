package org.shinomin.menjin.user.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.shinomin.menjin.bean.UserBean;
import org.shinomin.menjin.user.dao.IUserDAO;
import org.shinomin.commons.db.mybatis.ICommonDAOsuport;
import org.shinomin.commons.db.mybatis.impl.CommonDAOImpl;

/**
 * 
 * @author huangjin
 * @cratedate 2016-01-20 21:25:57
 * 
 */
@Repository
public class UserDAOImpl extends CommonDAOImpl implements IUserDAO {
	@Autowired
	private ICommonDAOsuport commonDAOsuport;

	@Override
	public String getNamespace() {
		return "org.shinomin.menjin.mapper.User.";
	}

	@Override
	public List<UserBean> login(UserBean user) {
		return commonDAOsuport.selectList(getNamespace() + "login", user);
	}

}
