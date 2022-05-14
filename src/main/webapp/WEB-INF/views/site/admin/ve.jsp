
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html >
<head>
  <meta charset="utf-8" />
  <meta http-equiv="X-UA-Compatible" content="IE=edge" />
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
  <meta name="description" content="" />
  <meta name="author" content="" />
  <title>Admin web quan ly rap chieu phim</title>
   <base href="${pageContext.servletContext.contextPath }/" />
  <link href="<c:url value='/resource2/assets/css/pace.min.css' />" rel="stylesheet" />
  <script src="<c:url value='/resource2/assets/js/pace.min.js' />"></script>
  <link rel="stylesheet" href="<c:url value='/resource2/assets/plugins/summernote/dist/summernote-bs4.css' />"/>
  <link rel="icon" href="<c:url value='/resource2/assets/images/favicon.ico' />" type="image/x-icon">
  <link href="<c:url value='/resource2/assets/plugins/vectormap/jquery-jvectormap-2.0.2.css' />" rel="stylesheet" />
  <link href="<c:url value='/resource2/assets/plugins/simplebar/css/simplebar.css' />" rel="stylesheet" />
  <link href="<c:url value='/resource2/assets/css/bootstrap.min.css' />" rel="stylesheet" />
  <link href="<c:url value='/resource2/assets/css/animate.css' />" rel="stylesheet" type="text/css" />
  <link href="<c:url value='/resource2/assets/css/icons.css' />" rel="stylesheet" type="text/css" />
  <link href="<c:url value='/resource2/assets/css/sidebar-menu.css' />" rel="stylesheet" />
  <link href="<c:url value='/resource2/assets/css/app-style.css' />" rel="stylesheet" />
  

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
       
        <c:if test="${nhan_vienss.vai_tro.ma_vai_tro == 1 }" >
          <li>
            <a href="${pageContext.request.contextPath}/site/admin.htm">
            <i class="zmdi zmdi-account-box"></i> <span>Quản lí Admin</span>
            </a>
           </li>
            <li>
          <a href="${pageContext.request.contextPath}/site/user.htm">
            <i class="zmdi zmdi-accounts"></i> <span>Quản lí User</span>
          </a>
        </li>
               <li>
          <a href="${pageContext.request.contextPath}/site/phongchieu.htm">
            <i class="zmdi zmdi-widgets"></i> <span>Phong chieu</span>
          </a>
        </li>
         <li>
          <a href="${pageContext.request.contextPath}/site/ve.htm">
            <i class="zmdi zmdi-widgets"></i> <span>Ve</span>
          </a>
        </li>
        <li>
          <a href="${pageContext.request.contextPath}/site/suatchieu.htm">
            <i class="zmdi zmdi-widgets"></i> <span>Suat chieu</span>
          </a>
        </li>
        <li>
          <a href="${pageContext.request.contextPath}/site/phim.htm">
            <i class="zmdi zmdi-grid"></i> <span>Phim</span>
          </a>
        </li>
        </c:if>
        <c:if test="${nhan_vienss.vai_tro.ma_vai_tro == 2 }" >
        <li>
          <a href="${pageContext.request.contextPath}/site/phim.htm">
            <i class="zmdi zmdi-grid"></i> <span>Phim</span>
          </a>
        </li>
        </c:if>
        <c:if test="${nhan_vienss.vai_tro.ma_vai_tro == 3 }">
        
        <li>
          <a href="${pageContext.request.contextPath}/site/phongchieu.htm">
            <i class="zmdi zmdi-widgets"></i> <span>Phong chieu</span>
          </a>
        </li>
        </c:if>
        <c:if test="${nhan_vienss.vai_tro.ma_vai_tro == 5 }" >
        <li>
          <a href="${pageContext.request.contextPath}/site/suatchieu.htm">
            <i class="zmdi zmdi-widgets"></i> <span>Suat chieu</span>
          </a>
        </li>
        </c:if>
     <c:if test="${nhan_vienss.vai_tro.ma_vai_tro == 4 }">
         <li>
          <a href="${pageContext.request.contextPath}/site/ve.htm">
            <i class="zmdi zmdi-widgets"></i> <span>Ve</span>
          </a>
        </li>
        </c:if>
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
              <span class="user-profile"><img src="<c:url value='/resource2/assets/images/avatar-admin.png' />" class="img-circle"
                  alt="user avatar"></span>
            </a>
            <ul class="dropdown-menu dropdown-menu-right">
              <li class="dropdown-item user-details">
                <a href="javaScript:void();">
                  <div class="media">
                    <div class="avatar"><img class="align-self-start mr-3" src="<c:url value='/resource2/assets/images/avatar-admin.png' />"
                        alt="user avatar"></div>
                    <div class="media-body">
                      <h6 class="mt-2 user-title">TAH Homeware</h6>
                      
                               <b> Admin: ${nhan_vienss.ho_ten}</b> 
                               <h>Vai tro: ${nhan_vienss.vai_tro.vai_tro}</h>
                                        
                    </div>
                  </div>
                </a>
              </li>
            
              <li class="dropdown-divider"></li>
           
			 <li class="dropdown-item"><i class="icon-power mr-2"></i><a href="site/redirect1.htm"> Đăng xuất</a></li>		
            </ul>
          </li>
        </ul>
      </nav>
    </header>
    <div class="clearfix"></div>
 <div class="content-wrapper"> 
      <div class="container-fluid"> 
        <!--End Row--> 
 
 
        <div class="row"> 
          <div class="col-lg-12"> 
            <button class="add-catalog"><a href="site/insertve.htm">Thêm Ve</a></button> 
          </div> 
          <div class="col-lg-12"> 
            <div class="card"> 
              <div class="card-body"> 
                <h5 class="card-title">Danh sách ve</h5>
                ${message }
                <div class="table-responsive">              
                  <table class="table table-striped"> 
                  <form:form action="site/ve.htm" method="post" modelAttribute="ve">
                    <thead> 
                      <tr> 
                       
                        <th scope="col">Ma ve</th> 
                        <th scope="col">Ngay ban</th>
                        <th scope="col">Gia ve </th>
                      
                        <th scope="col">Suat chieu  </th>
                        <th scope="col">Ghe  </th>
                        <th scope="col">Khach hang  </th>
                                             
                     </tr> 
                    </thead> 
                    <tbody> 
                  <c:forEach items="${ves}" var="v"> 
                      <tr> 
                        <td scope="row">${v.ma_ve}</td> 
                        <td>${v.ngay_ban}</td> 
        				<td>${v.gia_ve}</td>
        				<td>${v.suat_chieu.gio_bat_dau_gio_ket_thuc}</td>
        				<td>${v.ghe.vi_tri_day }</td> 
        				<td>${v.khach_hang.ho_ten }</td>
        				 <td> 
        				 <button class="btn btn-danger"><a href="site/ve/${v.ma_ve }.htm?linkDelete">Delete</a></button>
                         
                           <button  class="btn btn-success"><a href="site/ve/${v.ma_ve }.htm?linkEdit">Update</a></button>
                        </td> 
                     </tr> 
                    </c:forEach> 
                    </tbody>
                    </form:form> 
                  </table> 
                </div> 
              </div> 
            </div> 
          </div> 
        </div> 
      </div> 
    </div> 
<a href="javaScript:void();" class="back-to-top"><i class="fa fa-angle-double-up"></i> </a>
<div class="right-sidebar">
    <div class="switcher-icon">
        <i class="zmdi zmdi-settings zmdi-hc-spin"></i>
    </div>
    <div class="right-sidebar-content">
        <p class="mb-0">Màu nền admin</p>
        <hr>
        <ul class="switcher">
            <li id="theme1"></li>
            <li id="theme2"></li>
            <li id="theme3"></li>
            <li id="theme4"></li>
            <li id="theme5"></li>
            <li id="theme6"></li>
        </ul>
        <p class="mb-0">Màu nền gradient</p>
        <hr>
        <ul class="switcher">
            <li id="theme7"></li>
            <li id="theme8"></li>
            <li id="theme9"></li>
            <li id="theme10"></li>
            <li id="theme11"></li>
            <li id="theme12"></li>
            <li id="theme13"></li>
            <li id="theme14"></li>
            <li id="theme15"></li>
        </ul>
    </div>
</div>
</div>
<a href="javaScript:void();" class="back-to-top"><i class="fa fa-angle-double-up"></i> </a>
    <div class="right-sidebar">
      <div class="switcher-icon">
        <i class="zmdi zmdi-settings zmdi-hc-spin"></i>
      </div>
      <div class="right-sidebar-content">
        <p class="mb-0">Màu nền admin</p>
        <hr>
        <ul class="switcher">
          <li id="theme1"></li>
          <li id="theme2"></li>
          <li id="theme3"></li>
          <li id="theme4"></li>
          <li id="theme5"></li>
          <li id="theme6"></li>
        </ul>
        <p class="mb-0">Màu nền gradient</p>
        <hr>
        <ul class="switcher">
          <li id="theme7"></li>
          <li id="theme8"></li>
          <li id="theme9"></li>
          <li id="theme10"></li>
          <li id="theme11"></li>
          <li id="theme12"></li>
          <li id="theme13"></li>
          <li id="theme14"></li>
          <li id="theme15"></li>
        </ul>
      </div>
    </div>
 
  
 <script src="<c:url value='/resource2/assets/js/jquery.min.js' />"></script>
  <script src="<c:url value='/resource2/assets/js/popper.min.js' />"></script>
  <script src="<c:url value='/resource2/assets/js/bootstrap.min.js' />"></script>
  <script src="<c:url value='/resource2/assets/plugins/simplebar/js/simplebar.js' />"></script>
  <script src="<c:url value='/resource2/assets/js/sidebar-menu.js' />"></script>
  <script src="<c:url value='/resource2/assets/js/jquery.loading-indicator.js' />"></script>
  <script src="<c:url value='/resource2/assets/js/app-script.js' />"></script>
  <script src="<c:url value='/resource2/assets/plugins/Chart.js/Chart.min.js' />"></script>
  <script src="<c:url value='/resource2/assets/js/index.js' />"></script>
  <script src="<c:url value='/resource2/assets/plugins/summernote/dist/summernote-bs4.min.js' />"></script>
</body>

</html>