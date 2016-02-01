package org.shinomin.menjin.webservice;

import java.io.UnsupportedEncodingException;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.tempuri.zmlq_xsd.service_wsdl.ServicePortType;

public class WsUtil {
	private static ServicePortType getWsType() {
		JaxWsProxyFactoryBean factoryBean = new JaxWsProxyFactoryBean();
		factoryBean.setServiceClass(ServicePortType.class);
		factoryBean.setAddress("http://10.157.12.40:9977/");
		ServicePortType type = (ServicePortType) factoryBean.create();
		return type;
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

}
