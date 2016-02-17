package org.shinomin.menjin.webservice;

import java.io.UnsupportedEncodingException;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
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
		String result = getWsType().queryPersons(field, oper, value);
		try {
			result = new String(result.getBytes("iso-8859-1"), "gbk");
		} catch (UnsupportedEncodingException e) {
		}
		return result;
	}

	public static String getAllReaders(String acCodeID) {
		String result = getWsType().getAllReaders(acCodeID);
		try {
			result = new String(result.getBytes("iso-8859-1"), "gbk");
		} catch (UnsupportedEncodingException e) {
		}
		return result;
	}

	public static String getAllACCodes(String personid, String cardno) {
		String result = getWsType().getAllACCodes(personid, cardno);
		try {
			result = new String(result.getBytes("iso-8859-1"), "gbk");
		} catch (UnsupportedEncodingException e) {
		}
		return result;
	}
}
