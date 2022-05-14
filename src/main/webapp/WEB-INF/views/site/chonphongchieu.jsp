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

         <form:form action="site/movies4.htm" modelAttribute="suat_chieus"  method="post" > 
   <div class="form-group">
   <label for="input-1">Phong chieu</label> 
   <form:select path="phong_chieu.ma_pc" 
						class="form-select" aria-label="Default select example" style="width: 200px;" >
						<c:forEach var="a" items="${suatchieus4 }">
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
                    <label for="input-1">Ca chieu:${cachieu }</label> 
                   <form:input type="text" style="display: none;" class="form-control" id="input-1"  path="gio_bat_dau_gio_ket_thuc"  value="${cachieu }"/>
                 </div>
                 <div class="form-group"> 
                    <label for="input-1">Ngay chieu:${ngaychieu }</label> 
                   <form:input type="text" style="display: none;" class="form-control" id="input-1"  path="ngay_chieu"  value="${ngaychieu }"/>
                 </div>	
                   <div class="form-group"> 
                    <label for="input-1">Khach Hang :${khach_hangs.ho_ten }</label> 
                 </div>	
                   <button  class="btn btn-success"  type="submit">Next</button>
                </form:form>
                 
</body>
</html>