package org.shinomin.menjin.bean;

public class HwCardBean {
	private String personid;
	private String cardno;
	private String stat_cod;
	private String pincode;
	private String issue_date;
	private String expire_date;

	public String getPersonid() {
		return personid;
	}

	public void setPersonid(String personid) {
		this.personid = personid;
	}

	public String getCardno() {
		return cardno;
	}

	public void setCardno(String cardno) {
		this.cardno = cardno;
	}

	public String getStat_cod() {
		return stat_cod;
	}

	public void setStat_cod(String stat_cod) {
		this.stat_cod = stat_cod;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getIssue_date() {
		return issue_date;
	}

	public void setIssue_date(String issue_date) {
		this.issue_date = issue_date;
	}

	public String getExpire_date() {
		return expire_date;
	}

	public void setExpire_date(String expire_date) {
		this.expire_date = expire_date;
	}

}
