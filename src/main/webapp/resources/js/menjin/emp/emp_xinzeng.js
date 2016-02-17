jQuery(document).ready(function() {
	page_init("widgets_box");

	// form validate
	validate();

	// form submit
	formSubmit();
});

function validate() {
	$('#empname,#empno').validatebox({
		required : true
	});
}

function formSubmit() {
	$('#form1').form({
		url : cu('/emp/do_xinzeng'),
		onSubmit : function() {
			if (!$('#form1').form('validate')) {
				return false;
			}
		},
		success : function(data) {
			data=JSON.parse(data);
			eualert(data.message);
		}
	});
}