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

	       <li ><a href="#" class='text-white'><%=member.getUserName()%>님</a></li>  
	       <li ><a href="/logout.do" class='text-info'>로그아웃</a></li>

        </c:otherwise>
      </c:choose>	 
     </div>  
	</nav>
	</div>
	<br />
	<div class="container" align="center" style="height: 500px">
	   <div align="left">
		 <ul class="list-group" >
            <li class="list-group-item list-group-item-primary" align="center">자재 입출고 현황</li>
		</ul>
		</div>
		<br />
		<table class="table table-striped table-condensed" style="font-size: 12px">
		 <thead class="thead-dark">
			<tr>
				<th>순번</th>
				<th>입출고 코드</th>
				<th>부품코드</th>
				<th>부품명</th>
				<th>입출고시간</th>
				<th>입출고유형</th>				
				<th>창고명</th>				
				<th>구역명</th>				
				<th>이동창고</th>				
				<th>수량</th>
				<th>수량</th>
				<th>납품처</th>
				<th>비고</th>				
			</tr>
			</thead>

			<c:forEach var="itemStock" items="${itemStockList}">
			<tr>
				<td>${itemStock.getNum()}</td>
				<td>${itemStock.getItemInoutCd()}</td>
				<td>${itemStock.getItemCd()}</td>
				<td>${itemStock.getItemName()}</td>
				<td>${itemStock.getIntoutDate()}</td>
				<td>${itemStock.getInoutType()}</td>
				<td>${itemStock.getStoreCd()}</td>
				<td>${itemStock.getLocalCd()}</td>
				<td>${itemStock.getInoutPlant()}</td>
				<td>${itemStock.getItemCnt()}</td>
				<td>${itemStock.getVendorName()}</td>
				<td>${itemStock.getRemark()}</td>
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