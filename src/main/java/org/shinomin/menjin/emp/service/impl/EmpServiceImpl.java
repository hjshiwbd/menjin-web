package org.shinomin.menjin.emp.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.shinomin.commons.bean.ExecuteResult;
import org.shinomin.commons.db.mybatis.Pager;
import org.shinomin.commons.utils.JsonUtil;
import org.shinomin.menjin.bean.EmpBean;
import org.shinomin.menjin.emp.dao.IEmpDAO;
import org.shinomin.menjin.emp.service.IEmpService;
import org.shinomin.menjin.spring.session.LoginSessionScope;
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
	@Autowired
	private LoginSessionScope loginSessionScope;

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

	@Override
	public String doXinzeng(EmpBean emp) {
		logger.info("emp:{}", JsonUtil.toJson(emp));
		ExecuteResult e = new ExecuteResult();
		try {
			checkAddParam(emp);
		} catch (Exception ex) {
			e.setResult("0");
			e.setMessage(ex.getMessage());
			return JsonUtil.toJson(e);
		}

		try {
			int maxid = empDAO.selectMaxID();
			emp.setEmpid(maxid + "");
			emp.setEmpcrtdby(loginSessionScope.getLoginUser().getUsername());
			int n = empDAO.insert(emp);
			if (n == 1) {
				e.setResult("1");
				e.setMessage("添加成功");
			} else {
				e.setResult("0");
				e.setMessage("添加失败，请稍后重试");
			}
		} catch (Exception e1) {
			logger.error(e1.getMessage(), e1);
			e.setResult("0");
			e.setMessage("添加失败，请稍后重试");
		}
		return JsonUtil.toJson(e);
	}

	private void checkAddParam(EmpBean emp) throws Exception {
		if (StringUtils.isEmpty(emp.getEmpno())) {
			throw new Exception("empno is empty");
		}
		if (StringUtils.isEmpty(emp.getEmpname())) {
			throw new Exception("empname is empty");
		}

		// 检查唯一性 LNAME/empno唯一
		int n = empDAO.selectCount("hrms_emp", "where empno=?", emp.getEmpno());
		if (n > 0) {
			throw new Exception("此员工编号已存在");
		}
	}
}
