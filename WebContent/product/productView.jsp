<%@page import="com.mes.service.ProductService"%>
<%@page import="com.mes.vo.Member"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.mes.vo.Product"%>
<%@page import="com.mes.dao.ProductDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	ProductService productdata = new ProductService();
	ArrayList<Product> productList = productdata.getProductList();
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

<title>Product_View</title>
</head>
<body>
<div align="center">
	<h3>Product</h3>
</div>
<!-- 내용보기 -->
<div class="contaner">
	<div class="row">
		<table class="table table-striped" style="text-align: center; border: 1px solid #dddddd;">
			<thead>
				<tr>
					<th style="background-color: #eeeeee; text-align: center;">제품코드</th>
					<th style="background-color: #eeeeee; text-align: center;">제품명</th>
					<th style="background-color: #eeeeee; text-align: center;">제품스펙</th>
					<th style="background-color: #eeeeee; text-align: center;">비고</th>
				</tr>
			</thead>
			<tbody>
				<%
					for(int i = 0; i < productList.size(); i++) {
				%>
					<tr>
						<td><%= productList.get(i).getProductCd() %></td>
						<td><%= productList.get(i).getProductName() %></td>
						<td><%= productList.get(i).getProductSpec() %></td>
						<td><%= productList.get(i).getRemark()%></td>
					</tr>
					<%
						}
					%>
			</tbody>
		</table>
	</div>
	<div class="container" align="center">
		<input type="button" value="PRODUCT 입력" class="btn btn-success" style="text-align: center">
	</div>
</div>
<br>
<div align="center">
	<input type="button" value="HOME" class="btn btn-primary" onclick="index.do" />
	<input type="button" value="ITEM 입력" class="btn btn-success" style="text-align: center">
</div>
<hr>
</body>
</html>