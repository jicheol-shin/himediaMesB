<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.mes.service.ProductionService" %>
<%@page import="com.mes.vo.Production" %>
<%@page import="java.util.ArrayList"%>
<%@page import="com.mes.dao.ProductionDAO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	ProductionService productiondata = new ProductionService();
	ArrayList<Production> productionList = productiondata.getProductionList();

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

<title>Production</title>
</head>
<body>
<!-- 제목 -->
<div align="center">
	<h3>Production</h3>
</div>
<!-- 내용 -->
<div class="contaner">
	<div class="row">
		<table class="table table-striped" style="text-align: center; border: 1px solid #dddddd;">
			<thead>
				<tr>
					<th style="background-color: #eeeeee; text-align: center;">수우일자</th>
					<th style="background-color: #eeeeee; text-align: center;">작업지시번호</th>
					<th style="background-color: #eeeeee; text-align: center;">제품코드</th>
					<th style="background-color: #eeeeee; text-align: center;">수주코드</th>
					<th style="background-color: #eeeeee; text-align: center;">라인코드</th>
					<th style="background-color: #eeeeee; text-align: center;">작업자</th>
					<th style="background-color: #eeeeee; text-align: center;">생산수량</th>
					<th style="background-color: #eeeeee; text-align: center;">수주수량</th>
					<th style="background-color: #eeeeee; text-align: center;">생산시작일</th>
					<th style="background-color: #eeeeee; text-align: center;">생산완료일</th>
					
				</tr>
				</thead>
				<tbody>
				<% 
				for (int i =0; i < productionList.size(); i++){
				%>
					<tr>
						<td><%= productionList.get(i).getOrdDate() %></td>
						<td><%= productionList.get(i).getPartNo() %></td>
						<td><%= productionList.get(i).getItemCd() %></td>
						<td><%= productionList.get(i).getOrdCd() %></td>
						<td><%= productionList.get(i).getLineCd() %></td>
						<td><%= productionList.get(i).getInUsrId() %></td>
						<td><%= productionList.get(i).getQuantity() %></td>
						<td><%= productionList.get(i).getBackCnt() %></td>
						<td><%= productionList.get(i).getStartDate() %></td>
						<td><%= productionList.get(i).getEndDate() %></td>
					
					
					</tr>
				<%
				}
				%>
				</tbody>		
		</table>
	</div>
</div>
<div class="container" align=center>
	<a href="../index.do"><input type="button" value="HOME" class="btn btn-primary" onclick="index.do"/></a>
</div>
			

</body>
</html>