package org.shinomin.menjin.xtkz.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.shinomin.commons.db.mybatis.Pager;
import org.shinomin.commons.utils.JsonUtil;

public class EasyuiUtil {
	public static String parseDatagrid(List<?> list) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("total", list.size());
		map.put("rows", list);
		return JsonUtil.toJson(map);
	}

	public static String parseDatagrid(Pager<?> pager) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("total", pager.getTotal());
		map.put("rows", pager.getPageList());
		return JsonUtil.toJson(map);
	}
}
