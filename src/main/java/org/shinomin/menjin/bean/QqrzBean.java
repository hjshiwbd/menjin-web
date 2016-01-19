package org.shinomin.menjin.bean;

import java.io.Serializable;

@SuppressWarnings("serial")
public class QqrzBean implements Serializable
{
	private String id;//
	private String rybh;// 人员编号
	private String lm;// 类名
	private String ffm;// 方法名
	private String qqdz;// 请求地址
	private String qqcs;// 请求参数
	private String qqbh;// 请求编码
	private String qqmc;// 请求名称
	private String qqms;// 请求描述
	private String ip;// ip
	private String qqsj;// 请求时间
	private String sessionid;// sessionid
	private String header;// header

	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public String getRybh()
	{
		return rybh;
	}

	public void setRybh(String rybh)
	{
		this.rybh = rybh;
	}

	public String getLm()
	{
		return lm;
	}

	public void setLm(String lm)
	{
		this.lm = lm;
	}

	public String getFfm()
	{
		return ffm;
	}

	public void setFfm(String ffm)
	{
		this.ffm = ffm;
	}

	public String getQqdz()
	{
		return qqdz;
	}

	public void setQqdz(String qqdz)
	{
		this.qqdz = qqdz;
	}

	public String getQqcs()
	{
		return qqcs;
	}

	public void setQqcs(String qqcs)
	{
		this.qqcs = qqcs;
	}

	public String getQqbh()
	{
		return qqbh;
	}

	public void setQqbh(String qqbh)
	{
		this.qqbh = qqbh;
	}

	public String getQqmc()
	{
		return qqmc;
	}

	public void setQqmc(String qqmc)
	{
		this.qqmc = qqmc;
	}

	public String getQqms()
	{
		return qqms;
	}

	public void setQqms(String qqms)
	{
		this.qqms = qqms;
	}

	public String getIp()
	{
		return ip;
	}

	public void setIp(String ip)
	{
		this.ip = ip;
	}

	public String getQqsj()
	{
		return qqsj;
	}

	public void setQqsj(String qqsj)
	{
		this.qqsj = qqsj;
	}

	public String getSessionid()
	{
		return sessionid;
	}

	public void setSessionid(String sessionid)
	{
		this.sessionid = sessionid;
	}

	public String getHeader()
	{
		return header;
	}

	public void setHeader(String header)
	{
		this.header = header;
	}

}