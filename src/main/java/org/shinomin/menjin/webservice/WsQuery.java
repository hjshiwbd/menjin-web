package org.shinomin.menjin.webservice;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.nutz.json.Json;
import org.shinomin.commons.bean.ExecuteResult;
import org.shinomin.commons.utils.ConvertUtil;
import org.shinomin.commons.utils.JsonUtil;
import org.shinomin.menjin.bean.HwAcccodeBean;
import org.shinomin.menjin.bean.HwCardBean;
import org.shinomin.menjin.bean.HwPersonBean;
import org.shinomin.menjin.bean.HwReaderBean;
import org.shinomin.menjin.bean.HwpaeventBean;
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
//			logger.debug("json:{}", json);
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

	public static List<HwCardBean> queryCards(String field, String oper, String value) {
		String json = WsUtil.queryCards(field, oper, value);
		if (StringUtils.isNotBlank(json)) {
			List<HwCardBean> list = convertList(getWsObject(json), HwCardBean.class);
			return list;
		} else {
			return null;
		}
	}

	public static List<HwReaderBean> getAllReaders(String acCodeID) {
		String json = WsUtil.getAllReaders(acCodeID);
		List<HwReaderBean> list = convertList(getWsObject(json), HwReaderBean.class);
		return list;
	}

	public static List<HwAcccodeBean> getAllACCodes(String personid, String cardno) {
		String json = WsUtil.getAllACCodes(personid, cardno);
		if (StringUtils.isNotBlank(json)) {
			List<HwAcccodeBean> list = convertList(getWsObject(json), HwAcccodeBean.class);
			logger.info("getAllACCodes size:{}", list.size());
			return list;
		} else {
			return null;
		}
	}

	public static ExecuteResult addPerson(HwPersonBean person, String badgeId) {
		String json = WsUtil.addPerson(person, badgeId);
		if (StringUtils.isNotBlank(json)) {
			logger.info("add person:{}", json);
			return Json.fromJson(ExecuteResult.class, json);
		} else {
			return null;
		}
	}

	public static ExecuteResult addCard(HwCardBean card, String companyid) {
		String json = WsUtil.addCard(card, companyid);
		if (StringUtils.isNotBlank(json)) {
			logger.info("addCard:{}", json);
			return Json.fromJson(ExecuteResult.class, json);
		} else {
			return null;
		}
	}

	public static boolean addACCodeToCard(String cardid, String accodeid) {
		String json = WsUtil.addACCodeToCard(cardid, accodeid);
		if (StringUtils.isNotBlank(json)) {
			logger.info("addACCodeToCard:{}", json);
			ExecuteResult e = Json.fromJson(ExecuteResult.class, json);
			return "0".equals(e.getResult());
		} else {
			return false;
		}
	}

	public static boolean removeACCodeFromCard(String cardid, String accodeid) {
		String json = WsUtil.removeACCodeFromCard(cardid, accodeid);
		if (StringUtils.isNotBlank(json)) {
			logger.info("removeACCodeFromCard:{}", json);
			ExecuteResult e = Json.fromJson(ExecuteResult.class, json);
			return "0".equals(e.getResult());
		} else {
			return false;
		}
	}

	public static boolean removeCard(String cardno) {
		String json = WsUtil.removeCard(cardno);
		if (StringUtils.isNotBlank(json)) {
			logger.info("removeCard:{}", json);
			ExecuteResult e = Json.fromJson(ExecuteResult.class, json);
			return "0".equals(e.getResult());
		} else {
			return false;
		}
	}

	public static boolean removePerson(String personid) {
		String json = WsUtil.removePerson(personid);
		if (StringUtils.isNotBlank(json)) {
			logger.info("removePerson:{}", json);
			ExecuteResult e = Json.fromJson(ExecuteResult.class, json);
			return "0".equals(e.getResult());
		} else {
			return false;
		}
	}

	public static boolean readerControl(String readerid, int cmd) {
		String json = WsUtil.readerControl(readerid, cmd);
		if (StringUtils.isNotBlank(json)) {
			logger.info("readerControl:{}", json);
			ExecuteResult e = Json.fromJson(ExecuteResult.class, json);
			return "0".equals(e.getResult());
		} else {
			return false;
		}
	}

	public static boolean startRecvRealEvent() {
		String json = WsUtil.startRecvRealEvent();
		if (StringUtils.isNotBlank(json)) {
			logger.info("startRecvRealEvent:{}", json);
			ExecuteResult e = Json.fromJson(ExecuteResult.class, json);
			return "0".equals(e.getResult());
		} else {
			return false;
		}
	}

	public static boolean stopRecvRealEvent() {
		String json = WsUtil.stopRecvRealEvent();
		if (StringUtils.isNotBlank(json)) {
			logger.info("stopRecvRealEvent:{}", json);
			ExecuteResult e = Json.fromJson(ExecuteResult.class, json);
			return "0".equals(e.getResult());
		} else {
			return false;
		}
	}

	public static List<HwpaeventBean> getHistoryEvent(String beginDate, String endDate, boolean isTrigger) {
		String json = WsUtil.getHistoryEvent(beginDate, endDate,isTrigger);
		if (StringUtils.isNotBlank(json)) {
			List<HwpaeventBean> list = convertList(getWsObject(json), HwpaeventBean.class);
			logger.info("eventlist size:{}", list.size());
			return list;
		} else {
			return null;
		}
	}

}
