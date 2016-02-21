package org.shinomin.menjin.webservice;

import java.io.UnsupportedEncodingException;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.shinomin.commons.utils.JsonUtil;
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
		logger.info("person:{}, badge:{}", json, badgeId);
		String result = getWsType().addPerson(json, badgeId);
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

}
