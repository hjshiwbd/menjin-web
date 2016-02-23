package org.shinomin.menjin.bean;

import java.io.Serializable;

@SuppressWarnings("serial")
public class HwpaeventBean implements Serializable {
	private String id;//
	private String logdevdescrp;//
	private String logdevtypedesc;//
	private String rec_dat;//
	private String evnt_dat;//
	private String evnt_descrp;//
	private String descrp;//
	private String location;//
	private String cardno;//
	private String lname;//
	private String fname;//
	private String stat_cod;//
	private String comp_name;//
	private String threat_lev;//

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLogdevdescrp() {
		return logdevdescrp;
	}

	public void setLogdevdescrp(String logdevdescrp) {
		this.logdevdescrp = logdevdescrp;
	}

	public String getLogdevtypedesc() {
		return logdevtypedesc;
	}

	public void setLogdevtypedesc(String logdevtypedesc) {
		this.logdevtypedesc = logdevtypedesc;
	}

	public String getRec_dat() {
		return rec_dat;
	}

	public void setRec_dat(String rec_dat) {
		this.rec_dat = rec_dat;
	}

	public String getEvnt_dat() {
		return evnt_dat;
	}

	public void setEvnt_dat(String evnt_dat) {
		this.evnt_dat = evnt_dat;
	}

	public String getEvnt_descrp() {
		return evnt_descrp;
	}

	public void setEvnt_descrp(String evnt_descrp) {
		this.evnt_descrp = evnt_descrp;
	}

	public String getDescrp() {
		return descrp;
	}

	public void setDescrp(String descrp) {
		this.descrp = descrp;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getCardno() {
		return cardno;
	}

	public void setCardno(String cardno) {
		this.cardno = cardno;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getStat_cod() {
		return stat_cod;
	}

	public void setStat_cod(String stat_cod) {
		this.stat_cod = stat_cod;
	}

	public String getComp_name() {
		return comp_name;
	}

	public void setComp_name(String comp_name) {
		this.comp_name = comp_name;
	}

	public String getThreat_lev() {
		return threat_lev;
	}

	public void setThreat_lev(String threat_lev) {
		this.threat_lev = threat_lev;
	}

}