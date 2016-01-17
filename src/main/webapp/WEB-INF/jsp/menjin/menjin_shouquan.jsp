<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/inc/inc_java.jsp"%>
<!DOCTYPE html>
<html lang="zh">
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<title>门禁管理系统</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1, user-scalable=no">
<meta name="description" content="">
<meta name="author" content="">
<%@ include file="/WEB-INF/jsp/inc/inc_css.jsp"%>
<!-- TYPEAHEAD -->
<link rel="stylesheet" type="text/css" href="<%=path%>/resources/js/typeahead/typeahead.css" />
<!-- SELECT2 -->
<link rel="stylesheet" type="text/css" href="<%=path%>/resources/js/select2/select2.min.css" />
<link rel="stylesheet" href="<%=path%>/resources/js/zTree_v3/css/zTreeStyle/zTreeStyle.css" type="text/css">
</head>
<body>
	<!-- HEADER -->
	<!--/HEADER -->
	<!-- PAGE -->
	<section id="page">
		<!-- SIDEBAR -->
		<div id="sidebar" class="sidebar"></div>
		<!-- /SIDEBAR -->
		<div id="main-content">
			<div class="container">
				<div class="row">
					<div id="content" class="col-lg-12">
						<!-- PAGE HEADER-->
						<div class="row">
							<div class="col-sm-12">
								<div class="page-header">
									<!-- STYLER -->
									<!-- /STYLER -->
									<div class="clearfix">
										<h3 class="content-title pull-left">门禁授权</h3>
									</div>
									<div class="divide-20"></div>
									<div class="description">设置或者收回员工访问门禁的权限</div>
								</div>
							</div>
						</div>
						<!-- /PAGE HEADER -->
						<div class="row">
							<div class="col-md-12">
								<!-- BOX -->
								<div class="box border primary">
									<div class="box-title">
										<h4>
											<i class="fa fa-bars"></i>1.选择人员
										</h4>
										<div class="tools hidden-xs">
											<a href="#box-config" data-toggle="modal" class="config"> <i class="fa fa-cog"></i>
											</a> <a href="javascript:;" class="reload"> <i class="fa fa-refresh"></i>
											</a> <a href="javascript:;" class="collapse"> <i class="fa fa-chevron-up"></i>
											</a> <a href="javascript:;" class="remove"> <i class="fa fa-times"></i>
											</a>
										</div>
									</div>
									<div class="box-body big">
										<div class="row">
											<form class="" action="">
												<div class="form-group col-xs-2">
													<label class="col-xs-6">姓名</label><input type="text" class="form-control">
												</div>
												<div class="form-group col-xs-2">
													<label class="col-xs-6">公司</label><input type="text" class="form-control">
												</div>
												<div class="form-group col-xs-2">
													<label class="col-xs-6">部门</label><input type="text" class="form-control">
												</div>
												<div class="form-group col-xs-2">
													<label class="col-xs-6">工号</label><input type="text" class="form-control">
												</div>
												<div class="form-group col-xs-2">
													<label class="col-xs-6">卡号</label><input type="text" class="form-control">
												</div>
												<div class="clearfix"></div>
												<div class="form-group col-xs-2">
													<button type="button" class="btn btn-primary">查询</button>
												</div>
											</form>
										</div>
										<div class="row">
											<div class="col-md-8">
												<!-- BOX -->
												<div class="box border primary">
													<div class="box-title">
														<h4>
															<i class="fa fa-bar-chart-o"></i>查询结果
														</h4>
														<div class="tools"></div>
													</div>
													<div class="box-body">
														<table id="dg"></table>
													</div>
												</div>
												<!-- 												<h3>已选择：12人</h3> -->
												<!-- /BOX -->
											</div>
											<div class="col-md-4">
												<!-- BOX -->
												<div class="box border primary">
													<div class="box-title">
														<h4>
															<i class="fa fa-bar-chart-o"></i>选择门禁并授权
														</h4>
														<div class="tools"></div>
													</div>
													<div class="box-body">
														<ul id="treeDemo" class="ztree"></ul>
													</div>
												</div>
												<!-- <h3>已选择：12人</h3> -->
												<!-- /BOX -->
											</div>
										</div>
									</div>
								</div>
								<!-- /BOX -->
							</div>
						</div>
						<div class="separator"></div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!--/PAGE -->
	<%@ include file="/WEB-INF/jsp/inc/inc_js.jsp"%>
	<!-- SELECT2 -->
	<script type="text/javascript" src="<%=path%>/resources/js/select2/select2.min.js"></script>
	<!-- TYPEHEAD -->
	<script type="text/javascript" src="<%=path%>/resources/js/typeahead/typeahead.min.js"></script>
	<!-- AUTOSIZE -->
	<script type="text/javascript" src="<%=path%>/resources/js/autosize/jquery.autosize.min.js"></script>
	<!-- COUNTABLE -->
	<script type="text/javascript" src="<%=path%>/resources/js/countable/jquery.simplyCountable.min.js"></script>
	<!-- UNIFORM -->
	<script type="text/javascript" src="<%=path%>/resources/js/uniform/jquery.uniform.min.js"></script>
	<script type="text/javascript" src="<%=path%>/resources/js/menjin/menjin/menjin_shouquan.js"></script>
	<script type="text/javascript" src="<%=path%>/resources/js/zTree_v3/js/jquery.ztree.core-3.5.js"></script>
	<script type="text/javascript" src="<%=path%>/resources/js/zTree_v3/js/jquery.ztree.excheck-3.5.js"></script>
	<SCRIPT type="text/javascript">
	<!--
		var setting = {
			check : {
				enable : true
			},
			data : {
				simpleData : {
					enable : true
				}
			}
		};

		var zNodes = [ {
			id : 1,
			pId : 0,
			name : "随意勾选 1",
			open : true
		}, {
			id : 11,
			pId : 1,
			name : "随意勾选 1-1",
			open : true
		}, {
			id : 111,
			pId : 11,
			name : "随意勾选 1-1-1"
		}, {
			id : 112,
			pId : 11,
			name : "随意勾选 1-1-2"
		}, {
			id : 12,
			pId : 1,
			name : "随意勾选 1-2",
			open : true
		}, {
			id : 121,
			pId : 12,
			name : "随意勾选 1-2-1"
		}, {
			id : 122,
			pId : 12,
			name : "随意勾选 1-2-2"
		}, {
			id : 2,
			pId : 0,
			name : "随意勾选 2",
			checked : true,
			open : true
		}, {
			id : 21,
			pId : 2,
			name : "随意勾选 2-1"
		}, {
			id : 22,
			pId : 2,
			name : "随意勾选 2-2",
			open : true
		}, {
			id : 221,
			pId : 22,
			name : "随意勾选 2-2-1",
			checked : true
		}, {
			id : 222,
			pId : 22,
			name : "随意勾选 2-2-2"
		}, {
			id : 23,
			pId : 2,
			name : "随意勾选 2-3"
		} ];

		var code;

		function setCheck() {
			var zTree = $.fn.zTree.getZTreeObj("treeDemo"), py = $("#py").attr("checked") ? "p" : "", sy = $("#sy").attr("checked") ? "s" : "", pn = $("#pn")
					.attr("checked") ? "p" : "", sn = $("#sn").attr("checked") ? "s" : "", type = {
				"Y" : py + sy,
				"N" : pn + sn
			};
			zTree.setting.check.chkboxType = type;
			showCode('setting.check.chkboxType = { "Y" : "' + type.Y + '", "N" : "' + type.N + '" };');
		}
		function showCode(str) {
			if (!code)
				code = $("#code");
			code.empty();
			code.append("<li>" + str + "</li>");
		}

		$(document).ready(function() {
			$.fn.zTree.init($("#treeDemo"), setting, zNodes);
			setCheck();
			$("#py").bind("change", setCheck);
			$("#sy").bind("change", setCheck);
			$("#pn").bind("change", setCheck);
			$("#sn").bind("change", setCheck);
		});
	//-->
	</SCRIPT>
</body>
</html>