<%@page import="com.mes.vo.ReleaseProduct"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.mes.service.ReleaseOrderService"%>
<%@page import="com.mes.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
   Member member = (Member) session.getAttribute("login_info");

   ReleaseOrderService releaseOrderService = new ReleaseOrderService();
   ArrayList<ReleaseProduct> releaseOrderList = (ArrayList<ReleaseProduct>) request.getAttribute("releaseOrderList");
%>
<c:set var="releaseOrder_data" value="<%=releaseOrderList %>"/>
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
			display: table;
        	margin-left: auto;
       		margin-right: auto;
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
		
		ul {                                /* 테이블 제목  */
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
		
		.btn-primary {                       /* 발주하기 버튼 */
			background-color: #ff4d4d;      /* 버튼배경 */
			color:#fff;                     /* 글씨색 */
			width: 100px;                   /* 버튼크기 */
		}
		.btn-primary:hover {                 /* 버튼 마우스 토글시 보이는 색 */
			background-color: #ff9999;
		}
		
	</style>
	<title>Himedia MES_B</title>
</head>
<body>
<div class="container">
   <div class="bs-component">
   <br />
   <nav class="navbar navbar-expand-md font-weight-bold" style="background-color: #008080;">
	 <a class="navbar-brand" href="/index.do" style="color: #fff">Himedia MES</a>
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

	       <li ><a href="#" class="font-weight-bold logtext"><%=member.getUserName()%>님</a></li>  
	       <li ><a href="../logout.do" class="font-weight-bold logtext">로그아웃</a></li>

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
	      <li class ="list-group-item font-weight-bold" style="background-color: #33334d;">출고 지시</li>
	    </ul>
	  </div>
	  <br />
	  <table class="table table-striped table-condensed" style="font-size: 15px">
	  	<thead class="thead-dark" align="center" >
	  		<tr>
	  			<th>출고요청일자</th>
	  			<th>출고요청코드</th>
	  			<th>거래처</th>
	  			<th>완제품코드</th>
	  			<th>진행상태</th>
	  			<th>요청수량</th>
	  			<th>출고</th>
	  			<th>비고</th>
	  		</tr>
	  	</thead>
	  	<tbody align="center">
	  	
	  		<c:forEach var="releaseOrderList" items="${releaseOrder_data}">
	  		<tr>
	  			<td>${releaseOrderList.getReleDate()}</td>
	  			<td>${releaseOrderList.getReleCd()}</td>
	  			<td>${releaseOrderList.getCustomer()}</td>
	  			<td>${releaseOrderList.getProductCd()}</td>
	  			<td>${releaseOrderList.getProcess()}</td>
	  			<td>${releaseOrderList.getReqCnt()}</td>
	  			<td>
	  			  <a href="/releaseOrderInput.do?releCd=${releaseOrderList.getReleCd()}">
	  			   <button type="button" class="btn btn-primary link-hover-color-success" style="font-size: 15px">출고하기</button>
	  			  </a>
	  			</td>
	  			<td>${releaseOrderList.getRemark()}</td>
	  		</tr>
	  		</c:forEach>
	  	</tbody>
	  
	  </table>
	</div>
	<br />
	<br />
	<hr>
	<nav class="justify-content-center navbar navbar-expand-md" style="background-color: #008080;" >
	  <div align="center">
	    <a href="../index.do">
	     <!--  <button type="button" class="btn btn-info btn-lg btn-block" onclick="location.href='index.do';" style="font-size: 20px;">HOME</button> -->
	    </a>
	  </div>
    </nav> 
</div>
</body>
</html>