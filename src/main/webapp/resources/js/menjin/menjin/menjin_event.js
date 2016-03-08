var dg = $('#dg');
var addUserDiv = $('#addUserDiv');
var editDptDiv = $('#editDptDiv');
var clickRow;
var treeObj;

$(function() {
	page_init("widgets_box");
	//
	initDg();
	// 查询
	search();
});

/**
 * 查询功能
 */
function search() {
	$('#cx').tjbd({
		form : '#searchForm',
		dg : dg,
		isdatagrid : true
	});
	// $('#cx').on('click', function() {
	// var param = {
	// logdevdescrp : $('#searchForm #logdevdescrp').val()
	// };
	// dg.datagrid('reload', param);
	// });
}

function initDg() {
	var url = cu('/menjin/event_list_eu');
	var col = [
	// {
	// field : '',
	// checkbox : true
	// },
	{
		field : 'lname',
		title : '人员编号',
		width : 100
	}, {
		field : 'fname',
		title : '人员',
		width : 100
	}, {
		field : 'cardno',
		title : '卡号',
		width : 100
	}, {
		field : 'logdevdescrp',
		title : '设备',
		width : 100
	}, {
		field : 'evnt_dat',
		title : '时间',
		width : 100
	}, {
		field : 'evnt_descrp',
		title : '事件描述',
		width : 100
	}, {
		field : 'descrp',
		title : '描述',
		width : 100
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
	// set['toolbar'] = [ {
	// text : '新增用户',
	// handler : function() {
	// addUserDiv.modal('show');
	// }
	// }
	// , {
	// text : '编辑部门',
	// handler : function() {
	// edit_dpt();
	// }
	// }
	// ];
	set['onClickRow'] = function(index, row) {
		clickRow = row;
	};
	dg.datagrid(set);

}
