package org.shinomin.menjin.webservice;

import java.io.UnsupportedEncodingException;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.shinomin.commons.utils.DateUtil;
import org.shinomin.commons.utils.JsonUtil;
import org.shinomin.menjin.bean.HwCardBean;
import org.shinomin.menjin.bean.HwPersonBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tempuri.zmlq_xsd.service_wsdl.ServicePortType;

public class WsUtil {
	private static Logger logger = LoggerFactory.getLogger(WsUtil.class);
	private static int initCount = 0;

	private static ServicePortType getWsType() {
		JaxWsProxyFactoryBean factoryBean = new JaxWsProxyFactoryBean();
		factoryBean.setServiceClass(ServicePortType.class);
		factoryBean.setAddress("http://10.157.12.40:9977/");
		ServicePortType type = (ServicePortType) factoryBean.create();
		if (initCount++ == 0) {
			init(type);
		}
		return type;
	}

	private static void init(ServicePortType type) {
		boolean bAutoLogin = true;
		String inStrDBAddr = "";
		String inStrDBName = "";
		String inStrDBUser = "";
		String inStrDBPassword = "";
		String inStrPCAddr = "";
		String inStrPCUser = "";
		String inStrPCPassword = "";
		type.init(bAutoLogin, inStrDBAddr, inStrDBName, inStrDBUser, inStrDBPassword, inStrPCAddr, inStrPCUser,
				inStrPCPassword);
		logger.info("web service init finish");
	}

	public static String getAllPersons() {
		String result = getWsType().getAllPersons();
		try {
			result = new String(result.getBytes("iso-8859-1"), "gbk");
		} catch (UnsupportedEncodingException e) {
		}
		return result;
	}

	public static String queryPersons(String field, String oper, String value) {
		logger.info("field:{}, oper:{}, value:{}", field, oper, value);
		String result = getWsType().queryPersons(field, oper, value);
		try {
			result = new String(result.getBytes("iso-8859-1"), "gbk");
		} catch (UnsupportedEncodingException e) {
		}
		return result;
	}

	public static String queryCards(String field, String oper, String value) {
		logger.info("field:{}, oper:{}, value:{}", field, oper, value);
		String result = getWsType().queryCards(field, oper, value);
		try {
			result = new String(result.getBytes("iso-8859-1"), "gbk");
		} catch (UnsupportedEncodingException e) {
		}
		return result;
	}

	public static String getAllReaders(String acCodeID) {
		logger.info("accode:{}", acCodeID);
		String result = getWsType().getAllReaders(acCodeID);
		try {
			result = new String(result.getBytes("iso-8859-1"), "gbk");
		} catch (UnsupportedEncodingException e) {
		}
		return result;
	}

	public static String getAllACCodes(String personid, String cardno) {
		logger.info("person:{}, cardno:{}", personid, cardno);
		String result = getWsType().getAllACCodes(personid, cardno);
		try {
			result = new String(result.getBytes("iso-8859-1"), "gbk");
		} catch (UnsupportedEncodingException e) {
		}
		return result;
	}

	public static String addPerson(HwPersonBean person, String badgeId) {
		HwPersonBean _person = new HwPersonBean();
		_person.setId("");
		_person.setLname(person.getLname());
		_person.setFname(person.getFname());
		_person.setIssue_date(person.getIssue_date());
		_person.setExpire_date(person.getExpire_date());
		String json = JsonUtil.toJson(_person);
		// {"id":"0x002dfd0e7fb3088411d3aa910040051fce21","descrp":"标准雇员"}
		// {"id":"0x002dfd0e7fb4088411d3aa910040051fce21","descrp":"订约人"}
		logger.info("person:{}, badge:{}", json, badgeId);
		String result = getWsType().addPerson(json, badgeId);
		return result;
	}

	public static String addCard(HwCardBean card, String companyid) {
		// {"id":"0x00481576267975bf4c9cb7a2d3a8c0d46df4","nam":"外包职工公共权限"}
		// {"id":"0x004842343236434238382d443536302d3433","nam":"No Access"}
		// {"id":"0x0048729e6eb48d9311d4a45600508bc86902","nam":"NexWatch"}
		// {"id":"0x0048867a5151855d4d9f9d4d638a80b2fc0b","nam":"办公楼隆达职工（打扫卫生）"}
		// {"id":"0x00488a1872d040a54a3882e897327e7955a0","nam":"All Access"}
		// {"id":"0x004893d5a574470d42c18df519d6fab6347a","nam":"内部职工公共权限"}
		HwCardBean _card = new HwCardBean();
		_card.setCardno(card.getCardno());
		_card.setPersonid(card.getPersonid());
		_card.setPincode("");
		_card.setStat_cod("A");
		_card.setIssue_date(card.getIssue_date());
		_card.setExpire_date(card.getExpire_date());
		String json = JsonUtil.toJson(_card);
		String result = getWsType().addCard(json, "0x00488a1872d040a54a3882e897327e7955a0");
		return result;
	}

	public static String addACCodeToCard(String cardno, String accodeid) {
		logger.info("cardno:{}, accodeid:{}", cardno, accodeid);
		String result = getWsType().addACCodeToCard(accodeid, cardno);
		return result;
	}

	public static String removeACCodeFromCard(String cardno, String accodeid) {
		logger.info("cardno:{}, accodeid:{}", cardno, accodeid);
		String result = getWsType().removeACCodeFromCard(accodeid, cardno);
		return result;
	}

	public static String readerControl(String readerid, int cmd) {
		logger.info("readerid:{}, cmd:{}", readerid, cmd);
		String result = getWsType().readerControl(readerid, cmd);
		return result;
	}

	public static String removeCard(String cardno) {
		logger.info("cardno:{}", cardno);
		String result = getWsType().removeCard(cardno);
		return result;
	}

	public static String removePerson(String personid) {
		logger.info("personid:{}", personid);
		String result = getWsType().removePerson(personid);
		return result;
	}

	public static String startRecvRealEvent() {
		String result = getWsType().startRecvRealEvent();
		logger.info("startRecvRealEvent done");
		return result;
	}

	public static String stopRecvRealEvent() {
		String result = getWsType().stopRecvRealEvent();
		logger.info("stopRecvRealEvent done");
		return result;
	}

	public static String getHistoryEvent(String beginDate, String endDate, boolean isTrigger) {
		logger.info("getHistoryEvent:{}-{}", beginDate, endDate);
		long begin = DateUtil.parseDate(beginDate).getTime() / 1000;
		long end = DateUtil.parseDate(endDate).getTime() / 1000;
		String result = getWsType().getHistoryEvent(begin, end, isTrigger);
		try {
			result = new String(result.getBytes("iso-8859-1"), "gbk");
		} catch (UnsupportedEncodingException e) {
		}
		return result;
	}

}
