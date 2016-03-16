package org.shinomin.menjin.listener;

import org.shinomin.menjin.webservice.WsQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.stereotype.Component;

/**
 * 服务停止时,自动执行
 * 
 * @author hjin
 * 
 */
@Component
public class ContextStopListener implements ApplicationListener<ContextClosedEvent> {

	@Value("${hw.notify.turnon}")
	private String hw_notify_turnon;
	@Autowired
	private WsQuery wsQuery;

	@Override
	public void onApplicationEvent(ContextClosedEvent event) {
		if ("1".equals(hw_notify_turnon)) {
			wsQuery.stopRecvRealEvent();
		}
	}

}
