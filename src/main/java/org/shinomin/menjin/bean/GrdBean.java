package org.shinomin.menjin.bean;

import java.io.Serializable;

@SuppressWarnings("serial")
public class GrdBean implements Serializable {
	private String grdid;//
	private String grdno;//
	private String grdname;//
	private String grdordno;//
	private String grdisselect;//

	public String getGrdid() {
		return grdid;
	}

	public void setGrdid(String grdid) {
		this.grdid = grdid;
	}

	public String getGrdno() {
		return grdno;
	}

	public void setGrdno(String grdno) {
		this.grdno = grdno;
	}

	public String getGrdname() {
		return grdname;
	}

	public void setGrdname(String grdname) {
		this.grdname = grdname;
	}

	public String getGrdordno() {
		return grdordno;
	}

	public void setGrdordno(String grdordno) {
		this.grdordno = grdordno;
	}

	public String getGrdisselect() {
		return grdisselect;
	}

	public void setGrdisselect(String grdisselect) {
		this.grdisselect = grdisselect;
	}

}