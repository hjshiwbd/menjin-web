package org.shinomin.menjin.exception;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.shinomin.commons.bean.ExecuteResult;
import org.shinomin.commons.utils.JsonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ExceptionResolver {
	private Logger logger = LoggerFactory.getLogger(getClass());

	@ResponseBody
	@ExceptionHandler(Exception.class)
	public String handler(Exception ex) {
		// ModelAndView model = new ModelAndView();
		// logger.info(ex.getMessage(), ex);
		// model.addObject("result", "0");
		// String message = null;
		// try {
		// message = URLEncoder.encode(ex.getMessage(), "utf-8");
		// } catch (UnsupportedEncodingException e) {
		// }
		// model.addObject("message", ex.getMessage());// "系统响应异常，请稍候再试");
		// model.addObject("continueurl", "/");
		// model.setViewName("error/error500");

		ExecuteResult e = new ExecuteResult("-999", "");
		String message = null;
		try {
			message = URLEncoder.encode(ex.getMessage(), "utf-8");
		} catch (UnsupportedEncodingException e1) {
		}
		e.setMessage(message);

		return JsonUtil.toJson(e);
	}
}