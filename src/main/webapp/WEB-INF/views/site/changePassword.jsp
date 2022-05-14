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
  <section class="row-1">
             <div class="col mt-4">
            <ul class="nav nav-tabs" id="myTab" role="tablist">
                <li class="nav-item" role="presentation">
                  <a class="nav-link active" id="videoEditing-tab" data-toggle="tab" href="#videoEditing" role="tab" aria-controls="videoEditing" aria-selected="true">User editing</a>
                </li>
              </ul>
              <div class="tab-content" id="myTabContent">
                <div class="tab-pane fade show active" id="videoEditing" role="tabpanel" aria-labelledby="videoEditing-tab">
                   <form action=""  method="post">
                      <div class="card">
                          <div class="card-header">
                              Change password
                          </div>
                          <div class="card-body">
                              <div class="row">
                                  <div class="col">
                                      <div class="form-group">
                                        <label for="username">Username</label>
                                        <input type="text" class="form-control" name="username" id="username" aria-describedby="usernameHid" placeholder="Username">
                                      </div>
                                      <div class="form-group">
                                        <label for="password">New Password</label>
                                        <input type="password" class="form-control" name="password1" id="password1" placeholder="Password">
                                      </div>
                                  </div>
                                  <div class="col">
                                      <div class="form-group">
                                        <label for="currentPassword">Current Password</label>
                                        <input type="password" class="form-control" name="current" id="currentPassword" placeholder="Current Password">
                                      </div>
                                      <form:form action="site/changePassword.htm" method="post" modelAttribute="khach_hangs"  >
                                      <div class="form-group">
                                        <label for="confirmPassword">Confirm Password</label>
                                        <form:input  class="form-control" path="mat_khau"  placeholder="ConfirmPassword"/>
                                      </div>
                                  </div>
                              </div>
                          </div>
                          <div style="color: green;">${messagep }</div>
                           <div class="card-footer text-muted">
                              <button class="btn btn-success" type="submit" name="btnChange">Change Password</button>
                          </div>
                          </form:form>
                      </div>
                  </form>
       
                </div>
              </div>
            </div>
           </section>
			
 



<div>
<p>${messageP }</p>
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