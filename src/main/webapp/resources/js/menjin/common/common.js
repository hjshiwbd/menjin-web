$.ajaxSetup({
	cache : false
});

/**
 * 通用ajax提交方法
 * 
 * @param options
 *            参数对象包含属性:url,param,callback,dataType,target.<br/>
 *            dataType和target至少有一个为undefined
 * @returns {Boolean}
 */
function commonAjax(options) {
	$.ajaxSetup({
		cache : false
	});

	// 参数为空或者ajax请求url为空时不做任何处理
	if (options == null || !options.url) {
		return false;
	}
	// 参数的处理
	var param = options.param;
	var _callback = options.callback;
	var _async = options.async == undefined ? true : options.async;
	var dataType = options.dataType == undefined ? 'json' : options.dataType;
	var callback = function(msg) {
		if (typeof (_callback) == "function") {
			_callback(msg);
		}
	};

	$.ajax({
		type : "post",
		async : _async,
		url : options.url,
		data : param,
		dataType : 'html',
		success : function(msg) {
			if (msg.indexOf('REQUESTERROR') != -1) {
				// 出错页面
				$('body').html(msg);
			} else if (msg.indexOf('USERNOTLOGINYET') != -1) {
				// session超时页面
				// window.open(ctxpath, "_self");
				location.reload();
			} else {
				// clog(msg);
				// 正常处理

				// 返回类型是json格式
				if (dataType == 'json') {
					msg = $.parseJSON(msg);
				}
				// 页面返回区域
				if (options.target) {
					$(options.target).html(msg);
				}

				if (typeof (callback) == "function") {
					callback(msg);
				}
			}
		},
		error : function(resp1, resp2, resp3) {
			if (resp1.readyState != '4') {
				// cas登录超时,刷新页面,使其重新登录
				location.href = location.href;
			}
			if (resp1.readyState == '4') {
				var html = resp1.responseText;
				if (html.indexOf('REQUESTERROR') != -1) {
					// ajax请求参数未被springMvc识别,显示错误页面(来自web.xml的error-code=400的配置)
					$('body').html(resp1.responseText);
				}
			}
		}
	});
}

/**
 * 向数组尾部添加新元素.第一个参数是原数组,其他参数均被push到arr尾部.若参数是数组会循环后添加
 * 
 * @param arr
 */
function arrayAppend(arr) {
	if (arguments.length > 1) {
		for (var i = 1; i < arguments.length; i++) {
			var child = arguments[i];
			if (Object.prototype.toString.call(child) == '[object Array]') {
				for ( var key in child) {
					arr.push(child[key]);
				}
			} else {
				arr.push(arguments[i]);
			}
		}
	}
	return arr;
}
