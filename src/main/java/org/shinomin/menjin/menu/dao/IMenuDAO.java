package org.shinomin.menjin.menu.dao;

import java.util.List;
import java.util.Map;

import org.shinomin.commons.db.mybatis.ICommonDAO;
import org.shinomin.menjin.bean.MenuBean;

/**
 * 
 * @author huangjin
 * @cratedate 2016-01-17 15:12:48
 * 
 */
public interface IMenuDAO extends ICommonDAO {
	List<MenuBean> selectQx(Map<String, Object> param);
}
