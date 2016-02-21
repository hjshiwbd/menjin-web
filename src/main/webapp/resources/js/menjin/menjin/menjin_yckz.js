var treeObj;
jQuery(document).ready(function() {
	page_init("widgets_box");

	// 树
	initTree();

	// 控制功能
	readerFunctions();
});

/**
 * 读卡器的控制
 */
function readerFunctions() {
	$('#qiyong').click('on', function() {
		var options = {
			url : cu('/menjin/raeder/qiyong'),
			param : {
				readerid : $('#selectedId').val()
			},
			callback : function(resp) {
				eualert(resp.message);
			}
		};
		commonAjax(options);
	});
	$('#sjjs').click('on', function() {
		var options = {
			url : cu('/menjin/raeder/sjjs'),
			param : {
				readerid : $('#selectedId').val()
			},
			callback : function(resp) {
				eualert(resp.message);
			}
		};
		commonAjax(options);
	});
	$('#jiesuo').click('on', function() {
		var options = {
			url : cu('/menjin/raeder/jiesuo'),
			param : {
				readerid : $('#selectedId').val()
			},
			callback : function(resp) {
				eualert(resp.message);
			}
		};
		commonAjax(options);
	});
	$('#suo').click('on', function() {
		var options = {
			url : cu('/menjin/raeder/suo'),
			param : {
				readerid : $('#selectedId').val()
			},
			callback : function(resp) {
				eualert(resp.message);
			}
		};
		commonAjax(options);
	});
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
		},
		callback : {
			onClick : zTreeOnClick
		}

	};

	$("#readerTree").css('height', '450px');
	$.fn.zTree.init($("#readerTree"), treeSetting, readers);
	treeObj = $.fn.zTree.getZTreeObj("readerTree");
}

function zTreeOnClick(event, treeId, treeNode) {
	$('#selectedName').html(treeNode.descrp);
	$('#selectedId').val(treeNode.id);
};
