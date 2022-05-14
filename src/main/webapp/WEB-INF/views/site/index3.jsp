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

         <form:form action="site/movies2.htm" modelAttribute="ghe"  method="post" >   
               
                 <div class="form-group"> 
                    <label for="input-1"> ghe</label> 
                    <form:select path="ma_ghe" items="${suatchieus5}"
						itemLabel="vi_tri_day" itemValue="ma_ghe" 
						class="form-select form-select-lg mb-6"
						aria-label=".form-select-lg example">
					</form:select> 
                 </div>
                 <div class="row" style="margin-left: 12px;">
                   <c:forEach var="a" items="${suatchieus5}">           
                     
                     
                     <c:choose>
    <c:when test="${a.vi_tri_trong ==1 }">
                  <div class="seat">1</div>
                   
               </c:when>    
                <c:otherwise>
                        <div class="seat">0</div>   
                </c:otherwise>
                     </c:choose>
                      
                    </c:forEach>
                 </div>
                 
                 <div class="form-group"> 
                    <label for="input-1">Suat chieu:${suatchieus6.ma_sc}</label>          
                 </div>	
               <div class="form-group"> 
                    <label for="input-1">Phim:${maphim }</label> 
                   
                 </div>
                 <div class="form-group"> 
                    <label for="input-1">Ngay chieu:${ngaychieu }</label> 
                   
                 </div>	
                   <div class="form-group"> 
                    <label for="input-1">Khach Hang :${khach_hangs.ho_ten }</label> 
                 </div>		
                   <button  class="btn btn-success"  type="submit">Next</button>
                </form:form>
                 
</body>
</html>