
package org.tempuri.zmlq;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>anonymous complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="in-strCardNO" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="in-strReaderID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="in-strTimeZoneID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="in-strTEMPACCESS" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="in-strTEMPACCESS-START-TIME" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="in-strTEMPACCESS-END-TIME" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
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
    "inStrCardNO",
    "inStrReaderID",
    "inStrTimeZoneID",
    "inStrTEMPACCESS",
    "inStrTEMPACCESSSTARTTIME",
    "inStrTEMPACCESSENDTIME"
})
@XmlRootElement(name = "AddReaderToCard")
public class AddReaderToCard {

    @XmlElementRef(name = "in-strCardNO", type = JAXBElement.class, required = false)
    protected JAXBElement<String> inStrCardNO;
    @XmlElementRef(name = "in-strReaderID", type = JAXBElement.class, required = false)
    protected JAXBElement<String> inStrReaderID;
    @XmlElementRef(name = "in-strTimeZoneID", type = JAXBElement.class, required = false)
    protected JAXBElement<String> inStrTimeZoneID;
    @XmlElementRef(name = "in-strTEMPACCESS", type = JAXBElement.class, required = false)
    protected JAXBElement<String> inStrTEMPACCESS;
    @XmlElementRef(name = "in-strTEMPACCESS-START-TIME", type = JAXBElement.class, required = false)
    protected JAXBElement<String> inStrTEMPACCESSSTARTTIME;
    @XmlElementRef(name = "in-strTEMPACCESS-END-TIME", type = JAXBElement.class, required = false)
    protected JAXBElement<String> inStrTEMPACCESSENDTIME;

    /**
     * 获取inStrCardNO属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getInStrCardNO() {
        return inStrCardNO;
    }

    /**
     * 设置inStrCardNO属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setInStrCardNO(JAXBElement<String> value) {
        this.inStrCardNO = value;
    }

    /**
     * 获取inStrReaderID属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getInStrReaderID() {
        return inStrReaderID;
    }

    /**
     * 设置inStrReaderID属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setInStrReaderID(JAXBElement<String> value) {
        this.inStrReaderID = value;
    }

    /**
     * 获取inStrTimeZoneID属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getInStrTimeZoneID() {
        return inStrTimeZoneID;
    }

    /**
     * 设置inStrTimeZoneID属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setInStrTimeZoneID(JAXBElement<String> value) {
        this.inStrTimeZoneID = value;
    }

    /**
     * 获取inStrTEMPACCESS属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getInStrTEMPACCESS() {
        return inStrTEMPACCESS;
    }

    /**
     * 设置inStrTEMPACCESS属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setInStrTEMPACCESS(JAXBElement<String> value) {
        this.inStrTEMPACCESS = value;
    }

    /**
     * 获取inStrTEMPACCESSSTARTTIME属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getInStrTEMPACCESSSTARTTIME() {
        return inStrTEMPACCESSSTARTTIME;
    }

    /**
     * 设置inStrTEMPACCESSSTARTTIME属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setInStrTEMPACCESSSTARTTIME(JAXBElement<String> value) {
        this.inStrTEMPACCESSSTARTTIME = value;
    }

    /**
     * 获取inStrTEMPACCESSENDTIME属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getInStrTEMPACCESSENDTIME() {
        return inStrTEMPACCESSENDTIME;
    }

    /**
     * 设置inStrTEMPACCESSENDTIME属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setInStrTEMPACCESSENDTIME(JAXBElement<String> value) {
        this.inStrTEMPACCESSENDTIME = value;
    }

}
