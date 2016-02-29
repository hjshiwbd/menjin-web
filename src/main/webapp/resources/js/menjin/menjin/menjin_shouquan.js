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
	search();

	// 全选&全不选
	selectAll();
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
		var persons = dg.datagrid('getChecked');
//		clog(persons);

		var cards = [];
		$.each(persons, function(i, o) {
			cards.push($.trim(o['empcardno']));
		});

		if (cards.length == 0) {
			eualert('请选择选择人员');
			return false;
		}
		
		// clog(accodes);
		var accodeIds = [];
		var accodes = treeObj.getCheckedNodes(true);
		$.each(accodes, function(i, o) {
			accodeIds.push(o['id']);
		});
		
//		if (accodeIds.length == 0) {
//			eualert('请选择选择门禁');
//			return false;
//		}
		
		var o = {
			cards : cards,
			accodeIds : accodeIds
		};
//		clog(o);
		var options = {
			url : cu('/menjin/save_shouquan'),
			param : {
				json : JSON.stringify(o)
			},
			callback : function(data) {
				eualert(data.message);
			}
		};
		commonAjax(options);
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
	}, {
		field : 'empsex',
		title : '性别',
		width : 100
	}, {
		field : 'empcardno',
		title : '卡号',
		width : 100
	}, {
		field : 'empstatusid',
		title : '状态',
		width : 100,
		formatter : function(value, row, index) {
			var txt = '';
			switch (value) {
			case '1':
				txt = '在职';
				break;
			case '2':
				txt = '准备离职';
				break;
			case '3':
				txt = '离职';
				break;
			case '4':
				txt = '退养';
				break;
			case '5':
				txt = '退休';
				break;
			case '6':
				txt = '冻结';
				break;
			case '7':
				txt = '其他(非在职)';
				break;
			default:
				txt = '';
				break;
			}
			return txt;
		}
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
					//eualert('此人尚无任何权限');
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

function selectAll() {
	$('#quanxuan').on('click', function() {
		treeObj.checkAllNodes(true);
	});
	$('#quanbuxuan').on('click', function() {
		treeObj.checkAllNodes(false);
	});
}