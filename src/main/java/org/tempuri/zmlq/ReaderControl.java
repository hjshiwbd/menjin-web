
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
 *         &lt;element name="in-strReaderID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="nCmd" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
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
    "inStrReaderID",
    "nCmd"
})
@XmlRootElement(name = "ReaderControl")
public class ReaderControl {

    @XmlElementRef(name = "in-strReaderID", type = JAXBElement.class, required = false)
    protected JAXBElement<String> inStrReaderID;
    protected int nCmd;

    /**
     * ��ȡinStrReaderID���Ե�ֵ��
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
     * ����inStrReaderID���Ե�ֵ��
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
     * ��ȡnCmd���Ե�ֵ��
     * 
     */
    public int getNCmd() {
        return nCmd;
    }

    /**
     * ����nCmd���Ե�ֵ��
     * 
     */
    public void setNCmd(int value) {
        this.nCmd = value;
    }

}
