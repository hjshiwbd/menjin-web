package org.shinomin.menjin.login.service;

import javax.servlet.http.HttpServletRequest;

import org.shinomin.menjin.bean.UserBean;
import org.springframework.web.servlet.ModelAndView;

public interface ILoginService
{
	/**
	 * 是否登录
	 * 
	 * @return
	 */
	boolean isLogined();

	void afterLoginSuccess(HttpServletRequest request, UserBean user);

	UserBean queryLoginUser(UserBean user) throws Exception;

	ModelAndView doLogin(HttpServletRequest request, UserBean user);

}
