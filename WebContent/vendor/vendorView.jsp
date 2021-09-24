<%@page import="com.mes.vo.Member"%>
<%@page import="com.mes.service.VendorService"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.mes.vo.Vendor"%>
<%@page import="com.mes.dao.VendorDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	Member member = (Member) session.getAttribute("login_info");

	VendorService vendordata = new VendorService();
	ArrayList<Vendor> vendorList = vendordata.getVendorList();
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
<title>VENDOR_VIEW</title>
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
	<h3>거래처관리</h3>
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
					<th style="background-color: #eeeeee; text-align: center;">거래처코드</th>
					<th style="background-color: #eeeeee; text-align: center;">거래처명</th>
					<th style="background-color: #eeeeee; text-align: center;">거래처유형</th>
					<th style="background-color: #eeeeee; text-align: center;">사업자등록번호</th>
					<th style="background-color: #eeeeee; text-align: center;">대표자</th>
					<th style="background-color: #eeeeee; text-align: center;">업종</th>
					<th style="background-color: #eeeeee; text-align: center;">이메일</th>
					<th style="background-color: #eeeeee; text-align: center;">전화번호</th>
					<th style="background-color: #eeeeee; text-align: center;">비고</th>
				</tr>
			</thead>
			<tbody>
				<%
					for(int i = 0; i < vendorList.size(); i++) {
				%>
					<tr>
						<td><%= vendorList.get(i).getVendorCd() %></td>
						<td><%= vendorList.get(i).getVendorName() %></td>
						<td><%= vendorList.get(i).getVendorType() %></td>
						<td><%= vendorList.get(i).getVendorNum() %></td>
						<td><%= vendorList.get(i).getRepName() %></td>
						<td><%= vendorList.get(i).getSectors() %></td>
						<td><%= vendorList.get(i).getEmail() %></td>
						<td><%= vendorList.get(i).getTel() %></td>
						<td><%= vendorList.get(i).getRemark() %></td>
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
	<input type="button" value="거래처 입력" class="btn btn-success" style="text-align: center">
</div>
<hr>
</body>
</html>