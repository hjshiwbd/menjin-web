package org.shinomin.menjin.card.service.impl;

import java.util.List;

import org.shinomin.commons.db.mybatis.Pager;
import org.shinomin.menjin.bean.CardaccodeBean;
import org.shinomin.menjin.card.dao.ICardaccodeDAO;
import org.shinomin.menjin.card.service.ICardaccodeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * 
 * @author huangjin
 * @cratedate 2016-02-21 23:26:45
 * 
 */
@Service
public class CardaccodeServiceImpl implements ICardaccodeService
{
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private ICardaccodeDAO cardaccodeDAO;

	@Override
	public CardaccodeBean selectOne(CardaccodeBean cardaccode)
	{
		return cardaccodeDAO.selectOne(cardaccode);
	}

	@Override
	public List<CardaccodeBean> selectList(CardaccodeBean cardaccode)
	{
		return cardaccodeDAO.selectList(cardaccode);
	}

	@Override
	public Pager<CardaccodeBean> selectPage(CardaccodeBean cardaccode, Pager<CardaccodeBean> pager)
	{
		return cardaccodeDAO.selectPage(cardaccode, pager);
	}

	@Override
	public int insert(CardaccodeBean cardaccode)
	{
		return cardaccodeDAO.insert(cardaccode);
	}

	@Override
	public int update(CardaccodeBean cardaccode)
	{
		return cardaccodeDAO.update(cardaccode);
	}

	@Override
	public int delete(CardaccodeBean cardaccode)
	{
		return cardaccodeDAO.delete(cardaccode);
	}
}
