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
										<h3 class="content-title pull-left">人员新增</h3>
									</div>
									<div class="divide-20"></div>
									<div class="description">添加人员，和卡片进行绑定</div>
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
											<i class="fa fa-bars"></i>人员新增
										</h4>
										<div class="tools hidden-xs">
											<a href="#box-config" data-toggle="modal" class="config"> <i class="fa fa-cog"></i>
											</a> <a href="javascript:;" class="reload"> <i class="fa fa-refresh"></i>
											</a> <a href="javascript:;" class="collapse"> <i class="fa fa-chevron-up"></i>
											</a> <a href="javascript:;" class="remove"> <i class="fa fa-times"></i>
											</a>
										</div>
									</div>
									<div class="row">
										<div class="col-md-12">
											<div class=" col-xs-8">
												<form id="form1" method="post">
													<div class="form-group">
														<label class="">人员名称</label><input type="text" name="empname" id="empname" class="form-control" value="">
													</div>
													<div class="form-group">
														<label class="">工号</label><input type="text" name="empno" id="empno" class="form-control" value="">
													</div>
													<div class="form-group">
														<label class="">卡号</label><input type="text" name="empcardno" id="empcardno" class="form-control" value="">
													</div>
													<div class="form-group">
														<label class="">银行卡</label><input type="text" name="empbankno" class="form-control" value="">
													</div>
													<!-- 												<div class="form-group"> -->
													<!-- 													<label class="">有效天数</label><input type="text" style="width:10%" class="form-control" value=""> -->
													<!-- 												</div> -->
													<div class="form-group">
														<button id="sq" class="btn btn-primary">保存</button>
													</div>
												</form>
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
	<script type="text/javascript" src="<%=path%>/resources/js/menjin/emp/emp_xinzeng.js"></script>
</body>
</html>