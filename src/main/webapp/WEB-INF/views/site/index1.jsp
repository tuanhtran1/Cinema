<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!doctype html>
<html>
<head>
	<!-- Required meta tags -->
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<title>Home</title>
	<base href="${pageContext.servletContext.contextPath }/" />
    <link rel="stylesheet" href="<c:url value='/resource/assets/css/style-starter.css' />" />
	<link href="//fonts.googleapis.com/css2?family=Open+Sans:ital,wght@0,300;0,400;0,600;0,700;1,600&display=swap"
		rel="stylesheet">
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
<div class="row" style="margin-left: 50px;margin-top: 100px;">
<div class="col-4" style="margin-top: 50px;">
<form:form action="site/movies1.htm" modelAttribute="suat_chieus"  method="post" > 
								  <div class="form-group">
   <label for="input-1">Ngay chieu</label> 
   <form:select path="ngay_chieu" 
						class="form-select" aria-label="Default select example" style="width: 200px;" >
						<c:forEach var="a" items="${suatchieus2 }">
                           <option value="${a[0]}"> 
                          ${a[0]}
                        </option>
         </c:forEach>
	     </form:select>
			</div>	
                 <div class="form-group"> 
                    <label for="input-1">Phim:${maphim }</label> 
                   <form:input type="text" style="display: none;" class="form-control" id="input-1"  path="phim.ma_phim"  value="${maphim }"/>
                 </div>	
                   <div class="form-group"> 
                    <label for="input-1">Khach Hang :${khach_hangs.ho_ten }</label> 
                 </div>	
                   <button  class="btn btn-success"  type="submit">Next</button>
                </form:form>
                </div>
                <div class="col-8">
                <div class="modal-dialog" role="document">
									<div class="modal-content" id="mymodalcontent">
										
										<div class="modal-body" id="dynamic-content">
											<img src="<c:url value='/resource/assets/images/m1.jpg'/>" class="img-fluid modalimg" alt="" />
											<p>
												<h3>Release Date&nbsp;:31 May 2019 </h3>
												<h3>Venue&nbsp;:Cg Road </h3>
											</p>
											<h4>About Movie</h4>
											<p>
												Rocketman is a 2019 biographical musical film based on the life of
												British musician Elton John. Directed by Dexter Fletcher and written by
												Lee Hall, it stars Taron Egerton as Elton John, with Jamie Bell as
												Bernie Taupin, Richard Madden as John Reid, and Bryce Dallas Howard as
												Sheila Eileen, John's mother. The film follows John in his early days in
												England as a prodigy at the Royal Academy of Music through his musical
												partnership with Taupin, and is titled after John's 1972 song "Rocket
												Man".
											</p>
											<h4>Star Cast</h4>
											<p>
												Taron Egerton as Elton John<br />
												Jamie Bell as Bernie Taupin<br />
												Richard Madden as John Reid<br />
												Bryce Dallas Howard as Sheila Dwight<br />
												Gemma Jones as Ivy, Elton's grandmother
											</p>
										</div>
										
									</div>
								</div>
								</div>
  </div>
    <div class="form-group">
								
	</div>

                 
</body>
</html>