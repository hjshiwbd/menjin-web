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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * web service查询
 * 
 * @author hjin
 * 
 */
@Component
public class WsQuery {
	private Logger logger = LoggerFactory.getLogger(WsQuery.class);

	@Autowired
	private WsUtil wsUtil;
	
	private String RESULT = "result";
	private String MESSAGE = "message";
	private String OBJECT = "object";

	@SuppressWarnings("unchecked")
	private <T> List<T> convertList(Object wsObject, Class<T> clz) {
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
	private Object getWsObject(String json) {
		if (logger.isDebugEnabled()) {
			// logger.debug("json:{}", json);
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

	public List<HwPersonBean> getAllPersons() {
		String json = wsUtil.getAllPersons();
		List<HwPersonBean> list = convertList(getWsObject(json), HwPersonBean.class);
		logger.info("person size:{}", list.size());
		return list;
	}

	public List<HwPersonBean> queryPersons(String field, String oper, String value) {
		String json = wsUtil.queryPersons(field, oper, value);
		if (StringUtils.isNotBlank(json)) {
			List<HwPersonBean> list = convertList(getWsObject(json), HwPersonBean.class);
			return list;
		} else {
			return null;
		}
	}

	public List<HwCardBean> queryCards(String field, String oper, String value) {
		String json = wsUtil.queryCards(field, oper, value);
		if (StringUtils.isNotBlank(json)) {
			List<HwCardBean> list = convertList(getWsObject(json), HwCardBean.class);
			return list;
		} else {
			return null;
		}
	}

	public List<HwReaderBean> getAllReaders(String acCodeID) {
		String json = wsUtil.getAllReaders(acCodeID);
		List<HwReaderBean> list = convertList(getWsObject(json), HwReaderBean.class);
		return list;
	}

	public List<HwAcccodeBean> getAllACCodes(String personid, String cardno) {
		String json = wsUtil.getAllACCodes(personid, cardno);
		if (StringUtils.isNotBlank(json)) {
			List<HwAcccodeBean> list = convertList(getWsObject(json), HwAcccodeBean.class);
			logger.info("getAllACCodes size:{}", list.size());
			return list;
		} else {
			return null;
		}
	}

	public ExecuteResult addPerson(HwPersonBean person, String badgeId) {
		String json = wsUtil.addPerson(person, badgeId);
		if (StringUtils.isNotBlank(json)) {
			logger.info("add person:{}", json);
			return Json.fromJson(ExecuteResult.class, json);
		} else {
			return null;
		}
	}

	public ExecuteResult addCard(HwCardBean card, String companyid) {
		String json = wsUtil.addCard(card, companyid);
		if (StringUtils.isNotBlank(json)) {
			logger.info("addCard:{}", json);
			return Json.fromJson(ExecuteResult.class, json);
		} else {
			return null;
		}
	}

	public boolean addACCodeToCard(String cardid, String accodeid) {
		String json = wsUtil.addACCodeToCard(cardid, accodeid);
		if (StringUtils.isNotBlank(json)) {
			logger.info("addACCodeToCard:{}", json);
			ExecuteResult e = Json.fromJson(ExecuteResult.class, json);
			return "0".equals(e.getResult());
		} else {
			return false;
		}
	}

	public boolean removeACCodeFromCard(String cardid, String accodeid) {
		String json = wsUtil.removeACCodeFromCard(cardid, accodeid);
		if (StringUtils.isNotBlank(json)) {
			logger.info("removeACCodeFromCard:{}", json);
			ExecuteResult e = Json.fromJson(ExecuteResult.class, json);
			return "0".equals(e.getResult());
		} else {
			return false;
		}
	}

	public boolean removeCard(String cardno) {
		String json = wsUtil.removeCard(cardno);
		if (StringUtils.isNotBlank(json)) {
			logger.info("removeCard:{}", json);
			ExecuteResult e = Json.fromJson(ExecuteResult.class, json);
			return "0".equals(e.getResult());
		} else {
			return false;
		}
	}

	public boolean removePerson(String personid) {
		String json = wsUtil.removePerson(personid);
		if (StringUtils.isNotBlank(json)) {
			logger.info("removePerson:{}", json);
			ExecuteResult e = Json.fromJson(ExecuteResult.class, json);
			return "0".equals(e.getResult());
		} else {
			return false;
		}
	}

	public boolean readerControl(String readerid, int cmd) {
		String json = wsUtil.readerControl(readerid, cmd);
		if (StringUtils.isNotBlank(json)) {
			logger.info("readerControl:{}", json);
			ExecuteResult e = Json.fromJson(ExecuteResult.class, json);
			return "0".equals(e.getResult());
		} else {
			return false;
		}
	}

	public boolean startRecvRealEvent() {
		String json = wsUtil.startRecvRealEvent();
		if (StringUtils.isNotBlank(json)) {
			logger.info("startRecvRealEvent:{}", json);
			ExecuteResult e = Json.fromJson(ExecuteResult.class, json);
			return "0".equals(e.getResult());
		} else {
			return false;
		}
	}

	public boolean stopRecvRealEvent() {
		String json = wsUtil.stopRecvRealEvent();
		if (StringUtils.isNotBlank(json)) {
			logger.info("stopRecvRealEvent:{}", json);
			ExecuteResult e = Json.fromJson(ExecuteResult.class, json);
			return "0".equals(e.getResult());
		} else {
			return false;
		}
	}

	public List<HwpaeventBean> getHistoryEvent(String beginDate, String endDate, boolean isTrigger) {
		String json = wsUtil.getHistoryEvent(beginDate, endDate, isTrigger);
		if (StringUtils.isNotBlank(json)) {
			List<HwpaeventBean> list = convertList(getWsObject(json), HwpaeventBean.class);
			logger.info("eventlist size:{}", list.size());
			return list;
		} else {
			return null;
		}
	}

}
