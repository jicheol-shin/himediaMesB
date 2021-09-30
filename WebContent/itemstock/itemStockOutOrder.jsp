<%@page import="com.mes.vo.Production"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.mes.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
   Member member = (Member) session.getAttribute("login_info");
   ArrayList<Production> itemStockOutOrderList = (ArrayList<Production>) request.getAttribute("itemStockOutOrderList");
%>
<c:set var="itemStockOut_data" value="<%=itemStockOutOrderList%>"/>
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
    .logtext {                         
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
		background-color: tomato;
		color: #fff;
	}
</style>
<title>Himedia MES_B</title>
</head>
<body>
<h1></h1>
<div class="container">
   <div class="bs-component">
   <br />
    <nav class="navbar navbar-expand-md font-weight-bold" style="background-color: #008080;">
	 <a class="navbar-brand" href="/index.do" style="color: #fff">Himedia MES</a>
      <%@ include file="../main/menu.jsp"%>
     <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
    	 <span class="navbar-toggler-icon"></span>
 	 </button>
     <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1" >
    	<c:choose>
          <c:when test="<%=member == null %>" > 
    	    <a class="nav-link text-white" href="index.do" data-toggle="modal" data-target="#login">
        	  로그인
            </a>
          </c:when>  
  	    <c:otherwise>
	       <li ><a href="#" class='text-white logtext'><%=member.getUserName()%>님</a></li>  
	       <li ><a href="../logout.do" class="font-weight-bold logtext">로그아웃</a></li>
        </c:otherwise>
      </c:choose>	 
     </div>  
	</nav>
	</div>
	<br />
	<div class="container" align="center" style="height: 500px">
	   <div align="left">
		 <ul class="list-group" >
            <li class="list-group-item list-group-item-primary" align="center">자재 불출 처리</li>
		</ul>
		</div>
		<br />
		<table class="table table-striped table-condensed" style="font-size: 15px">
		 <thead class="thead-dark">
			<tr>
				<th>작업지시일</th>
				<th>작업지시번호</th>
				<th>제품코드</th>
				<th>LILE NO</th>
				<th>생산수량</th>				
				<th>자재불출</th>	
			</tr>
			</thead>

			<c:forEach var="itemStockOutOrder" items="${itemStockOut_data}">
			<tr>
				<td>${itemStockOutOrder.getWorkOrderDate()}</td>
				<td>${itemStockOutOrder.getWorkOrderNo()}</td>
				<td>${itemStockOutOrder.getProductCd()}</td>
				<td>${itemStockOutOrder.getLineNo()}</td>
				<td align="center"><fmt:formatNumber value="${itemStockOutOrder.getWorkQty()}" pattern="#,###"/>
				<td><a href="itemstockOut.do?workOrderNo=${itemStockOutOrder.getWorkOrderNo()}"> <button type="button" class="btn btn-primary link-hover-color" >자재불출하기</button></a></td>
			</tr>
			</c:forEach>
		</table>
	</div>	
	<br /><br />
	<hr />
  	<nav class="justify-content-center navbar navbar-expand-md" style="background-color: #008080;" >
    </nav>  
</div>
</body>
</html>