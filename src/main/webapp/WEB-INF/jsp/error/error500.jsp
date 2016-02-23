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
	<!-- PAGE -->
	<section REQUESTERROR="REQUESTERROR" id="page">
		<!-- SIDEBAR -->
<!-- 		<div id="sidebar" class="sidebar"></div> -->
		<!-- /SIDEBAR -->
		<div id="main-content">
			<div class="container">
				<div class="row">
					<div id="content" class="col-lg-12">
						<!-- /PAGE HEADER -->
						<div class="row">
							<div class="col-md-12 not-found text-center">
								<div class="error-500">500</div>
							</div>
							<div class="col-md-4 col-md-offset-4 not-found text-center">
								<div class="content">
									<h3>${message}</h3>
									<div class="btn-group">
										<a href="<%=path%>${continueurl}" class="btn btn-danger">确定</a>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>

	<%@ include file="/WEB-INF/jsp/inc/inc_js.jsp"%>
	<script>
		jQuery(document).ready(function() {
			page_init("widgets_box");
		});
	</script>
	<!-- /JAVASCRIPTS -->
</body>
</html>