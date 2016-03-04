package org.shinomin.menjin.emp.service;

import java.util.List;

import org.shinomin.commons.db.mybatis.Pager;
import org.shinomin.menjin.bean.EmpBean;
import org.shinomin.menjin.bean.EmpextBean;
import org.springframework.web.servlet.ModelAndView;

/**
 * 
 * @author huangjin
 * @cratedate 2016-02-16 20:35:40
 * 
 */
public interface IEmpService
{
	/**
	 * simple
	 * 
	 * @param emp
	 * @return
	 */
	public EmpBean selectOne(EmpBean emp);

	/**
	 * simple
	 * 
	 * @param emp
	 * @return
	 */
	public List<EmpBean> selectList(EmpBean emp);

	/**
	 * simple
	 * 
	 * @param emp
	 * @param pager
	 * @return
	 */
	public Pager<EmpBean> selectPage(EmpBean emp, Pager<EmpBean> pager);

	/**
	 * simple
	 * 
	 * @return
	 */
	public int insert(EmpBean emp);

	/**
	 * simple
	 * 
	 * @param emp
	 * @return
	 */
	public int update(EmpBean emp);

	/**
	 * simple
	 * 
	 * @param emp
	 * @return
	 */
	public int delete(EmpBean emp);

	public String doXinzeng(EmpBean emp, EmpextBean empext) throws Exception;

	public ModelAndView showXinzeng();

	public String doDelete(EmpBean emp);

}
