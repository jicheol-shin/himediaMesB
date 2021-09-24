<%@page import="com.mes.vo.ReleaseProduct"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.mes.service.ReleaseProductViewService"%>
<%@page import="com.mes.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	Member member = (Member) session.getAttribute("login_info");

	ArrayList<ReleaseProduct> releaseProductList = (ArrayList<ReleaseProduct>) request.getAttribute("releaseProductList");
%>
<c:set var="releaseProduct_data" value="<%=releaseProductList%>"/>
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
<title>RELEASE_PRODUCT_VIEW</title>
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
	<h3>출하관리</h3>
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
					<th>출고요청코드</th>
					<th>출하요청일자</th>
					<th>수주코드</th>
					<th>거래처</th>
					<th>제품코드</th>
					<th>진행상태</th>
					<th>요청수량</th>
					<th>출하수량</th>
					<th>재고수량</th>
					<th>요청잔량</th>
					<th>납품예정일</th>
					<th>비고</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach var="release" items="${releaseProduct_data}">
               <tr>
                  <td>${release.getReleCd()}</td>
                  <td>${release.getReleDate()}</td>
                  <td>${release.getOrdCd()}</td>
                  <td>${release.getCustomer()}</td>
                  <td>${release.getProductCd()}</td>
                  <td>${release.getProcess()}</td>
                  <td>${release.getReqCnt()}</td>
                  <td>${release.getReleCnt()}</td>
                  <td>${release.getGoodCount()}</td>
                  <td>${release.getBackCnt()}</td>
                  <td>${release.getReleDelDate()}</td>
                  <td>${release.getRemark()}</td>
               </tr>
             </c:forEach>
			</tbody>
		</table>
	</div>
</div>
<br>
<div align="center">
	<a href="/releaseProductInputForm.do"><input type="button" value="출하 입력" class="btn btn-success" style="text-align: center"></a>
</div>
<hr>
</body>
</html>
</body>
</html>
</body>
</html>