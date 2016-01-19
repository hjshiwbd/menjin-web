package org.shinomin.menjin.accesslog.service;

import java.io.Serializable;

import org.shinomin.menjin.bean.HttpRequestBean;

public interface IAccessLogService
{
	/**
	 * 初始化日志对象
	 * 
	 * @param request
	 * @param clzName
	 * @param methodName
	 * @param userid
	 * @param logContent
	 * @return
	 */
	public Serializable initAccessLog(HttpRequestBean request, String clzName, String methodName, String userid, String logContent);

	/**
	 * simple
	 * 
	 * @param log
	 */
	public void insertAccessLog(Serializable log);

}
