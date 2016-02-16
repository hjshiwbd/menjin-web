var dg = $('#dg');
var dgHeight = 450;
var treeObj;

jQuery(document).ready(function() {
	page_init("forms");
	initDg();
	initTree();
	// 授权
	sq();
	// 取消授权
	qxsq();

	// 日期
	initRq();

	// 查询人员
	// search();
});

/**
 * 查询功能
 */
function search() {
	var option = {
		form : '#searchform',
		isdatagrid : true,
		validation : function() {
			return $('#searchform').form('validate');
		},
		dg : dg
	};
	// $('#cx').tjbd(option);
}

function initRq() {
	$('.issue_date').datebox({
		// editable : false,
		width : 235,
		height : 34
	});
}

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
	$.fn.zTree.init($("#tree"), treeSetting, acccodeList);
	treeObj = $.fn.zTree.getZTreeObj("tree");
}

function initDg() {
	// $('#dg').datagrid({
	// url : '/menjin/data/datagrid_data1.json',
	// collapsible : true,
	// method : 'get'
	// });

	// var url = '/menjin/data/datagrid_data1.json';
	var url = cu('/menjin/query_hw_person_dg');
	var col = [ {
		field : '',
		checkbox : true
	}, {
		field : 'empno',
		title : '编号',
		width : 100
	}, {
		field : 'empname',
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
	set['height'] = 450;
	set['singleSelect'] = true;
	set['onLoadSuccess'] = function() {
		// 鼠标划过显示title
		$('.datagrid-cell').each(function(i, o) {
			var txt = $(o).text();
			$(o).attr('title', txt);
		});
	};
	// 点击行,显示人员访问码权限
	set['onClickRow'] = function(index, row) {
		treeObj.checkAllNodes(false);// 取消所有已勾选
		var url = cu('/menjin/person_acccode');
		var options = {
			url : url,
			param : {
				empno : row.empno,
				empcardno : row.empcardno
			},
			callback : function(resp) {
				if (resp.result == '1') {
					var acclist = resp.object;
					for ( var key in acclist) {
						var acc = acclist[key];
						var node = treeObj.getNodeByParam("id", acc.id, null);
						treeObj.checkNode(node, true, true);
					}
				} else {
					eualert('此人尚无任何权限');
				}
			}
		};
		commonAjax(options);
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
		key : {
			name : 'descrp'
		},
		simpleData : {
			enable : true,
			idKey : "id",
			pIdKey : "",
			rootPId : null
		}
	}
};
