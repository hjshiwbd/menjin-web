var dg = $('#dg');

$(function() {
	page_init("forms");
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
	set['height'] = 450;
	set['onLoadSuccess'] = function() {
		// 鼠标划过显示title
		$('.datagrid-cell').each(function(i, o) {
			var txt = $(o).text();
			$(o).attr('title', txt);
		});
	};
	set['toolbar'] = [ {
		text : '删除',
		handler : function() {
			alert('shanchu');
		}
	}, {
		text : '冻结',
		handler : function() {
			alert('dongjie');
		}
	}, {
		text : '解冻',
		handler : function() {
			alert('解冻');
		}
	} ];

	dg.datagrid(set);

}
