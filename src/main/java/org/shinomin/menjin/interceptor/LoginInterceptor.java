package org.shinomin.menjin.interceptor;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.shinomin.commons.utils.WildcardUtil;
import org.shinomin.menjin.login.service.ILoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter
{
	private Logger logger = LoggerFactory.getLogger(getClass());

	private List<String> doNotIntercept;

	@Autowired
	private ILoginService loginService;

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

		// 是否登录
		if (!loginService.isLogined())
		{
			// 未登录,解析当前地址
			String currentUrl = getCurrentUrl(request);
			String loginUrl = request.getContextPath() + "/login/login.html?continueurl=" + currentUrl;
			// 重定向到登录并携带当前地址
			logger.info("not login, redirect to:{}", loginUrl);
			response.sendRedirect(loginUrl);
			return false;
		}
		else
		{
			// 已登录继续
			return super.preHandle(request, response, handler);
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

	/**
	 * 获得当前请求地址
	 * 
	 * @param request
	 * @return
	 * @author hjin
	 */
	private String getCurrentUrl(HttpServletRequest request)
	{
		String requestUrl = request.getRequestURL().toString();
		String queryString = "";
		if (request.getMethod().equals("GET"))
		{
			queryString = request.getQueryString();
			queryString = queryString == null ? "" : "?" + queryString;
		}
		String url = null;
		try
		{
			url = URLEncoder.encode(requestUrl + queryString, "utf-8");
		}
		catch (UnsupportedEncodingException e)
		{
			logger.error(e.getMessage(), e);
		}
		return url;
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
