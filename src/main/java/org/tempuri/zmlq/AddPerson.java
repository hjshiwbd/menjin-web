
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
 *         &lt;element name="in-structPerson" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="in-strBadgeTypeID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
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
    "inStructPerson",
    "inStrBadgeTypeID"
})
@XmlRootElement(name = "AddPerson")
public class AddPerson {

    @XmlElementRef(name = "in-structPerson", type = JAXBElement.class, required = false)
    protected JAXBElement<String> inStructPerson;
    @XmlElementRef(name = "in-strBadgeTypeID", type = JAXBElement.class, required = false)
    protected JAXBElement<String> inStrBadgeTypeID;

    /**
     * 获取inStructPerson属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getInStructPerson() {
        return inStructPerson;
    }

    /**
     * 设置inStructPerson属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setInStructPerson(JAXBElement<String> value) {
        this.inStructPerson = value;
    }

    /**
     * 获取inStrBadgeTypeID属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getInStrBadgeTypeID() {
        return inStrBadgeTypeID;
    }

    /**
     * 设置inStrBadgeTypeID属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setInStrBadgeTypeID(JAXBElement<String> value) {
        this.inStrBadgeTypeID = value;
    }

}
