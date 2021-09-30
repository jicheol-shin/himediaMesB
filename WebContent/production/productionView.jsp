<%@page import="com.mes.vo.Production"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.mes.vo.Member"%>
<%@page import="com.mes.service.ProductionViewService"%>
<%@page import="com.mes.vo.ProductionView" %>
<%@page import="java.util.ArrayList" %>
<%@page import="com.mes.dao.ProductionViewDAO" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
	Member member = (Member) session.getAttribute("login_info");
    ArrayList<Production> productionViewList = (ArrayList<Production>) request.getAttribute("productionViewList");
    System.out.println(productionViewList);
%>
<c:set var="productionView_data" value="<%=productionViewList%>"/>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css" 
      	  integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ"
	  	  crossorigin="anonymous">  
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>	
	<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
	<style type="text/css">

		.logtext {                         /* 로그아웃, 관리자 글자크기 */
			font-size: 12px; 
			width:80px;
			color: #fff;
		} 
		ul {
		list-style-type: none;
		background-color: #ccc;
		width: 254px;
		padding: 0;
		margin:  0;
		}
		
		li {
			list-style-type: none;
		}
		
		li a {                             
			text-decoration: none;
			display: block;
			color: #000;
			padding: 8px 15px 8px 15px;
		}
				
		li a:hover {                      
			background-color: #e6ffff;
			color: #008080;
		}

		tbody {                           
			font-size: 15px
		}
		
	</style>
<title>Himedia MES_B</title>
</head>
<body>
<div class="container">
   <div class="bs-component">
   <br />
   <nav class="navbar navbar-expand-md font-weight-bold" style="background-color: #008080;">
	 <a class="navbar-brand" href="/index.do" style="color: #fff">Himedia MES</a>
	 <%@ include file="../main/menu.jsp" %>
	 
	 <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
    	 <span class="navbar-toggler-icon"></span>
 	 </button>
     <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1" >
    	<c:choose>
          <c:when test="<%=member == null %>" > 
    	    <a class="nav-link text-white" href="#" data-toggle="modal" data-target="#login">
        	  로그인
            </a>
          </c:when>  
  	    <c:otherwise>

	       <li ><a href="#" class="font-weight-bold logtext"><%=member.getUserName()%>님</a></li>  
	       <li ><a href="../logout.do" class="font-weight-bold logtext">로그아웃</a></li>

        </c:otherwise>
      </c:choose>	 
     </div>  
	</nav>
	</div>
	<br />
	
	<!-- 목록 보이기 -->
	<div class="container" align="center">
		<div align="left">
		 <ul class="list-group" >
            <li class="list-group-item list-group-item-primary" align="center">생산현황관리</li>
		</ul>
	  </div>
	  <br />
	  <table class="table table-striped table-condensed" style="font-size: 15px">
	  	<thead class="thead-dark" align="center" >
				<tr>
					<th>작업지시일자</th>
					<th>작업지시번호</th>
					<th>제품코드</th>
					<th>라인코드</th>
					<th>작업자</th>
					<th>생산지시수량</th>
					<th>생산완료수량</th>
					<th>생산진행율</th>
					<th>생산완료일</th>
				</tr>
				</thead>
					<tbody>
				<c:forEach var="production" items="${productionView_data}">
					<tr>
						<td>${production.getWorkOrderDate()}</td>
						<td>${production.getWorkOrderNo()}</td>
						<td>${production.getProductCd()}</td>
						<td>${production.getLineCd()}</td>
						<td>${production.getInUserId()}</td>
				    	<td align="center"><fmt:formatNumber value="${production.getWorkQty()}" pattern="#,###"/>
						<td align="center"><fmt:formatNumber value="${production.getProductionQty()}" pattern="#,###"/>
						<td align="center"><fmt:formatNumber value="${production.getProgress()}" pattern="#,###%"/>
						<td>${production.getEndDate()}</td>
				</tr>
				</c:forEach>
							
				</table>

	</div>
	<br />
	<br />
	<hr>
	<nav class="justify-content-center navbar navbar-expand-md" style="background-color: #008080;" >
    </nav> 
</div>
</body>
</html>