package org.shinomin.menjin.login.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.shinomin.commons.utils.CryptogramUtil;
import org.shinomin.menjin.bean.MenuBean;
import org.shinomin.menjin.bean.UserBean;
import org.shinomin.menjin.constant.MenjinSessionConstant;
import org.shinomin.menjin.exception.UserNotFoundException;
import org.shinomin.menjin.exception.ValidationException;
import org.shinomin.menjin.login.service.ILoginService;
import org.shinomin.menjin.menu.dao.IMenuDAO;
import org.shinomin.menjin.menu.service.IMenuService;
import org.shinomin.menjin.spring.session.LoginSessionScope;
import org.shinomin.menjin.user.dao.IUserDAO;
import org.shinomin.menjin.user.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

@Service
public class LoginServiceImpl implements ILoginService {
	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private LoginSessionScope loginSession;
	@Autowired
	private IMenuService menuService;
	@Autowired
	private IUserService userService;
	@Autowired
	private IUserDAO userDAO;
	@Autowired
	private IMenuDAO menuDAO;

	@Override
	public boolean isLogined() {
		return loginSession.getLoginUser() != null;
	}

	@Override
	public void afterLoginSuccess(HttpServletRequest request, UserBean user) {
		loginSession.setLoginUser(user);

		request.getSession().setAttribute(MenjinSessionConstant.SESSION_USER, user);

		List<MenuBean> list = new ArrayList<>();
		if (loginSession.isAdminUser()) {
			// admin用户,显示全部菜单
			MenuBean search = new MenuBean();
			search.setStatus("1");
			list = menuService.selectList(search);
			loginSession.setFlatMenuList(list);
		} else {
			// 其他用户,根据资源联查
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("user_id", loginSession.getLoginUser().getUsername());
			param.put("resource_type", "menu");
			list = menuDAO.selectQx(param);
		}

		List<MenuBean> lv1List = treeFormat(list);
		loginSession.setTreeMenuList(lv1List);
		request.getSession().setAttribute("user_menus", lv1List);
	}

	/**
	 * menulist递归成树结构
	 * 
	 * @param list
	 * @return
	 */
	private List<MenuBean> treeFormat(List<MenuBean> list) {
		List<MenuBean> roots = new ArrayList<>();
		for (MenuBean menu1 : list) {
			if ("1".equals(menu1.getStatus()) && "root".equals(menu1.getPid())) {
				roots.add(recursive(list, menu1));
			}
		}

		return roots;
	}

	/**
	 * 递归
	 * 
	 * @param list
	 * @param menu1
	 * @return
	 */
	private MenuBean recursive(List<MenuBean> list, MenuBean menu1) {
		List<MenuBean> children = new ArrayList<>();
		for (MenuBean menu2 : list) {
			if (menu1.getId().equals(menu2.getPid())) {
				recursive(list, menu2);
				children.add(menu2);
			}
		}
		menu1.setChildren(children);
		return menu1;
	}

	@Override
	public UserBean queryLoginUser(UserBean user) throws UserNotFoundException {
		if (user == null || StringUtils.isBlank(user.getUsername()) || StringUtils.isBlank(user.getPassword())) {
			throw new IllegalArgumentException("invalid param");
		}

		UserBean search = new UserBean();
		search.setUsername(user.getUsername());
		List<UserBean> list = userDAO.login(search);
		if (list.size() == 1) {
			UserBean dbuser = list.get(0);
			String encryptedPass = CryptogramUtil.encryptHexStr(user.getPassword());
			if (dbuser.getPassword().equals(encryptedPass)) {
				return dbuser;
			} else {
				logger.info("user login password error:{}", user.getUsername());
				throw new UserNotFoundException("登录信息有误，请重新登录");
			}
		} else if (list.size() > 1) {
			// 暂不处理,数据库username字段唯一
		} else {
			// not exists
			logger.info("user not exists:{}", user.getUsername());
			throw new UserNotFoundException("登录信息有误，请重新登录");
		}
		return null;
	}

	@Override
	public ModelAndView doLogin(HttpServletRequest request, UserBean user) {
		ModelAndView model = new ModelAndView();
		String errMsg = "";
		try {
			if (checkParam(user)) {
				UserBean loginedUser = queryLoginUser(user);
				loginedUser.setUsername(user.getUsername());
				afterLoginSuccess(request, loginedUser);
				model.setViewName("redirect:/");
				return model;
			}
		} catch (ValidationException e) {
			errMsg = e.getMessage();
		} catch (UserNotFoundException e) {
			errMsg = e.getMessage();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			errMsg = "系统异常，请稍候再试";
		}
		model.addObject("errMsg", errMsg);
		model.addObject("user", user);
		model.setViewName("login/login");
		return model;
	}

	private boolean checkParam(UserBean user) throws ValidationException {
		if (StringUtils.isBlank(user.getUsername())) {
			logger.info("username is empty");
			throw new ValidationException("登录名不能为空");
		}
		if (StringUtils.isBlank(user.getPassword())) {
			logger.info("password is empty");
			throw new ValidationException("密码不能为空");
		}
		return true;
	}
}
