package org.shinomin.menjin.emp.service.impl;

import java.util.List;

import org.shinomin.commons.db.mybatis.Pager;
import org.shinomin.menjin.bean.EmpextBean;
import org.shinomin.menjin.emp.dao.IEmpextDAO;
import org.shinomin.menjin.emp.service.IEmpextService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * 
 * @author huangjin
 * @cratedate 2016-02-21 16:22:31
 * 
 */
@Service
public class EmpextServiceImpl implements IEmpextService
{
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private IEmpextDAO empextDAO;

	@Override
	public EmpextBean selectOne(EmpextBean empext)
	{
		return empextDAO.selectOne(empext);
	}

	@Override
	public List<EmpextBean> selectList(EmpextBean empext)
	{
		return empextDAO.selectList(empext);
	}

	@Override
	public Pager<EmpextBean> selectPage(EmpextBean empext, Pager<EmpextBean> pager)
	{
		return empextDAO.selectPage(empext, pager);
	}

	@Override
	public int insert(EmpextBean empext)
	{
		return empextDAO.insert(empext);
	}

	@Override
	public int update(EmpextBean empext)
	{
		return empextDAO.update(empext);
	}

	@Override
	public int delete(EmpextBean empext)
	{
		return empextDAO.delete(empext);
	}
}
