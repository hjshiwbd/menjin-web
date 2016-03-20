package org.shinomin.menjin.bean;

import java.io.Serializable;

@SuppressWarnings("serial")
public class EmpcardBean implements Serializable {
	private String empid;//
	private String cardid;//
	private String carddispno;//
	private String cardsegid;//
	private String cardstatusid;//
	private String cardstatuschgday;//
	private String actforegift;//
	private String disforegift;//
	private String rtnforegift;//
	private String remark;//
	private String carddueday;//
	private String cardpwd;//
	private String cardapplyid;//
	private String actcost;//

	//
	private CardinfoBean cardinfo;

	public String getEmpid() {
		return empid;
	}

	public void setEmpid(String empid) {
		this.empid = empid;
	}

	public String getCardid() {
		return cardid;
	}

	public void setCardid(String cardid) {
		this.cardid = cardid;
	}

	public String getCarddispno() {
		return carddispno;
	}

	public void setCarddispno(String carddispno) {
		this.carddispno = carddispno;
	}

	public String getCardsegid() {
		return cardsegid;
	}

	public void setCardsegid(String cardsegid) {
		this.cardsegid = cardsegid;
	}

	public String getCardstatusid() {
		return cardstatusid;
	}

	public void setCardstatusid(String cardstatusid) {
		this.cardstatusid = cardstatusid;
	}

	public String getCardstatuschgday() {
		return cardstatuschgday;
	}

	public void setCardstatuschgday(String cardstatuschgday) {
		this.cardstatuschgday = cardstatuschgday;
	}

	public String getActforegift() {
		return actforegift;
	}

	public void setActforegift(String actforegift) {
		this.actforegift = actforegift;
	}

	public String getDisforegift() {
		return disforegift;
	}

	public void setDisforegift(String disforegift) {
		this.disforegift = disforegift;
	}

	public String getRtnforegift() {
		return rtnforegift;
	}

	public void setRtnforegift(String rtnforegift) {
		this.rtnforegift = rtnforegift;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getCarddueday() {
		return carddueday;
	}

	public void setCarddueday(String carddueday) {
		this.carddueday = carddueday;
	}

	public String getCardpwd() {
		return cardpwd;
	}

	public void setCardpwd(String cardpwd) {
		this.cardpwd = cardpwd;
	}

	public String getCardapplyid() {
		return cardapplyid;
	}

	public void setCardapplyid(String cardapplyid) {
		this.cardapplyid = cardapplyid;
	}

	public String getActcost() {
		return actcost;
	}

	public void setActcost(String actcost) {
		this.actcost = actcost;
	}

	public CardinfoBean getCardinfo() {
		return cardinfo;
	}

	public void setCardinfo(CardinfoBean cardinfo) {
		this.cardinfo = cardinfo;
	}
}