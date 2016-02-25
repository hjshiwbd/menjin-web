var treeObj;

jQuery(document).ready(function() {
	page_init("widgets_box");

	// dpt tree
	dptTree();// 部门树初始化
	dptTreeOpertion();// 部门树的相关操作

	// form validate
	validate();

	// form submit
	formSubmit();
});

function dptTree() {
	var treeSetting = {
		data : {
			key : {
				name : 'dptname'
			},
			simpleData : {
				enable : true,
				idKey : "dptid",
				pIdKey : "dptparnt",
				rootPId : "0"
			}
		}
	};

	// $("#tree").css('height', dgHeight + 'px');
	$.fn.zTree.init($("#dptTree"), treeSetting, dptList);
	treeObj = $.fn.zTree.getZTreeObj("dptTree");
}

function dptTreeOpertion() {
	$('#dptQingchu').on('click', function() {
		// 删除已选择
	});
	$('#dtpQueding').on('click', function() {
		var nodes = treeObj.getSelectedNodes();
		if (nodes && nodes.length > 0) {
			var dptid = nodes[0]['dptid'];
			$('#dptid').val(dptid);
			$('#dptname').html(nodes[0]['dptname']);
			$('#dptModal').modal('hide');
		}

	});
}

function validate() {
	$('#empname,#empno').validatebox({
		required : true
	});
}

function formSubmit() {
	$('#form1').form({
		url : cu('/emp/do_xinzeng'),
		onSubmit : function() {
			var dptid = $('#dptid').val();
			// clog('dptid', dptid);
			if (dptid == '') {
				eualert('请选择部门');
				return false;
			}
			if (!$('#form1').form('validate')) {
				return false;
			}
			showWaitingDiv();
		},
		success : function(data) {
			hideWaitingDiv();
			// clog(data);
			if (data.indexOf('REQUESTERROR') != -1) {
				// 出错页面
				eualert(decodeURIComponent('系统响应异常，请稍候再试'));
				return;
			} else {
				data = JSON.parse(data);
				eualert(decodeURIComponent(data.message));
			}
		}
	});
}