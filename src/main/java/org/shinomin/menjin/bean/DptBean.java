package org.shinomin.menjin.bean;

import java.io.Serializable;
import java.util.List;

@SuppressWarnings("serial")
public class DptBean implements Serializable {
	private String dptid;//
	private String dptparnt;//
	private String dptprcno;//
	private String dptno;//
	private String dptname;//
	private String dptisactive;//
	private String dpttypeid;//
	private String dptadd;//
	private String dptphone;//
	private String dptmngr;//
	private String dptcntct;//
	private String dptcrtdby;//
	private String dptcrtdday;//
	private String dptisselect;//
	private String dpthousetype;//
	private String dpthousearea;//
	private String dpthousecost;//
	private String dpthousewatervalue;//
	private String dpthouseelectvalue;//
	private String dpthousegasvalue;//
	private String dpthouseisbill;//
	private String pdptno;//
	private String cardtypeid;//
	private String dptname_spell;//

	//
	private List<DptBean> children;

	public String getDptid() {
		return dptid;
	}

	public void setDptid(String dptid) {
		this.dptid = dptid;
	}

	public String getDptparnt() {
		return dptparnt;
	}

	public void setDptparnt(String dptparnt) {
		this.dptparnt = dptparnt;
	}

	public String getDptprcno() {
		return dptprcno;
	}

	public void setDptprcno(String dptprcno) {
		this.dptprcno = dptprcno;
	}

	public String getDptno() {
		return dptno;
	}

	public void setDptno(String dptno) {
		this.dptno = dptno;
	}

	public String getDptname() {
		return dptname;
	}

	public void setDptname(String dptname) {
		this.dptname = dptname;
	}

	public String getDptisactive() {
		return dptisactive;
	}

	public void setDptisactive(String dptisactive) {
		this.dptisactive = dptisactive;
	}

	public String getDpttypeid() {
		return dpttypeid;
	}

	public void setDpttypeid(String dpttypeid) {
		this.dpttypeid = dpttypeid;
	}

	public String getDptadd() {
		return dptadd;
	}

	public void setDptadd(String dptadd) {
		this.dptadd = dptadd;
	}

	public String getDptphone() {
		return dptphone;
	}

	public void setDptphone(String dptphone) {
		this.dptphone = dptphone;
	}

	public String getDptmngr() {
		return dptmngr;
	}

	public void setDptmngr(String dptmngr) {
		this.dptmngr = dptmngr;
	}

	public String getDptcntct() {
		return dptcntct;
	}

	public void setDptcntct(String dptcntct) {
		this.dptcntct = dptcntct;
	}

	public String getDptcrtdby() {
		return dptcrtdby;
	}

	public void setDptcrtdby(String dptcrtdby) {
		this.dptcrtdby = dptcrtdby;
	}

	public String getDptcrtdday() {
		return dptcrtdday;
	}

	public void setDptcrtdday(String dptcrtdday) {
		this.dptcrtdday = dptcrtdday;
	}

	public String getDptisselect() {
		return dptisselect;
	}

	public void setDptisselect(String dptisselect) {
		this.dptisselect = dptisselect;
	}

	public String getDpthousetype() {
		return dpthousetype;
	}

	public void setDpthousetype(String dpthousetype) {
		this.dpthousetype = dpthousetype;
	}

	public String getDpthousearea() {
		return dpthousearea;
	}

	public void setDpthousearea(String dpthousearea) {
		this.dpthousearea = dpthousearea;
	}

	public String getDpthousecost() {
		return dpthousecost;
	}

	public void setDpthousecost(String dpthousecost) {
		this.dpthousecost = dpthousecost;
	}

	public String getDpthousewatervalue() {
		return dpthousewatervalue;
	}

	public void setDpthousewatervalue(String dpthousewatervalue) {
		this.dpthousewatervalue = dpthousewatervalue;
	}

	public String getDpthouseelectvalue() {
		return dpthouseelectvalue;
	}

	public void setDpthouseelectvalue(String dpthouseelectvalue) {
		this.dpthouseelectvalue = dpthouseelectvalue;
	}

	public String getDpthousegasvalue() {
		return dpthousegasvalue;
	}

	public void setDpthousegasvalue(String dpthousegasvalue) {
		this.dpthousegasvalue = dpthousegasvalue;
	}

	public String getDpthouseisbill() {
		return dpthouseisbill;
	}

	public void setDpthouseisbill(String dpthouseisbill) {
		this.dpthouseisbill = dpthouseisbill;
	}

	public String getPdptno() {
		return pdptno;
	}

	public void setPdptno(String pdptno) {
		this.pdptno = pdptno;
	}

	public String getCardtypeid() {
		return cardtypeid;
	}

	public void setCardtypeid(String cardtypeid) {
		this.cardtypeid = cardtypeid;
	}

	public String getDptname_spell() {
		return dptname_spell;
	}

	public void setDptname_spell(String dptname_spell) {
		this.dptname_spell = dptname_spell;
	}

	public List<DptBean> getChildren() {
		return children;
	}

	public void setChildren(List<DptBean> children) {
		this.children = children;
	}
}