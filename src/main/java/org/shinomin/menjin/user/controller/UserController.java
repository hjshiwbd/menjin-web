package org.shinomin.menjin.user.controller;

import org.shinomin.menjin.bean.UserBean;
import org.shinomin.menjin.bean.UserresourceBean;
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
public class UserController {
	@Autowired
	private IUserService userService;

	@RequestMapping("/mima")
	public ModelAndView mima() throws Exception {
		ModelAndView model = new ModelAndView();
		model.setViewName("user/user_mima");
		return model;
	}

	@ResponseBody
	@RequestMapping("/change_mima")
	public String changeMima(String oldPassword, String newPassword, String newPassword2) throws Exception {
		return userService.changeMima(oldPassword, newPassword, newPassword2);
	}

	@RequestMapping("/list")
	public ModelAndView list() throws Exception {
		return userService.showList();
	}

	@ResponseBody
	@RequestMapping("/list_eu")
	public String listEu(Integer page, Integer rows, UserBean user) throws Exception {
		return userService.queryListEu(page, rows, user);
	}

	@ResponseBody
	@RequestMapping("/do_add")
	public String doAdd(UserBean user) throws Exception {
		return userService.doAdd(user);
	}

	@ResponseBody
	@RequestMapping("/reset_pass")
	public String resetPass(UserBean user) throws Exception {
		return userService.doResetPass(user);
	}

	@ResponseBody
	@RequestMapping("/do_delete")
	public String doDelete(UserBean user) throws Exception {
		return userService.doDelete(user);
	}

	@ResponseBody
	@RequestMapping("/query_user_qx")
	public String queryUserQx(UserresourceBean ur) throws Exception {
		return userService.queryUserQx(ur);
	}
	
	/**
	 * 设置权限
	 * 
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping("/save_qx")
	public String saveQx(String json) throws Exception {
		return userService.saveQx(json);
	}
}
