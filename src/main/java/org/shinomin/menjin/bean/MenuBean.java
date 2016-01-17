package org.shinomin.menjin.bean;

import java.io.Serializable;
import java.util.List;

@SuppressWarnings("serial")
public class MenuBean implements Serializable
{
	private String id;// menuid
	private String name;// 菜单名称
	private String url;//
	private String opentype;//
	private String pid;//
	private String css;// css class样式
	private Integer sortorder;
	private String status;//

	private List<MenuBean> children;

	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getUrl()
	{
		return url;
	}

	public void setUrl(String url)
	{
		this.url = url;
	}

	public String getOpentype()
	{
		return opentype;
	}

	public void setOpentype(String opentype)
	{
		this.opentype = opentype;
	}

	public String getPid()
	{
		return pid;
	}

	public void setPid(String pid)
	{
		this.pid = pid;
	}

	public List<MenuBean> getChildren()
	{
		return children;
	}

	public void setChildren(List<MenuBean> children)
	{
		this.children = children;
	}

	public String getCss()
	{
		return css;
	}

	public void setCss(String css)
	{
		this.css = css;
	}

	public Integer getSortorder()
	{
		return sortorder;
	}

	public void setSortorder(Integer sortorder)
	{
		this.sortorder = sortorder;
	}

	public String getStatus()
	{
		return status;
	}

	public void setStatus(String status)
	{
		this.status = status;
	}
}