<%@page import="com.mes.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
   Member member = (Member) session.getAttribute("login_info");
%>
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
    .logtext { font-size: 10px; width:70px;}
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
   <nav class="navbar navbar-expand-md bg-secondary navbar-dark text-light">
	 <a class="navbar-brand" href="/index.do">Himedia MES</a>
      <%@ include file="../main/menu.jsp"%>
     <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1" >
    	<c:choose>
          <c:when test="<%=member == null %>" > 
    	    <a class="nav-link text-white" href="index.do" data-toggle="modal" data-target="#login">
        	  로그인
            </a>
          </c:when>  
  	    <c:otherwise>
	       <li ><a href="#" class='text-white logtext'><%=member.getUserName()%>님</a></li>  
	       <li ><a href="/logout.do" class='text-info logtext'>로그아웃</a></li>
        </c:otherwise>
      </c:choose>	 
     </div>  
	</nav>
	</div>
	<br />
	<div class="container" align="center" style="height: 500px">
	   <div align="left">
		 <ul class="list-group" >
            <li class="list-group-item list-group-item-primary" align="center">자재 불출</li>
		</ul>
		</div>
		<br />
		 <div class="container" align="right">
	         <form action="" method="post">
	             <span role="status" aria-live="polite" class="ui-helper-hidden-accessible"></span>
	             제품코드   : <input type="text" role="searchbox" class="InputBox " autocomplete="off">
	             작업지시일 : <input type="text" role="searchbox" class="InputBox " autocomplete="off">~<input type="text" role="searchbox" class="InputBox " autocomplete="off">
	             <button type="submit">조회</button>
	         </form>
	     </div>
	     <br />
		<table class="table table-striped table-condensed" style="font-size: 12px">
		 <thead class="thead-dark">
			<tr>
				<th>순번</th>
				<th>작업지시일</th>
				<th>자재불출일</th>
				<th>작업지시번호</th>
				<th>제품코드</th>
				<th>제품명</th>
				<th>LILE NO</th>
				<th>생산수량</th>				
				<th>불출여부</th>				
				<th>비고</th>				
			</tr>
			</thead>

			<c:forEach var="itemStockOutOrder" items="${itemStockOutOrderList}">
			<tr>
				<td>${itemStockOutOrder.getNum()}</td>
				<td>${itemStockOutOrder.getWorkOrderDate()}</td>
				<td>${itemStockOutOrder.getItemStockOutDate()}</td>
				<td>${itemStockOutOrder.getWorkOrderNo()}</td>
				<td>${itemStockOutOrder.getProductCd()}</td>
				<td>${itemStockOutOrder.getProductName()}</td>
				<td>${itemStockOutOrder.getLineNo()}</td>
				<td>${itemStockOutOrder.getWorkQty()}</td>
				<td>${itemStockOutOrder.getIssue()}</td>
				<td>${itemStockOutOrder.getRemark()}</td>
			</tr>
			</c:forEach>
		</table>
	</div>	
	<br /><br />
    <nav class="navbar navbar-expand-md bg-secondary navbar-dark  text-light">
    </nav>  
</div>
</body>
</html>