package org.shinomin.menjin.bean;

import java.io.Serializable;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.shinomin.commons.utils.CommonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings("serial")
public class HttpRequestBean implements Serializable
{
	Logger logger = LoggerFactory.getLogger(getClass());
	private Map<String, Object> parameter;
	private String ip;
	private String uri;
	private Map<String, String> header;
	private String sessionid;
	private Map<String, Object> sessionAttribute;

	public HttpRequestBean(HttpServletRequest request,HttpServletResponse response)
	{
		if (request != null)
		{
			setHeader(request);
			setParameter(request);
			ip = CommonUtil.getIpAddr(request);
			uri=request.getRequestURI();
			try
            {
	            if (request.getSession() != null)
	            {
	            	setSessionAttribute(request.getSession());
	            	sessionid = request.getSession().getId();
	            }
            }
            catch (Exception e)
            {
            	// session获取失败,暂无处理
            }
		}
	}

	public Map<String, Object> getParameter()
	{
		return parameter;
	}

	@SuppressWarnings("unchecked")
	private void setParameter(HttpServletRequest request)
	{
		parameter = new HashMap<String, Object>();
		Enumeration<String> names = request.getParameterNames();
		while (names.hasMoreElements())
		{
			String name = (String) names.nextElement();
			Object value = request.getParameter(name);
			parameter.put(name, value);
		}
	}

	public String getIp()
	{
		return ip;
	}

	public String getUri()
	{
		return uri;
	}

	public Map<String, String> getHeader()
	{
		return header;
	}

	@SuppressWarnings("unchecked")
	private void setHeader(HttpServletRequest request)
	{
		header = new HashMap<String, String>();
		Enumeration<String> names = request.getHeaderNames();
		while (names.hasMoreElements())
		{
			String name = names.nextElement();
			header.put(name, request.getHeader(name));
		}
	}

	public String getSessionid()
	{
		return sessionid;
	}

	public Map<String, Object> getSessionAttribute()
	{
		return sessionAttribute;
	}

	@SuppressWarnings("unchecked")
	private void setSessionAttribute(HttpSession session)
	{
		sessionAttribute = new HashMap<String, Object>();
		Enumeration<String> names = session.getAttributeNames();
		while (names.hasMoreElements())
		{
			String name = (String) names.nextElement();
			Object value = session.getAttribute(name);
			sessionAttribute.put(name, value);
		}
	}
}
