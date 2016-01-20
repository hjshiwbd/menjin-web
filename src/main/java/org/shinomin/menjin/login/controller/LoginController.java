package org.shinomin.menjin.login.controller;

import javax.servlet.http.HttpServletRequest;

import org.shinomin.commons.utils.CryptogramUtil;
import org.shinomin.menjin.bean.UserBean;
import org.shinomin.menjin.login.service.ILoginService;
import org.shinomin.menjin.spring.session.LoginSessionScope;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/login")
public class LoginController
{
	@Autowired
	private ILoginService loginService;
	@Autowired
	private LoginSessionScope loginSession;

	@RequestMapping("/login")
	public ModelAndView login(HttpServletRequest request) throws Exception
	{
		ModelAndView model = new ModelAndView();
		if (loginService.isLogined())
		{
			model.setViewName("redirect:/");
		}
		else
		{
			model.setViewName("login/login");
		}

		return model;
	}

	@RequestMapping("do_login")
	public ModelAndView doLogin(HttpServletRequest request, UserBean user) throws Exception
	{
		ModelAndView model = new ModelAndView();

		UserBean loginedUser = loginService.queryLoginUser(user);
		user.setId("1");
		loginService.afterLoginSuccess(request, user);

		model.setViewName("redirect:/");
		return model;
	}

	@RequestMapping("/logout")
	public ModelAndView logout(HttpServletRequest request) throws Exception
	{
		ModelAndView model = new ModelAndView();
		request.getSession().invalidate();
		
		model.setViewName("redirect:/");
		return model;
	}

}
