package org.shinomin.menjin.emp.service.impl;

import java.util.List;

import org.shinomin.commons.db.mybatis.Pager;
import org.shinomin.menjin.bean.EmpBean;
import org.shinomin.menjin.emp.dao.IEmpDAO;
import org.shinomin.menjin.emp.service.IEmpService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 * @author huangjin
 * @cratedate 2016-02-16 20:35:40
 * 
 */
@Service
public class EmpServiceImpl implements IEmpService {
	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private IEmpDAO empDAO;

	@Override
	public EmpBean selectOne(EmpBean emp) {
		return empDAO.selectOne(emp);
	}

	@Override
	public List<EmpBean> selectList(EmpBean emp) {
		return empDAO.selectList(emp);
	}

	@Override
	public Pager<EmpBean> selectPage(EmpBean emp, Pager<EmpBean> pager) {
		return empDAO.selectPage(emp, pager);
	}

	@Override
	public int insert(EmpBean emp) {
		return empDAO.insert(emp);
	}

	@Override
	public int update(EmpBean emp) {
		return empDAO.update(emp);
	}

	@Override
	public int delete(EmpBean emp) {
		return empDAO.delete(emp);
	}
}
