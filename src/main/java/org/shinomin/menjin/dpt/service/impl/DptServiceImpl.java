package org.shinomin.menjin.dpt.service.impl;

import java.util.List;

import org.shinomin.commons.db.mybatis.Pager;
import org.shinomin.commons.utils.JsonUtil;
import org.shinomin.menjin.bean.DptBean;
import org.shinomin.menjin.dpt.dao.IDptDAO;
import org.shinomin.menjin.dpt.service.IDptService;
import org.shinomin.menjin.xtkz.controller.EasyuiUtil;
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
		Pager<DptBean> pager = new Pager<>();
		pager.setCurtPage(page);
		pager.setCountPerPage(rows);
		selectPage(dpt, pager);
		return EasyuiUtil.parseDatagrid(pager);
	}
}
