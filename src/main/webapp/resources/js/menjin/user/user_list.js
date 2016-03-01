var dg = $('#dg');
var addUserDiv = $('#addUserDiv');
var editDptDiv = $('#editDptDiv');
var clickRow;
var treeObj;

$(function() {
	//
	initDg();
	// 查询
	search();
	// 保存用户
	bc();
	// 授权菜单树
	initMenutree();
	// 授权保存
	sqbc();
});

/**
 * 授权保存
 * 
 * @returns
 */
function sqbc() {
	$('#sqbc').on('click', function() {
		var nodes = treeObj.getCheckedNodes(true);
		var msg = '您确定要收回此人的全部权限吗';
		if (nodes.length > 0) {
			msg = '您确定要授权吗';
		}
		euconfirm(msg, function(r) {
			if (r) {
				var userId = clickRow['username'];
				var resource_ids = [];
				$.each(nodes, function(i, o) {
					// clog(o);
					resource_ids.push(o['id']);
				});
				var param = {
					user_id : userId,
					resource_ids : resource_ids
				};
				// clog(JSON.stringify(param));
				var options = {
					url : cu('/user/save_qx'),
					param : {
						json : JSON.stringify(param)
					},
					callback : function(resp) {
						eualert(resp.message);
						if (resp.result == '1') {
							dg.datagrid('reload');
						}
						$('#shouquanDiv').modal('hide');
					}
				};
				commonAjax(options);
			}
		});
	});
}

function initMenutree() {
	var treeSetting = {
		check : {
			enable : true,
			chkboxType : {
				"Y" : "p",
				"N" : "p"
			}
		},
		data : {
			key : {
				name : 'name'
			},
			simpleData : {
				enable : true,
				idKey : "id",
				pIdKey : "pid",
				rootPId : null
			}
		}
	};

	$("#menutree").css('height', '400px');
	$.fn.zTree.init($("#menutree"), treeSetting, menuList);
	treeObj = $.fn.zTree.getZTreeObj("menutree");

}

/**
 * 查询功能
 */
function search() {
	$('#cx').on('click', function() {
		var param = {
			username : $('#searchForm #username').val()
		};
		dg.datagrid('reload', param);
	});
}

function bc() {
	$('#form1 #username').validatebox({
		required : true
	});

	$('#bc').on('click', function() {
		if ($('#form1').form('validate') == true) {
			var username = $('#form1 #username').val();
			var options = {
				url : cu('/user/do_add'),
				param : {
					username : username
				},
				callback : function(resp) {
					if (resp.result == '1') {
						addUserDiv.modal('hide');
						dg.datagrid('reload');
					}
					eualert(resp.message);
				}
			};
			commonAjax(options);
		}
	});
}

function initDg() {
	var url = cu('/user/list_eu');
	var col = [
	// {
	// field : '',
	// checkbox : true
	// },
	{
		field : 'username',
		title : '用户名',
		width : 300
	}, {
		field : 'shouquan',
		title : '授权',
		width : 100,
		formatter : function(value, row, index) {
			return '<a href="javascript:shouquan(' + index + ')">授权</a>';
		}
	}, {
		field : 'reset',
		title : '重置密码',
		width : 100,
		formatter : function(value, row, index) {
			return '<a href="javascript:resetPass(' + index + ')">重置密码</a>';
		}
	}, {
		field : 'del',
		title : '删除',
		width : 100,
		formatter : function(value, row, index) {
			return '<a href="javascript:del(' + index + ')">删除</a>';
		}
	} ];
	var cols = [ col ];
	var set = dgSetting1(url, cols);
	// set['fitColumns'] = false;
	set['onLoadSuccess'] = function() {
		// 鼠标划过显示title
		$('.datagrid-cell').each(function(i, o) {
			var txt = $(o).text();
			$(o).attr('title', txt);
		});
	};
	set['toolbar'] = [ {
		text : '新增用户',
		handler : function() {
			addUserDiv.modal('show');
		}
	}
	// , {
	// text : '编辑部门',
	// handler : function() {
	// edit_dpt();
	// }
	// }
	];
	set['onClickRow'] = function(index, row) {
		clickRow = row;
	};
	dg.datagrid(set);

}

function resetPass(index) {
	euconfirm('您确定要重置此用户的密码吗', function(r) {
		if (r) {
			var row = dg.datagrid('getRows');
			var options = {
				url : cu('/user/reset_pass'),
				param : {
					username : row[index].username
				},
				callback : function(resp) {
					eualert(resp.message);
				}
			};
			commonAjax(options);
		}
	});
}

function del(index) {
	euconfirm('您确定要删除此用户吗', function(r) {
		if (r) {
			var row = dg.datagrid('getRows');
			var options = {
				url : cu('/user/do_delete'),
				param : {
					username : row[index].username
				},
				callback : function(resp) {
					eualert(resp.message);
					if (resp.result == '1') {
						dg.datagrid('reload');
					}
				}
			};
			commonAjax(options);
		}
	});
}

function shouquan(index) {
	// 弹出框显示username
	$('#showquanDiv #shouquan_username').text(clickRow.username);
	// 显示此用户的权限
	reshowUserQx();
	// 打开弹出
	$('#shouquanDiv').modal('show');
}

function reshowUserQx() {
	// 清除勾选
	treeObj.checkAllNodes(false);
	// 查询
	var user_id = clickRow['username'];
	var options = {
		url : cu('/user/query_user_qx'),
		param : {
			user_id : user_id
		},
		callback : function(list) {
			// clog(list);
			for (var i = 0; i < list.length; i++) {
				var ur = list[i];
				var resource_id = ur['resource_id'];
				var node = treeObj.getNodeByParam("id", resource_id, null);
				if (node) {
					treeObj.checkNode(node, true, true);
				}
			}
		}
	};
	commonAjax(options);
}
