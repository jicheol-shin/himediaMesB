<%@page import="com.mes.service.ItemService"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.mes.vo.Item"%>
<%@page import="com.mes.dao.ItemDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	ItemService itemdata = new ItemService();
	ArrayList<Item> itemList = itemdata.getItemList();
%>
<%-- <c:set var="itemData" value="${itemList}"/> --%>
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
<title>ITEM_View</title>
</head>
<body>
<!-- 항목선택 -->
<div align="center">
	<h3>ITEMS</h3>
</div>
<div class="container" align="center">                                     
	<span class="dropdown">
    	<button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">
			<select class="form-select" aria-label="Default select example" style="color: black">
		 		<option selected>ITEM_CD MENU</option>
				<option value="1">ITEM1</option>
		  		<option value="2">ITEM2</option>
		  		<option value="3">ITEM3</option>
			</select>
    	</button>
	</span>
	<span class="dropdown">
    	<button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">
			<select class="form-select" aria-label="Default select example" style="color: black">
				<option selected>ITEM_NAME MENU</option>
				<option value="1">드립커피바디</option>
				<option value="2">드립커피뚜껑</option>
				<option value="3">드림커피뚜껑_체결나사</option>
				<option value="4">컵받침부</option>
				<option value="5">원두필터</option>
				<option value="6">원두필터컵</option>
				<option value="7">원두필터컵_손잡이</option>
				<option value="8">물컵</option>
				<option value="9">원두컵</option>
			</select>
		</button>
	</span>
	<span class="dropdown">
		<button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">
			<select class="form-select" aria-label="Default select example" style="color: black">
			  	<option selected>CUST_CD MENU</option>
			  	<option value="1">AAA</option>
				<option value="2">AAB</option>
				<option value="3">AAC</option>
				<option value="3">AAD</option>
			</select>
	    </button>
	</span>
	<input type="button" value="SELECT" class="btn btn-primary">
	<input type="button" value="ITEM 입력" class="btn btn-success" style="text-align: center">
</div>
<br>
<hr>
<br>
<!-- 내용보기 -->
<div class="contaner">
	<div class="row">
		<table class="table table-striped" style="text-align: center; border: 1px solid #dddddd;">
			<thead>
				<tr>
					<th style="background-color: #eeeeee; text-align: center;">부품코드</th>
					<th style="background-color: #eeeeee; text-align: center;">부품명</th>
					<th style="background-color: #eeeeee; text-align: center;">구분</th>
					<th style="background-color: #eeeeee; text-align: center;">거래처코드</th>
					<th style="background-color: #eeeeee; text-align: center;">표준단가</th>
					<th style="background-color: #eeeeee; text-align: center;">유통기한(발주->납품)</th>
					<th style="background-color: #eeeeee; text-align: center;">비고</th>
				</tr>
			</thead>
			<tbody>
				<%
					for(int i = 0; i < itemList.size(); i++) {
				%>
					<tr>
						<td><%= itemList.get(i).getItemCd() %></td>
						<td><%= itemList.get(i).getItemName() %></td>
						<td><%= itemList.get(i).getItemType() %></td>
						<td><%= itemList.get(i).getVendorCd() %></td>
						<td><%= itemList.get(i).getUnitPrice() %></td>
						<td><%= itemList.get(i).getLeadTime() %></td>
						<td><%= itemList.get(i).getRemark() %></td>
					</tr>
					<%
						}
					%>
			</tbody>
		</table>
	</div>
</div>
<br>
<hr>
</body>
</html>