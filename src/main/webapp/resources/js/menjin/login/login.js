$(function() {
	validate();
	login();
});

function validate() {
	$('#username,#password').validatebox({
		required : true
	});
}

function login() {
	$('form').submit(function() {
		var flag = true;
		if ($('form').form('validate') == false) {
			return false;
		}
	});
}
