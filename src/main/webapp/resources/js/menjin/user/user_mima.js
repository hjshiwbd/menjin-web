$(function() {
	page_init("form");
	initMima();
	showErr();
	tj();
});

function initMima() {
	$('#oldPassword').validatebox({
		required : true
	});
	$('#newPassword').validatebox({
		required : true
	// ,validType : 'equalTo["#newPassword2"]'
	});
	$('#newPassword2').validatebox({
		required : true,
		validType : 'equalTo["#newPassword"]'
	});
}

function showErr() {
	var v = $('#errMsg').val();
	if (v != '') {
		eualert(v);
	}
}

/**
 * 提交
 */
function tj() {
	$('#fm1').on('submit', function() {
		if ($('#fm1').form('validate') == true) {
			var options = {
				url : '/menjin/user/change_mima.html',
				param : {
					oldPassword : $('#oldPassword').val(),
					newPassword : $('#newPassword').val(),
					newPassword2 : $('#newPassword2').val()
				},
				callback : function(resp) {
					eualert(resp.message);
				}
			};
			commonAjax(options);
		}
		return false;
	});
}