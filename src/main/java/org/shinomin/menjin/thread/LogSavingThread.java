package org.shinomin.menjin.thread;

import java.io.Serializable;

import org.shinomin.menjin.accesslog.service.IAccessLogService;
import org.shinomin.menjin.bean.HttpRequestBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class LogSavingThread implements Runnable
{
	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private IAccessLogService accessLogService;

	private HttpRequestBean request;
	private String clzName;
	private String methodName;
	private String userid;
	private String logContent;

	@Override
	public void run()
	{
		if (request != null)
		{
			Serializable log = accessLogService.initAccessLog(request,
			        clzName, methodName, userid, logContent);
			accessLogService.insertAccessLog(log);
			logger.info("accesslog saved");
		}
	}

	public HttpRequestBean getRequest()
	{
		return request;
	}

	public void setRequest(HttpRequestBean request)
	{
		this.request = request;
	}

	public String getClzName()
	{
		return clzName;
	}

	public void setClzName(String clzName)
	{
		this.clzName = clzName;
	}

	public String getMethodName()
	{
		return methodName;
	}

	public void setMethodName(String methodName)
	{
		this.methodName = methodName;
	}

	public String getLogContent()
	{
		return logContent;
	}

	public void setLogContent(String logContent)
	{
		this.logContent = logContent;
	}

	public String getUserid()
	{
		return userid;
	}

	public void setUserid(String userid)
	{
		this.userid = userid;
	}
}
