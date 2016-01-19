package org.shinomin.menjin.interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.shinomin.commons.utils.WildcardUtil;
import org.shinomin.menjin.bean.MenuBean;
import org.shinomin.menjin.spring.session.LoginSessionScope;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * 设置menu
 * 
 * @author hjin
 * 
 */
public class MenuInterceptor extends HandlerInterceptorAdapter
{
	private Logger logger = LoggerFactory.getLogger(getClass());
	private List<String> doNotIntercept;
	@Autowired
	private LoginSessionScope loginSessionScope;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception
	{
		if (!(handler instanceof HandlerMethod))
		{
			// 非常规请求
			logger.info("unexpected handler:" + handler.toString());
			return super.preHandle(request, response, handler);
		}

		HandlerMethod c = (HandlerMethod) handler;
		// 被拦截类名
		String clzName = c.getBeanType().getSimpleName();
		// 被拦截方法名
		String methodName = c.getMethod().getName();
		// 被拦截点
		String interceptPoint = clzName + "." + methodName;

		// 当前地址不需要拦截
		if (isDoNotBeIntercepted(interceptPoint))
		{
			return super.preHandle(request, response, handler);
		}

		invokeUrl(request);
		return super.preHandle(request, response, handler);
	}

	private void invokeUrl(HttpServletRequest request)
	{
		String uri = request.getRequestURI();
		String ctxpath = request.getContextPath();
		String url = uri.substring(ctxpath.length());
		List<MenuBean> list = loginSessionScope.getFlatMenuList();
		MenuBean current = null;
		if (list != null && !list.isEmpty())
		{
			for (MenuBean menu : list)
			{
				if (StringUtils.isNotBlank(menu.getUrl()) && menu.getUrl().equals(url))
				{
					logger.debug(menu.getUrl() + "-" + url);
					current = menu;
				}
			}
		}
		if (current != null)
		{
			loginSessionScope.setMenuid1(current.getPid());// 一级菜单
			loginSessionScope.setMenuid2(current.getId());// 二级菜单
		}
	}

	/**
	 * 是否不需要被拦截
	 * 
	 * @param interceptPoint
	 *            类名.方法名
	 * @return
	 */
	private boolean isDoNotBeIntercepted(String interceptPoint)
	{
		for (String wildcard : doNotIntercept)
		{
			if (WildcardUtil.isWildMatch(wildcard, interceptPoint))
			{
				return true;
			}
		}
		return false;
	}

	public List<String> getDoNotIntercept()
	{
		return doNotIntercept;
	}

	public void setDoNotIntercept(List<String> doNotIntercept)
	{
		this.doNotIntercept = doNotIntercept;
	}
}
