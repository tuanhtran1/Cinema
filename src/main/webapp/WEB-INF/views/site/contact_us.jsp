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
    <h4>Contact Us</h4>
    <h3>Leave a Message</h3>
    <p>If you have a question regarding our services,
      feel free to contact us using the form below.</p>

    <form:form name="contact-us-form"  modelAttribute="contact" action="site/contact_us.htm">
      <div class="row100" id="fname-row100">
        <div class="col">
        <span class="text">First Name</span>
          <div class="inputBox" id="fname-inputBox">
            <form:input  path="fname" />
            <span class="line" id="fname-line"></span>
          </div>
        </div>
        <div class="col">
        <span class="text">Last Name</span>
          <div class="inputBox" id="lname-inputBox">
            <form:input path="lname" />
            <span class="line" id="lname-line"></span>
          </div>
        </div>
      </div>
      <div class="row100" id="email-row100">
        <div class="col">
        <span class="text">Email ID</span>
          <div class="inputBox" id="email-inputBox">
            <form:input  path="email"  />
            <span class="line" id="email-line"></span>
          </div>
        </div>
        <div class="col">
        <span class="text">Mobile Number</span>
          <div class="inputBox" id="tel-inputBox">
            <form:input  path="so_dt"  />
            <span class="line" id="tel-line"></span>
          </div>
        </div>
      </div>
      <div class="row100">
        <div class="col">
        <span class="text">Type your message Here...</span>
          <div class="inputBox textarea">
            <form:textarea path="message"></form:textarea>
            <span class="line"></span>
          </div>
        </div>
      </div>
      <div class="row100">
        <div class="col">
          <div class="submitbutton">
            <button class="btn submitbtn"  name="${btnStatus }">Submit</button>
          </div>
        </div>
      </div>
    </form:form>
    <p>${message }</p>
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