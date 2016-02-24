package org.shinomin.menjin.door.controller;

import org.shinomin.menjin.bean.DoorBean;
import org.shinomin.menjin.door.service.IDoorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 
 * @author huangjin
 * @cratedate 2016-02-24 20:56:41
 * 
 */
@Controller
@RequestMapping("/door")
public class DoorController {
	@Autowired
	private IDoorService doorService;

	@ResponseBody
	@RequestMapping("/query_door_eu")
	public String queryDoorEu(Integer page, Integer rows, DoorBean door) throws Exception {
		return doorService.queryDoorEu(page, rows, door);
	}

	@ResponseBody
	@RequestMapping("/do_add")
	public String doAdd(DoorBean door) throws Exception {
		return doorService.doAdd(door);
	}

	@ResponseBody
	@RequestMapping("/do_delete")
	public String doDelete(DoorBean door) throws Exception {
		return doorService.doDelete(door);
	}

	@ResponseBody
	@RequestMapping("/do_edit")
	public String doEdit(DoorBean door) throws Exception {
		return doorService.doEdit(door);
	}
	
}
