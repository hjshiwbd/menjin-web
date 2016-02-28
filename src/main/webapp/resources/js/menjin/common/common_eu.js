/**
 * datagrid公用配置
 * 
 * @param url
 * @param cols
 * @returns {___anonymous4128_4374}
 */
function dgSetting1(url, cols) {
	var loadCount = 0;
	var o = {
		url : url,
		height : 400,
		fitColumns : true,
		autoRowHeight : true,
		striped : true,
		nowrap : true,
		checkOnSelect : true,
		pagination : true,
		pageSize : 100,
		pageList : [ 100, 300, 500 ],
		columns : cols,
		onBeforeLoad : function() {
			// if (loadCount++ == 0) {
			// return false;
			// }
		}
	};
	return o;
}

function eualert(msg, callback, title, icon) {
	title = title ? title : '提示信息';
	icon = icon ? icon : 'info';
	$.messager.alert(title, msg, icon, callback);
}

function euconfirm(msg, callback, title) {
	title = title ? title : '提示信息';
	$.messager.confirm(title, msg, callback);
}

function xscol() {
	var xscol = [ {
		field : 'xm',
		title : '姓名',
		width : 50,
		formatter : function(value, row, index) {
			if (row['xs']) {
				return row['xs']['xm'];
			} else {
				return '';
			}
		}
	}, {
		field : 'sf',
		title : '身份',
		width : 50,
		formatter : function(value, row, index) {
			if (row['xs'] && row['xs']['sf']) {
				return row['xs']['sf']['mc'];
			} else {
				return '';
			}
		}
	}, {
		field : 'xq',
		title : '校区',
		width : 100,
		formatter : function(value, row, index) {
			if (row['xs']) {
				return row['xs']['xq'];
			} else {
				return '';
			}
		}
	}, {
		field : 'xy',
		title : '学院',
		width : 100,
		formatter : function(value, row, index) {
			if (row['xs']) {
				return row['xs']['xy'];
			} else {
				return '';
			}
		}
	}, {
		field : 'sy',
		title : '书院',
		width : 100,
		formatter : function(value, row, index) {
			if (row['xs']) {
				return row['xs']['sy'];
			} else {
				return '';
			}
		}
	}, {
		field : 'zy',
		title : '专业',
		width : 100,
		formatter : function(value, row, index) {
			if (row['xs']) {
				return row['xs']['zy'];
			} else {
				return '';
			}
		}
	}, {
		field : 'nj',
		title : '年级',
		width : 50,
		formatter : function(value, row, index) {
			if (row['xs']) {
				return row['xs']['nj'];
			} else {
				return '';
			}
		}
	}, {
		field : 'bj',
		title : '班级',
		width : 50,
		formatter : function(value, row, index) {
			if (row['xs']) {
				return row['xs']['bj'];
			} else {
				return '';
			}
		}
	}, {
		field : 'bzr',
		title : '导师',
		width : 50,
		formatter : function(value, row, index) {
			if (row['xs']) {
				return row['xs']['bzr'];
			} else {
				return '';
			}
		}
	} ];
	return xscol;
}
// 业务办理 zone3 学生信息
function xscol_yw() {
	var xscol = [ {
		field : 'xs_sf',
		title : '身份',
		width : 50,
		formatter : function(value, row, index) {
			if (row['sfBean']) {
				return row['sfBean']['mc'];
			} else {
				return value;
			}
		}
	}, {
		field : 'xs_xq',
		title : '校区',
		width : 130,
		formatter : function(value, row, index) {
			if (row['xsBean']) {
				return row['xsBean']['xq'];
			} else {
				return value;
			}
		}
	}, {
		field : 'xs_xy',
		title : '学院',
		width : 180,
		formatter : function(value, row, index) {
			if (row['xsBean']) {
				return row['xsBean']['xy'];
			} else {
				return value;
			}
		}
	}, {
		field : 'xs_sy',
		title : '书院',
		width : 100,
		formatter : function(value, row, index) {
			if (row['xsBean']) {
				return row['xsBean']['sy'];
			} else {
				return value;
			}
		}
	}, {
		field : 'xs_zy',
		title : '专业',
		width : 100,
		formatter : function(value, row, index) {
			if (row['xsBean']) {
				return row['xsBean']['zy'];
			} else {
				return value;
			}
		}
	}, {
		field : 'xs_nj',
		title : '年级',
		width : 100,
		formatter : function(value, row, index) {
			if (row['xsBean']) {
				return row['xsBean']['nj'];
			} else {
				return value;
			}
		}
	}, {
		field : 'xs_bj',
		title : '班级',
		width : 100,
		formatter : function(value, row, index) {
			if (row['xsBean']) {
				return row['xsBean']['bj'];
			} else {
				return value;
			}
		}
	}, {
		field : 'xs_bzr',
		title : '导师',
		width : 80,
		formatter : function(value, row, index) {
			if (row['xsBean']) {
				return row['xsBean']['bzr'];
			} else {
				return value;
			}
		}
	} ];
	return xscol;
}
// 业务办理 zone3 学生信息 xs的bean 是==xs
function xscol_yw2() {
	var xscol = [ {
		field : 'xs_sf',
		title : '身份',
		width : 50,
		formatter : function(value, row, index) {
			if (row['xs'] && row['xs']['sf']) {
				return row['xs']['sf']['mc'];
			} else {
				return value;
			}
		}
	}, {
		field : 'xs_xq',
		title : '校区',
		width : 130,
		formatter : function(value, row, index) {
			if (row['xs']) {
				return row['xs']['xq'];
			} else {
				return value;
			}
		}
	}, {
		field : 'xs_xy',
		title : '学院',
		width : 180,
		formatter : function(value, row, index) {
			if (row['xs']) {
				return row['xs']['xy'];
			} else {
				return value;
			}
		}
	}, {
		field : 'xs_sy',
		title : '书院',
		width : 100,
		formatter : function(value, row, index) {
			if (row['xs']) {
				return row['xs']['sy'];
			} else {
				return value;
			}
		}
	}, {
		field : 'xs_zy',
		title : '专业',
		width : 100,
		formatter : function(value, row, index) {
			if (row['xs']) {
				return row['xs']['zy'];
			} else {
				return value;
			}
		}
	}, {
		field : 'xs_nj',
		title : '年级',
		width : 100,
		formatter : function(value, row, index) {
			if (row['xs']) {
				return row['xs']['nj'];
			} else {
				return value;
			}
		}
	}, {
		field : 'xs_bj',
		title : '班级',
		width : 100,
		formatter : function(value, row, index) {
			if (row['xs']) {
				return row['xs']['bj'];
			} else {
				return value;
			}
		}
	}, {
		field : 'xs_bzr',
		title : '导师',
		width : 80,
		formatter : function(value, row, index) {
			if (row['xs']) {
				return row['xs']['bzr'];
			} else {
				return value;
			}
		}
	} ];
	return xscol;
}

function xscol2() {
	var xscol = [ , {
		field : 'xs_xm',
		title : '姓名',
		width : 100,
		formatter : function(value, row, index) {
			if (row['xsBean']) {
				return row['xsBean']['xm'];
			} else {
				return '';
			}
		}
	}, {
		field : 'sf_mc',
		title : '身份',
		width : '100',
		formatter : function(value, row, index) {
			if (row['sfBean']) {
				return row['sfBean']['mc'];
			} else {
				return '';
			}
		}
	}, {
		field : 'xs_xq',
		title : '校区',
		width : 100,
		formatter : function(value, row, index) {
			if (row['xsBean']) {
				return row['xsBean']['xq'];
			} else {
				return '';
			}
		}
	}, {
		field : 'xs_xy',
		title : '学院',
		width : 150,
		formatter : function(value, row, index) {
			if (row['xsBean']) {
				return row['xsBean']['xy'];
			} else {
				return '';
			}
		}

	}, {
		field : 'xs_sy',
		title : '书院',
		width : 100,
		formatter : function(value, row, index) {
			if (row['xsBean']) {
				return row['xsBean']['sy'];
			} else {
				return '';
			}
		}
	}, {
		field : 'xs_zy',
		title : '专业',
		width : '100',
		formatter : function(value, row, index) {
			if (row['xsBean']) {
				return row['xsBean']['zy'];
			} else {
				return '';
			}
		}
	}, {
		field : 'xs_nj',
		title : '年级',
		width : '100',
		formatter : function(value, row, index) {
			if (row['xsBean']) {
				return row['xsBean']['nj'];
			} else {
				return '';
			}
		}
	}, {
		field : 'xs_bj',
		title : '班级',
		width : '100',
		formatter : function(value, row, index) {
			if (row['xsBean']) {
				return row['xsBean']['bj'];
			} else {
				return '';
			}
		}

	}, {
		field : 'bzr',
		title : '导师',
		width : 50,
		formatter : function(value, row, index) {
			if (row['xsBean']) {
				return row['xsBean']['bzr'];
			} else {
				return '';
			}
		}
	} ];
	return xscol;
}

function removetxt() {
	return [ {
		iconCls : 'icon-clear',
		handler : function(e) {
			if ($(e.data.target).hasClass('combobox-f')) {
				$(e.data.target).combobox('clear');
			} else {
				$(e.data.target).textbox('reset');
			}
		}
	} ];
}

function addKeyupEvent(combobox) {
	var timer = undefined;
	combobox.next().on('keyup', function(e) {
		window.clearTimeout(timer);
		timer = setTimeout(function() {
			doInputSearch(combobox);
		}, 200);
	});
	combobox.next().find('.textbox-text').on('focus', function() {
		// combobox.combobox('showPanel');
	});
}

function doInputSearch(combobox) {
	var v = combobox.combobox('getText');
	if (v == '') {
		combobox.combobox('setValue', undefined);
		combobox.combobox('setText', undefined);
	} else {
		var data = combobox.combobox('getData');
		// clog(v);
		// clog(data);
		for ( var i in data) {
			var o = data[i];
			var dm = combobox.combobox('options')['valueField'];
			var mc = combobox.combobox('options')['textField'];
			if (startsWith(o[mc], v)) {
				combobox.combobox('select', o[dm]);
				break;
			}
		}
	}
}

function onUpOrDown(obj, offset) {
	var v = obj.combobox('getValue');
	var data = obj.combobox('getData');
	if (data == undefined || data.length == 0) {
		return;
	}
	var dm = obj.combobox('options')['valueField'];
	// var mc = obj.combobox('options')['textField'];
	var index = getIndex(data, v, dm);
	index = route(index, offset, data.length);
	if (index != -1) {
		obj.combobox('select', data[index][dm]);
	}
}

function route(i, offset, length) {
	// 第一位,-1,到最后一位
	if (i == 0 && offset == -1) {
		return length - 1;
	}
	// 最后一位,1,到第一位
	if (i == (length - 1) && offset == 1) {
		return 0;
	}
	return i + offset;
}

function getIndex(data, v, dm) {
	for ( var i in data) {
		var o = data[i];
		if (o[dm] == v) {
			return parseInt(i, 10);
		}
	}
	return -1;
}
