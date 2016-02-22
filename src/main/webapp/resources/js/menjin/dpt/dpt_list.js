var dg = $('#dg');
var addDptDiv = $('#addDptDiv');
var editDptDiv = $('#editDptDiv')

$(function() {
	initDg();
	// 查询
	search();
	// 保存部门
	bcbm();
	// 修改部门
	xgbm();
});

/**
 * 查询功能
 */
function search() {
	$('#cx').on('click', function() {
		var param = {
			dptname : $('#searchForm #dptname').val()
		};
		dg.treegrid('reload', param);
	});
}

function bcbm() {
	$('#form1 #dptno,#form1 #dptname,#form1 #dptparnt').validatebox({
		required : true
	});

	$('#bcbm').on('click', function() {
		if ($('#form1').form('validate') == true) {
			var dptno = $('#form1 #dptno').val();
			var dptname = $('#form1 #dptname').val();
			var dptparnt = $('#form1 #dptparnt').val();
			var options = {
				url : cu('/dpt/do_add'),
				param : {
					dptno : dptno,
					dptname : dptname,
					dptparnt : dptparnt
				},
				callback : function(resp) {
					if (resp.result == '1') {
						addDptDiv.modal('hide');
						dg.treegrid('reload');
					}
					eualert(resp.message);
				}
			};
			commonAjax(options);
		}
	});
}

function initDg() {
	var url = cu('/dpt/list_eu');
	var col = [
	// {
	// field : '',
	// checkbox : true
	// },
	{
		field : 'dptno',
		title : '编号',
		width : 10
	}, {
		field : 'dptname',
		title : '名称',
		width : 100
	} ];
	var cols = [ col ];
	var set = dgSetting1(url, cols);
	set['idField'] = 'dptid';
	set['treeField'] = 'dptname';
	set['pagination'] = undefined;
	set['onLoadSuccess'] = function() {
		// 鼠标划过显示title
		$('.datagrid-cell').each(function(i, o) {
			var txt = $(o).text();
			$(o).attr('title', txt);
		});
	};
	set['toolbar'] = [ {
		text : '新增部门',
		handler : function() {
			addDptDiv.modal('show');
		}
	}, {
		text : '删除部门',
		handler : function() {
			delete_dpt();
		}
	}
//	, {
//		text : '编辑部门',
//		handler : function() {
//			edit_dpt();
//		}
//	}
	];

	dg.treegrid(set);

}

function edit_dpt() {
	var rows = dg.treegrid('getSelections');
	// clog(rows);
	if (rows.length == 1) {
		var options = {
			url : cu('/'),
			param : {},
			callback : function() {

			}
		};
		// 回填
		$('#form2 #dptid').val(rows[0].dptid);
		$('#form2 #dptno').val(rows[0].dptno);
		$('#form2 #dptname').val(rows[0].dptname);
		$('#form2 #dptparnt').val(rows[0].dptparnt);
		editDptDiv.modal('show');
	} else {
		eualert('请选择要编辑的部门');
	}
}

function xgbm() {
	$('#form2 #dptno,#form2 #dptname,#form2 #dptparnt').validatebox({
		required : true
	});

	$('#xgbm').on('click', function() {
		if ($('#form2').form('validate') == true) {
			var dptid = $('#form2 #dptid').val();
			var dptno = $('#form2 #dptno').val();
			var dptname = $('#form2 #dptname').val();
			var dptparnt = $('#form2 #dptparnt').val();
			var options = {
				url : cu('/dpt/do_edit'),
				param : {
					dptid : dptid,
					dptno : dptno,
					dptname : dptname,
					dptparnt : dptparnt
				},
				callback : function(resp) {
					if (resp.result == '1') {
						addDptDiv.modal('hide');
						dg.treegrid('reload');
					}
					eualert(resp.message);
				}
			};
			commonAjax(options);
		}
	});
}

function delete_dpt() {
	var rows = dg.treegrid('getSelections');
	// clog(rows);
	if (rows.length != 0) {
		euconfirm('您确定要删除选中的部门吗', function(r) {
			if (r) {
				var dptid = rows[0].dptid;
				var options = {
					url : cu('/dpt/do_delete'),
					param : {
						dptid : dptid
					},
					callback : function(resp) {
						eualert(resp.message);
						if (resp.result == '1') {
							dg.treegrid('reload');
						}
					}
				};
				commonAjax(options);
			}
		});
	} else {
		eualert('请选择要删除的部门');
	}
}