<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html >
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link href="<c:url value='/resource2/style.css' />" rel="stylesheet" type="text/css"  />
    <title>Movie Seat Booking</title>
    <base href="${pageContext.servletContext.contextPath }/" />
    <style type="text/css">
    .seat.sold {
     background-color: red;
     }
     .seat {
  background-color: #fff;
  height: 26px;
  width: 32px;
  margin: 3px;
  font-size: 50px;
  border-top-left-radius: 10px;
  border-top-right-radius: 10px;
}
}
    </style>
  </head>
  <body>
    <div class="movie-container">
      <label> Select a movie:</label>
      <select id="movie">
        <option value="220">Godzilla vs Kong (RS.220)</option>
        <option value="320">Radhe (RS.320)</option>
        <option value="250">RRR (RS.250)</option>
        <option value="260">F9 (RS.260)</option>
      </select>
    </div>

    <ul class="showcase">
      <li>
        <div class="seat"></div>
        <small>Available</small>
      </li>
      <li>
        <img src="<c:url value='/resource2/anh.png' />" alt="" />
        <small>Selected</small>
      </li>
      <li>
        <div class="seat sold"></div>
        <small>Sold</small>
      </li>
    </ul>
    <div class="container">
      <div class="screen"></div>
        <form:form action="site/movies2.htm" modelAttribute="ghe"  method="post" >   
               
                 
                 <!--  <div class="row" style="margin-left: 12px;">
                 <c:forEach var="a"  items="${suatchieus5}">
                 <c:choose>
                   <c:when test="${a.vi_tri_trong ==1 }">
                      <div class="seat"></div>  
                     </c:when>    
                    <c:otherwise>
                        <div class="seat sold"></div>   
                      </c:otherwise>
                     </c:choose>
                      
                    </c:forEach>
             </div>-->                                     
             <div class="row" style="margin-left: 12px; ">      
               <c:forEach var="a"  items="${suatchieus5}">
                 <c:choose>
                   <c:when test="${a.vi_tri_trong ==1 }">
                     
                   <form:checkbox  path="ma_ghe" value="${a.ma_ghe }" class="seat"  />
                   <label>${a.vi_tri_day }</label>
                     </c:when>    
                    <c:otherwise>
                    <div class="seat sold"></div>
                    <form:checkbox  path="ma_ghe" value="${a.ma_ghe }" class="seat" style="display: none;" />
                    <label>${a.vi_tri_day }</label>
                      </c:otherwise>
                     </c:choose>
                    </c:forEach>
                    </div>
                    
                 <!--   <form:checkboxes items="${ghes1}" 
                 path="ma_ghe" itemLabel="vi_tri_day" itemValue="ma_ghe" class="seat"  /> -->

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
      <div class="row">
        <div class="seat"></div>
        <div class="seat"></div>
        <div class="seat"></div>
        <div class="seat"></div>
        <div class="seat"></div>
        <div class="seat"></div>
        <div class="seat"></div>
        <div class="seat"></div>
      </div>

      <div class="row">
        <div class="seat"></div>
        <div class="seat"></div>
        <div class="seat"></div>
        <div class="seat sold"></div>
        <div class="seat sold"></div>
        <div class="seat"></div>
        <div class="seat"></div>
        <div class="seat"></div>
      </div>
      <div class="row">
        <div class="seat"></div>
        <div class="seat"></div>
        <div class="seat"></div>
        <div class="seat"></div>
        <div class="seat"></div>
        <div class="seat"></div>
        <div class="seat sold"></div>
        <div class="seat sold"></div>
      </div>
      <div class="row">
        <div class="seat"></div>
        <div class="seat"></div>
        <div class="seat"></div>
        <div class="seat"></div>
        <div class="seat"></div>
        <div class="seat"></div>
        <div class="seat"></div>
        <div class="seat"></div>
      </div>
      <div class="row">
        <div class="seat"></div>
        <div class="seat"></div>
        <div class="seat"></div>
        <div class="seat sold"></div>
        <div class="seat sold"></div>
        <div class="seat"></div>
        <div class="seat"></div>
        <div class="seat"></div>
      </div>
      <div class="row">
        <div class="seat"></div>
        <div class="seat"></div>
        <div class="seat"></div>
        <div class="seat"></div>
        <div class="seat sold"></div>
        <div class="seat sold"></div>
        <div class="seat sold"></div>
        <div class="seat"></div>
      </div>
    </div>

    <p class="text">
      You have selected <span id="count">0</span> seat for a price of RS.<span
        id="total"
        >0</span
      >
    </p>
    <script src="<c:url value='/resource2/script.js' />"></script>
  </body>
</html>
    