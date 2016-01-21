
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
 *         &lt;element name="in-strField" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="in-strOper" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="in-strValue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
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
    "inStrField",
    "inStrOper",
    "inStrValue"
})
@XmlRootElement(name = "QueryPersons")
public class QueryPersons {

    @XmlElementRef(name = "in-strField", type = JAXBElement.class, required = false)
    protected JAXBElement<String> inStrField;
    @XmlElementRef(name = "in-strOper", type = JAXBElement.class, required = false)
    protected JAXBElement<String> inStrOper;
    @XmlElementRef(name = "in-strValue", type = JAXBElement.class, required = false)
    protected JAXBElement<String> inStrValue;

    /**
     * 获取inStrField属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getInStrField() {
        return inStrField;
    }

    /**
     * 设置inStrField属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setInStrField(JAXBElement<String> value) {
        this.inStrField = value;
    }

    /**
     * 获取inStrOper属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getInStrOper() {
        return inStrOper;
    }

    /**
     * 设置inStrOper属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setInStrOper(JAXBElement<String> value) {
        this.inStrOper = value;
    }

    /**
     * 获取inStrValue属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getInStrValue() {
        return inStrValue;
    }

    /**
     * 设置inStrValue属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setInStrValue(JAXBElement<String> value) {
        this.inStrValue = value;
    }

}
