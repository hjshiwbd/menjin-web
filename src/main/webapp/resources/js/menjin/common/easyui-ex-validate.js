/**
 * use for easy ui form validate mode add by hjin 2012-11-5
 */
$(function() {
	$
			.extend(
					$.fn.validatebox.defaults.rules,
					{
						dateformat : {
							validator : function(value, param) {
								value = $.trim(value);
								if (value == "")
									return false;

								var reg = /^(([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3})-(((0?[13578]|1[02])-(0[1-9]|[12][0-9]|3[01]))|((0?[469]|11)-(0[1-9]|[12][0-9]|30))|(0?2-(0[1-9]|[1][0-9]|2[0-8]))))|((([0-9]{2})(0[48]|[2468][048]|[13579][26])|((0[48]|[2468][048]|[3579][26])00))-02-29)$/;
								if (!reg.test(value)
										|| value.split("-")[2].length > 2)
									return false;
								else
									return true;

							},
							message : '日期格式不正确,日期格式应该为:2008-08-08'
						},
						trimRequired : {
							validator : function(value, param) {
								if (!param || param[0] == true) {
									var trimValue = $.trim(value);
									if (trimValue == "") {
										return false;
									} else {
										return true;
									}
								} else {
									return true;
								}
							},
							message : '该输入项为必输项'
						},
						number : {
							validator : function(value, param) {
								if (!param || param[0] == true) {
									return /^-?\d+$/.test(value);
								} else {
									return true;
								}
							},
							message : '请输入数字'
						},
						minnumber : {
							validator : function(value, param) {
								// 必须大于某值
								if (/^\d+$/.test(value)) {
									if (parseInt(value) <= param[0]) {
										return false;
									} else {
										return true;
									}
								} else {
									return false;
								}
							},
							message : ""
						},
						Postcode : {
							validator : function(value, param) {
								// 没有参数或者参数为true时校验
								if (!param || param[0] == true) {
									return /^[1-9]\d{5}$/.test(value);
								} else {
									return true;
								}
							},
							message : '邮政编码不存在'
						},
						QQ : {
							validator : function(value, param) {
								// 没有参数或者参数为true时校验
								if (!param || param[0] == true) {
									return /^[1-9]\d{4,10}$/.test(value);
								} else {
									return true;
								}
							},
							message : 'QQ号码不正确'
						},
						mobile : {
							validator : function(value, param) {
								// 没有参数或者参数为true时校验
								if (!param || param[0] == true) {
									return /^((\(\d{2,3}\))|(\d{3}\-))?1(3|4|5|8)\d{9}$/
											.test(value);
								} else {
									return true;
								}
							},
							message : '手机号码不正确'
						},
						equalTo : {
							validator : function(value, param) {
								// 没有参数或者参数为true时校验
								if (param[0]) {
									return value == $(param[0]).val();
								} else {
									return true;
								}
							},
							message : '两次输入的密码不一致'
						},
						url : {
							validator : function(value, param) {
								var strRegex = '((?:http|https)(?::\\/{2}[\\w]+)(?:[\\/|\\.]?)(?:[^\\s"]*))';
								var re = new RegExp(strRegex);
								return re.test(value);
							},
							message : 'url地址不正确'
						},
						ip : {
							validator : function(value, param) {
								// ipv4 address validate
								var strRegex = '((?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?))(?![\\d])';
								var re = new RegExp(strRegex);
								return re.test(value);
							},
							message : 'ip格式不正确'
						},
						// 通用编码的格式
						codeStyle : {
							validator : function(value, param) {
								var reg = /^[A-Za-z0-9_]{5,20}$/;
								return reg.test(value);
							},
							message : '5-20位字符,可由数字和英文组成'
						},
						// 通用编码的格式
						codeFormat : {
							validator : function(value, param) {
								var reg = /^[A-Za-z0-9_]+$/;
								if (reg.test(value)) {
									// 判断长度是否正确
									if (value.length < param[0]
											|| value.length > param[1]) {
										return false;
									} else {
										return true;
									}
								}
								return reg.test(value);
							},
							message : '{0}-{1}位字符,可由数字和英文组成'
						},
						email : {
							validator : function(value, param) {
								var reg = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
								return reg.test(value);
							},
							message : '邮箱地址不正确'
						},
						phone : {
							validator : function(value, param) {
								var reg = /^\d{3,4}-{0,1}\d{7,8}$/;
								return reg.test(value);
							},
							message : '电话号码格式不正确'
						},
						regex : {
							validator : function(value, param) {
								// 是否正则对象,否则就是字符对象
								var isExgex = Object.prototype.toString.call(param[0]) === '[object RegExp]';
								var reg = isExgex ? param[0] : new RegExp(param[0]);
								clog('in-ex-vali:', param[0], ', value:',
										value, ' , result:', reg.test(value));
								return reg.test(value);
							},
							message : '数据格式错误'
						}
					});

	function getMaxDay(year, month) {
		if (month == 4 || month == 6 || month == 9 || month == 11)
			return "30";
		if (month == 2)
			if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0)
				return "29";
			else
				return "28";
		return "31";
	}
});