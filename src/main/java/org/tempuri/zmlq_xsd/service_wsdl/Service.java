package org.tempuri.zmlq_xsd.service_wsdl;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;

/**
 * gSOAP 2.8.27 generated service definition
 *
 * This class was generated by Apache CXF 3.1.4
 * 2016-02-21T22:58:45.301+08:00
 * Generated source version: 3.1.4
 * 
 */
@WebServiceClient(name = "Service", 
                  wsdlLocation = "http://10.157.12.40:9977/",
                  targetNamespace = "http://tempuri.org/ZMLQ.xsd/Service.wsdl") 
public class Service extends javax.xml.ws.Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://tempuri.org/ZMLQ.xsd/Service.wsdl", "Service");
    public final static QName Service = new QName("http://tempuri.org/ZMLQ.xsd/Service.wsdl", "Service");
    static {
        URL url = null;
        try {
            url = new URL("http://10.157.12.40:9977/");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(Service.class.getName())
                .log(java.util.logging.Level.INFO, 
                     "Can not initialize the default wsdl from {0}", "http://10.157.12.40:9977/");
        }
        WSDL_LOCATION = url;
    }

    public Service(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public Service() {
        super(WSDL_LOCATION, SERVICE);
    }
    
    public Service(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    public Service(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    public Service(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }    




    /**
     *
     * @return
     *     returns ServicePortType
     */
    @WebEndpoint(name = "Service")
    public ServicePortType getService() {
        return super.getPort(Service, ServicePortType.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns ServicePortType
     */
    @WebEndpoint(name = "Service")
    public ServicePortType getService(WebServiceFeature... features) {
        return super.getPort(Service, ServicePortType.class, features);
    }

}
