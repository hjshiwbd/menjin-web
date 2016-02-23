package org.shinomin.menjin.log.service.impl;

import java.util.List;

import org.shinomin.commons.db.mybatis.Pager;
import org.shinomin.menjin.bean.HwpaeventBean;
import org.shinomin.menjin.log.dao.IHwpaeventDAO;
import org.shinomin.menjin.log.service.IHwpaeventService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * 
 * @author huangjin
 * @cratedate 2016-02-23 22:52:11
 * 
 */
@Service
public class HwpaeventServiceImpl implements IHwpaeventService
{
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private IHwpaeventDAO hwpaeventDAO;

	@Override
	public HwpaeventBean selectOne(HwpaeventBean hwpaevent)
	{
		return hwpaeventDAO.selectOne(hwpaevent);
	}

	@Override
	public List<HwpaeventBean> selectList(HwpaeventBean hwpaevent)
	{
		return hwpaeventDAO.selectList(hwpaevent);
	}

	@Override
	public Pager<HwpaeventBean> selectPage(HwpaeventBean hwpaevent, Pager<HwpaeventBean> pager)
	{
		return hwpaeventDAO.selectPage(hwpaevent, pager);
	}

	@Override
	public int insert(HwpaeventBean hwpaevent)
	{
		return hwpaeventDAO.insert(hwpaevent);
	}

	@Override
	public int update(HwpaeventBean hwpaevent)
	{
		return hwpaeventDAO.update(hwpaevent);
	}

	@Override
	public int delete(HwpaeventBean hwpaevent)
	{
		return hwpaeventDAO.delete(hwpaevent);
	}
}
