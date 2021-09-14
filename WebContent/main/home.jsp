<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
   // MemberVO member = (MemberVO) session.getAttribute("login_info");
   String member = null;
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

	ul {
		list-style-type: none;
		background-color: #ccc;
		width: 254px;
		padding: 0;
		margin:  0;
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
<h1></h1>
<div class="container">
   <div class="bs-component">
   <br />
   <nav class="navbar navbar-expand-md bg-dark navbar-dark">
	 <a class="navbar-brand" href="#">Himedia MES</a>
	 <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
    	 <span class="navbar-toggler-icon"></span>
 	 </button>
     <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1" >
    	<c:choose>
          <c:when test="<%=member == null %>" > 
    	    <a class="nav-link" href="#" data-toggle="modal" data-target="#login">
        	  로그인
            </a>
          </c:when>  
  	    <c:otherwise>
	       <li ><a href="#" class='text-primary'>xxxxx님</a></li>  
        </c:otherwise>
      </c:choose>	 
     </div>  
		<div class="modal" id="login">
		  <div class="modal-dialog">
		    <div class="modal-content">
		      <div class="modal-header">
		        <h4 class="modal-title">로그인</h4>
		      </div>
		      <div class="modal-body">
				<form action="" class="was-validated">
					<div class="form-group">
						<label for="userId">아이디  </label>
						<input type="text" class="form-control" id="userId" placeholder="Enter ID" name="userId" required>
					</div>
					<div class="form-group">
						<label for="userPw">비밀번호 </label>
						<input type="password" class="form-control" id="userPw" placeholder="Enter Password" name="userPw" required>
					</div>
					<button type="submit" class="btn btn-primary" style="margin-left:50%;">로그인</button>
					<button type="button" class="btn btn-danger" data-dismiss="modal">취소</button> 
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
	      <div class="p-3 border bg-info" align="center">기본정보관리</div>
	      <div> 
		      <ul>
				   <li><a href="#" >기본정보관리1</a></li>
				   <li><a href="#" >기본정보관리2</a></li>
				   <li><a href="#" >기본정보관리3</a></li>
				   <li><a href="#" >기본정보관리4</a></li>
		      </ul>
		   </div>   
	   	 </div>
	    <div class="col">
	      <div class="p-3 border bg-info" align="center">영업관리</div>
	      <div> 
		      <ul>
				   <li><a href="#" >영업관리1</a></li>
				   <li><a href="#" >영업관리2</a></li>
				   <li><a href="#" >영업관리3</a></li>
				   <li><a href="#" >영업관리4</a></li>
		      </ul>
		   </div>   
	   	 </div>
	    <div class="col">
	      <div class="p-3 border bg-info"  align="center">구매관리</div>
	      <div> 
		      <ul>
				   <li><a href="#" >구매관리1</a></li>
				   <li><a href="#" >구매관리2</a></li>
				   <li><a href="#" >구매관리3</a></li>
				   <li><a href="#" >구매관리4</a></li>
		      </ul>
		   </div>   
	   	 </div>
	    <div class="col">
	      <div class="p-3 border bg-info" align="center">생산관리</div>
	      <div> 
		      <ul>
				   <li><a href="#" >생산관리1</a></li>
				   <li><a href="#" >생산관리2</a></li>
				   <li><a href="#" >생산관리3</a></li>
				   <li><a href="#" >생산관리4</a></li>
		      </ul>
		   </div>   
	   	 </div>
	   	</div>
	   <br />
	   <br />
	  <div class="row row-cols-2 row-cols-lg-4 g-2 g-lg-4">
	      <div class="col">
		      <div class="p-3 border bg-info" align="center">품질관리</div>
		      	<div> 
			      <ul>
					   <li><a href="#" >품질관리1</a></li>
					   <li><a href="#" >품질관리2</a></li>
					   <li><a href="#" >품질관리3</a></li>
					   <li><a href="#" >품질관리4</a></li>
			      </ul>
			  </div>   
		  </div>
	      <div class="col">
		      <div class="p-3 border bg-info" align="center">자재/창고관리</div>
		      	<div> 
			      <ul>
					   <li><a href="#" >자재관리1</a></li>
					   <li><a href="#" >자재관리2</a></li>
					   <li><a href="#" >자재관리3</a></li>
					   <li><a href="#" >자재관리4</a></li>
			      </ul>
			  </div>   
		  </div>
	      <div class="col">
		      <div class="p-3 border bg-info" align="center">물류관리</div>
		      	<div> 
			      <ul>
					   <li><a href="#" >창고관리1</a></li>
					   <li><a href="#" >창고관리2</a></li>
					   <li><a href="#" >창고관리3</a></li>
					   <li><a href="#" >창고관리4</a></li>
			      </ul>
			  </div>   
		  </div>
	   </div>
	</div><br /><br />
	
    <nav class="navbar navbar-expand-md bg-dark navbar-dark">
    </nav>  
</div>
</body>
</html>