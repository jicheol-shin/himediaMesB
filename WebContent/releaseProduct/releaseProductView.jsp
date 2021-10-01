<%@page import="com.mes.vo.ReleaseProduct"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.mes.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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

	.logtext {                         /* 로그아웃, 관리자 글자크기 */
		font-size: 12px; 
		width:80px;
		color: #fff;
	} 
		
	li {                               /* 제목 테이블 정렬 */
		list-style-type: none;
	}
		
	li a {                             /* 메뉴 상단 관리자, 로그아웃 사이 간격 */
		text-decoration: none;
		display: block;
		color: #000;
		padding: 8px 15px 8px 15px;
	}
		
	li a:hover {                        /* 상단메뉴(드롭다운시 마우스 메뉴 이름에 올리면 보이는 색깔) */
		background-color: #e6ffff;
		color: #008080;
	}
		
	ul.class-box {                      /* 테이블 제목  */
		list-style-type: none;
		font-size: 26px;
		color: #fff;                    /* 글자색 */
		width: 254px;
		padding: 0;
		display: table;
        margin-left: auto;
       	margin-right: auto;
	}
		
	tbody {                             /* 출력DB 테이블 데이터 글씨크기 */
		font-size: 15px
	}
	
</style>
<title>RELEASE_PRODUCT_VIEW</title>
</head>
<body>
<div class="container">
	<!-- 로그인바 -->
	<div class="bs-component">
	<br />
	<nav class="navbar navbar-expand-md font-weight-bold" style="background-color: #008080;">
		<a href="/index.do" class="navbar-brand" style="color: #fff">HIMIDIA MES</a>
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
					<li ><a href="#" class="font-weight-bold logtext"><%=member.getUserName()%>님</a></li>  
	       			<li ><a href="../logout.do" class="font-weight-bold logtext">로그아웃</a></li>
				</c:otherwise>
			</c:choose>
		</div>
	</nav>
	</div>
	<hr>
	<div class="container" align="center">
		<!-- 제목박스 -->
		<div align="center">
	    	<ul class="list-group class-box">
	      		<li class ="list-group-item font-weight-bold" style="background-color: #33334d;">출하관리</li>
	    	</ul>
		</div>
	  	<br />
		<!-- input 버튼 -->
  		<div align="right">
			<a href="/releaseProductInputForm.do"><input type="button" value="출하 입력" class="btn btn-primary" style="text-align: center; font-size: 15px"></a>
		</div>
	  	<br />
		<!-- 내용보기 -->
		<table class="table table-striped table-condensed" style="font-size: 15px">
		  	<thead class="thead-dark" align="center" >
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
			<tbody align="center">
				<c:forEach var="release" items="${releaseProduct_data}">
					<tr>
						<td>${release.getReleCd()}</td>
						<td>${release.getReleDate()}</td>
						<td>${release.getOrdCd()}</td>
						<td>${release.getCustomer()}</td>
						<td>${release.getProductCd()}</td>
						<td>${release.getProcess()}</td>
						<td align="center"><fmt:formatNumber value="${release.getReqCnt()}" pattern="#,###"/>
						<td align="center"><fmt:formatNumber value="${release.getReleCnt()}" pattern="#,###"/>
						<td align="center"><fmt:formatNumber value="${release.getGoodCount()}" pattern="#,###"/>
						<td align="center"><fmt:formatNumber value="${release.getBackCnt()}" pattern="#,###"/>
						<td>${release.getReleDelDate()}</td>
						<td>${release.getRemark()}</td>
					</tr>
	             </c:forEach>
			</tbody>
		</table>
	</div>
	<hr>
	<nav class="justify-content-center navbar navbar-expand-md" style="background-color: #008080;" >
		<div align="center"></div>
	</nav>
</div>
</body>
</html>
