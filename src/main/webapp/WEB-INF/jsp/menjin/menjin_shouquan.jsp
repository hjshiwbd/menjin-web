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
											<i class="fa fa-bars"></i>门禁授权
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
											<form id="searchForm" class="" action="">
												<div class="form-group col-xs-2">
													<label class="col-xs-6">编号</label><input type="text" class="form-control">
												</div>
												<div class="form-group col-xs-2">
													<label class="col-xs-6">姓名</label><input type="text" class="form-control">
												</div>
<!-- 												<div class="form-group col-xs-2"> -->
<!-- 													<label class="col-xs-6">生效日期</label><input type="text" name="issue_date1" class="issue_date form-control"> 到 <input type="text" -->
<!-- 														id="issue_date2" name="issue_date2" class="form-control issue_date"> -->
<!-- 												</div> -->
<!-- 												<div class="form-group col-xs-2"> -->
<!-- 													<label class="col-xs-6">失效日期</label><input type="text" name="issue_date1" class="issue_date form-control"> 到 <input type="text" -->
<!-- 														name="issue_date2" class="issue_date form-control"> -->
<!-- 												</div> -->
												<div class="clearfix"></div>
												<div class="form-group col-xs-2">
													<button id="cx" type="button" class="btn btn-primary">查询人员</button>
												</div>
											</form>
										</div>
										<div class="row">
											<div class="col-md-8">
												<!-- BOX -->
												<div class="box border primary">
													<div class="box-title">
														<h4>
															<i class="fa fa-bar-chart-o"></i>请选择人员
														</h4>
														<div class="tools"></div>
													</div>
													<div class="box-body">
														<table id="dg"></table>
													</div>
												</div>
												<!-- /BOX -->
											</div>
											<div class="col-md-4">
												<!-- BOX -->
												<div class="box border primary">
													<div class="box-title">
														<h4>
															<i class="fa fa-bar-chart-o"></i>请选择门禁
														</h4>
														<div class="tools"></div>
													</div>
													<div class="box-body">
														<ul id="tree" class="ztree"></ul>
													</div>
												</div>
												<!-- <h3>已选择：12人</h3> -->
												<!-- /BOX -->
											</div>
										</div>
										<div class="row">
											<div class="col-md-12">
												<button id="sq" class="btn btn-danger">授权</button>
												<button id="qxsq" class="btn btn-danger">取消授权</button>
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
	<script type="text/javascript" src="<%=path%>/resources/js/zTree_v3/js/jquery.ztree.core-3.5.js"></script>
	<script type="text/javascript" src="<%=path%>/resources/js/zTree_v3/js/jquery.ztree.excheck-3.5.js"></script>
	<script type="text/javascript" src="<%=path%>/resources/js/menjin/menjin/menjin_shouquan.js"></script>
</body>
</html>