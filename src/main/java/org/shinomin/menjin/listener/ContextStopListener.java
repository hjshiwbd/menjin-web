package org.shinomin.menjin.listener;

import org.shinomin.menjin.webservice.WsQuery;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextStoppedEvent;
import org.springframework.stereotype.Component;

/**
 * 服务启动时,自动执行
 * 
 * @author hjin
 * 
 */
@Component
public class ContextStopListener implements ApplicationListener<ContextClosedEvent> {

	@Override
	public void onApplicationEvent(ContextClosedEvent event) {
		WsQuery.stopRecvRealEvent();
		ApplicationContext app = event.getApplicationContext();
		if (isCache(app)) {
//			WsQuery.stopRecvRealEvent();
		}
	}

	private boolean isCache(ApplicationContext app) {
		return "Root WebApplicationContext".equals(app.getDisplayName())
				|| "org.springframework.context.support.GenericApplicationContext".equals(app.getClass().getName());
	}

}
