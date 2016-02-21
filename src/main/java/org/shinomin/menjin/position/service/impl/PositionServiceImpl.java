package org.shinomin.menjin.position.service.impl;

import java.util.List;

import org.shinomin.commons.db.mybatis.Pager;
import org.shinomin.menjin.bean.PositionBean;
import org.shinomin.menjin.position.dao.IPositionDAO;
import org.shinomin.menjin.position.service.IPositionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * 
 * @author huangjin
 * @cratedate 2016-02-21 18:03:54
 * 
 */
@Service
public class PositionServiceImpl implements IPositionService
{
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private IPositionDAO positionDAO;

	@Override
	public PositionBean selectOne(PositionBean position)
	{
		return positionDAO.selectOne(position);
	}

	@Override
	public List<PositionBean> selectList(PositionBean position)
	{
		return positionDAO.selectList(position);
	}

	@Override
	public Pager<PositionBean> selectPage(PositionBean position, Pager<PositionBean> pager)
	{
		return positionDAO.selectPage(position, pager);
	}

	@Override
	public int insert(PositionBean position)
	{
		return positionDAO.insert(position);
	}

	@Override
	public int update(PositionBean position)
	{
		return positionDAO.update(position);
	}

	@Override
	public int delete(PositionBean position)
	{
		return positionDAO.delete(position);
	}
}
