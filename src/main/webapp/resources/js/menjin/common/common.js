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
	var hideWait = options.hideWait == undefined ? true : options.hideWait;
	var callback = function(msg) {
		if (typeof (_callback) == "function") {
			_callback(msg);
		}
	};

	if (!hideWait) {
		showWaitingDiv();
	}

	$.ajax({
		type : "post",
		async : _async,
		url : options.url,
		data : param,
		dataType : 'html',
		success : function(msg) {
			if (msg.indexOf('REQUESTERROR') != -1) {
				// 出错页面
				// $('body').html(msg);
				eualert('请求失败');
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
					if (msg.result == '-999') {
						eualert(decodeURIComponent(msg.message));
						return;
					}
				}
				// 页面返回区域
				if (options.target) {
					$(options.target).html(msg);
				}

				if (typeof (callback) == "function") {
					callback(msg);
				}
				hideWaitingDiv();
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
			hideWaitingDiv();
		}
	});
}

/**
 * 显示等待提示信息
 */
function showWaitingDiv() {
	var option = {
		message : '数据处理中请稍候...',
		draggable : false,
		css : {
			backgroundColor : '#eee',
			border : '1px solid #aaa',
			color : '#000'
		},
		overlayCSS : {
			backgroundColor : '#000',
			opacity : 0.3,
			cursor : 'default'
		}
	};
	$.blockUI(option);
}

/**
 * 关闭loading层
 */
function hideWaitingDiv() {
	$.unblockUI();
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

/**
 * short for console.log
 * 
 * @param msg
 * @returns {Boolean}
 */
function clog() {
	if (window.console && window.console.log && arguments.length > 0) {
		var s = '';
		for (var i = 0; i < arguments.length; i++) {
			s += ',arguments[' + i + ']';
		}
		s = s.substring(1);
		eval('console.log(' + s + ')');
	}
}
