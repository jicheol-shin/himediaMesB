<%@page import="com.mes.vo.ReleaseStatement"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.mes.service.ReleaseOutService"%>
<%@page import="com.mes.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
   Member member = (Member) session.getAttribute("login_info");

   ReleaseOutService releaseOutService = new ReleaseOutService();
   ArrayList<ReleaseStatement> releaseOutList = (ArrayList<ReleaseStatement>) request.getAttribute("releaseOutList");
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
	<title>Himedia MES_B</title>
</head>
<body>
<div class="container">
   <div class="bs-component">
   <br />
   <nav class="navbar navbar-expand-md font-weight-bold" style="background-color: #e3f2fd;">
	 <a class="navbar-brand" href="/index.do">Himedia MES</a>
	 <%@ include file="../main/menu.jsp" %>
	 
	 <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
    	 <span class="navbar-toggler-icon"></span>
 	 </button>
     <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1" >
    	<c:choose>
          <c:when test="<%=member == null %>" > 
    	    <a class="nav-link text-white" href="#" data-toggle="modal" data-target="#login">
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
	
	<!-- 목록 보이기 -->
	<div class="container" align="center">
	  <div align="left">
	    <ul class="list-group">
	      <li class ="list-group-item font-weight-bold" align="center" style="background-color: #d1d1e0;">출고 내역</li>
	    </ul>
	  </div>
	  <br />
	  <table class="table table-striped table-condensed" style="font-size: 12px">
	  	<thead class="thead-dark lead" align="center" >
	  		<tr>
	  			<th>순번</th>
	  			<th>출고요청코드</th>
	  			<th>제품코드</th>
	  			<th>제품명</th>
	  			<th>수량</th>
	  			<th>거래처</th>
	  			<th>출고일</th>
	  			<th>비고</th>
	  		</tr>
	  	</thead>
	  	<tbody align="center">
	  	
	  		<c:forEach var="releaseOutList" items="${releaseOutService}">
	  		<tr>
	  			<td>${releaseOutList.getNum()}</td>
	  			<td>${releaseOutList.getReleCd()}</td>
	  			<td>${releaseOutList.getProductCd()}</td>
	  			<td>${releaseOutList.getProductName()}</td>
	  			<td>${releaseOutList.getReqCnt()}</td>
	  			<td>${releaseOutList.getCustomer()}</td>
	  			<td>${releaseOutList.getReleDelDate()}</td>
	  			<td>${releaseOutList.getRemark()}</td>
	  		</tr>
	  		</c:forEach>
	  	</tbody>
	  
	  </table>
	</div>
	<br />
	<br />
	<nav class="justify-content-center navbar navbar-expand-md" style="background-color: #e3f2fd;" >
	  <div align="center">
	    <a href="../index.do"><button type="button" class="btn btn-info btn-lg btn-block" onclick="location.href='index.do';" style="font-size: 20px;">HOME</button></a>
	  </div>
    </nav> 
</div>
</body>
</html>