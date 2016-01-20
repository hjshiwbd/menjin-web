package org.shinomin.menjin.login.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.shinomin.menjin.bean.MenuBean;
import org.shinomin.menjin.bean.UserBean;
import org.shinomin.menjin.constant.MenjinSessionConstant;
import org.shinomin.menjin.login.service.ILoginService;
import org.shinomin.menjin.menu.service.IMenuService;
import org.shinomin.menjin.spring.session.LoginSessionScope;
import org.shinomin.menjin.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements ILoginService
{
	@Autowired
	private LoginSessionScope loginSession;
	@Autowired
	private IMenuService menuService;
	@Autowired
	private IUserService userService;

	@Override
	public boolean isLogined()
	{
		return loginSession.getLoginUser() != null;
	}

	@Override
	public void afterLoginSuccess(HttpServletRequest request, UserBean user)
	{
		loginSession.setLoginUser(user);

		request.getSession().setAttribute(MenjinSessionConstant.SESSION_USER, user);

		MenuBean search = new MenuBean();
		search.setStatus("1");
		List<MenuBean> list = menuService.selectList(search);
		loginSession.setFlatMenuList(list);

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
	private List<MenuBean> treeFormat(List<MenuBean> list)
	{
		List<MenuBean> roots = new ArrayList<>();
		for (MenuBean menu1 : list)
		{
			if ("1".equals(menu1.getStatus()) && "root".equals(menu1.getPid()))
			{
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
	private MenuBean recursive(List<MenuBean> list, MenuBean menu1)
	{
		List<MenuBean> children = new ArrayList<>();
		for (MenuBean menu2 : list)
		{
			if (menu1.getId().equals(menu2.getPid()))
			{
				recursive(list, menu2);
				children.add(menu2);
			}
		}
		menu1.setChildren(children);
		return menu1;
	}

	@Override
	public UserBean queryLoginUser(UserBean user)
	{
		if (user == null || StringUtils.isBlank(user.getUsername()) || StringUtils.isBlank(user.getPassword()))
		{
			throw new IllegalArgumentException("invalid param");
		}

		UserBean search = new UserBean();
		search.setUsername(user.getUsername());
		return userService.selectOne(search);
	}

}
