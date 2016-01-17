package org.shinomin.menjin.spring.request;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

@Component
@Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class RequestScope
{
	private String menuid1;
	private String menuid2;

	public String getMenuid1()
	{
		return menuid1;
	}

	public void setMenuid1(String menuid1)
	{
		this.menuid1 = menuid1;
	}

	public String getMenuid2()
	{
		return menuid2;
	}

	public void setMenuid2(String menuid2)
	{
		this.menuid2 = menuid2;
	}
}
