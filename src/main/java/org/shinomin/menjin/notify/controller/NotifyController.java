package org.shinomin.menjin.notify.controller;

import org.apache.commons.lang3.StringUtils;
import org.nutz.json.Json;
import org.shinomin.commons.bean.ExecuteResult;
import org.shinomin.commons.utils.JsonUtil;
import org.shinomin.menjin.bean.HwpaeventBean;
import org.shinomin.menjin.log.service.IHwpaeventService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/notify")
public class NotifyController {
	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private IHwpaeventService hwpaeventService;

	@ResponseBody
	@RequestMapping(value = "/event")
	public String event(String message) throws Exception {
		logger.info("message:{}", message);
		ExecuteResult e = new ExecuteResult("0", "");

		if (StringUtils.isNotBlank(message)) {
			try {
				HwpaeventBean event = Json.fromJson(HwpaeventBean.class, message);
				hwpaeventService.insert(event);
				logger.debug("eventlog save finish");
				e.setResult("1");
				e.setMessage("ok");
			} catch (Exception e1) {
				logger.info(e1.getMessage(), e1);
				e.setMessage("proccess_failed");
			}
		} else {
			e.setMessage("message_invalid");
		}

		return JsonUtil.toJson(e);
	}

}
