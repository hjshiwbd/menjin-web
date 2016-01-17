var dg = $('#dg');
jQuery(document).ready(function() {
	App.setPage("forms"); // Set current page
	App.init(); // Initialise plugins and elements

	initDg();

});

function initDg() {
	// $('#dg').datagrid({
	// url : '/menjin/data/datagrid_data1.json',
	// collapsible : true,
	// method : 'get'
	// });

	var url = '/menjin/data/datagrid_data1.json';
	var col = [ {
		field : '',
		checkbox : true
	}, {
		field : 'itemid',
		title : '姓名',
		width : 100
	}, {
		field : 'productid',
		title : '公司',
		width : 100
	}, {
		field : 'listprice',
		title : '部门',
		width : 100
	}, {
		field : 'unitcost',
		title : '工号',
		width : 100
	}, {
		field : 'attr1',
		title : '卡号',
		width : 100
	} ];
	var cols = [ col ];
	var set = dgSetting1(url, cols);
	set['onLoadSuccess'] = function() {
		// 鼠标划过显示title
		$('.datagrid-cell').each(function(i, o) {
			var txt = $(o).text();
			$(o).attr('title', txt);
		});
	};
	set['toolbar'] = [ {
		text:'添加人员到列表',
		handler:function(){alert('add')}
	} ];

	dg.datagrid(set);

}
