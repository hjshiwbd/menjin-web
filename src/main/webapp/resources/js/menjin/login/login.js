$(function() {
	validate();
	login();
	showLoginError();
});

function validate() {
	$('#username,#password').validatebox({
		required : true
	});
}

function login() {
	$('form').submit(function() {
		if ($('form').form('validate') == false) {
			return false;
		}
	});
}

function showLoginError() {
	var v = $('#errMsg').val();
	if (v != '') {
		eualert(v);
	}
}