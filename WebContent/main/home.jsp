<%@page import="com.mes.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
   Member member = (Member) session.getAttribute("login_info");
  
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
    .btn{font-size: 12px;}               /* 로그인창 - 로그인버튼 글자크기 */
    
	ul { 							     /* 메뉴 백그라운드 설정 */
		list-style-type: none;
		background-color: #d1d1e0;
		width: 254px;
		padding: 0;
		margin:  0;
	}
	
	li {                                 /* 제목테이블 */
		list-style-type: none;
	}

	li a {                               /* 메뉴 상단  */
		text-decoration: none;
		display: block;
		color: #000;
		padding: 8px 15px 8px 15px;
	}
	a:link {color: #fff;}
	a:hover{color:#ffcc00;}
	
	.p-3 {                               /* 제목 배경 */
		background-color: #33334d;
		color: #fff;
	}

	li a:hover {                         /* 메뉴 토글시 보이는 색 설정 */
			background-color: #ffffcc;
			color: #008080;
	}

</style>
<title>Himedia MES_B</title>
</head>
<body>
<h1></h1>
<div class="container">
   <div class="bs-component">
   <br />
   <nav class="navbar navbar-expand-md font-weight-bold" style="background-color: #008080;">
	 <a class="navbar-brand font-weight-bold" href="index.do" style="color: #fff">Himedia MES</a>
	 <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
    	 <span class="navbar-toggler-icon"></span>
 	 </button>
     <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1" >
    	<c:choose>
          <c:when test="<%=member == null %>" > 
    	    <a class="nav-link link-hover-color" href="#" data-toggle="modal" data-target="#login">
        	  로그인
            </a>
          </c:when>  
  	    <c:otherwise>

	       <li ><a href="#" class='text-white'><%=member.getUserName()%>님</a></li>  
	       <li ><a href="logout.do" class='text-info'>로그아웃</a></li>

        </c:otherwise>
      </c:choose>	 
     </div>
     
		<div class="modal" id="login">
		  <div class="modal-dialog">
		    <div class="modal-content">
		      <div class="modal-header text-info">
		        <h4 class="modal-title">로그인</h4>
		      </div>
		      <div class="modal-body">
				<form action="login.do" method="post" class="was-validated">
					<div class="form-group text-info">
						<label for="userId">아이디  </label>
						<input type="text" class="form-control" id="userId" placeholder="Enter ID" name="userId" required>
					</div>
					<div class="form-group text-info">
						<label for="userPw">비밀번호 </label>
						<input type="password" class="form-control" id="password" placeholder="Enter Password" name="password" required>
					</div>
					<button type="submit" class="btn btn-primary btn-lg" style="margin-left:36%;">로그인</button>
					<button type="button" class="btn btn-danger btn-lg" data-dismiss="modal">취소</button> 
				</form>
		      </div>
		    </div>
		  </div>
		</div>
		
	</nav>
	</div>
	<br />
	<div class="main">
	  <div class="row row-cols-2 row-cols-lg-4 g-2 g-lg-4">
	    <div class="col">
	      <div class="p-3 border font-weight-bold" align="center">기본정보관리</div>
	      <div> 
		      <ul>
				   <li><a href="item.do" >부품관리</a></li>
				   <li><a href="product.do" >완제품관리</a></li>
				   <li><a href="vendor.do" >거래처관리</a></li>
				   <li><a href="bomView.do" >BOM관리</a></li>
				   <li><a href="line.do" >라인관리</a></li>
				   <li><a href="memberView.do" >사용자관리</a></li>
				   <li><a href="errorProduce.do" >불량관리</a></li>
		      </ul>
		   </div>   
	   	 </div>
	    <div class="col">
	      <div class="p-3 border font-weight-bold" align="center">영업관리</div>
	      <div> 
		      <ul>
				   <li><a href="takeOrderView.do" >수주관리</a></li>
				   <li><a href="releaseProductView.do" >출하관리</a></li>
		      </ul>
		   </div>   
	   	 </div>
	    <div class="col">
	      <div class="p-3 border font-weight-bold"  align="center">구매관리</div>
	      <div> 
		      <ul>
				   <li><a href="takeOrderPurchase.do" >구매 발주 관리</a></li>
				   <li><a href="buyTakeOrder.do" >발주내역</a></li>
		      </ul>
		   </div>   
	   	 </div>
	    <div class="col">
	      <div class="p-3 border font-weight-bold" align="center">생산관리</div>
	      <div> 
		      <ul>
				   <li><a href="production.do" >생산지시</a></li>
				   <li><a href="prodcutionLine.do" >공정관리</a></li>
				   <li><a href="productionView.do" >생산지시현황</a></li>
		      </ul>
		   </div>   
	   	 </div>
	   	</div>
	   <br />
	   <br />
	  <div class="row row-cols-2 row-cols-lg-4 g-2 g-lg-4">
	      <div class="col">
		      <div class="p-3 border font-weight-bold" align="center">품질관리</div>
		      	<div> 
			      <ul>
					    <li><a href="quality.do" >품질관리</a></li>

			      </ul>
			  </div>   
		  </div>
	      <div class="col">
		      <div class="p-3 border font-weight-bold" align="center">자재/창고관리</div>
		      	<div> 
			      <ul>
					   <li><a href="itemstockInout.do" >자재 입출고현황</a></li>
					   <li><a href="itemstockOutOrder.do" >자재불출관리</a></li>
					   <li><a href="itemstock.do" >자재재고현황</a></li>
			      </ul>
			  </div>   
		  </div>
	      <div class="col">
		      <div class="p-3 border font-weight-bold" align="center">물류관리</div>
		      	<div> 
			      <ul>
					   <li><a href="productInventory.do" >제품 재고 관리</a></li>
					   <li><a href="releaseOrder.do" >출고 지시</a></li>
					   <li><a href="releaseOut.do" >출고 내역</a></li>
			      </ul>
			  </div>   
		  </div>
	   </div>
	</div>
	<br /><br />
   <nav class="navbar navbar-expand-md" style="background-color: #008080;" ">
    </nav>  
</div>
</body>
</html>