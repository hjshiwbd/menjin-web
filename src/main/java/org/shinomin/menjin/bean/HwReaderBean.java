package org.shinomin.menjin.bean;

import java.io.Serializable;

@SuppressWarnings("serial")
public class HwReaderBean implements Serializable {
	private String id;
	private String descrp;
	private String location;
	private String alt_descrp;
	private String panel;
	private String site;
	private String pid;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public String getAlt_descrp() {
		return alt_descrp;
	}

	public void setAlt_descrp(String alt_descrp) {
		this.alt_descrp = alt_descrp;
	}

	public String getPanel() {
		return panel;
	}

	public void setPanel(String panel) {
		this.panel = panel;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}
}
