<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/inc/inc_java.jsp"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<title>登录</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1, user-scalable=no">
<meta name="description" content="">
<meta name="author" content="">
<%@ include file="/WEB-INF/jsp/inc/inc_css.jsp"%>
<style type="text/css">
.form-control {
	height: 40px;
}
</style>
</head>
<body class="login">
	<!-- PAGE -->
	<section id="page">
		<!-- HEADER -->
		<header>
			<!-- NAV-BAR -->
			<div class="container">
				<div class="row">
					<div class="col-md-4 col-md-offset-4">
						<div id="logo" class="">
<%-- 							<a href="index.html"><img src="<%=path%>/resources/img/logo/logo-alt.png" height="40" alt="logo name" /></a> --%>
						</div>
					</div>
				</div>
			</div>
			<!--/NAV-BAR -->
		</header>
		<!--/HEADER -->
		<!-- LOGIN -->
		<section id="login" class="visible">
			<div class="container">
				<div class="row">
					<div class="col-md-4 col-md-offset-4">
						<div class="login-box-plain">
							<h2 class="bigintro">门禁权限管理系统</h2>
							<div class="divide-40"></div>
							<form action="<%=path%>/login/do_login.html" role="form">
								<div class="form-group">
									<label for="exampleInputEmail1">登录名</label> <i class="fa fa-user"></i> <input type="text" class="form-control" value="admin" name="username" id="exampleInputEmail1">
								</div>
								<div class="form-group">
									<label for="exampleInputPassword1">密码</label> <i class="fa fa-lock"></i> <input type="password" class="form-control" id="exampleInputPassword1">
								</div>
								<div class="form-actions">
									<button type="submit" class="btn btn-danger">登&nbsp;&nbsp;&nbsp;&nbsp;录</button>
								</div>
							</form>
							<!-- SOCIAL LOGIN -->
							<div class="divide-20"></div>
							
							<!-- /SOCIAL LOGIN -->
							<div class="login-helpers">
								<a href="#" onclick_donothing="swapScreen('forgot');return false;">忘记密码?</a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</section>
		<!--/LOGIN -->
		<!-- REGISTER -->
		<section id="register">
			<div class="container">
				<div class="row">
					<div class="col-md-4 col-md-offset-4">
						<div class="login-box-plain">
							<h2 class="bigintro">Register</h2>
							<div class="divide-40"></div>
							<form role="form">
								<div class="form-group">
									<label for="exampleInputName">Full Name</label> <i class="fa fa-font"></i> <input type="text" class="form-control" id="exampleInputName">
								</div>
								<div class="form-group">
									<label for="exampleInputUsername">Username</label> <i class="fa fa-user"></i> <input type="text" class="form-control" id="exampleInputUsername">
								</div>
								<div class="form-group">
									<label for="exampleInputEmail1">Email address</label> <i class="fa fa-envelope"></i> <input type="email" class="form-control" id="exampleInputEmail1">
								</div>
								<div class="form-group">
									<label for="exampleInputPassword1">Password</label> <i class="fa fa-lock"></i> <input type="password" class="form-control" id="exampleInputPassword1">
								</div>
								<div class="form-group">
									<label for="exampleInputPassword2">Repeat Password</label> <i class="fa fa-check-square-o"></i> <input type="password" class="form-control"
										id="exampleInputPassword2">
								</div>
								<div class="form-actions">
									<label class="checkbox"> <input type="checkbox" class="uniform" value=""> I agree to the <a href="#">Terms of Service</a> and <a
										href="#">Privacy Policy</a></label>
									<button type="submit" class="btn btn-success">Sign Up</button>
								</div>
							</form>
							<!-- SOCIAL REGISTER -->
							<div class="divide-20"></div>
							<div class="center">
								<strong>Or register using your social account</strong>
							</div>
							<div class="divide-20"></div>
							<div class="social-login center">
								<a class="btn btn-primary btn-lg"> <i class="fa fa-facebook"></i>
								</a> <a class="btn btn-info btn-lg"> <i class="fa fa-twitter"></i>
								</a> <a class="btn btn-danger btn-lg"> <i class="fa fa-google-plus"></i>
								</a>
							</div>
							<!-- /SOCIAL REGISTER -->
							<div class="login-helpers">
								<a href="#" onclick="swapScreen('login');return false;"> Back to Login</a> <br>
							</div>
						</div>
					</div>
				</div>
			</div>
		</section>
		<!--/REGISTER -->
		<!-- FORGOT PASSWORD -->
		<section id="forgot">
			<div class="container">
				<div class="row">
					<div class="col-md-4 col-md-offset-4">
						<div class="login-box-plain">
							<h2 class="bigintro">Reset Password</h2>
							<div class="divide-40"></div>
							<form role="form">
								<div class="form-group">
									<label for="exampleInputEmail1">Enter your Email address</label> <i class="fa fa-envelope"></i> <input type="email" class="form-control"
										id="exampleInputEmail1">
								</div>
								<div class="form-actions">
									<button type="submit" class="btn btn-info">Send Me Reset Instructions</button>
								</div>
							</form>
							<div class="login-helpers">
								<a href="#" onclick="swapScreen('login');return false;">Back to Login</a> <br>
							</div>
						</div>
					</div>
				</div>
			</div>
		</section>
		<!-- FORGOT PASSWORD -->
	</section>
	<!--/PAGE -->
	<%@ include file="/WEB-INF/jsp/inc/inc_js.jsp"%>
	<!-- UNIFORM -->
	<script type="text/javascript" src="<%=path%>/resources/js/uniform/jquery.uniform.min.js"></script>
	<script>
		jQuery(document).ready(function() {
			App.setPage("login"); //Set current page
			App.init(); //Initialise plugins and elements
		});
	</script>
	<script type="text/javascript">
		function swapScreen(id) {
			jQuery('.visible').removeClass('visible animated fadeInUp');
			jQuery('#' + id).addClass('visible animated fadeInUp');
		}
	</script>
	<!-- /JAVASCRIPTS -->
</body>
</html>