package org.shinomin.menjin.bean;

import java.io.Serializable;

@SuppressWarnings("serial")
public class AuthorsetBean implements Serializable {
	private String cardid;//
	private String doorid;//
	private String password;//
	private String duedate;//
	private String authortype;//
	private String authorstatus;//
	private String usertimegrp;//
	private String downloaded;//
	private String firstdownloaded;//
	private String preventcard;// 是否有布防的权限
	private String isdelete;//
	private String lastdowntime;//

	public String getCardid() {
		return cardid;
	}

	public void setCardid(String cardid) {
		this.cardid = cardid;
	}

	public String getDoorid() {
		return doorid;
	}

	public void setDoorid(String doorid) {
		this.doorid = doorid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDuedate() {
		return duedate;
	}

	public void setDuedate(String duedate) {
		this.duedate = duedate;
	}

	public String getAuthortype() {
		return authortype;
	}

	public void setAuthortype(String authortype) {
		this.authortype = authortype;
	}

	public String getAuthorstatus() {
		return authorstatus;
	}

	public void setAuthorstatus(String authorstatus) {
		this.authorstatus = authorstatus;
	}

	public String getUsertimegrp() {
		return usertimegrp;
	}

	public void setUsertimegrp(String usertimegrp) {
		this.usertimegrp = usertimegrp;
	}

	public String getDownloaded() {
		return downloaded;
	}

	public void setDownloaded(String downloaded) {
		this.downloaded = downloaded;
	}

	public String getFirstdownloaded() {
		return firstdownloaded;
	}

	public void setFirstdownloaded(String firstdownloaded) {
		this.firstdownloaded = firstdownloaded;
	}

	public String getPreventcard() {
		return preventcard;
	}

	public void setPreventcard(String preventcard) {
		this.preventcard = preventcard;
	}

	public String getIsdelete() {
		return isdelete;
	}

	public void setIsdelete(String isdelete) {
		this.isdelete = isdelete;
	}

	public String getLastdowntime() {
		return lastdowntime;
	}

	public void setLastdowntime(String lastdowntime) {
		this.lastdowntime = lastdowntime;
	}

}