var __ctx = '/menjin';
var __suffix = '.html';

var isLeftLoaded = false;

$(function() {
	// left menu
	$('#sidebar').load(cu('/left'), function() {
		// 加载完成
		isLeftLoaded = true;
		// 高亮当前
		$('#menu1_'+$('#left_menuid1').val()).addClass('active');
		$('#menu2_'+$('#left_menuid2').val()).addClass('current');
	});

});

/**
 * create url
 * 
 * @param url
 * @returns {String}
 */
function cu(url) {
	return __ctx + url + __suffix;
}

function page_init(pageName) {
	var timer = undefined;
	timer = setInterval(function() {
		if (isLeftLoaded != undefined && isLeftLoaded) {
			App.setPage(pageName); // Set current page
			App.init(); // Initialise plugins and elements
			window.clearInterval(timer);
		}
	}, 100);
}