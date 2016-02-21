var treeObj;
jQuery(document).ready(function() {
	page_init("widgets_box");
	initTree();
});

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
