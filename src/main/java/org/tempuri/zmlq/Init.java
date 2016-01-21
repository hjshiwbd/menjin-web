
package org.tempuri.zmlq;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>anonymous complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="in-strDBAddr" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="in-strDBName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="in-strDBUser" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="in-strDBPassword" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="in-strPCAddr" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="in-strPCUser" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "inStrDBAddr",
    "inStrDBName",
    "inStrDBUser",
    "inStrDBPassword",
    "inStrPCAddr",
    "inStrPCUser"
})
@XmlRootElement(name = "Init")
public class Init {

    @XmlElementRef(name = "in-strDBAddr", type = JAXBElement.class, required = false)
    protected JAXBElement<String> inStrDBAddr;
    @XmlElementRef(name = "in-strDBName", type = JAXBElement.class, required = false)
    protected JAXBElement<String> inStrDBName;
    @XmlElementRef(name = "in-strDBUser", type = JAXBElement.class, required = false)
    protected JAXBElement<String> inStrDBUser;
    @XmlElementRef(name = "in-strDBPassword", type = JAXBElement.class, required = false)
    protected JAXBElement<String> inStrDBPassword;
    @XmlElementRef(name = "in-strPCAddr", type = JAXBElement.class, required = false)
    protected JAXBElement<String> inStrPCAddr;
    @XmlElementRef(name = "in-strPCUser", type = JAXBElement.class, required = false)
    protected JAXBElement<String> inStrPCUser;

    /**
     * ��ȡinStrDBAddr���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getInStrDBAddr() {
        return inStrDBAddr;
    }

    /**
     * ����inStrDBAddr���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setInStrDBAddr(JAXBElement<String> value) {
        this.inStrDBAddr = value;
    }

    /**
     * ��ȡinStrDBName���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getInStrDBName() {
        return inStrDBName;
    }

    /**
     * ����inStrDBName���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setInStrDBName(JAXBElement<String> value) {
        this.inStrDBName = value;
    }

    /**
     * ��ȡinStrDBUser���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getInStrDBUser() {
        return inStrDBUser;
    }

    /**
     * ����inStrDBUser���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setInStrDBUser(JAXBElement<String> value) {
        this.inStrDBUser = value;
    }

    /**
     * ��ȡinStrDBPassword���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getInStrDBPassword() {
        return inStrDBPassword;
    }

    /**
     * ����inStrDBPassword���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setInStrDBPassword(JAXBElement<String> value) {
        this.inStrDBPassword = value;
    }

    /**
     * ��ȡinStrPCAddr���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getInStrPCAddr() {
        return inStrPCAddr;
    }

    /**
     * ����inStrPCAddr���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setInStrPCAddr(JAXBElement<String> value) {
        this.inStrPCAddr = value;
    }

    /**
     * ��ȡinStrPCUser���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getInStrPCUser() {
        return inStrPCUser;
    }

    /**
     * ����inStrPCUser���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setInStrPCUser(JAXBElement<String> value) {
        this.inStrPCUser = value;
    }

}
