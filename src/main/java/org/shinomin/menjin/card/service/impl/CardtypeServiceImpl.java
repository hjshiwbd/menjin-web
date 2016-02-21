package org.shinomin.menjin.card.service.impl;

import java.util.List;

import org.shinomin.commons.db.mybatis.Pager;
import org.shinomin.menjin.bean.CardtypeBean;
import org.shinomin.menjin.card.dao.ICardtypeDAO;
import org.shinomin.menjin.card.service.ICardtypeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * 
 * @author huangjin
 * @cratedate 2016-02-21 18:10:06
 * 
 */
@Service
public class CardtypeServiceImpl implements ICardtypeService
{
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private ICardtypeDAO cardtypeDAO;

	@Override
	public CardtypeBean selectOne(CardtypeBean cardtype)
	{
		return cardtypeDAO.selectOne(cardtype);
	}

	@Override
	public List<CardtypeBean> selectList(CardtypeBean cardtype)
	{
		return cardtypeDAO.selectList(cardtype);
	}

	@Override
	public Pager<CardtypeBean> selectPage(CardtypeBean cardtype, Pager<CardtypeBean> pager)
	{
		return cardtypeDAO.selectPage(cardtype, pager);
	}

	@Override
	public int insert(CardtypeBean cardtype)
	{
		return cardtypeDAO.insert(cardtype);
	}

	@Override
	public int update(CardtypeBean cardtype)
	{
		return cardtypeDAO.update(cardtype);
	}

	@Override
	public int delete(CardtypeBean cardtype)
	{
		return cardtypeDAO.delete(cardtype);
	}
}
