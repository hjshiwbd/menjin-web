package org.shinomin.menjin.user.controller;

import org.shinomin.menjin.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * 
 * @author huangjin
 * @cratedate 2016-01-20 21:25:57
 * 
 */
@Controller
@RequestMapping("/user")
public class UserController
{
	@Autowired
	private IUserService userService;

	@RequestMapping("/mima")
	public ModelAndView mima() throws Exception
	{
		ModelAndView model = new ModelAndView();
		model.setViewName("user/user_mima");
		return model;
	}

	@ResponseBody
	@RequestMapping("/change_mima")
	public String changeMima(String oldPassword, String newPassword, String newPassword2) throws Exception
	{
		return userService.changeMima(oldPassword, newPassword, newPassword2);
	}
}
