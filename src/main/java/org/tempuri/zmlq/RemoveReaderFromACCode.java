
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
 *         &lt;element name="in-strACCodeID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="in-strReaderID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
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
    "inStrACCodeID",
    "inStrReaderID"
})
@XmlRootElement(name = "RemoveReaderFromACCode")
public class RemoveReaderFromACCode {

    @XmlElementRef(name = "in-strACCodeID", type = JAXBElement.class, required = false)
    protected JAXBElement<String> inStrACCodeID;
    @XmlElementRef(name = "in-strReaderID", type = JAXBElement.class, required = false)
    protected JAXBElement<String> inStrReaderID;

    /**
     * 获取inStrACCodeID属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getInStrACCodeID() {
        return inStrACCodeID;
    }

    /**
     * 设置inStrACCodeID属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setInStrACCodeID(JAXBElement<String> value) {
        this.inStrACCodeID = value;
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

}
