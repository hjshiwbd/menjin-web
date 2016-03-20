package org.shinomin.menjin.emp.service.impl;

import java.util.List;

import org.shinomin.commons.db.mybatis.Pager;
import org.shinomin.menjin.bean.EmpcardBean;
import org.shinomin.menjin.emp.dao.IEmpcardDAO;
import org.shinomin.menjin.emp.service.IEmpcardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * 
 * @author huangjin
 * @cratedate 2016-03-20 21:24:06
 * 
 */
@Service
public class EmpcardServiceImpl implements IEmpcardService
{
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private IEmpcardDAO empcardDAO;

	@Override
	public EmpcardBean selectOne(EmpcardBean empcard)
	{
		return empcardDAO.selectOne(empcard);
	}

	@Override
	public List<EmpcardBean> selectList(EmpcardBean empcard)
	{
		return empcardDAO.selectList(empcard);
	}

	@Override
	public Pager<EmpcardBean> selectPage(EmpcardBean empcard, Pager<EmpcardBean> pager)
	{
		return empcardDAO.selectPage(empcard, pager);
	}

	@Override
	public int insert(EmpcardBean empcard)
	{
		return empcardDAO.insert(empcard);
	}

	@Override
	public int update(EmpcardBean empcard)
	{
		return empcardDAO.update(empcard);
	}

	@Override
	public int delete(EmpcardBean empcard)
	{
		return empcardDAO.delete(empcard);
	}
}
