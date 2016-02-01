/**
 * 通过入参，提交表单参数
 * 指定form，获取其中的参数
 * 提交方式：isdatagrid查询、isload异步加载新页面，isexport导出，（最原始的参数提交返回json，执行callback）
 * 参数：
 * url，请求地址
 * form，form的选择器（#formid）
 * param，请求参数。在form内的参数的基础上，加额外的参数。
 * selects，数组['name1','name2']，值=-1则不提交此参数
 * ingoreSelectvalue 对应selects参数，默认-1
 * datebox，数组['name1','name2']，字段结尾加“1”和“2”来表示开始、结束的时间
 * callback，回调方法
 * isexport，是否导出
 * isdatagrid，是否是datagrid查询，依赖dg参数
 * dg，和isdatagrid关联，表示dg对象
 * isload，是否是异步加载页面区域内容，依赖loadtarget
 * loadtarget，异步加载区域的选择器，eg：#div1
 * onLoadSuccess，load成功后的回调方法
 * validation，提交之前的验证，返回false则不提交
 */
$.fn
		.extend({
			"tjbd" : function(option) {
				var src = $(this);
				var __tjbd_option = getOption(option);
				var url = __tjbd_option.url;
				var param = __tjbd_option.param;
				var form = __tjbd_option.form;
				var selects = __tjbd_option.selects;
				var datebox = __tjbd_option.datebox;
				var ingoreSelectvalue = __tjbd_option.ingoreSelectvalue == undefined ? '-1'
						: __tjbd_option.ingoreSelectvalue;// form中的下拉框的value='-1'时,不作为参数提交
				var callback = __tjbd_option.callback == undefined ? function(o) {
					eualert(o['message']);
				}
						: __tjbd_option.callback;
				var isexport = __tjbd_option.isexport ? __tjbd_option.isexport
						: false;// 是否导出操作
				var dg = __tjbd_option.dg ? __tjbd_option.dg : false;// datagrid对象
				var isdatagrid = __tjbd_option.isdatagrid ? __tjbd_option.isdatagrid
						: false;// 是否datagrid查询
				var isload = __tjbd_option.isload ? __tjbd_option.isload
						: false;// 是否load方式加载页面
				var loadtarget = __tjbd_option.loadtarget ? __tjbd_option.loadtarget
						: undefined;
				var onLoadSuccess = __tjbd_option.onLoadSuccess ? __tjbd_option.onLoadSuccess
						: false;// load成功回调方法
				var validation = __tjbd_option.validation ? __tjbd_option.validation
						: function() {
							return true;
						};

				function getOption(option) {
					var opname = '__tjbd_option';
					var __tjbd_option = src.data(opname);
					if (__tjbd_option == undefined) {
						__tjbd_option = option;
						src.data(opname, option);
					}
					// clog(src[0].id,__tjbd_option);
					return __tjbd_option;
				}

				// 初始化提交参数
				function getParam() {
					var multiNameCount_ = {};// name有多个时,记录此name已被处理了多少次
					var _param = {};
					if (form != undefined) {
						var arr = $(form).serializeArray();
						// clog(arr);
						for ( var key in arr) {
							var o = arr[key];
							addDatebox(_param, arr, datebox);
							if (o['value'] != '' && isAddSelect(o, selects)) {
								setValueIntoParam(_param, o, multiNameCount_);
							}
						}
					}
					if (param != undefined) {
						for ( var key in param) {
							if (typeof(param[key])=='function') {
								_param[key] = param[key]();
							} else {
								_param[key] = param[key];
							}
						}
					}
					// clog('_param:', JSON.stringify(_param));
					return _param;
				}

				// 将form参数设置到_param
				function setValueIntoParam(param, o, multiNameCount_) {
					var name = o['name'];
					// 是否有多个同name的dom
					// 重复name的命名格式:必须含有[].eg:xs.sflxids[]
					// var isone = $(form).find('[name="' +name + '"]').length
					// == 1;
					var isone = name.indexOf('[]') == -1;
					if (!isone) {
						var count = multiNameCount_[name];
						count = count == undefined ? 0 : count;
						// 多个name时,组成xs.sflxids[0]=xx,xs.sflxids[1]=xx,xs.sflxids[2]=xx的格式提交
						var i = name.indexOf('[');
						param[name.substring(0, i + 1) + count
								+ name.substring(i + 1)] = o['value'];
						// 记录次数
						multiNameCount_[name] = ++count;
					} else {
						param[name] = o['value'];
					}
				}

				// 添加日期参数
				function addDatebox(param, arr, datebox) {
					if (datebox != undefined) {
						var suffix = [ '1', '2' ];
						for ( var i in datebox) {
							var name = datebox[i];
							var name1 = name + suffix[0];
							var name2 = name + suffix[1];
							for ( var k in arr) {
								var o = arr[k];
								if (o['name'] == name1 && o['value'] != '') {
									param[name1] = o['value'] + ' 00:00:00';
									arrRemove(arr, k);
								}
								if (o['name'] == name2 && o['value'] != '') {
									param[name2] = o['value'] + ' 23:59:59';
									arrRemove(arr, k);
								}
							}
						}
					}
				}

				// 处理select
				function isAddSelect(param, selects) {
					if (selects != undefined) {
						for ( var key in selects) {
							if (param['name'] == selects[key]
									&& param['value'] == ingoreSelectvalue) {
								return false;
							}
						}
					}
					return true;
				}

				// 数组删除
				function arrRemove(arr, i) {
					arr.splice(i, 1);
				}

				// 提交
				function dotj() {
					if (isdatagrid && dg != undefined) {
						// datagrid查询
						dg.datagrid('reload', getParam());
					} else if (isload && loadtarget != undefined) {
						// load加载新页面
						var opt = {
							url : url,
							param : getParam(),
							dataType : 'html',
							callback : function(o) {
								$(loadtarget).html(o);
								if (onLoadSuccess) {
									onLoadSuccess(o);
								}
							}
						};
						commonAjax(opt);
					} else if (url != undefined) {
						// 正常提交
						var opt = {
							url : url,
							param : getParam(),
							callback : function(o) {
								if (o['result'] == '1' && isexport) {
									// 根据返回内容,进行导出下载
									doExpDownload(o);
								} else {
									// 正常返回
									callback(o);
								}
							}
						};
						commonAjax(opt);
					}

				}
				function doExpDownload(o) {
					// 导出,添加隐藏表单,然后提交
					var html = '<form id="_tjbd_export" action="" target="_self" style="display: none;"></form>';
					src.after(html);
					var xzdz = o['object'];// 下载地址
					$('#_tjbd_export').attr('action', xzdz).submit();
					$('#_tjbd_export').remove();
				}

				if (typeof (option) == 'string') {
					return eval(option + '()');
				} else {
					src.on('click', function(e) {
						if (validation(e)) {
							dotj();
						}
					});
				}
			}
		});
