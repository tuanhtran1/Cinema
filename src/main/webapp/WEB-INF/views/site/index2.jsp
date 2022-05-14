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

     <form:form action="site/insertve1.htm" modelAttribute="ve1"  method="post" > 	
                 <div class="form-group"> 
                    <label for="input-1">Gia ve</label> 
                    <form:input type="text" class="form-control" id="input-1" placeholder="Ngay chieu" path="gia_ve"/> 
                 </div>
                 <div class="form-group"> 
                    <label for="input-1">Ghe:${maghe }</label> 
                    <form:input type="text"  class="form-control" id="input-1" placeholder="suat chieu" path="ghe.ma_ghe"  value="${maghe }"/>
                    
                 </div>	
                 <div class="form-group"> 
                    <label for="input-1">Ma Suat chieu:${suatchieus6.ma_sc} </label> 
                    <form:input type="text" style="display: none;" class="form-control" id="input-1" placeholder="suat chieu" path="suat_chieu.ma_sc"  value="${suatchieus6.ma_sc}"/> 
                 </div>	
                  <div class="form-group"> 
                    <label for="input-1">Khach Hang :${khach_hangs.ho_ten }</label>
                     <form:input type="text" style="display: none;" class="form-control" id="input-1"  path="khach_hang.ma_kh"  value="${khach_hangs.ma_kh }"/> 
                 </div> 
                                 		
                  <div class="form-footer"> 
					  
                    <button type="submit"  class="btn btn-success"> Them</button>
                </div>  
                </form:form>
                <p>${message }</p>
</body>
</html>