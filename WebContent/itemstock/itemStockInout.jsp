<%@page import="com.mes.utility.Pager"%>
<%@page import="com.mes.vo.ItemStockInout"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.mes.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
   Member member = (Member) session.getAttribute("login_info");
   ArrayList<ItemStockInout> itemStockInoutList = (ArrayList<ItemStockInout>) request.getAttribute("itemStockInoutList");
   Pager pager = (Pager) request.getAttribute("pageInfo");
   int curPage = pager.getPageNum();
   int totalPage = pager.getTotalPage();
   int startPage = pager.getStartPage();
   int endPage = pager.getEndPage();
%>
<c:set var="itemStockInout_data" value="<%=itemStockInoutList%>"/>
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
	
	/* tr :hover {
		background-color: skyblue;
	} */

	ul.class-box {
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
</style>
<title>Himedia MES_B</title>
</head>
<body>
<div class="container">
   <div class="bs-component">
   <br />
    <nav class="navbar navbar-expand-md font-weight-bold" style="background-color: #008080;">
	 <a class="navbar-brand" href="/index.do" style="color: #fff">Himedia MES</a>
     <%@ include file="../main/menu.jsp"%>
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

	       <li ><a href="#" class='text-white logtext'><%=member.getUserName()%>님</a></li>  
	       <li ><a href="../logout.do" class="font-weight-bold logtext">로그아웃</a></li>

        </c:otherwise>
      </c:choose>	 
     </div>  
	</nav>
	</div>
	<br />
	<div class="container" align="center" style="height: 100%">
	   <div align="center">
		 <ul class="list-group class-box" >
            <li class="list-group-item font-weight-bold" style="background-color: #33334d;">자재 입출고 현황</li>
		</ul>
	  </div>
		<br />
	   <div align="right">
	    <form action="itemstockInout.do" method="post">
		 <ul class="list-group list-group-flush" >
            <li class="list-group-item">
             <select name="stockInout">
				<option>입출고 선택</option>
				<option value="IN">입고내역</option>
				<option value="OUT">출고내역</option>
			</select>	
           	<input type="submit"  value="조회"/>
            </li>
		</ul>
		</form>
	  </div>
      <table class="table table-striped table-condensed" style="font-size: 15px">
		 <thead class="thead-dark">
			<tr>
				<th>순번</th>
				<th>입출고분류</th>
				<th>부품코드</th>
				<th>부품명</th>
				<th>입출고시간</th>
				<th>입출고유형</th>				
				<th>창고명</th>				
				<th>이동창고</th>				
				<th>수량</th>
				<th>입고처</th>
				<th>비고</th>				
			</tr>
			</thead>

			<c:forEach var="itemStock" items="${itemStockInout_data}">
			<tr>
				<td>${itemStock.getNum()}</td>
				<td>${itemStock.getInoutCd()}</td>
				<td>${itemStock.getItemCd()}</td>
				<td>${itemStock.getItemName()}</td>
				<td>${itemStock.getIntoutDate()}</td>
				<td>${itemStock.getInoutType()}</td>
				<td>${itemStock.getStoreCd()}</td>
				<td>${itemStock.getInoutPlant()}</td>
				<td align="center"><fmt:formatNumber value="${itemStock.getItemCnt()}" pattern="#,###"/>
				<td>${itemStock.getVendorName()}</td>
				<td>${itemStock.getRemark()}</td>
			</tr>
			</c:forEach>
		</table>
	</div>	

	<div class="container" align="center">
		<ul class="pagination justify-content-center">
			<c:if test="${startPage ne 1}">
				<li class="page-item"><a href="itemstockInout.do?page=1" class="page-link"><i class="fas fa-fast-backward"></i></a></li>
				<li class="page-item"><a href="itemstockInout.do?page=${page_num-10}" class="page-link"><i class="fas fa-backward"></i></a></li>
			</c:if>
				<c:forEach var="page_num" begin="${startPage}" end="${endPage}" step="1">
					<li class="page-item"><a class="page-link" href="itemstockInout.do?page=${page_num}" >${page_num}</a></li>
				</c:forEach>
			<c:if test="${endPage < totalPage}">
				<li class="page-item"><a href="itemstockInout.do?page=${endPage+1}" class="page-link"><i class="fas fa-forward"></i></a></li>
				<li class="page-item"><a href="itemstockInout.do?page=${totalPage}" class="page-link"><i class="fas fa-fast-forward"></i></a></li>
			</c:if>
		</ul>
	</div>
	<hr />
  	<nav class="justify-content-center navbar navbar-expand-md" style="background-color: #008080;" >
    </nav>  
</div>
</body>
</html>