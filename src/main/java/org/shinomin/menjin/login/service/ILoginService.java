package org.shinomin.menjin.login.service;

import javax.servlet.http.HttpServletRequest;

import org.shinomin.menjin.bean.UserBean;

public interface ILoginService
{
	/**
	 * 是否登录
	 * 
	 * @return
	 */
	boolean isLogined();

	void afterLoginSuccess(HttpServletRequest request, UserBean user);

	UserBean queryLoginUser(UserBean user);

}
