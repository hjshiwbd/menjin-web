var dg = $('#dg');
jQuery(document).ready(function() {
	page_init("forms");
	initTree();
});

function initTree() {
	$.fn.zTree.init($("#treeDemo"), treeSetting, zNodes);
}

var treeSetting = {
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
