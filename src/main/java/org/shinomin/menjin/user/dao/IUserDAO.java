package org.shinomin.menjin.user.dao;

import java.util.List;

import org.shinomin.commons.db.mybatis.ICommonDAO;
import org.shinomin.menjin.bean.UserBean;

/**
 * 
 * @author huangjin
 * @cratedate 2016-01-20 21:25:57
 * 
 */
public interface IUserDAO extends ICommonDAO
{
	List<UserBean> login(UserBean user);
}
