package org.shinomin.menjin.listener;

import org.shinomin.menjin.webservice.WsQuery;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * 服务启动时,自动执行
 * 
 * @author hjin
 * 
 */
@Component
public class ContextLoadListener implements ApplicationListener<ContextRefreshedEvent> {

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		ApplicationContext app = event.getApplicationContext();
		if (isCache(app)) {
			WsQuery.startRecvRealEvent();
		}
	}

	private boolean isCache(ApplicationContext app) {
		return "Root WebApplicationContext".equals(app.getDisplayName())
				|| "org.springframework.context.support.GenericApplicationContext".equals(app.getClass().getName());
	}

}
