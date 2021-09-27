<%@page import="com.mes.service.ErrorProduceService"%>
<%@page import="com.mes.vo.ErrorProduce"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.mes.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	Member member = (Member) session.getAttribute("login_info");

	ErrorProduceService errorProduceService = new ErrorProduceService();
	ArrayList<ErrorProduce> errorproduceList = (ArrayList<ErrorProduce>) request.getAttribute("errorproduceList");
%>
<c:set var="errorProduce_data" value="<%=errorproduceList%>"/>
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

	.logtext { font-size: 12px; width:80px;}
	
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
		background-color: #b3b3ff;
		color: #001a66;
	}
	
	ul {
		list-style-type: none;
		font-size: 30px;
		color: #4d2600;
	}
	
	tbody {
		font-size: 18px
	}
	
	.btn-info {
		background-color: #0073e6;
		color:#ffffe6;
		width: 100px;
	}
	.btn-info:hover {
		background-color: #000066;
	}
	
</style>
<title>ERROR_PEODUCE_VIEW</title>
</head>
<body>
<div class="container">
	<!-- 로그인바 -->
	<div class="bs-component">
	<br />
	<nav class="navbar navbar-expand-md font-weight-bold" style="background-color: #82C3F5;">
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
					<li ><a href="#" class="font-weight-bold text-dark logtext"><%=member.getUserName()%>님</a></li>  
	       			<li ><a href="../logout.do" class="font-weight-bold text-dark logtext">로그아웃</a></li>
				</c:otherwise>
			</c:choose>
		</div>
	</nav>
	</div>
	<br />
	<hr>
	<br>
	<div class="container" align="center">
		<!-- 제목박스 -->
		<div align="left">
	    	<ul class="list-group">
	      		<li class ="list-group-item font-weight-bold" align="center" style="background-color: #CDE5F7;">불량관리</li>
	    	</ul>
		</div>
	  	<br />
		<!-- 내용보기 -->
		<table class="table table-striped table-condensed" style="font-size: 10px">
		  	<thead class="thead-dark lead" align="center" >
				<tr>
					<th>불량코드</th>
					<th>불량내용</th>
					<th>비고</th>
				</tr>
			</thead>
			<tbody align="center">
				<c:forEach var="error" items="${errorProduce_data}">
		          	<tr>
						<td>${error.getErrorCd()}</td>
						<td>${error.getErrorName()}</td>
						<td>${error.getRemark()}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<div align="center">
		<input type="button" value="불량 입력" class="btn btn-success" style="text-align: center">
	</div>
	<hr>
	<nav class="justify-content-center navbar navbar-expand-md" style="background-color: #82C3F5;" >
		<div align="center"></div>
	</nav>
</div>
</body>
</html>
