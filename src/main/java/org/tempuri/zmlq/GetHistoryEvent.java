
package org.tempuri.zmlq;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
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
 *         &lt;element name="in-iBegin" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="in-iEnd" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="in-bOccurTime" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
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
    "inIBegin",
    "inIEnd",
    "inBOccurTime"
})
@XmlRootElement(name = "GetHistoryEvent")
public class GetHistoryEvent {

    @XmlElement(name = "in-iBegin")
    protected long inIBegin;
    @XmlElement(name = "in-iEnd")
    protected long inIEnd;
    @XmlElement(name = "in-bOccurTime")
    protected boolean inBOccurTime;

    /**
     * 获取inIBegin属性的值。
     * 
     */
    public long getInIBegin() {
        return inIBegin;
    }

    /**
     * 设置inIBegin属性的值。
     * 
     */
    public void setInIBegin(long value) {
        this.inIBegin = value;
    }

    /**
     * 获取inIEnd属性的值。
     * 
     */
    public long getInIEnd() {
        return inIEnd;
    }

    /**
     * 设置inIEnd属性的值。
     * 
     */
    public void setInIEnd(long value) {
        this.inIEnd = value;
    }

    /**
     * 获取inBOccurTime属性的值。
     * 
     */
    public boolean isInBOccurTime() {
        return inBOccurTime;
    }

    /**
     * 设置inBOccurTime属性的值。
     * 
     */
    public void setInBOccurTime(boolean value) {
        this.inBOccurTime = value;
    }

}
