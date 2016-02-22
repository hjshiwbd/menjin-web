package org.shinomin.menjin.dpt.service;

import java.util.List;

import org.shinomin.commons.db.mybatis.Pager;
import org.shinomin.menjin.bean.DptBean;

/**
 * 
 * @author huangjin
 * @cratedate 2016-02-21 17:11:21
 * 
 */
public interface IDptService
{
	/**
	 * simple
	 * 
	 * @param dpt
	 * @return
	 */
	public DptBean selectOne(DptBean dpt);

	/**
	 * simple
	 * 
	 * @param dpt
	 * @return
	 */
	public List<DptBean> selectList(DptBean dpt);

	/**
	 * simple
	 * 
	 * @param dpt
	 * @param pager
	 * @return
	 */
	public Pager<DptBean> selectPage(DptBean dpt, Pager<DptBean> pager);

	/**
	 * simple
	 * 
	 * @return
	 */
	public int insert(DptBean dpt);

	/**
	 * simple
	 * 
	 * @param dpt
	 * @return
	 */
	public int update(DptBean dpt);

	/**
	 * simple
	 * 
	 * @param dpt
	 * @return
	 */
	public int delete(DptBean dpt);

	public String listEu(Integer page, Integer rows, DptBean dpt);

	public String doAdd(DptBean dpt);

	public String doDelete(DptBean dpt);

	public String doEdit(DptBean dpt);

}
