package org.shinomin.menjin.bean;

import java.io.Serializable;

@SuppressWarnings("serial")
public class HwPersonBean implements Serializable {
	private String id;
	private String lname;
	private String fname;
	private String issue_date;// 生效日期
	private String expire_date;// 失效日期

	// /////////////
	private String issue_date1;// 生效日期1,用于查询
	private String issue_date2;// 生效日期2,用于查询
	private String expire_date1;// 失效日期1 用于查询
	private String expire_date2;// 失效日期2 用于查询

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public String getIssue_date1() {
		return issue_date1;
	}

	public void setIssue_date1(String issue_date1) {
		this.issue_date1 = issue_date1;
	}

	public String getIssue_date2() {
		return issue_date2;
	}

	public void setIssue_date2(String issue_date2) {
		this.issue_date2 = issue_date2;
	}

	public String getExpire_date1() {
		return expire_date1;
	}

	public void setExpire_date1(String expire_date1) {
		this.expire_date1 = expire_date1;
	}

	public String getExpire_date2() {
		return expire_date2;
	}

	public void setExpire_date2(String expire_date2) {
		this.expire_date2 = expire_date2;
	}

}
