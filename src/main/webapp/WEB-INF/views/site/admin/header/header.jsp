<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8" />
  <meta http-equiv="X-UA-Compatible" content="IE=edge" />
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
  <meta name="description" content="" />
  <meta name="author" content="" />
  <title>Admin web bán đồ gia dụng</title>
  <link href="<c:url value='/WEB-INF/views/site/admin/assets/css/pace.min.css' />" rel="stylesheet" />
  <script src="<c:url value='/WEB-INF/views/site/admin/assets/js/pace.min.js' />"></script>
  <link rel="stylesheet" href="<c:url value='/WEB-INF/views/site/admin/assets/plugins/summernote/dist/summernote-bs4.css' />"/>
  <link rel="icon" href="<c:url value='/WEB-INF/views/site/admin/assets/images/favicon.ico' />" type="image/x-icon">
  <link href="<c:url value='/WEB-INF/views/site/admin/assets/plugins/vectormap/jquery-jvectormap-2.0.2.css' />" rel="stylesheet" />
  <link href="<c:url value='/WEB-INF/views/site/admin/assets/plugins/simplebar/css/simplebar.css' />" rel="stylesheet" />
  <link href="<c:url value='/WEB-INF/views/site/admin/assets/css/bootstrap.min.css' />" rel="stylesheet" />
  <link href="<c:url value='/WEB-INF/views/site/admin/assets/css/animate.css' />" rel="stylesheet" type="text/css" />
  <link href="<c:url value='/WEB-INF/views/site/admin/assets/css/icons.css' />" rel="stylesheet" type="text/css" />
  <link href="<c:url value='/WEB-INF/views/site/admin/assets/css/sidebar-menu.css' />" rel="stylesheet" />
  <link href="<c:url value='/WEB-INF/views/site/admin/assets/css/app-style.css' />" rel="stylesheet" />
  

</head>

<body class="bg-theme bg-theme1">


  <!-- start loader -->
  <div id="pageloader-overlay" class="visible incoming">
    <div class="loader-wrapper-outer">
      <div class="loader-wrapper-inner">
        <div class="loader"></div>
      </div>
    </div>
  </div>
  
 <div id="wrapper">

  <div id="sidebar-wrapper" data-simplebar="" data-simplebar-auto-hide="true">
      <div class="brand-logo">
        <a href="${pageContext.request.contextPath}/admin/homepage">
          <img src="<c:url value='/WEB-INF/views/site/admin/assets/images/logo-icon.png' />" class="logo-icon" alt="logo icon">
          <h5 class="logo-text">Admin Web Homeware</h5>
        </a>
      </div>
      <ul class="sidebar-menu do-nicescrol">
        <li class="sidebar-header">MENU ADMIN</li>
        <li>
          <a href="${pageContext.request.contextPath}/admin/homepage">
            <i class="zmdi zmdi-view-dashboard"></i> <span>Tổng quan</span>
          </a>
        </li>
        
         <li>
          <a href="${pageContext.request.contextPath}/admin/admin/list">
            <i class="zmdi zmdi-account-box"></i> <span>Quản lí Admin</span>
          </a>
        </li>
        <li>
          <a href="${pageContext.request.contextPath}/admin/user/list">
            <i class="zmdi zmdi-accounts"></i> <span>Quản lí User</span>
          </a>
        </li>
        <li>
          <a href="${pageContext.request.contextPath}/admin/cate/list">
            <i class="zmdi zmdi-grid"></i> <span>Chuyên Mục</span>
          </a>
        </li>
        <li>
          <a href="${pageContext.request.contextPath}/admin/product/list">
            <i class="zmdi zmdi-widgets"></i> <span>Danh Sách Sản Phẩm</span>
          </a>
        </li>
        <li>
          <a href="${pageContext.request.contextPath}/admin/order/list">
            <i class="zmdi zmdi-shopping-cart"></i> <span>Đơn Hàng</span>
          </a>
        </li>
        
        <li>
          <a href="${pageContext.request.contextPath}/admin/order/list-detail">
            <i class="zmdi zmdi-shopping-cart"></i> <span>Chi Tiết Đơn Hàng</span>
          </a>
        </li>
        <li>
          <a href="${pageContext.request.contextPath}/admin/review/list">
            <i class="zmdi zmdi-calendar-check"></i> <span>Review</span>
          </a>   
        </li>
        <li>
          <a href="${pageContext.request.contextPath}/admin/new/list">
            <i class="icon-envelope-open"></i> <span>Tin tức</span>
          </a>
        </li>
      </ul>
    </div>
    <header class="topbar-nav">
      <nav class="navbar navbar-expand fixed-top">
        <ul class="navbar-nav mr-auto align-items-center">
          <li class="nav-item">
            <a class="nav-link toggle-menu" href="javascript:void();">
              <i class="icon-menu menu-icon"></i>
            </a>
          </li>
        </ul>
		
        <ul class="navbar-nav align-items-center right-nav-link">
          <li class="nav-item">
            <a class="nav-link dropdown-toggle dropdown-toggle-nocaret" data-toggle="dropdown" href="#">
              <span class="user-profile"><img src="${pageContext.request.contextPath}/view/admin/assets/images/avatar-admin.png" class="img-circle"
                  alt="user avatar"></span>
            </a>
            <ul class="dropdown-menu dropdown-menu-right">
              <li class="dropdown-item user-details">
                <a href="javaScript:void();">
                  <div class="media">
                    <div class="avatar"><img class="align-self-start mr-3" src="${pageContext.request.contextPath}/view/admin/assets/images/avatar-admin.png"
                        alt="user avatar"></div>
                    <div class="media-body">
                      <h6 class="mt-2 user-title">TAH Homeware</h6>
                	<b> Admin:  <%=session.getAttribute("admin-username") %></b>                         
                    </div>
                  </div>
                </a>
              </li>
            
              <li class="dropdown-divider"></li>
			 <li class="dropdown-item"><i class="icon-power mr-2"></i><a href="${pageContext.request.contextPath}/admin/logout"> Đăng xuất</a></li>		
            </ul>
          </li>
        </ul>
      </nav>
    </header>
    <div class="clearfix"></div>