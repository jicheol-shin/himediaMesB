<%@page import="com.mes.vo.ItemStock"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.mes.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
   Member member = (Member) session.getAttribute("login_info");
   ArrayList<ItemStock> itemStockList = (ArrayList<ItemStock>) request.getAttribute("itemStockList");
%>
<c:set var="itemStock_data" value="<%=itemStockList%>"/>
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
    .logtext { font-size: 10px; width:70px;}
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
<title>Himedia MES_B</title>
</head>
<body>
<div class="container">
   <div class="bs-component">
   <br />
   <nav class="navbar navbar-expand-md bg-secondary navbar-dark text-light">
	 <a class="navbar-brand" href="/index.do">Himedia MES</a>
     <%@ include file="../main/menu.jsp"%>

     <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1" >
    	<c:choose>
          <c:when test="<%=member == null %>" > 
    	    <a class="nav-link text-white" href="#" data-toggle="modal" data-target="#login">
        	  로그인
            </a>
          </c:when>  
  	    <c:otherwise>

	       <li ><a href="#" class='text-white logtext'><%=member.getUserName()%>님</a></li>  
	       <li ><a href="/logout.do" class='text-info logtext'>로그아웃</a></li>

        </c:otherwise>
      </c:choose>	 
     </div>  
	</nav>
	</div>
	<br />
	<div class="container" align="center" style="height: 500px">
	   <div align="left">
		 <ul class="list-group" >
            <li class="list-group-item list-group-item-primary" align="center">자재 재고 현황</li>
		</ul>
		</div>
		<br />
		<table class="table table-striped table-condensed" style="font-size: 12px">
		 <thead class="thead-dark">
			<tr>
				<th>순번</th>
				<th>부품코드</th>
				<th>부품명</th>
				<th>단가</th>
				<th>창고명</th>				
				<th>구역명</th>				
				<th>양품수량</th>
				<th>불량수량</th>
				<th>비고</th>				
			</tr>
			</thead>

			<c:forEach var="itemStock" items="${itemStock_data}">
			<tr>
				<td>${itemStock.getNum()}</td>
				<td>${itemStock.getItemCd()}</td>
				<td>${itemStock.getItemName()}</td>
				<td align="right"><fmt:formatNumber value="${itemStock.getUnitPrice()}" pattern="#,###.#"/>
				<td>${itemStock.getStoreCd()}</td>
				<td>${itemStock.getLocalCd()}</td>
				<td align="right"><fmt:formatNumber value="${itemStock.getGoodCnt()}" pattern="#,###"/>
				<td align="right">${itemStock.getBadCnt()}</td>
				<td>${itemStock.getRemark()}</td>
			</tr>
			</c:forEach>
		</table>
	</div>	
	<br /><br />
    <nav class="navbar navbar-expand-md bg-secondary navbar-dark  text-light">
    </nav>  
</div>
</body>
</html>