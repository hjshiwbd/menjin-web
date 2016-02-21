package org.shinomin.menjin.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ExceptionResolver {
	private Logger logger = LoggerFactory.getLogger(getClass());

	@ExceptionHandler(Exception.class)
	public ModelAndView handler(Exception ex) {
		ModelAndView model = new ModelAndView();
		logger.info(ex.getMessage(), ex);
		model.addObject("result", "0");
		model.addObject("message", "系统响应异常，请稍候再试");
		model.addObject("continueurl", "/");
		model.setViewName("error/error500");
		return model;
	}
}