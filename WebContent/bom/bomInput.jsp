<%@page import="com.mes.vo.Vendor"%>
<%@page import="com.mes.vo.Member"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.mes.vo.Product"%>
<%@page import="com.mes.vo.Item"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	Member member = (Member) session.getAttribute("login_info");
	
	ArrayList<Product> productList = (ArrayList<Product>) request.getAttribute("productList");
	
	ArrayList<Item> itemList = (ArrayList<Item>) request.getAttribute("itemList");
	
	ArrayList<Vendor> vendorList = (ArrayList<Vendor>) request.getAttribute("vendorList");
%>
<c:set var="product_data" value="<%=productList%>"/>
<c:set var="item_data" value="<%=itemList%>"/>
<c:set var="vendor_data" value="<%=vendorList%>"/>
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
	
	table {
	  width: 80%;
	}
	
</style>
<title>BOM_INPUT</title>
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
	<div class="row">
		<br />
		<div class="col-md-12">
		<hr>
		<!-- 제목박스 -->
		<div align="center">
		  <ul class="list-group class-box">
		    <li class ="list-group-item font-weight-bold" style="background-color: #33334d;">BOM입력</li>
		  </ul>
		</div>
		<br />
		<!-- 내용입력 -->
		<form action="/bomInput.do" method="post">
			<div class="table table-responsive">
				<table class="thead-dark lead" align="center" >
					<tr>
					    <td>제품코드</td>
					    <td>
						    <select name="productCd">
						    	<option value="">제품코드를 선택해주세요.</option>
							    <c:forEach var="product" items="${product_data}">
							    	<option value="${product.getProductCd()}">${product.getProductCd()}</option>
							    </c:forEach>
						    </select>
					    </td>
					</tr>
					<tr>
					    <td>부품코드</td>
					    <td>
						    <select name="itemCd">
						    	<option value="">부품코드를 선택해주세요.</option>
							    <c:forEach var="item" items="${item_data}">
							    	<option value="${item.getItemCd()}">${item.getItemCd()}</option>
							    </c:forEach>
						    </select>
					    </td>
					</tr>
					<tr>
					    <td>부품명</td>
					    <td>
						    <select name="itemName">
						    	<option value="">부품명을 선택해주세요.</option>
							    <c:forEach var="item" items="${item_data}">
							    	<option value="${item.getItemName()}">${item.getItemName()}</option>
							    </c:forEach>
						    </select>
					    </td>
					</tr>
					<tr>
					    <td>소요량</td>
					    <td><input type="number" name="itemCnt" class="form-control" ></td>
					</tr>
					<tr>
					    <td>단위</td>
					    <td><input type="text" name="unit" class="form-control" placeholder="ex) EA"></td>
					</tr>
					<tr>
					    <td>단가</td>
					    <td><input type="number" name="unitPrice" class="form-control" ></td>
					</tr>
					<tr>
					    <td>납품처</td>
					    <td>
						    <select name="vendorCd">
						    	<option value="">거래처코드를 선택해주세요.</option>
							    <c:forEach var="vendor" items="${vendor_data}">
							    	<c:if test="${ vendor.getVendorType() eq '부품거래처' }">
								    	<option value="${vendor.getVendorCd()}">${vendor.getVendorCd()}</option>
							    	</c:if>
							    </c:forEach>
						    </select>
					    </td>
					</tr>
					<tr>
					    <td>비고</td>
					    <td><input type="text" name="remark" class="form-control" ></td>
					</tr>
					<tr>  
						<td colspan="2"  class="text-center">
						    <input type="submit" value="SUBMIT" class="btn btn-success">
						    <input type="reset" value="RESET" class="btn btn-warning">
						</td>
					</tr>
				</table>
			</div>
		</form>   
		<hr>
		<nav class="justify-content-center navbar navbar-expand-md" style="background-color: #008080;" >
			<div align="center"></div>
		</nav>
		</div>
	</div>
</div>
</body>
</html>