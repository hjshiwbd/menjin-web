package org.shinomin.menjin.accesslog.service.impl;

import java.io.Serializable;

import org.apache.commons.lang3.StringUtils;
import org.shinomin.commons.utils.JsonUtil;
import org.shinomin.menjin.accesslog.service.IAccessLogService;
import org.shinomin.menjin.bean.HttpRequestBean;
import org.shinomin.menjin.bean.QqrzBean;
import org.shinomin.menjin.bean.UserBean;
import org.shinomin.menjin.constant.MenjinSessionConstant;
import org.shinomin.menjin.qqrz.dao.IQqrzDAO;
import org.shinomin.menjin.spring.session.LoginSessionScope;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QqrzServceImpl implements IAccessLogService
{
	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private IQqrzDAO qqrzDAO;
	@Autowired
	private LoginSessionScope loginSessionScope;

	@Override
	public Serializable initAccessLog(HttpRequestBean request, String clzName, String methodName, String userid, String logContent)
	{
		QqrzBean log = new QqrzBean();
		log.setRybh(getUserid(request, userid));
		log.setFfm(methodName);
		log.setLm(clzName);
		log.setIp(request.getIp());
		log.setHeader(JsonUtil.toJson(request.getHeader()));
		log.setQqcs(JsonUtil.toJson(request.getParameter()));
		log.setQqms(logContent);
		log.setQqdz(request.getUri());
		log.setSessionid(request.getSessionid());

		if (logger.isDebugEnabled())
		{
			logger.debug("accesslog:{}", JsonUtil.toJson(log));
		}
		return log;
	}

	private String getUserid(HttpRequestBean request, String userid)
	{
		if (StringUtils.isNotBlank(userid))
		{
			return userid;
		}

		if (request.getSessionAttribute() != null)
		{
			UserBean user = (UserBean) request.getSessionAttribute().get(MenjinSessionConstant.SESSION_USER);
			return user == null ? null : user.getUsername();
		}
		else
		{
			return null;
		}
	}

	@Override
	public void insertAccessLog(Serializable log)
	{
		qqrzDAO.insert(log);
	}

}
