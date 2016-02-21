var dg = $('#dg');
$(function() {
	initDg();
	// 查询
	search();
});

/**
 * 查询功能
 */
function search() {
	var option = {
		form : '#searchForm',
		isdatagrid : true,
		validation : function() {
			return $('#searchform').form('validate');
		},
		dg : dg
	};
	$('#cx').tjbd(option);
}

function initDg() {
	// $('#dg').datagrid({
	// url : '/menjin/data/datagrid_data1.json',
	// collapsible : true,
	// method : 'get'
	// });

	// var url = '/menjin/data/datagrid_data1.json';
	var url = cu('/dpt/list_eu');
	var col = [ {
		field : '',
		checkbox : true
	}, {
		field : 'dptid',
		title : '编号',
		width : 100
	}, {
		field : 'dptname',
		title : '姓名/名称',
		width : 100
	}
	// ,{
	// field : 'issue_date',
	// title : '生效日期',
	// width : 100
	// }, {
	// field : 'expire_date',
	// title : '失效日期',
	// width : 100
	// }
	];
	var cols = [ col ];
	var set = dgSetting1(url, cols);
	set['idField'] = 'dptid';
	set['treeField'] = 'dptname';
	// set['height'] = 450;
	set['onLoadSuccess'] = function() {
		// 鼠标划过显示title
		$('.datagrid-cell').each(function(i, o) {
			var txt = $(o).text();
			$(o).attr('title', txt);
		});
	};
	// 点击行,显示人员访问码权限
	set['onClickRow'] = function(index, row) {
	};
	// set['toolbar'] = [ {
	// text : '添加人员到列表',
	// handler : function() {
	// alert('add')
	// }
	// } ];

	dg.treegrid(set);

}