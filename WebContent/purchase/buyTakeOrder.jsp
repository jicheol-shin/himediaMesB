
<%@page import="com.mes.vo.OrderStatement"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.mes.service.OrderStatementService"%>
<%@page import="com.mes.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
   Member member = (Member) session.getAttribute("login_info");

   OrderStatementService orderStatementService = new OrderStatementService();
   ArrayList<OrderStatement> orderStatementList = (ArrayList<OrderStatement>) request.getAttribute("OrderStatementList");
%>
<c:set var="OrderStatementService" value="<%=orderStatementList %>"/>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css" 
      	  integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ"
	  	  crossorigin="anonymous">  
	<link rel="stylesheet" href="http://code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css"/> <!-- 달력 -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>	
	<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
	<script src="http://code.jquery.com/jquery-1.11.0.min.js"></script> <!-- 달력 -->
    <script src="http://code.jquery.com/ui/1.11.4/jquery-ui.min.js"></script> <!-- 달력 -->
    <!-- datepicker 한국어로 -->
    <script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/i18n/datepicker-ko.js"></script> <!-- 달력 -->
	<script>                

        $(document).ready(function() {

            //datepicker 한국어로 사용하기 위한 언어설정
            $.datepicker.setDefaults($.datepicker.regional['ko']);     
        
            // Datepicker            
            $(".datepicker").datepicker({
                showButtonPanel: true,
                dateFormat: "yy-mm-dd",
                onClose : function ( selectedDate ) {
                
                    var eleId = $(this).attr("id");
                    var optionName = "";

                    if(eleId.indexOf("StartDate") > 0) {
                        eleId = eleId.replace("StartDate", "EndDate");
                        optionName = "minDate";
                    } else {
                        eleId = eleId.replace("EndDate", "StartDate");
                        optionName = "maxDate";
                    }

                    $("#"+eleId).datepicker( "option", optionName, selectedDate );        
                    $(".searchDate").find(".chkbox2").removeClass("on"); 
                }
            }); 

            //시작일.
            /*$('#searchStartDate').datepicker("option","onClose", function( selectedDate ) {    
                // 시작일 datepicker가 닫힐때
                // 종료일의 선택할수있는 최소 날짜(minDate)를 선택한 시작일로 지정
                $("#searchEndDate").datepicker( "option", "minDate", selectedDate );
                $(".searchDate").find(".chkbox2").removeClass("on");
            });
            */

            //종료일.
            /*$('#searchEndDate').datepicker("option","onClose", function( selectedDate ) {    
                // 종료일 datepicker가 닫힐때
                // 시작일의 선택할수있는 최대 날짜(maxDate)를 선택한 종료일로 지정 
                $("#searchStartDate").datepicker( "option", "maxDate", selectedDate );
                $(".searchDate").find(".chkbox2").removeClass("on");
            });
            */

            $(".dateclick").dateclick();    // DateClick
            $(".searchDate").schDate();        // searchDate
            
        });

        // Search Date
        jQuery.fn.schDate = function(){
            var $obj = $(this);
            var $chk = $obj.find("input[type=radio]");
            $chk.click(function(){                
                $('input:not(:checked)').parent(".chkbox2").removeClass("on");
                $('input:checked').parent(".chkbox2").addClass("on");                    
            });
        };

        // DateClick
        jQuery.fn.dateclick = function(){
            var $obj = $(this);
            $obj.click(function(){
                $(this).parent().find("input").focus();
            });
        }    

        
        function setSearchDate(start){

            var num = start.substring(0,1);
            var str = start.substring(1,2);

            var today = new Date();

            //var year = today.getFullYear();
            //var month = today.getMonth() + 1;
            //var day = today.getDate();
            
            var endDate = $.datepicker.formatDate('yy-mm-dd', today);
            $('#searchEndDate').val(endDate);
            
            if(str == 'd'){
                today.setDate(today.getDate() - num);
            }else if (str == 'w'){
                today.setDate(today.getDate() - (num*7));
            }else if (str == 'm'){
                today.setMonth(today.getMonth() - num);
                today.setDate(today.getDate() + 1);
            }

            var startDate = $.datepicker.formatDate('yy-mm-dd', today);
            $('#searchStartDate').val(startDate);
                    
            // 종료일은 시작일 이전 날짜 선택하지 못하도록 비활성화
            $("#searchEndDate").datepicker( "option", "minDate", startDate );
            
            // 시작일은 종료일 이후 날짜 선택하지 못하도록 비활성화
            $("#searchStartDate").datepicker( "option", "maxDate", endDate );

        }   
	</script>
	
	<style type="text/css">

		.logtext { font-size: 12px; width:80px;}
		
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
			background-color: #b3b3ff;
			color: #001a66;
		}
		
		ul {
			list-style-type: none;
			font-size: 30px;
			color: #4d2600;
		}
		
		tbody {
			font-size: 18px
		}
		
		.btn-info {
			background-color: #0073e6;
			color:#ffffe6;
			width: 100px;
		}
		.btn-info:hover {
			background-color: #000066;
		}
		
		/* 달력 */
		input[type=text],input[type=password]{font-family:"Malgun Gothic","맑은 고딕",Dotum,"돋움",Arial,sans-serif}
        *{margin:0;padding:0;font-family:"Malgun Gothic","맑은 고딕",Dotum,"돋움",Arial,sans-serif}
        body{font-size:12px;color:#555;background:transparent;-webkit-user-select:none;-moz-user-select:none;-webkit-text-size-adjust:none;-moz-text-size-adjust:none;-ms-text-size-adjust:none}
        ol,ul{list-style:none} 
        table{table-layout:fixed;width:100%;border-collapse:collapse;border-spacing:0}
        caption{overflow:hidden;width:0;height:0;font-size:0;line-height:0;text-indent:-999em}
        img,fieldset{border:0}
        legend{height:0;visibility:hidden}
        em,address{font-style:normal}
        img{border:0 none;vertical-align:middle}
        a{color:#555;text-decoration:none}
        input,select{margin:0;padding:0;vertical-align:middle}
        button{margin:0;padding:0;font-family:inherit;border:0 none;background:transparent;cursor:pointer}
        button::-moz-focus-inner{border:0;padding:0}
        header,footer,aside,nav,section,article{display:block}

        .clearfix{*zoom:1}
        .clearfix:after{content:"";display:block;clear:both;overflow:hidden}

        /* Search */
        .searchBox{border:none}
        .searchBox tbody th{padding:20px 10px 20px 35px;font-size:14px;font-weight:bold;text-align:left;vertical-align:top;border:none;background:#e6e6e6 }
        .searchBox tbody td{padding:12px 10px 12px 25px;border:none;background-color:#efefef}
        
        .searchDate{overflow:hidden;margin-bottom:10px;*zoom:1}
        .searchDate:after{display:block;clear:both;content:''}
        .searchDate li{position:relative;float:left;margin:0 7px 0 0}
        .searchDate li .chkbox2{display:block;text-align:center}
        .searchDate li .chkbox2 input{position:absolute;z-index:-1}
        .searchDate li .chkbox2 label{display:block;width:72px;height:26px;font-size:14px;font-weight:bold;color:#fff;text-align:center;line-height:25px;text-decoration:none;cursor:pointer;background:#a5b0b6}
        .searchDate li .chkbox2.on label{background:#ec6a6a}
        
        .demi{display:inline-block;margin:0 1px;vertical-align:middle}
        .inpType{padding-left:6px;height:24px;line-height:24px;border:1px solid #dbdbdb}
        .btncalendar{display:inline-block;width:22px;height:22px;background:url(images/btn_calendar.gif) center center no-repeat;text-indent:-999em}
	</style>
	
	<title>Himedia MES_B</title>
</head>
<body>
  <div class="container">
   <div class="bs-component">
   <br />
   <nav class="navbar navbar-expand-md font-weight-bold" style="background-color: #e3f2fd;">
	 <a class="navbar-brand" href="/index.do">Himedia MES</a>
	 <%@ include file="../main/menu.jsp" %>
	 
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

	       <li ><a href="#" class="font-weight-bold text-dark logtext logtext"><%=member.getUserName()%>님</a></li>  
	       <li ><a href="../logout.do" class="font-weight-bold text-dark logtext logtext">로그아웃</a></li>

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
	      <li class ="list-group-item font-weight-bold" align="center" style="background-color: #d1d1e0;">발주내역</li>
	    </ul>
	  </div>
	  <br />
	  <form> 
  <!-- search -->
  <table class="searchBox">
    <caption>조회</caption>
      <colgroup>
        <col width="123px">
        <col width="*">
      </colgroup>
  <tbody>
    <tr>
      <th>조회기간</th>
        <td>
          <ul class="searchDate">
            <li>
              <span class="chkbox2">
               <input type="radio" name="dateType" id="dateType1" onclick="setSearchDate('0d')"/>
               <label for="dateType1">당일</label>
              </span>
            </li>
            <li>
              <span class="chkbox2">
                <input type="radio" name="dateType" id="dateType2" onclick="setSearchDate('3d')"/>
                <label for="dateType2">3일</label>
              </span>
            </li>
            <li>
              <span class="chkbox2">
                <input type="radio" name="dateType" id="dateType3" onclick="setSearchDate('1w')"/>
                <label for="dateType3">1주</label>
              </span>
            </li>
            <li>
              <span class="chkbox2">
                <input type="radio" name="dateType" id="dateType4" onclick="setSearchDate('2w')"/>
                <label for="dateType4">2주</label>
              </span>
            </li>
            <li>
              <span class="chkbox2">
                <input type="radio" name="dateType" id="dateType5" onclick="setSearchDate('1m')"/>
                <label for="dateType5">1개월</label>
              </span>
            </li>
            <li>
              <span class="chkbox2">
                <input type="radio" name="dateType" id="dateType6" onclick="setSearchDate('3m')"/>
                <label for="dateType6">3개월</label>
              </span>
            </li>
            <li>
              <span class="chkbox2">
                <input type="radio" name="dateType" id="dateType7" onclick="setSearchDate('6m')"/>
                <label for="dateType7">6개월</label>
              </span>
            </li>
           </ul>
                        
         <div class="clearfix">
         <!-- 시작일 -->
           <span class="dset">
            <input type="text" class="datepicker inpType" name="searchStartDate" id="searchStartDate" >
            <a href="#none" class="btncalendar dateclick"><i class="far fa-calendar-alt">달력</i></a>
           </span>
           <span class="demi">~</span>
         <!-- 종료일 -->
           <span class="dset">
            <input type="text" class="datepicker inpType" name="searchEndDate" id="searchEndDate" >
            <a href="#none" class="btncalendar dateclick">달력</a>
            <a href="/buyTakeOrder.do"><button type="submit" class="btn btn-info" onclick="location.href='buyTakeOrder.do';" style="font-size: 15px;">조회</button></a>
           </span>
         </div>    
        </td>
    </tr>

  <tbody>
  </table>
 </form>
  <br />
	  <table class="table table-striped table-condensed" style="font-size: 12px">
	  	<thead class="thead-dark" align="center" style="font-size: 13px">
	  		<tr>
			  <th>순번</th>
			  <th>수주코드</th>
			  <th>부품코드</th>
			  <th>부품명</th>
			  <th>발주일</th>
			  <th>재고량</th>
			  <th>발주량</th>
			  <th>단가</th>
			  <th>합계</th>
			  <th>거래처코드</th>
			  <th>소요일</th>
			  <th>비고</th>
	  		</tr>
	  	</thead>
	  	<tbody align="center">
	  	
	  		<c:forEach var="orderStatementList" items="${orderStatementService}">
			<tr>
			  <td>${orderStatementList.getNum()}</td>
			  <td>${orderStatementList.getOrdCd()}</td>
			  <td>${orderStatementList.getItemCd()}</td>
			  <td>${orderStatementList.getItemName()}</td>
			  <td>${orderStatementList.getOrderDate()}</td>
			  <td>${orderStatementList.getItemCnt()}</td>
			  <td>${orderStatementList.getOrderCnt()}</td>
			  <td>${orderStatementList.getUnitPrice()}</td>
			  <td>${orderStatementList.getSumPrice()}</td>
			  <td>${orderStatementList.getVendorCd()}</td>
			  <td>${orderStatementList.getLeadTime()}</td>
			  <td>${orderStatementList.getRemark()}</td>
			</tr>
	  		</c:forEach>
	  	</tbody>
	  </table>
	</div>
	<br />
	<br />
	<nav class="justify-content-center navbar navbar-expand-md" style="background-color: #e3f2fd;" >
	  <div align="center">
	    <a href="../index.do"><button type="button" class="btn btn-info btn-lg btn-block" onclick="location.href='index.do';" style="font-size: 20px;">HOME</button></a>
	  </div>
    </nav> 
</div>
</body>
</html>