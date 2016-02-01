package org.shinomin.menjin.notify.controller;

import org.shinomin.commons.bean.ExecuteResult;
import org.shinomin.commons.utils.JsonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/notify")
public class NotifyController {
	private Logger logger = LoggerFactory.getLogger(getClass());

	@ResponseBody
	@RequestMapping(value = "/testPost", method = RequestMethod.POST)
	public String testPost(String message) throws Exception {
		logger.info("message:{}", message);

		ExecuteResult e = new ExecuteResult("1", "ok");
		e.setObject(message);

		return JsonUtil.toJson(e);
	}

	@ResponseBody
	@RequestMapping(value = "/testGet", method = RequestMethod.GET)
	public String testGet(String message) throws Exception {
		logger.info("message:{}", message);

		ExecuteResult e = new ExecuteResult("1", "ok");
		e.setObject(message);

		return JsonUtil.toJson(e);
	}

}
