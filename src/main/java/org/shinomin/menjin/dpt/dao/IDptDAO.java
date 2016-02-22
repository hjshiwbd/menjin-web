package org.shinomin.menjin.dpt.dao;

import org.shinomin.commons.db.mybatis.ICommonDAO;
import org.shinomin.menjin.bean.DptBean;

/**
 * 
 * @author huangjin
 * @cratedate 2016-02-21 17:11:21
 * 
 */
public interface IDptDAO extends ICommonDAO {
	public Integer selectMaxPrcno(DptBean dpt);
}
