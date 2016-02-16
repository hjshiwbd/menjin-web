package org.shinomin.menjin.webservice;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.shinomin.commons.utils.ConvertUtil;
import org.shinomin.commons.utils.JsonUtil;
import org.shinomin.menjin.bean.HwAcccodeBean;
import org.shinomin.menjin.bean.HwPersonBean;
import org.shinomin.menjin.bean.HwReaderBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * web service查询
 * 
 * @author hjin
 * 
 */
public class WsQuery {
	private static Logger logger = LoggerFactory.getLogger(WsQuery.class);

	private static String RESULT = "result";
	private static String MESSAGE = "message";
	private static String OBJECT = "object";

	@SuppressWarnings("unchecked")
	private static <T> List<T> convertList(Object wsObject, Class<T> clz) {
		if (wsObject instanceof List<?>) {
			List<T> list = new ArrayList<>();
			List<Map<String, Object>> src = (List<Map<String, Object>>) wsObject;
			for (Map<String, Object> map : src) {
				T t = ConvertUtil.mapToObject(map, clz);
				list.add(t);
			}
			return list;
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	private static Object getWsObject(String json) {
		if (logger.isDebugEnabled()) {
			logger.debug("json:{}", json);
		}
		Map<String, Object> map = (Map<String, Object>) JsonUtil.toObj(json);
		String result = map.get(RESULT).toString();
		if ("0".equals(result)) {
			Object obj = map.get(OBJECT);
			return obj;
		} else if ("1".equals(result)) {
			String msg = map.get(MESSAGE).toString();
			logger.info("ws failed msg:{}", msg);
			return null;
		} else {
			logger.info("ws returns nothing");
			return null;
		}
	}

	public static List<HwPersonBean> getAllPersons() {
		String json = WsUtil.getAllPersons();
		List<HwPersonBean> list = convertList(getWsObject(json), HwPersonBean.class);
		logger.info("person size:{}", list.size());
		return list;
	}

	public static List<HwPersonBean> queryPersons(String field, String oper, String value) {
		String json = WsUtil.queryPersons(field, oper, value);
		if (StringUtils.isNotBlank(json)) {
			List<HwPersonBean> list = convertList(getWsObject(json), HwPersonBean.class);
			return list;
		} else {
			return null;
		}
	}

	public static List<HwPersonBean> queryPersons(HwPersonBean person) {
		String[] arr = getQueryPersonParam(person);
		String json = WsUtil.queryPersons(arr[0], arr[1], arr[2]);
		List<HwPersonBean> list = convertList(getWsObject(json), HwPersonBean.class);
		return list;
	}

	public static List<HwReaderBean> getAllReaders(String acCodeID) {
		String json = WsUtil.getAllReaders(acCodeID);
		List<HwReaderBean> list = convertList(getWsObject(json), HwReaderBean.class);
		return list;
	}

	private static String[] getQueryPersonParam(HwPersonBean person) {
		String[] arr = new String[3];
		String field = "";
		String oper = "like";
		String value = "";
		if (StringUtils.isNotBlank(person.getId())) {
			field = "ID";
			value = person.getId();
		} else if (StringUtils.isNotBlank(person.getLname())) {
			field = "LNAME";
			value = person.getLname();
		} else if (StringUtils.isNotBlank(person.getFname())) {
			field = "FNAME";
			value = person.getFname();
		} else if (StringUtils.isNotBlank(person.getIssue_date1())) {
			field = "ISSUE_DATE";
			oper = ">=";
			value = person.getIssue_date1();
		} else if (StringUtils.isNotBlank(person.getIssue_date2())) {
			field = "ISSUE_DATE";
			oper = "<=";
			value = person.getIssue_date1();
		} else if (StringUtils.isNotBlank(person.getExpire_date1())) {
			field = "EXPIRE_DATE";
			oper = "<=";
			value = person.getIssue_date1();
		} else if (StringUtils.isNotBlank(person.getExpire_date2())) {
			field = "EXPIRE_DATE";
			oper = "<=";
			value = person.getIssue_date1();
		}

		arr[0] = field;
		arr[1] = oper;
		arr[2] = value;
		return arr;
	}

	public static List<HwAcccodeBean> getAllACCodes(String personid, String cardno) {
		String json = WsUtil.getAllACCodes(personid, cardno);
		if (StringUtils.isNotBlank(json)) {
			List<HwAcccodeBean> list = convertList(getWsObject(json), HwAcccodeBean.class);
			logger.info("person size:{}", list.size());
			return list;
		} else {
			return null;
		}
	}
}
