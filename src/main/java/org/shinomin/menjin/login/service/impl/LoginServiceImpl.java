package org.shinomin.menjin.login.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.shinomin.menjin.bean.MenuBean;
import org.shinomin.menjin.bean.UserBean;
import org.shinomin.menjin.login.service.ILoginService;
import org.shinomin.menjin.menu.service.IMenuService;
import org.shinomin.menjin.spring.session.LoginSessionScope;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements ILoginService
{
	@Autowired
	private LoginSessionScope loginSession;
	@Autowired
	private IMenuService menuService;

	@Override
	public boolean isLogined()
	{
		return loginSession.getLoginUser() != null;
	}

	@Override
	public void afterLoginSuccess(HttpServletRequest request, UserBean user)
	{
		loginSession.setLoginUser(user);
		
		request.getSession().setAttribute("session_user", user);
		
		List<MenuBean> list = menuService.selectList(null);
		loginSession.setFlatMenuList(list);

		List<MenuBean> lv1List = treeFormat(list);
		loginSession.setTreeMenuList(lv1List);
		request.getSession().setAttribute("user_menus", lv1List);
	}

	private List<MenuBean> treeFormat(List<MenuBean> list)
	{
		List<MenuBean> roots = new ArrayList<>();
		for (MenuBean menu1 : list)
		{
			if ("root".equals(menu1.getPid()))
			{
				roots.add(recursive(list, menu1));
			}
		}

		return roots;
	}

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

}
