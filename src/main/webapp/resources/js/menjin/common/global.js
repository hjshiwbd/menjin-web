var __ctx = '/menjin';
var __suffix = '.html';

$(function() {
	// left menu
	$('#sidebar').load(cu('/left'));
	
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