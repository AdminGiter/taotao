<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" class="no-js">
<head>
	<meta charset="utf-8">
	<title>淘淘商城后台管理系统</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta name="description" content="">
	<meta name="author" content="">
	<!-- CSS -->
	<link rel="stylesheet" href="<%=request.getContextPath()%>/css/login/supersized.css">
	<link rel="stylesheet" href="<%=request.getContextPath()%>/css/login/login.css">
	<link href="<%=request.getContextPath()%>/css/login/bootstrap.min.css" rel="stylesheet">
	<!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
	<!--[if lt IE 9]>
	<script src="js/html5.js"></script>
	<![endif]-->
	<script type="text/javascript">
		var basePath='<%=request.getContextPath()%>';
	</script>
	<script src="<%=request.getContextPath()%>/js/login/jquery-1.8.2.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/login/jquery.form.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/login/tooltips.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/login/login.js"></script>
</head>

<body>

<div class="page-container">
	<div class="main_box">
		<div class="login_box">
			<div class="login_logo">
				<img src="images/logo.png" >
			</div>

			<div class="login_form">
				<form>
					<div class="form-group">
						<label for="j_username" class="t">用户名：</label>
						<input id="username" value="" name="email" type="text" class="form-control x319 in"
							   autocomplete="off">
					</div>
					<div class="form-group">
						<label for="j_password" class="t">密　码：</label>
						<input id="password" value="" name="password" type="password"
							   class="password form-control x319 in">
					</div>
					<div class="form-group">
						<label class="t"></label>
						<label for="j_remember" class="m">
							<input id="j_remember" type="checkbox" value="true">&nbsp;记住登陆账号!</label>
					</div>
					<div class="form-group space">
						<label class="t"></label>　　　
						<button type="button"  id="submit_btn"
								class="btn btn-primary btn-lg">&nbsp;登&nbsp;录&nbsp </button>
						<input type="reset" value="&nbsp;重&nbsp;置&nbsp;" class="btn btn-default btn-lg">
					</div>
				</form>
			</div>
		</div>
		<div class="bottom">Copyright &copy; 2014 - 2015 <a href="#">系统登陆</a></div>
	</div>
</div>

<!-- Javascript -->

<script src="<%=request.getContextPath()%>/js/login/supersized.3.2.7.min.js"></script>
<script src="<%=request.getContextPath()%>/js/login/supersized-init.js"></script>
<div style="text-align:center;">
</div>
</body>
</html>