<%@page import="com.mes.utility.Pager"%>
<%@page import="com.mes.service.BomViewService"%>
<%@page import="com.mes.vo.Bom"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.mes.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	Member member = (Member) session.getAttribute("login_info");

	BomViewService bomViewService = new BomViewService();
	ArrayList<Bom> bomList = (ArrayList<Bom>) request.getAttribute("bomList");
	
	Pager pageInfo = (Pager) request.getAttribute("pageInfo");
	int totalPage = pageInfo.getTotalPage();
	int startPage = pageInfo.getStartPage();
	int endPage = pageInfo.getEndPage();
	int pageSize = 10; // 한 페이지에 출력할 갯수
%>
<c:set var="bom_data" value="<%=bomList%>"/>
<c:set var="totalPage" value="<%=totalPage%>"/>
<c:set var="startPage" value="<%=startPage%>"/>
<c:set var="endPage" value="<%=endPage%>"/>
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
<title>BOM_VIEW</title>
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
	      		<li class ="list-group-item font-weight-bold" align="center" style="background-color: #CDE5F7;">BOM관리</li>
	    	</ul>
		</div>
	  	<br />
		<!-- 내용보기 -->
		<table class="table table-striped table-condensed" style="font-size: 10px">
		  	<thead class="thead-dark lead" align="center" style="font-size: 17px" >
				<tr>
					<th>제품코드</th>
					<th>부품코드</th>
					<th>부품명</th>
					<th>소요량</th>
					<th>단위</th>
					<th>단가</th>
					<th>거래처코드</th>
					<th>비고</th>
				</tr>
			</thead>
			<tbody align="center">
				<c:forEach var="bom" items="${bom_data}">
	     	       <tr>
	 	              <td>${bom.getProductCd()}</td>
	                  <td>${bom.getItemCd()}</td>
	                  <td>${bom.getItemName()}</td>
	                  <td>${bom.getItemCnt()}</td>
	                  <td>${bom.getUnit()}</td>
	                  <td>${bom.getUnitPrice()}</td>
	                  <td>${bom.getVendorCd()}</td>
	                  <td>${bom.getRemark()}</td>
	               </tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<div align="center">
		<a href="/bomInputForm.do"><input type="button" value="BOM 입력" class="btn btn-success" style="text-align: center"></a>
	</div>
	<hr>
	<nav class="justify-content-center navbar navbar-expand-md" style="background-color: #82C3F5;" >
		<div align="center"></div>
	</nav>
</div>
<div class="container">
	<ul class="pagination justify-content-center">
		<c:if test="${startPage != 1}">
			<li class="page-item"><a href="bomView.do?page=1" class="page-link"><i class="fas fa-fast-backward"></i></a></li>
			<li class="page-item"><a href="bomView.do?page=${startPage-10}" class="page-link"><i class="fas fa-backward"></i></a></li>
		</c:if>
			<c:forEach var="page_num" begin="${startPage}" end="${endPage}" step="1">
				<li class="page-item"><a class="page-link" href="bomView.do?page=${page_num}" >${page_num}</a></li>
			</c:forEach>
		<c:if test="${endPage < totalPage}">
			<li class="page-item"><a href="bomView.do?page=${endPage+1}" class="page-link"><i class="fas fa-forward"></i></a></li>
			<li class="page-item"><a href="bomView.do?page=${totalPage}" class="page-link"><i class="fas fa-fast-forward"></i></a></li>
		</c:if>
	</ul>
</div>
</body>
</html>
