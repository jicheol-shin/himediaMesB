<%@page import="com.mes.vo.Line"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.mes.service.LineService"%>
<%@page import="com.mes.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	Member member = (Member) session.getAttribute("login_info");

	LineService linedata = new LineService();
	ArrayList<Line> lineList = linedata.getLineList();
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
<title>LINE_VIEW</title>
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
<div align="center">
	<h3>라인관리</h3>
</div>
<br>
<hr>
<br>
<!-- 내용보기 -->
<div class="contaner">
	<div class="row">
		<table class="table table-striped" style="text-align: center; border: 1px solid #dddddd;">
			<thead>
				<tr>
					<th style="background-color: #eeeeee; text-align: center;">라인코드</th>
					<th style="background-color: #eeeeee; text-align: center;">라인명</th>
					<th style="background-color: #eeeeee; text-align: center;">라인분류</th>
					<th style="background-color: #eeeeee; text-align: center;">설비사용</th>
					<th style="background-color: #eeeeee; text-align: center;">검사유무</th>
					<th style="background-color: #eeeeee; text-align: center;">불량수</th>
					<th style="background-color: #eeeeee; text-align: center;">비고</th>
				</tr>
			</thead>
			<tbody>
				<%
					for(int i = 0; i < lineList.size(); i++) {
				%>
					<tr>
						<td><%= lineList.get(i).getLineCd() %></td>
						<td><%= lineList.get(i).getLineName() %></td>
						<td><%= lineList.get(i).getLineType() %></td>
						<td><%= lineList.get(i).getEquipment() %></td>
						<td><%= lineList.get(i).getTest() %></td>
						<td><%= lineList.get(i).getErrorCnt() %></td>
						<td><%= lineList.get(i).getRemark() %></td>
					</tr>
					<%
						}
					%>
			</tbody>
		</table>
	</div>
</div>
<br>
<div align="center">
	<input type="button" value="라인 입력" class="btn btn-success" style="text-align: center">
</div>
<hr>
</body>
</html>
</body>
</html>