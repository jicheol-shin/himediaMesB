<%@page import="java.util.ArrayList"%>
<%@page import="com.mes.service.MemberViewService"%>
<%@page import="com.mes.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	Member member = (Member) session.getAttribute("login_info");
	ArrayList<Member> memberList = (ArrayList<Member>) request.getAttribute("memberList");
%>
<c:set var="member_data" value="<%=memberList%>"/>
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
<title>MEMBER_VIEW</title>
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
	      		<li class ="list-group-item font-weight-bold" style="background-color: #33334d;">사용자관리</li>
	    	</ul>
		</div>
	  	<br />
		<!-- input 버튼 -->
  		<div align="right">
			<input type="button" value="사용자 등록" class="btn btn-primary" style="text-align: center; font-size: 15px">
		</div>
	  	<br />
		<!-- 내용보기 -->
		<table class="table table-striped table-condensed" style="font-size: 15px">
		  	<thead class="thead-dark" align="center" >
				<tr>
					<th>사용자ID</th>
					<th>사용자비밀번호</th>
					<th>사용자명</th>
					<th>이메일</th>
					<th>전화번호</th>
					<th>부서</th>
					<th>직급</th>
					<th>비고</th>
				</tr>
			</thead>
			<tbody align="center">
				<c:forEach var="mem" items="${member_data}">
	               	<tr>
						<td>${mem.getUserId()}</td>
						<td>${mem.getPassword()}</td>
						<td>${mem.getUserName()}</td>
						<td>${mem.getEmail()}</td>
						<td>${mem.getTel()}</td>
						<td>${mem.getDep()}</td>
						<td>${mem.getRank()}</td>
						<td>${mem.getRemark()}</td>
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
