<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.mes.service.ProductionLineService"%>
<%@page import="com.mes.vo.ProductionLine" %>
<%@page import="java.util.ArrayList" %>
<%@page import="com.mes.dao.ProductionLineDAO" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	ProductionLineService productionLinedata = new ProductionLineService();
	ArrayList<ProductionLine> productionLineList = productionLinedata.getProductionLineList();
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

<title>Production Line</title>
</head>
<body>
<!-- 제목  -->
<div align="center">
<h1>Production Line</h1>
</div>
<!-- 내용 -->
<div class="contaner">
	<div class="row">
		<table class="table table-striped" style="text-align: center; border: 1px solid #dddddd;">
			<thead>
				<tr>
					<th style="background-color: #eeeeee; text-align: center;">작업지시번호</th>
					<th style="background-color: #eeeeee; text-align: center;">공정라인</th>
					<th style="background-color: #eeeeee; text-align: center;">생산수량</th>
					<th style="background-color: #eeeeee; text-align: center;">작업자</th>
					<th style="background-color: #eeeeee; text-align: center;">생산시작일</th>
					<th style="background-color: #eeeeee; text-align: center;">생산완료일</th>
				</tr>
				
				</thead>
		
		</table>
	</div>
</div>


<div class="container" align=center>
	<a href="../index.do"><input type="button" value="HOME" class="btn btn-primary" onclick="index.do"/></a>
</div>

</body>
</html>