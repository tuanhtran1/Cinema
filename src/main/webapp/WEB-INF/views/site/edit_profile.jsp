<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Contact Us page</title>
  <base href="${pageContext.servletContext.contextPath }/" />
  <link rel="stylesheet" type="text/css" href="<c:url value='/resource/assets/css/as-alert-message.min.css'/>">
  <link rel="stylesheet" type="text/css" href="<c:url value='/resource/assets/css/contact_us.css' />">
  <link rel="stylesheet" type="text/css" href="<c:url value='/resource/assets/css/style-starter.css' />">
</head>

<body>
  <header id="site-header" class="w3l-header fixed-top">
    <!--/nav-->
    <nav class="navbar navbar-expand-lg navbar-light fill px-lg-0 py-0 px-3">
      <div class="container">
        <h1><a class="navbar-brand" href="index.html"><span class="fa fa-play icon-log" aria-hidden="true"></span>
          MyShowz </a></h1>
        <!-- if logo is image enable this   
                    <a class="navbar-brand" href="#index.html">
                        <img src="image-path" alt="Your logo" title="Your logo" style="height:35px;" />
                    </a> -->
        <button class="navbar-toggler collapsed" type="button" data-toggle="collapse"
          data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false"
          aria-label="Toggle navigation">
          <!-- <span class="navbar-toggler-icon"></span> -->
          <span class="fa icon-expand fa-bars"></span>
          <span class="fa icon-close fa-times"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
          <ul class="navbar-nav ml-auto">
            <li class="nav-item">
              <a class="nav-link" href="site/index.htm">Home</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="site/movies.htm">Movies</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="site/about.htm">About</a>
            </li>

            <li class="nav-item active">
              <a class="nav-link" href="site/contact_us.htm">Contact</a>
            </li>
          </ul>

          <!--/search-right-->
          <!--/search-right-->

          <div class="Login_SignUp" id="login" style="font-size: 2rem ; display: inline-block; position: relative;">
            <!-- <li class="nav-item"> -->
            <a class="nav-link" href="sign_in.html"><i class="fa fa-user-circle-o"></i></a>
            <!-- </li> -->
          </div>
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
  <!-- Contact Us Form -->
  <div class="container">
         <div class="row">
   <div class="card">
       <div class="card-header">
           Thông tin sinh viên 
           <p>${p.ho_ten }</p>
       </div>
       <div class="card-body">
          <div class="row">
              <li>
				<strong class="dark-color">Ho ten:</strong>${khach_hangs.ho_ten}
				</li>
              <li>
				<strong class="dark-color">So cmnd:</strong>${khach_hangs.so_cmnd}
				</li>
				<li>
				<strong class="dark-color">So dien thoai:</strong>${khach_hangs.so_dien_thoai}
				</li>
				<li>
				<strong class="dark-color">Email :</strong>${khach_hangs.email}
				</li>
				<li>
				<strong class="dark-color">Dia chi:</strong>${khach_hangs.dia_chi}
				</li>
				<li>
				<strong class="dark-color">Ngay sinh:</strong>${khach_hangs.ngay_sinh}
				</li>
				<li>
				<strong class="dark-color">Gioi tinh:</strong>${khach_hangs.gioi_tinh}
				</li>
          </div> 
         
       <div class="card-footer text-muted">
       </div>
   </div>
</div>
<div class="row">
 
<form:form class="row g-3" modelAttribute="khach_hangs" method="post"
				action="site/edit_profile.htm">
                <div class="col-md-4">
					<label for="exampleFormControlInput1" class="form-label">Ma kh
						</label>
					<form:input path="ma_kh" class="form-control"
						id="exampleFormControlInput1"
						 />
				</div>
				<div class="col-md-4">
					<label for="exampleFormControlInput1" class="form-label">Ho ten
						</label>
					<form:input path="ho_ten" class="form-control"
						id="exampleFormControlInput1"
						placeholder="Vui long nhap ho ten" />
				</div>
				<div class="col-md-4">
					<label for="exampleFormControlInput1" class="form-label">So cmnd
						</label>
					<form:input path="so_cmnd" class="form-control"
						id="exampleFormControlInput1"
						placeholder="Vui long nhap so cmnd" />
				</div>
				<div class="col-md-4">
					<label for="exampleFormControlInput1" class="form-label">So dien thoai</label>
					<form:input path="so_dien_thoai"  class="form-control"
						id="exampleFormControlInput1"
						placeholder="Vui long nhap so dien thoai" />
				</div>
                <div class="col-md-4">
					<label for="exampleFormControlInput1" class="form-label">Email</label>
					<form:input path="email"  class="form-control"
						id="exampleFormControlInput1"
						placeholder="Vui long nhap email" />
				</div>
			   <div class="col-md-4">
					<label for="exampleFormControlInput1" class="form-label">Dia chi</label>
					<form:input path="dia_chi"  class="form-control"
						id="exampleFormControlInput1"
						placeholder="Vui long nhap dia chi" />
				</div>
			<div class="col-md-4">
					<label for="exampleFormControlInput1" class="form-label">Gioi tinh</label>
					<form:input path="gioi_tinh" class="form-control"
						id="exampleFormControlInput1"
						placeholder="Vui long nhap gioi tinh" />
				</div>
				<div class="col-md-4">
					<label for="exampleFormControlInput1" class="form-label">Ngay sinh</label>
					<form:input path="ngay_sinh" class="form-control"
						id="exampleFormControlInput1"
						placeholder="Vui long nhap ngay sinh" />
				</div>
				<div class="col-md-4">
				      <label>Confirm Password</label>
			       <form:input path="mat_khau" class="input-sm form-full" type="hidden" />
			       <input name="passwordInput" class="input-sm form-full" type="password" value="" >
				</div>
				<div class="col-12 mt-4">
					<button name="btnEdit" type="submit" class="btn btn-primary">Save</button>
				</div>
</form:form>
  <div class="col mt-4">
	<a href="site/changePassword.htm"><button name="changePassword" type="submit" class="btn btn-primary">Change password</button></a>
  </div>
   <div class="col mt-4">
	<a href="site/forgotPassword.htm"><button name="forgotPassword" type="submit" class="btn btn-primary">Forgot password</button></a>
  </div>
</div>
<div>
<p>${message }</p>
</div>
  </div>
  </div>
  <script type="text/javascript" src="<c:url value='/resource/assets/js/contact-us.js' />"></script>
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
</body>
</html>