<%@page import="com.mes.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	Member member = (Member) session.getAttribute("login_info");
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
<title>TAKE_ORDER_INPUT</title>
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
<div class="row">
<div class="col-md-2"></div>
	<br />
	<div class="col-md-8">
	<br />
	<h2 class="text-center">수주 입력</h2><p></p>
	<br>
	<hr>
	<br>
	<form action="/takeOrderInput.do" method="post">
		<div class="table table-responsive">
			<table class="table table-striped">
				<tr>
				    <td>수주코드</td>
				    <td><input type="text" name="ordCd" class="form-control" ></td>
				</tr>
				<tr>
				    <td>거래처코드</td>
				    <td><input type="text" name="vendorCd" class="form-control" ></td>
				</tr>
				<tr>
				    <td>제품코드</td>
				    <td><input type="text" name="productCd" class="form-control" ></td>
				</tr>
				<tr>
				    <td>진행상태</td>
				    <td><input type="text" name="process" class="form-control" ></td>
				</tr>
				<tr>
				    <td>납품예정일</td>
				    <td><input type="date" name="ordDelDate" class="form-control" ></td>
				</tr>
				<tr>
				    <td>수주수량</td>
				    <td><input type="text" name="ordCnt" class="form-control" ></td>
				</tr>
				<tr>
				    <td>비고</td>
				    <td><input type="text" name="remark" class="form-control" ></td>
				</tr>
				<tr>  
				<td colspan="2"  class="text-center">
				    <input type="submit" value="SUBMIT" class="btn btn-success">
				    <input type="reset" value="RESET" class="btn btn-warning">
				</td>
				</tr>
			</table>
		</div>
	</form>   
	</div>
</div>
</body>
</html>
</body>
</html>