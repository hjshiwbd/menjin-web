package org.shinomin.menjin.door.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.shinomin.commons.bean.ExecuteResult;
import org.shinomin.commons.db.mybatis.Pager;
import org.shinomin.commons.utils.JsonUtil;
import org.shinomin.menjin.bean.DoorBean;
import org.shinomin.menjin.door.dao.IDoorDAO;
import org.shinomin.menjin.door.service.IDoorService;
import org.shinomin.menjin.xtkz.controller.EasyuiUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 * @author huangjin
 * @cratedate 2016-02-24 20:56:41
 * 
 */
@Service
public class DoorServiceImpl implements IDoorService {
	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private IDoorDAO doorDAO;

	@Override
	public DoorBean selectOne(DoorBean door) {
		return doorDAO.selectOne(door);
	}

	@Override
	public List<DoorBean> selectList(DoorBean door) {
		return doorDAO.selectList(door);
	}

	@Override
	public Pager<DoorBean> selectPage(DoorBean door, Pager<DoorBean> pager) {
		return doorDAO.selectPage(door, pager);
	}

	@Override
	public int insert(DoorBean door) {
		return doorDAO.insert(door);
	}

	@Override
	public int update(DoorBean door) {
		return doorDAO.update(door);
	}

	@Override
	public int delete(DoorBean door) {
		return doorDAO.delete(door);
	}

	@Override
	public String queryDoorEu(Integer page, Integer rows, DoorBean door) {
		logger.info("door:{}", JsonUtil.toJson(door));
		// Pager<DoorBean> pager = new Pager<>();
		// pager.setCurtPage(page);
		// pager.setCountPerPage(rows);
		// selectPage(door, pager);

		List<DoorBean> list = selectList(door);
		return EasyuiUtil.parseDatagrid(list);
	}

	@Override
	public String doAdd(DoorBean door) {
		ExecuteResult e = new ExecuteResult("0", "添加失败");
		try {
			checkParamAdd(door);
		} catch (Exception e1) {
			e.setMessage(e1.getMessage());
			return JsonUtil.toJson(e);
		}

		initDoorBean(door);
		int n = insert(door);
		if (n > 0) {
			e.setResult("1");
			e.setMessage("添加成功");
			logger.info("door insert finish");
		}

		return JsonUtil.toJson(e);
	}

	private void initDoorBean(DoorBean door) {
		door.setRegid("9999");
		door.setDevid("9999");
		door.setReaderno("9999");
		door.setDevisused("1");
		door.setIskquse("0");
		door.setBlackcardver("0");
		door.setDvrchannel("0");
	}

	private void checkParamAdd(DoorBean door) throws Exception {
		if (StringUtils.isBlank(door.getDoorname())) {
			throw new Exception("名称不能为空");
		}
	}

	@Override
	public String doDelete(DoorBean door) {
		logger.info("door:{}", JsonUtil.toJson(door));
		ExecuteResult e = new ExecuteResult("0", "");
		if (StringUtils.isBlank(door.getDoorid())) {
			e.setMessage("请求有误");
		}

		int n = delete(door);
		if (n > 0) {
			e.setResult("1");
			e.setMessage("操作成功");
			logger.info("door delete finish");
		} else {
			e.setMessage("操作失败,请稍候再试");
		}
		return JsonUtil.toJson(e);
	}

	@Override
	public String doEdit(DoorBean door) {
		logger.info("door:{}", JsonUtil.toJson(door));
		ExecuteResult e = new ExecuteResult("0", "修改失败");

		if (StringUtils.isBlank(door.getDoorid())) {
			e.setMessage("请求有误");
			return JsonUtil.toJson(e);
		}

		DoorBean old = new DoorBean();
		old.setDoorid(door.getDoorid());
		old = selectOne(old);
		if (old == null) {
			e.setMessage("门禁信息不存在，请刷新后重试");
			return JsonUtil.toJson(e);
		}

		try {
			checkParamEdit(door, old);
		} catch (Exception e1) {
			logger.info(e1.getMessage());
			e.setMessage(e1.getMessage());
			return JsonUtil.toJson(e);
		}

		DoorBean update = new DoorBean();
		update.setDoorid(door.getDoorid());
		update.setDoorname(door.getDoorname());
		int n = update(update);
		if (n > 0) {
			e.setResult("1");
			e.setMessage("修改成功");
			logger.info("door edit finish");
		} else {
			e.setMessage("修改失败，请稍候再试");
		}

		return JsonUtil.toJson(e);
	}

	private void checkParamEdit(DoorBean door, DoorBean old) throws Exception {
		if (StringUtils.isBlank(door.getDoorname())) {
			throw new Exception("名称不能为空");
		}
	}
}
