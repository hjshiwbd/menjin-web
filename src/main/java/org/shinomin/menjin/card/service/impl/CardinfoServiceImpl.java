package org.shinomin.menjin.card.service.impl;

import java.util.List;

import org.shinomin.commons.db.mybatis.Pager;
import org.shinomin.menjin.bean.CardinfoBean;
import org.shinomin.menjin.card.dao.ICardinfoDAO;
import org.shinomin.menjin.card.service.ICardinfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * 
 * @author huangjin
 * @cratedate 2016-02-23 21:59:57
 * 
 */
@Service
public class CardinfoServiceImpl implements ICardinfoService
{
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private ICardinfoDAO cardinfoDAO;

	@Override
	public CardinfoBean selectOne(CardinfoBean cardinfo)
	{
		return cardinfoDAO.selectOne(cardinfo);
	}

	@Override
	public List<CardinfoBean> selectList(CardinfoBean cardinfo)
	{
		return cardinfoDAO.selectList(cardinfo);
	}

	@Override
	public Pager<CardinfoBean> selectPage(CardinfoBean cardinfo, Pager<CardinfoBean> pager)
	{
		return cardinfoDAO.selectPage(cardinfo, pager);
	}

	@Override
	public int insert(CardinfoBean cardinfo)
	{
		return cardinfoDAO.insert(cardinfo);
	}

	@Override
	public int update(CardinfoBean cardinfo)
	{
		return cardinfoDAO.update(cardinfo);
	}

	@Override
	public int delete(CardinfoBean cardinfo)
	{
		return cardinfoDAO.delete(cardinfo);
	}
}
