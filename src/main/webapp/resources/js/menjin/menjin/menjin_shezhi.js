var dg = $('#dg');
var treeObj;
var addDoorDiv = $('#addDoorDiv');
var editDoorDiv = $('#editDoorDiv');

jQuery(document).ready(function() {
	page_init("widgets_box");
	// initTree();
	initDg();
	// 保存门
	bcm();
	// 修改门
	xgm();
});

function bcm() {
	$('#form1 #doorname').validatebox({
		required : true
	});

	$('#bcm').on('click', function() {
		if ($('#form1').form('validate') == true) {
			var options = {
				url : cu('/door/do_add'),
				param : {
					doorname : $('#form1 #doorname').val(),
					hwacid : $('#form1 #hwacid').val()
				},
				callback : function(resp) {
					// clog(resp);
					if (resp.result == '1') {
						addDoorDiv.modal('hide');
						dg.treegrid('reload');
					}
					eualert(resp.message);
				}
			};
			commonAjax(options);
		}
	});
}

function delete_door() {
	var rows = dg.treegrid('getSelections');
	// clog(rows);
	if (rows.length != 0) {
		euconfirm('您确定要删除选中的门禁吗', function(r) {
			if (r) {
				var doorid = rows[0].doorid;
				var options = {
					url : cu('/door/do_delete'),
					param : {
						doorid : doorid
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

function xgm() {
	$('#form2 #doorname').validatebox({
		required : true
	});

	$('#xgm').on('click', function() {
		if ($('#form2').form('validate') == true) {
			var doorid = $('#form2 #doorid').val();
			var doorname = $('#form2 #doorname').val();
			var hwacid = $('#form2 #hwacid').val();
			var options = {
				url : cu('/door/do_edit'),
				param : {
					doorid : doorid,
					doorname : doorname,
					hwacid : hwacid
				},
				callback : function(resp) {
					if (resp.result == '1') {
						editDoorDiv.modal('hide');
						dg.treegrid('reload');
					}
					eualert(resp.message);
				}
			};
			commonAjax(options);
		}
	});
}

/**
 * 编辑门禁
 */
function edit_door() {
	var rows = dg.treegrid('getSelections');
	// clog(rows);
	if (rows.length == 1) {
		// 回填
		$('#form2 #doorid').val(rows[0].doorid);
		$('#form2 #doorname').val(rows[0].doorname);
		editDoorDiv.modal('show');
	} else {
		eualert('请选择要编辑的门禁');
	}
}

function initDg() {
	var url = cu('/door/query_door_eu');
	var col = [ {
		field : '',
		checkbox : true
	}, {
		field : 'doorname',
		title : '名称',
		width : 100
	}, {
		field : 'hwacid',
		title : 'hw访问码id',
		width : 100
	} ];
	var cols = [ col ];
	var set = dgSetting1(url, cols);
	set['height'] = 650;
	set['idField'] = 'doorid';
	set['treeField'] = 'doorname';
	set['pagination'] = undefined;
	set['singleSelect'] = true;
	set['onLoadSuccess'] = function() {
		// 鼠标划过显示title
		$('.datagrid-cell').each(function(i, o) {
			var txt = $(o).text();
			$(o).attr('title', txt);
		});
	};
	// 点击行,显示人员访问码权限
	set['toolbar'] = [ {
		text : '添加门禁',
		handler : function() {
			addDoorDiv.modal('show');
		}
	}, {
		text : '删除门禁',
		handler : function() {
			delete_door();
		}
	}, {
		text : '修改门禁',
		handler : function() {
			edit_door();
		}
	} ];

	dg.treegrid(set);

}

function initTree() {
	var treeSetting = {
		data : {
			key : {
				name : 'descrp'
			},
			simpleData : {
				enable : true,
				idKey : "id",
				pIdKey : "",
				rootPId : ""
			}
		}
	};
	$.fn.zTree.init($("#readerTree"), treeSetting, readers);
	treeObj = $.fn.zTree.getZTreeObj("readerTree");
}
