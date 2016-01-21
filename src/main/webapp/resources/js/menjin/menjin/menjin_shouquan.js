var dg = $('#dg');
var dgHeight = 450;

jQuery(document).ready(function() {
	page_init("forms");
	initDg();
	initTree();
	sq();
	qxsq();
});

/**
 * 授权
 */
function sq() {
	$('#sq').on('click', function() {
		alert('授权');
	});
}

/**
 * 取消授权
 */
function qxsq() {
	$('#qxsq').on('click', function() {
		alert('取消授权');
	});
}

function initTree() {
	$("#tree").css('height', dgHeight + 'px');
	$.fn.zTree.init($("#tree"), treeSetting, zNodes);
}

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
	// set['toolbar'] = [ {
	// text : '添加人员到列表',
	// handler : function() {
	// alert('add')
	// }
	// } ];

	dg.datagrid(set);

}

var treeSetting = {
	check : {
		enable : true,
		chkboxType : {
			"Y" : "s",
			"N" : "s"
		}
	},
	data : {
		simpleData : {
			enable : true
		}
	}
};

var zNodes = [ {
	id : 1,
	pId : 0,
	name : "门禁 1",
	open : true
}, {
	id : 11,
	pId : 1,
	name : "门禁 1-1",
	open : true
}, {
	id : 111,
	pId : 11,
	name : "门禁 1-1-1"
}, {
	id : 112,
	pId : 11,
	name : "门禁 1-1-2"
}, {
	id : 12,
	pId : 1,
	name : "门禁 1-2",
	open : true
}, {
	id : 121,
	pId : 12,
	name : "门禁 1-2-1"
}, {
	id : 122,
	pId : 12,
	name : "门禁 1-2-2"
}, {
	id : 2,
	pId : 0,
	name : "门禁 2",
	checked : true,
	open : true
}, {
	id : 21,
	pId : 2,
	name : "门禁 2-1"
}, {
	id : 22,
	pId : 2,
	name : "门禁 2-2",
	open : true
}, {
	id : 221,
	pId : 22,
	name : "门禁 2-2-1",
	checked : true
}, {
	id : 222,
	pId : 22,
	name : "门禁 2-2-2"
}, {
	id : 23,
	pId : 2,
	name : "门禁 2-3"
} ];
