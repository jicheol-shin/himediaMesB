<%@page import="com.mes.vo.TakeOrder"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.mes.service.TakeOrderPurchaseService"%>
<%@page import="com.mes.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
   Member member = (Member) session.getAttribute("login_info");

   TakeOrderPurchaseService takeOrderPurchaseService = new TakeOrderPurchaseService();
   ArrayList<TakeOrder> takeOrderList = takeOrderPurchaseService.getTakeOrderList();
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
		background-color: #002699;
		color: #fff;
		}
		
		ul {
		font-size: 25px
		}
		
		tbody {
		font-size: 18px
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

	       <li ><a href="#" class="text-white"><%=member.getUserName()%>님</a></li>  
	       <li ><a href="logout.do" class="text-white">로그아웃</a></li>

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
	      <li class ="list-group-item list-group-item-info font-weight-bold" align="center">구매 발주 관리</li>
	    </ul>
	  </div>
	  <br />
	  <table class="table table-striped table-condensed" style="font-size: 12px">
	  	<thead class="thead-dark lead" align="center">
	  		<tr>
	  			<th>수주코드</th>
	  			<th>제품코드</th>
	  			<th>제품명</th>
	  			<th>진행상태</th>
	  			<th>수주수량</th>
	  			<th>비고</th>
	  			<th>발주</th>
	  		</tr>
	  	</thead>
	  	<tbody align="center">
	  		<% 
	  			for(int i = 0; i < takeOrderList.size(); i++) { 
	  		%>
	  		<tr>
	  			<td><%= takeOrderList.get(i).getOrdCd() %></td>
	  			<td><%= takeOrderList.get(i).getProductCd() %></td>
	  			<td><%= takeOrderList.get(i).getProductName() %></td>
	  			<td><%= takeOrderList.get(i).getProcess() %></td>
	  			<td><%= takeOrderList.get(i).getOrdCnt() %></td>
	  			<td><%= takeOrderList.get(i).getRemark() %></td>
	  			<td><input type="button" class="btn btn-danger mx-auto link-hover-color" value="발주" onclick="buyTakeOrder.do"/></td>
	  		</tr>
	  		<%
	  			}
	  		%>
	  	</tbody>
	  
	  </table>
	</div>
	<br />
	<br />
	<nav class="justify-content-center navbar navbar-expand-md bg-secondary navbar-dark text-light" >
	  <div align="center">
	    <input type="button" value="HOME" class="btn btn-info" onclick="index.do" />
	  </div>
    </nav> 
</div>
</body>
</html>