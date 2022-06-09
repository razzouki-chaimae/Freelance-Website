<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head><meta charset="utf-8">
  
  <%@ include file="/VUE/Head.jsp" %>
  
  <!-- Template login -->
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="/freelanceProject/VUE/vendor/bootstrapLogin/css/bootstrap.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="/freelanceProject/VUE/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="/freelanceProject/VUE/vendor/animate/animate.css">
<!--===============================================================================================-->	
	<link rel="stylesheet" type="text/css" href="/freelanceProject/VUE/vendor/css-hamburgers/hamburgers.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="/freelanceProject/VUE/vendor/select2/select2.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="/freelanceProject/VUE/CSS/util.css">
	<link rel="stylesheet" type="text/css" href="/freelanceProject/VUE/CSS/styleLogin.css">
<!--===============================================================================================-->
<title>Se connecter</title>
</head>
<body>
  <!-- ======= Header ======= -->
  <%@ include file="/VUE/Header.jsp" %>
  
  <!-- ======= Login form ======= -->
  <div class="limiter">
		<div class="container-login100">
			<div class="wrap-login100">
				<div class="login100-pic js-tilt" data-tilt>
					<img src="/freelanceProject/VUE/img/Webp-net-resizeimage.png" alt="IMG">
				</div>

				<form class="login100-form validate-form" action="<%= request.getContextPath() %>/LoginServlet" method="POST">
					<span class="login100-form-title">
						Se connecter
					</span>

					<div class="wrap-input100 validate-input" data-validate = "Valid email is required: ex@abc.xyz">
						<input class="input100" type="text" name="email" pattern="[^@]+@[^@]+.[a-zA-Z]{2,6}" placeholder="example@email.com" required>
						<span class="focus-input100"></span>
						<span class="symbol-input100">
							<i class="fa fa-envelope" aria-hidden="true"></i>
						</span>
					</div>

					<div class="wrap-input100 validate-input" data-validate = "Password is required">
						<input class="input100" type="password" name="pass" placeholder="Password" required>
						<span class="focus-input100"></span>
						<span class="symbol-input100">
							<i class="fa fa-lock" aria-hidden="true"></i>
						</span>
					</div>
					
					<div class="container-login100-form-btn">
						<button class="login100-form-btn">
							Se connecter
						</button>
					</div>

					<div class="text-center p-t-136">
						<a class="txt2" href="/freelanceProject/VUE/index.jsp">
							Créer un compte
							<i class="fa fa-long-arrow-right m-l-5" aria-hidden="true"></i>
						</a>
					</div>
				</form>
			</div>
		</div>
	</div><!-- End Header -->

<!--===============================================================================================-->	
<script src="/freelanceProject/VUE/vendor/jquery/jquery-3.2.1.min.js"></script>
<!--===============================================================================================-->
	<script src="/freelanceProject/VUE/vendor/bootstrapLogin/js/popper.js"></script>
	<script src="/freelanceProject/VUE/vendor/bootstrapLogin/js/bootstrap.min.js"></script>
<!--===============================================================================================-->
	<script src="/freelanceProject/VUE/vendor/select2/select2.min.js"></script>
<!--===============================================================================================-->
	<script src="/freelanceProject/VUE/vendor/tilt/tilt.jquery.min.js"></script>
	<script >
		$('.js-tilt').tilt({
			scale: 1.1
		})
	</script>
<!--===============================================================================================-->
	<script src="/freelanceProject/VUE/js/mainLogin.js"></script>
	
	  <!-- ======= Footer ======= -->
	  <%@ include file="/VUE/Footer.jsp" %>
</body>
</html>