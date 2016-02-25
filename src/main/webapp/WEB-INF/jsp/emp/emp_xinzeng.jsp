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
														<label class="">姓名</label><input type="text" name="empname" id="empname" class="form-control" value="">
													</div>
													<div class="form-group">
														<label class="">人员编号</label><input type="text" name="empno" id="empno" class="form-control" value="">
													</div>
													<div class="form-group">
														<label class="">卡号</label><input type="text" name="empcardno" id="empcardno" class="form-control" value="">
													</div>
													<div class="form-group">
														<label class="">身份证</label><input type="text" name="empidno" id="empidno" class="form-control" value="">
													</div>
													<div class="form-group">
														<label class="">性别</label><br> <select name="empsex">
															<option value="男">男</option>
															<option value="女">女</option>
														</select>
													</div>
													<div class="form-group">
														<label class="">人员状态</label><br> <select name="empstatusid">
															<option value="1">在职</option>
															<option value="2">准备离职</option>
															<option value="3">离职</option>
															<option value="4">退养</option>
															<option value="5">退休</option>
															<option value="6">冻结</option>
															<option value="7">其他(非在职)</option>
														</select>
													</div>
													<div class="form-group">
														<label class="">所在部门</label><br>
														<button type="button" class="btn btn-info" data-toggle="modal" data-target="#dptModal">选择</button>
														<span id="dptname"></span> <input type="hidden" name="dptid" id="dptid">
													</div>
													<div class="form-group">
														<label class="">职务</label><br> <select name="positionid">
															<c:forEach items="${positionList}" var="p">
																<option value="${p.positionid}">${p.positionname}</option>
															</c:forEach>
														</select>
													</div>
													<div class="form-group">
														<label class="">级别</label><br> <select name="grdid">
															<c:forEach items="${grdList}" var="g">
																<option value="${g.grdid}">${g.grdname}</option>
															</c:forEach>
														</select>
													</div>
													<div class="form-group">
														<label class="">持卡类别</label><br> <select name="empcardtid">
															<c:forEach items="${cardtypeList}" var="cd">
																<option value="${cd.cardtypeid}">${cd.cardtypename}</option>
															</c:forEach>
														</select>
													</div>
													<div class="form-group">
														<label class="">门禁卡类型</label><br> <select name="badgeId">
															<option value="0x002dfd0e7fb3088411d3aa910040051fce21">标准雇员</option>
															<option value="0x002dfd0e7fb4088411d3aa910040051fce21">订约人</option>
														</select>
													</div>
													<div class="form-group">
														<label class="">银行卡</label><input type="text" name="empbankno" class="form-control" value="">
													</div>
													<div class="form-group">
														<label class="">岗位</label><input type="text" name="" class="form-control" value="">
													</div>
													<div class="form-group">
														<label class="">工种</label><input type="text" name="" class="form-control" value="">
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

	<div id="dptModal" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">请选择部门</h4>
				</div>
				<div class="modal-body">
					<ul id="dptTree" class="ztree" style=""></ul>
				</div>
				<div class="modal-footer">
					<!-- 					<button type="button" class="btn btn-primary" id="dptQingchu">清除</button> -->
					<button type="button" class="btn btn-primary" id="dtpQueding">确定</button>
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
				</div>
			</div>
		</div>
	</div>

	<!--/PAGE -->
	<%@ include file="/WEB-INF/jsp/inc/inc_js.jsp"%>
	<script type="text/javascript" src="<%=path%>/resources/js/zTree_v3/js/jquery.ztree.all-3.5.js"></script>
	<script type="text/javascript" src="<%=path%>/resources/js/menjin/emp/emp_xinzeng.js"></script>
	${json_script}
</body>
</html>