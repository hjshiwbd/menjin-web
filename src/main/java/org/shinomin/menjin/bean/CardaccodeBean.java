package org.shinomin.menjin.bean;

import java.io.Serializable;

@SuppressWarnings("serial")
public class CardaccodeBean implements Serializable {
	private String id;//
	private String cardno;//
	private String accodeid;//

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCardno() {
		return cardno;
	}

	public void setCardno(String cardno) {
		this.cardno = cardno;
	}

	public String getAccodeid() {
		return accodeid;
	}

	public void setAccodeid(String accodeid) {
		this.accodeid = accodeid;
	}

}