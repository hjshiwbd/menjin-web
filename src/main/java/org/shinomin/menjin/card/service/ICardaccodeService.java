package org.shinomin.menjin.card.service;

import java.util.List;

import org.shinomin.commons.db.mybatis.Pager;
import org.shinomin.menjin.bean.CardaccodeBean;

/**
 * 
 * @author huangjin
 * @cratedate 2016-02-21 23:26:45
 * 
 */
public interface ICardaccodeService
{
	/**
	 * simple
	 * 
	 * @param cardaccode
	 * @return
	 */
	public CardaccodeBean selectOne(CardaccodeBean cardaccode);

	/**
	 * simple
	 * 
	 * @param cardaccode
	 * @return
	 */
	public List<CardaccodeBean> selectList(CardaccodeBean cardaccode);

	/**
	 * simple
	 * 
	 * @param cardaccode
	 * @param pager
	 * @return
	 */
	public Pager<CardaccodeBean> selectPage(CardaccodeBean cardaccode, Pager<CardaccodeBean> pager);

	/**
	 * simple
	 * 
	 * @return
	 */
	public int insert(CardaccodeBean cardaccode);

	/**
	 * simple
	 * 
	 * @param cardaccode
	 * @return
	 */
	public int update(CardaccodeBean cardaccode);

	/**
	 * simple
	 * 
	 * @param cardaccode
	 * @return
	 */
	public int delete(CardaccodeBean cardaccode);

}
