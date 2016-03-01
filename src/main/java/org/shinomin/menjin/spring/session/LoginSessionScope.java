package org.shinomin.menjin.spring.session;

import java.util.List;

import org.shinomin.menjin.bean.MenuBean;
import org.shinomin.menjin.bean.UserBean;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

@Component
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class LoginSessionScope {
	private UserBean loginUser;
	private List<MenuBean> treeMenuList;
	private List<MenuBean> flatMenuList;
	/**
	 * 当前访问页面的1级菜单id
	 */
	private String menuid1;
	/**
	 * 当前访问页面的2级菜单id
	 */
	private String menuid2;

	/**
	 * is admin
	 * 
	 * @return
	 */
	public boolean isAdminUser() {
		if (loginUser == null) {
			return false;
		} else {
			return "admin".equals(loginUser.getUsername());
		}
	}

	public UserBean getLoginUser() {
		return loginUser;
	}

	public void setLoginUser(UserBean loginUser) {
		this.loginUser = loginUser;
	}

	public List<MenuBean> getTreeMenuList() {
		return treeMenuList;
	}

	public void setTreeMenuList(List<MenuBean> treeMenuList) {
		this.treeMenuList = treeMenuList;
	}

	public List<MenuBean> getFlatMenuList() {
		return flatMenuList;
	}

	public void setFlatMenuList(List<MenuBean> flatMenuList) {
		this.flatMenuList = flatMenuList;
	}

	public String getMenuid1() {
		return menuid1;
	}

	public void setMenuid1(String menuid1) {
		this.menuid1 = menuid1;
	}

	public String getMenuid2() {
		return menuid2;
	}

	public void setMenuid2(String menuid2) {
		this.menuid2 = menuid2;
	}

}
