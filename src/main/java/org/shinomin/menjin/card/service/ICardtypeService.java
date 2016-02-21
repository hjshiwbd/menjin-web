package org.shinomin.menjin.card.service;

import java.util.List;

import org.shinomin.commons.db.mybatis.Pager;
import org.shinomin.menjin.bean.CardtypeBean;

/**
 * 
 * @author huangjin
 * @cratedate 2016-02-21 18:10:06
 * 
 */
public interface ICardtypeService
{
	/**
	 * simple
	 * 
	 * @param cardtype
	 * @return
	 */
	public CardtypeBean selectOne(CardtypeBean cardtype);

	/**
	 * simple
	 * 
	 * @param cardtype
	 * @return
	 */
	public List<CardtypeBean> selectList(CardtypeBean cardtype);

	/**
	 * simple
	 * 
	 * @param cardtype
	 * @param pager
	 * @return
	 */
	public Pager<CardtypeBean> selectPage(CardtypeBean cardtype, Pager<CardtypeBean> pager);

	/**
	 * simple
	 * 
	 * @return
	 */
	public int insert(CardtypeBean cardtype);

	/**
	 * simple
	 * 
	 * @param cardtype
	 * @return
	 */
	public int update(CardtypeBean cardtype);

	/**
	 * simple
	 * 
	 * @param cardtype
	 * @return
	 */
	public int delete(CardtypeBean cardtype);

}
