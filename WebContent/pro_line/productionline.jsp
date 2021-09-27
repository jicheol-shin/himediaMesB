<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.mes.vo.Member"%>
<%@page import="com.mes.service.ProductionLineService"%>
<%@page import="com.mes.vo.ProductionLine" %>
<%@page import="java.util.ArrayList" %>
<%@page import="com.mes.dao.ProductionLineDAO" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	Member member = (Member) session.getAttribute("login_info");
	ProductionLineService productionLinedata = new ProductionLineService();
	ArrayList<ProductionLine> productionLineList = productionLinedata.getProductionLineList();
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
<title>Production Line</title>
</head>
<body>
<!-- 로그인바 -->
<div class="bs-component">
<br />
<nav class="navbar navbar-expand-md bg-secondary navbar-dark text-light">
	<a href="/index.do" class="navbar-brand">HIMIDIA MES</a>
	<%@ include file="../main/menu.jsp"%>
	<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
		<span class="navbar-toggler-icon"></span>
	</button>
	<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
		<c:choose>
			<c:when test="<%= member == null %>">
				<a href="#" class="nav-link text-white" data-toggle="modal" data-target="#login">
				로그인
				</a>
			</c:when>
			<c:otherwise>
				<li><a href="#" class="text-white"><%= member.getUserName() %>님</a></li>
				<li><a href="/logout.do" class="text-info">로그아웃</a></li>
			</c:otherwise>
		</c:choose>
	</div>
	</nav>
</div>
<br />
<!-- 제목  -->
	<div class="container" align="center" style="height: 500px">
	   <div align="left">
		 <ul class="list-group" >
            <li class="list-group-item list-group-item-primary" align="center">공정 관리</li>
		</ul>
		</div>
		<br />
<!-- 내용 -->
<div class="contaner">
	<div class="row">
		<table class="table table-striped" style="text-align: center; border: 1px solid #dddddd;">
			<thead>
				<tr>
					<th style="background-color: #eeeeee; text-align: center;">작업지시번호</th>
					<th style="background-color: #eeeeee; text-align: center;">공정라인</th>
					<th style="background-color: #eeeeee; text-align: center;">생산수량</th>
					<th style="background-color: #eeeeee; text-align: center;">작업자</th>
					<th style="background-color: #eeeeee; text-align: center;">생산시작일</th>
					<th style="background-color: #eeeeee; text-align: center;">생산완료일</th>
				</tr>
				</thead>
							<tbody>
				<%
					for(int i = 0; i < productionLineList.size(); i++) {
				%>
					<tr>
						<td><%= productionLineList.get(i).getWorkOrderNo() %></td>
						<td><%= productionLineList.get(i).getLineCd() %></td>
						<td><%= productionLineList.get(i).getWorkQty() %></td>
						<td><%= productionLineList.get(i).getInUserId() %></td>
						<td><%= productionLineList.get(i).getStarDate() %></td>
						<td><%= productionLineList.get(i).getEndDate() %></td>
					</tr>
					<%
						}
					%>
			</tbody>
		</table>
	</div>
</div>
<br>
		
		</table>
	</div>
</div>


<div class="container" align=center>
	<a href="../index.do"><input type="button" value="HOME" class="btn btn-primary" onclick="index.do"/></a>
	<a href="../pro_line/productionlineInput.jsp"><input type="button" value="생산량 입력" class="btn btn-success" style="text-align: center"></a>
	
</div>

</body>
</html>