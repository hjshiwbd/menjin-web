package org.shinomin.menjin.bean;

import java.io.Serializable;

/**
 * 职务
 * 
 * @author hjin
 * 
 */
@SuppressWarnings("serial")
public class PositionBean implements Serializable {
	private String positionid;//
	private String positionno;//
	private String positionname;//
	private String positionordno;//
	private String positionisselect;//
	private String positionename;// 岗位英文名

	public String getPositionid() {
		return positionid;
	}

	public void setPositionid(String positionid) {
		this.positionid = positionid;
	}

	public String getPositionno() {
		return positionno;
	}

	public void setPositionno(String positionno) {
		this.positionno = positionno;
	}

	public String getPositionname() {
		return positionname;
	}

	public void setPositionname(String positionname) {
		this.positionname = positionname;
	}

	public String getPositionordno() {
		return positionordno;
	}

	public void setPositionordno(String positionordno) {
		this.positionordno = positionordno;
	}

	public String getPositionisselect() {
		return positionisselect;
	}

	public void setPositionisselect(String positionisselect) {
		this.positionisselect = positionisselect;
	}

	public String getPositionename() {
		return positionename;
	}

	public void setPositionename(String positionename) {
		this.positionename = positionename;
	}

}