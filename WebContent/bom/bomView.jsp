<%@page import="com.mes.vo.Product"%>
<%@page import="com.mes.utility.Pager"%>
<%@page import="com.mes.vo.Bom"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.mes.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
	Member member = (Member) session.getAttribute("login_info");
	Pager pager = (Pager) request.getAttribute("pageInfo");
	ArrayList<Bom> bomList = (ArrayList<Bom>) request.getAttribute("bomList");
	ArrayList<Product> productList = (ArrayList<Product>) request.getAttribute("productList");
	int curPage = pager.getPageNum();	
	int totalPage = pager.getTotalPage();
	int startPage = pager.getStartPage();
	int endPage = pager.getEndPage();
%>
<c:set var="bom_data" value="<%=bomList%>"/>
<c:set var="product_data" value="<%=productList%>"/>
<c:set var="curPage" value="<%=curPage%>"/>
<c:set var="totalPage" value="<%=totalPage%>"/>
<c:set var="startPage" value="<%=startPage%>"/>
<c:set var="endPage" value="<%=endPage%>"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css" 
      integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ"
	  crossorigin="anonymous">
<script src="https://kit.fontawesome.com/d460482c18.js" crossorigin="anonymous"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>	
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script type="text/javascript">
	$(function(){
	    //직접입력 인풋박스 기존에는 숨어있다가
	$("#selboxDirect").hide();
	$("#selbox").change(function() {
	        //직접입력을 누를 때 나타남
	      if($("#selbox").val() == "직접입력") {
	          $("#selboxDirect").show();
	      }  else {
	          $("#selboxDirect").hide();
	      }
	  }) 
	});​
</script>
<style type="text/css">

	.logtext {                         /* 로그아웃, 관리자 글자크기 */
		font-size: 12px; 
		width:80px;
		color: #fff;
	} 
	
	ul {                                /* 테이블 제목  */
		list-style-type: none;
		color: #fff;                    /* 글자색 */
		width: 254px;
		padding: 0;
   		margin: 0;
/* 		font-size: 26px; */
/* 		display: table;
       	margin-left: auto;
   		margin-right: auto; */
	}
	
	/* 제목박스 */
	.titleBox{
 		font-size: 26px;
 		display: table;
       	margin-left: auto;
   		margin-right: auto;
	
	}
	
	li {                               /* 제목 테이블 정렬 */
		list-style-type: none;
/* 		display: table;
       	margin-left: auto;
   		margin-right: auto; */
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
	
	tbody {                             /* 출력DB 테이블 데이터 글씨크기 */
		font-size: 15px
	}    		
	
</style>
<title>BOM_VIEW</title>
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
					<li><a href="#" class="font-weight-bold logtext"><%=member.getUserName()%>님</a></li>  
	       			<li><a href="../logout.do" class="font-weight-bold logtext">로그아웃</a></li>
				</c:otherwise>
			</c:choose>
		</div>
	</nav>
	</div>
	<hr>
	<div class="container" align="center" style="height: 100%">
		<!-- 제목박스 -->
		<div class="titleBox" align="left">
	    	<ul class="list-group">
	      		<li class ="list-group-item font-weight-bold" align="center" style="background-color: #33334d;">BOM관리</li>
	    	</ul>
		</div>
		<br />
		<div align="right" class="fl_left">
			<table>
			  	<thead align="center">
					<tr>
						<!-- Select박스 -->
						<th>
							<form action="bomView.do" method="post">
					        <!-- c:foreach 활용 -->
			 				    <select name="productCd">
							    	<option>제품코드선택</option>
									<c:forEach var="product" items="${product_data}">
								    	<option value="${product.getProductCd()}">${product.getProductCd()}</option>
							    	<!-- 직접입력시 input값이 아닌 "직접입력"값이 들어가는 현상 오류 찾는중.. -->
									<!-- <option value="직접입력">직접입력</option> -->
								    </c:forEach>
							    </select>
								</select>
						    	<!-- 직접입력시 input값이 아닌 "직접입력"값이 들어가는 현상 오류 찾는중.. -->
								<!-- 상단의 select box에서 '직접입력'을 선택하면 나타날 인풋박스 -->
								<!-- <input type="text" id="selboxDirect" name="productCd" placeholder="직접입력"/> -->
								<input type="submit"  value="조회"/>
							</form>
						</th>
						<!-- input 버튼 -->
						<th>
							<a href="/bomInputForm.do"><input type="button" value="BOM 입력" class="btn btn-primary" style="text-align: center; font-size: 15px"></a>
						</th>
					</tr>
				</thead>
			</table>
		</div>
	  	<br />
		<!-- 내용보기 -->
		<table class="table table-striped table-condensed" style="font-size: 15px">
		  	<thead class="thead-dark" align="center">
				<tr>
					<th>제품코드</th>
					<th>부품코드</th>
					<th>부품명</th>
					<th>소요량</th>
					<th>단위</th>
					<th>단가</th>
					<th>거래처코드</th>
					<th>비고</th>
				</tr>
			</thead>
			<tbody align="center">
				<c:forEach var="bom" items="${bom_data}">
					<tr>
						<td>${bom.getProductCd()}</td>
	                    <td>${bom.getItemCd()}</td>
	                    <td>${bom.getItemName()}</td>
					  	<td align="center"><fmt:formatNumber value="${bom.getItemCnt()}" pattern="#,###"/>
					  	<td>${bom.getUnit()}</td>
					  	<td align="center"><fmt:formatNumber value="${bom.getUnitPrice()}" pattern="#,###"/>
	                    <td>${bom.getVendorCd()}</td>
	                    <td>${bom.getRemark()}</td>
	                </tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<br />
	<!-- 페이지번호 -->
	<!-- 페이지번호 버튼 ◀ 1~10 ▶ -->
	<div class="container" align="center">
		<ul class="pagination justify-content-center">
			<!-- 페이지번호버튼(앞으로) -->
			<%-- <c:if test="${startPage ne 1}"> --%>
				<li class="page-item"><a href="bomView.do?page=1" class="page-link"><i class="fas fa-fast-backward"></i></a></li>
				<li class="page-item"><a href="bomView.do?page=${page_num-10}" class="page-link"><i class="fas fa-backward"></i></a></li>
			<%-- </c:if> --%>
			<!-- 페이지번호버튼(숫자) -->
				<c:forEach var="page_num" begin="${startPage}" end="${endPage}" step="1">
					<li class="page-item"><a class="page-link" href="bomView.do?page=${page_num}" >${page_num}</a></li>
				</c:forEach>
			<!-- 페이지번호버튼(뒤로) -->
			<c:if test="${endPage < totalPage}">
				<li class="page-item"><a href="bomView.do?page=${endPage+1}" class="page-link"><i class="fas fa-forward"></i></a></li>
				<li class="page-item"><a href="bomView.do?page=${totalPage}" class="page-link"><i class="fas fa-fast-forward"></i></a></li>
			</c:if>
		</ul>
	</div>
	<hr>
	<nav class="justify-content-center navbar navbar-expand-md" style="background-color: #008080;" >
		<div align="center"></div>
	</nav>
</div>
</body>
</html>
