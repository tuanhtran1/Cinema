<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Signin</title>
	<base href="${pageContext.servletContext.contextPath }/" />
	<link rel="stylesheet" type="text/css" href="<c:url value='/resource/fontawesome/css/all.min.css' />">
	<link rel="stylesheet" type="text/css" href="<c:url value='/resource/assets/css/style-starter.css' />">
	<link rel="stylesheet" type="text/css" href="<c:url value='/resource/assets/css/sign-in.css' />">
</head>

<body>
	<header id="site-header" class="w3l-header fixed-top">
		<!--/nav-->
		<nav class="navbar navbar-expand-lg navbar-light fill px-lg-0 py-0 px-3">
			<div class="container">
				<h1><a class="navbar-brand" href="index.html"><span class="fa fa-play icon-log"
							aria-hidden="true"></span>
							MyShowz </a></h1>
				<div class="collapse navbar-collapse" id="navbarSupportedContent">
				</div>
				<div class="Login_SignUp" id="login_s">
					<!-- style="font-size: 2rem ; display: inline-block; position: relative;" -->
					<!-- <li class="nav-item"> -->
					<a class="nav-link" href="sign_in.html"><i class="fa fa-user-circle-o"></i></a>
					<!-- </li> -->
				</div>
				<!-- toggle switch for light and dark theme -->
				<div class="mobile-position">
					<nav class="navigation">
						<div class="theme-switch-wrapper">
							<label class="theme-switch" for="checkbox">
								<input type="checkbox" id="checkbox">
								<div class="mode-container">
									<i class="gg-sun"></i>
									<i class="gg-moon"></i>
								</div>
							</label>
						</div>
					</nav>
				</div>
			</div>
		</nav>
	</header>

	<div class="container_signup_signin" id="container_signup_signin">
		<div class="form-container sign-up-container">
			<form:form name="sign-up-form" action="site/sign_up.htm" method="post"  modelAttribute="khach_hang">
				<h1>Create Account</h1>
				<div class="social-container">
					<a href="#" class="social"><i class="fab fa-facebook-f"></i></a>
					<a href="#" class="social"><i class="fab fa-google-plus-g"></i></a>
					<a href="#" class="social"><i class="fab fa-linkedin-in"></i></a>
				</div>
				<span>or use your email for registration</span>
				<form:input path="ho_ten"  placeholder="Name" />
				<form:input path="email"  placeholder="Email" />
			
				<form:input  path="mat_khau" placeholder="Password" />
				<div class="form-field-wrapper">
									<div style="color: green;">${message }</div>
								</div>
				<button  name="btnAdd">Sign Up</button>
			</form:form>
			
		</div>
		<div class="form-container sign-in-container">
			<form name="sign-in-form" style="color: var(--theme-title);" method="post"  action="site/sign_in.htm">
				<h1>Sign in</h1>
				<div class="social-container">
					<a href="#" class="social" style="color: var(--theme-title);"><i class="fab fa-facebook-f"></i></a>
					<a href="#" class="social" style="color: var(--theme-title);"><i
							class="fab fa-google-plus-g"></i></a>
					<a href="#" class="social" style="color: var(--theme-title);"><i class="fab fa-linkedin-in"></i></a>
				</div>
				<span>or use your account</span>
				<input name="ho_ten"  placeholder="Username" />
				<input name="mat_khau"  placeholder="Password" />
				<a href="site/forgotPassword.htm">Forgot your password?</a>
				<button type="submit">Sign In</button>
			</form>
		</div>
		<div class="overlay-container">
			<div class="overlay">
				<div class="overlay-panel overlay-left">
					<h1>Welcome Back!</h1>
					<p>To keep connected with us please login with your login details</p>
					<button class="ghost" id="signIn">Sign In</button>
				</div>
				<div class="overlay-panel overlay-right">
					<h1>Hello, Friend!</h1>
					<p>Register and book your tickets now!!!</p>
					<button class="ghost" id="signUp">Sign Up</button>
				</div>
			</div>
		</div>
	</div>
	<h1>ket qua</h1>
	<p>${message }</p>
	<script type="text/javascript" src="<c:url value='/resource/assets/js/as-alert-message.min.js' />"></script>
	<script src="<c:url value='/resource/assets/js/jquery-3.3.1.min.js' />"></script>
	<!--/theme-change-->
	<script src="<c:url value='/resource/assets/js/theme-change.js' />"></script>
	<!-- disable body scroll which navbar is in active -->
	<script>
		$(function () {
			$('.navbar-toggler').click(function () {
				$('body').toggleClass('noscroll');
			})
		});
	</script>
	<!-- disable body scroll which navbar is in active -->
	<!--/MENU-JS-->
	<script>
		$(window).on("scroll", function () {
			var scroll = $(window).scrollTop();

			if (scroll >= 80) {
				$("#site-header").addClass("nav-fixed");
			} else {
				$("#site-header").removeClass("nav-fixed");
			}
		});

		//Main navigation Active Class Add Remove
		$(".navbar-toggler").on("click", function () {
			$("header").toggleClass("active");
		});
		$(document).on("ready", function () {
			if ($(window).width() > 991) {
				$("header").removeClass("active");
			}
			$(window).on("resize", function () {
				if ($(window).width() > 991) {
					$("header").removeClass("active");
				}
			});
		});
	</script>
	<script src="<c:url value='/resource/assets/js/bootstrap.min.js' />"></script>

	<script type="text/javascript" src="<c:url value='/resource/assets/js/sign-in.js' />"></script>

</body>

</html>