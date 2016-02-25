package org.shinomin.menjin.grd.service.impl;

import java.util.List;

import org.shinomin.commons.db.mybatis.Pager;
import org.shinomin.menjin.bean.GrdBean;
import org.shinomin.menjin.grd.dao.IGrdDAO;
import org.shinomin.menjin.grd.service.IGrdService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * 
 * @author huangjin
 * @cratedate 2016-02-25 21:37:56
 * 
 */
@Service
public class GrdServiceImpl implements IGrdService
{
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private IGrdDAO grdDAO;

	@Override
	public GrdBean selectOne(GrdBean grd)
	{
		return grdDAO.selectOne(grd);
	}

	@Override
	public List<GrdBean> selectList(GrdBean grd)
	{
		return grdDAO.selectList(grd);
	}

	@Override
	public Pager<GrdBean> selectPage(GrdBean grd, Pager<GrdBean> pager)
	{
		return grdDAO.selectPage(grd, pager);
	}

	@Override
	public int insert(GrdBean grd)
	{
		return grdDAO.insert(grd);
	}

	@Override
	public int update(GrdBean grd)
	{
		return grdDAO.update(grd);
	}

	@Override
	public int delete(GrdBean grd)
	{
		return grdDAO.delete(grd);
	}
}
