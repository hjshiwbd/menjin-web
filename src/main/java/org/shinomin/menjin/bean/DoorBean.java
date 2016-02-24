package org.shinomin.menjin.bean;

import java.io.Serializable;

@SuppressWarnings("serial")
public class DoorBean implements Serializable {
	private String doorid;//
	private String devid;//
	private String regid;// 楼层
	private String readerno;//
	private String doorname;//
	private String devisused;//
	private String iskquse;//
	private String blackcardver;//
	private String dvrname;//
	private String dvrchannel;//

	public String getDoorid() {
		return doorid;
	}

	public void setDoorid(String doorid) {
		this.doorid = doorid;
	}

	public String getDevid() {
		return devid;
	}

	public void setDevid(String devid) {
		this.devid = devid;
	}

	public String getRegid() {
		return regid;
	}

	public void setRegid(String regid) {
		this.regid = regid;
	}

	public String getReaderno() {
		return readerno;
	}

	public void setReaderno(String readerno) {
		this.readerno = readerno;
	}

	public String getDoorname() {
		return doorname;
	}

	public void setDoorname(String doorname) {
		this.doorname = doorname;
	}

	public String getDevisused() {
		return devisused;
	}

	public void setDevisused(String devisused) {
		this.devisused = devisused;
	}

	public String getIskquse() {
		return iskquse;
	}

	public void setIskquse(String iskquse) {
		this.iskquse = iskquse;
	}

	public String getBlackcardver() {
		return blackcardver;
	}

	public void setBlackcardver(String blackcardver) {
		this.blackcardver = blackcardver;
	}

	public String getDvrname() {
		return dvrname;
	}

	public void setDvrname(String dvrname) {
		this.dvrname = dvrname;
	}

	public String getDvrchannel() {
		return dvrchannel;
	}

	public void setDvrchannel(String dvrchannel) {
		this.dvrchannel = dvrchannel;
	}

}