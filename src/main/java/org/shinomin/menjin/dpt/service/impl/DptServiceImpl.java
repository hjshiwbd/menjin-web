package org.shinomin.menjin.dpt.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.shinomin.commons.bean.ExecuteResult;
import org.shinomin.commons.db.mybatis.Pager;
import org.shinomin.commons.utils.JsonUtil;
import org.shinomin.menjin.bean.DptBean;
import org.shinomin.menjin.dpt.dao.IDptDAO;
import org.shinomin.menjin.dpt.service.IDptService;
import org.shinomin.menjin.spring.session.LoginSessionScope;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 * @author huangjin
 * @cratedate 2016-02-21 17:11:21
 * 
 */
@Service
public class DptServiceImpl implements IDptService {
	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private IDptDAO dptDAO;
	@Autowired
	private LoginSessionScope loginSessionScope;

	@Override
	public DptBean selectOne(DptBean dpt) {
		return dptDAO.selectOne(dpt);
	}

	@Override
	public List<DptBean> selectList(DptBean dpt) {
		return dptDAO.selectList(dpt);
	}

	@Override
	public Pager<DptBean> selectPage(DptBean dpt, Pager<DptBean> pager) {
		return dptDAO.selectPage(dpt, pager);
	}

	@Override
	public int insert(DptBean dpt) {
		return dptDAO.insert(dpt);
	}

	@Override
	public int update(DptBean dpt) {
		return dptDAO.update(dpt);
	}

	@Override
	public int delete(DptBean dpt) {
		return dptDAO.delete(dpt);
	}

	@Override
	public String listEu(Integer page, Integer rows, DptBean dpt) {
		logger.info("dpt:{}", JsonUtil.toJson(dpt));
		List<DptBean> list = formatTree(selectList(dpt));
		return JsonUtil.toJson(list);
	}

	/**
	 * 构建树结构
	 * 
	 * @param dptList
	 * @return
	 */
	private List<DptBean> formatTree(List<DptBean> dptList) {
		List<DptBean> rootList = new ArrayList<>();
		for (DptBean dptBean : dptList) {
			if (dptBean.getDptparnt().equals("0")) {
				// 根结点
				getAllChildren(dptList, dptBean);
				rootList.add(dptBean);
			} else {
				// 非根结点,不处理
			}
		}
		return rootList;
	}

	/**
	 * 递归
	 * 
	 * @param dptList
	 * @param dpt1
	 */
	private void getAllChildren(List<DptBean> dptList, DptBean dpt1) {
		List<DptBean> children = new ArrayList<>();
		for (DptBean dpt2 : dptList) {
			if (dpt1.getDptid().equals(dpt2.getDptparnt())) {
				getAllChildren(dptList, dpt2);
				children.add(dpt2);
			}
		}
		dpt1.setChildren(children);
	}

	@Override
	public String doAdd(DptBean dpt) {
		logger.info("dpt:{}", JsonUtil.toJson(dpt));
		ExecuteResult e = new ExecuteResult("0", "");
		try {
			checkParamAdd(dpt);
		} catch (Exception e1) {
			logger.info(e1.getMessage());
			e.setMessage(e1.getMessage());
			return JsonUtil.toJson(e);
		}

		try {
			// prcno
			dpt.setDptprcno(generateDptPrcNo(dpt));
		} catch (Exception e1) {
			logger.info(e1.getMessage());
			e.setMessage(e1.getMessage());
			return JsonUtil.toJson(e);
		}
		// 创建人
		dpt.setDptcrtdby(loginSessionScope.getLoginUser().getUsername());
		int n = insert(dpt);
		if (n > 0) {
			e.setResult("1");
			e.setMessage("添加成功");
		} else {
			e.setMessage("添加失败，请稍候再试");
		}

		return JsonUtil.toJson(e);
	}

	/**
	 * 生成prcNO. 规则每两位数字为一级,连续n级.每级内按+1递增.如0101,0102; 020101,020102,020103等
	 * 
	 * @param dpt
	 * @throws Exception
	 */
	private String generateDptPrcNo(DptBean dpt) throws Exception {
		// 根据父节点no查到此父节点
		DptBean parent = new DptBean();
		parent.setDptno(dpt.getDptparnt());
		parent = selectOne(parent);
		String result = "";
		if (parent == null) {
			// 父节点no不存在
			throw new Exception("上级部门编码错误");
		} else {
			dpt.setDptparnt(parent.getDptid());// web传入的是dptno,此处修改为dptid
			Integer no = dptDAO.selectMaxPrcno(dpt);// 根据dptparent查最大值
			if (no == null) {
				// 未查到
				// 此节点第一次作为父节点出现,它的第一个子节点prcno=自身prcno+01
				result = parent.getDptprcno().trim() + "01";
			} else {
				// 查到了prcno
				if (String.valueOf(no).length() % 2 != 0) {
					// 长度奇数,第一位补0
					result = "0" + no;
				} else {
					// 长度偶数,直接返回
					result = "" + no;
				}
			}
		}
		logger.info("generateDptPrcNo:{}", result);
		return result;
	}

	private void checkParamAdd(DptBean dpt) throws Exception {
		if (StringUtils.isBlank(dpt.getDptno())) {
			throw new Exception("编号不能为空");
		}
		if (StringUtils.isBlank(dpt.getDptparnt())) {
			throw new Exception("上级部门编号不能为空");
		}
		if (StringUtils.isBlank(dpt.getDptname())) {
			throw new Exception("名称不能为空");
		}
		int n = dptDAO.selectCount("hrms_dpt", "where dptno=?", dpt.getDptno());
		if (n > 0) {
			throw new Exception("编号已存在");
		}
	}

	@Override
	public String doDelete(DptBean dpt) {
		ExecuteResult e = new ExecuteResult("0", "");
		if (StringUtils.isBlank(dpt.getDptid())) {
			e.setMessage("请求有误");
		}

		int count = dptDAO.selectCount("hrms_dpt", "where dptparnt=?", dpt.getDptid());
		if (count > 0) {
			e.setMessage("请先删除此部门下的子部门");
			return JsonUtil.toJson(e);
		}

		int n = delete(dpt);
		if (n > 0) {
			e.setResult("1");
			e.setMessage("操作成功");
		} else {
			e.setMessage("操作失败,请稍候再试");
		}
		return JsonUtil.toJson(e);
	}

	@Override
	public String doEdit(DptBean dpt) {
		logger.info("dpt:{}", JsonUtil.toJson(dpt));
		ExecuteResult e = new ExecuteResult("0", "");

		DptBean old = new DptBean();
		old.setDptid(dpt.getDptid());
		old = selectOne(old);
		if (old == null) {
			e.setMessage("请求部门不存在，请刷新后重试");
			return JsonUtil.toJson(e);
		}

		try {
			checkParamEdit(dpt, old);
		} catch (Exception e1) {
			logger.info(e1.getMessage());
			e.setMessage(e1.getMessage());
			return JsonUtil.toJson(e);
		}

		try {
			// prcno
			old.setDptno(dpt.getDptno());
			old.setDptname(dpt.getDptname());
			old.setDptprcno(generateDptPrcNo(dpt));
			old.setDptparnt(dpt.getDptparnt());
		} catch (Exception e1) {
			logger.info(e1.getMessage());
			e.setMessage(e1.getMessage());
			return JsonUtil.toJson(e);
		}
		int n = update(old);
		if (n > 0) {
			e.setResult("1");
			e.setMessage("修改成功");
		} else {
			e.setMessage("修改失败，请稍候再试");
		}

		return JsonUtil.toJson(e);
	}

	private void checkParamEdit(DptBean newdpt, DptBean olddpt) throws Exception {
		if (StringUtils.isBlank(newdpt.getDptno())) {
			throw new Exception("编号不能为空");
		}
		if (StringUtils.isBlank(newdpt.getDptparnt())) {
			throw new Exception("上级部门编号不能为空");
		}
		if (StringUtils.isBlank(newdpt.getDptname())) {
			throw new Exception("名称不能为空");
		}
		int n = dptDAO.selectCount("hrms_dpt", "where dptno=? and dptid != ?", newdpt.getDptno(), newdpt.getDptid());
		if (n > 0) {
			throw new Exception("编号已存在");
		}
		int n2 = dptDAO.selectCount("hrms_dpt", "where dptparnt=?", newdpt.getDptid());
		if (n2 > 0 && !olddpt.getDptparnt().equals(newdpt.getDptparnt())) {
			throw new Exception("此部门有下级部门，不能修改上级部门");
		}

	}
}
