<%@page import="com.mes.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.mes.service.ProductionCurrentService"%>
<%@page import="com.mes.vo.ProductionCurrent" %>
<%@page import="java.util.ArrayList" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%
	Member member = (Member) session.getAttribute("login_info");
	ProductionCurrentService productionCurrentdata = new ProductionCurrentService();
	ArrayList<ProductionCurrent> productionCurrentList = productionCurrentdata.getProductionCurrentList();

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" 
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" 
	integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"/>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" 
	integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"/>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" 
	integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"/>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
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
<title>PRODUCTION_PERCENT</title>
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
            <li class="list-group-item list-group-item-primary" align="center">생산 지시 현황</li>
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
					<th style="background-color: #eeeeee; text-align: center;">제품코드</th>
					<th style="background-color: #eeeeee; text-align: center;">생산수량</th>
					<th style="background-color: #eeeeee; text-align: center;">생산진행률</th>
				</tr>
				</thead>
							<tbody>
				<%
					for(int i = 0; i < productionCurrentList.size(); i++) {
				%>
					<tr>
						<td><%= productionCurrentList.get(i).getWorkOrderNo() %></td>
						<td><%= productionCurrentList.get(i).getProductCd() %></td>
						<td><%= productionCurrentList.get(i).getWorkQty() %></td>
						<td><%= productionCurrentList.get(i).getQtyPercent() %></td>
					</tr>
					<%
						}
					%>
				</tbody>	
</table>
	</div>
</div>
<div class="container" align=center>
	<a href="../index.do"><input type="button" value="HOME" class="btn btn-primary" onclick="index.do"/></a>
</div>

</body>
</html>