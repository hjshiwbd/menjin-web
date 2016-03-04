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
										<h3 class="content-title pull-left">门禁设置</h3>
									</div>
									<div class="divide-20"></div>
									<div class="description">门禁设置</div>
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
											<i class="fa fa-bars"></i>门禁设置
										</h4>
									</div>
									<div class="row">
										<div class="col-md-12">
											<!-- BOX -->
											<table id="dg"></table>
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

	<div id="addDoorDiv" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">新增部门</h4>
				</div>
				<div class="modal-body">
					<form id="form1" method="post">
						<!-- 						<div class="form-group"> -->
						<!-- 							<label class="">编号</label><input type="text" name="dptno" id="dptno" class="form-control" value=""> -->
						<!-- 						</div> -->
						<div class="form-group">
							<label class="">名称</label><input type="text" name="doorname" id="doorname" class="form-control" value="">
						</div>
						<div class="form-group">
							<label class="">hw访问码id</label><input type="text" name="hwacid" id="hwacid" class="form-control" value="">
						</div>
						<div class="form-group">
							<label class="">是否作为考勤用途</label><input type="text" name="hwacid" id="hwacid" class="form-control" value="">
						</div>
						<!-- 						<div class="form-group"> -->
						<!-- 							<label class="">上级部门编号</label><input type="text" name="dptparnt" id="dptparnt" class="form-control" value=""> -->
						<!-- 						</div> -->
						<div class="form-group">
							<button id="bcm" type="button" class="btn btn-primary">保存</button>
							<button class="btn btn-default" data-dismiss="modal">关闭</button>
						</div>
					</form>
				</div>
				<div class="modal-footer"></div>
			</div>
		</div>
	</div>

	<div id="editDoorDiv" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">请选择部门</h4>
				</div>
				<div class="modal-body">
					<form id="form2" method="post">
						<input type="hidden" id="doorid" name="doorid">
						<!-- 						<div class="form-group"> -->
						<!-- 							<label class="">编号</label><input type="text" name="dptno" id="dptno" class="form-control" value=""> -->
						<!-- 						</div> -->
						<div class="form-group">
							<label class="">名称</label><input type="text" name="doorname" id="doorname" class="form-control" value="">
						</div>
						<div class="form-group">
							<label class="">hw访问码id</label><input type="text" name="hwacid" id="hwacid" class="form-control" value="">
						</div>
						<!-- 						<div class="form-group"> -->
						<!-- 							<label class="">上级部门编号</label><input type="text" name="dptparnt" id="dptparnt" class="form-control" value=""> -->
						<!-- 						</div> -->
						<div class="form-group">
							<button id="xgm" type="button" class="btn btn-primary">保存</button>
							<button class="btn btn-default" data-dismiss="modal">关闭</button>
						</div>
					</form>
				</div>
				<div class="modal-footer"></div>
			</div>
		</div>
	</div>

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
	<script type="text/javascript" src="<%=path%>/resources/js/menjin/menjin/menjin_shezhi.js"></script>
</body>
</html>