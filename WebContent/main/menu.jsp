<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<style>
.btn{font-size: 13px;}
.dropdown-menu{width:20px; font-size:13px}
</style>
<div class="container" >
  <div class="dropdown">
    <button class="btn btn-default dropdown-toggle" type="button" id="menu1" data-toggle="dropdown">기본정보관리
    <span class="caret"></span></button>
    <ul class="dropdown-menu" role="menu" aria-labelledby="menu1">
      <li role="presentation"><a role="menuitem" tabindex="-1" href="item.do">부품관리</a></li>
      <li role="presentation"><a role="menuitem" tabindex="-1" href="product.do">완제품관리</a></li>
      <li role="presentation"><a role="menuitem" tabindex="-1" href="vendor.do">거래처관리</a></li>
      <li role="presentation"><a role="menuitem" tabindex="-1" href="bomView.do">BOM관리</a></li>
      <li role="presentation"><a role="menuitem" tabindex="-1" href="line.do">라인관리</a></li>
      <li role="presentation"><a role="menuitem" tabindex="-1" href="memberView.do">사용자관리</a></li>
      <li role="presentation"><a role="menuitem" tabindex="-1" href="errorProduce.do">불량관리</a></li>
    </ul>
  </div>
  <div class="dropdown">
    <button class="btn btn-default dropdown-toggle" type="button" id="menu2" data-toggle="dropdown">영업관리
    <span class="caret"></span></button>
    <ul class="dropdown-menu" role="menu" aria-labelledby="menu2">
      <li role="presentation"><a role="menuitem" tabindex="-1" href="takeOrderView.do">수주관리</a></li>
      <li role="presentation"><a role="menuitem" tabindex="-1" href="releaseProductView.do">출하관리</a></li>
    </ul>
  </div>
  <div class="dropdown">
    <button class="btn btn-default dropdown-toggle" type="button" id="menu3" data-toggle="dropdown">구매관리
    <span class="caret"></span></button>
    <ul class="dropdown-menu" role="menu" aria-labelledby="menu3">
      <li role="presentation"><a role="menuitem" tabindex="-1" href="takeOrderPurchase.do">구매발주관리</a></li>
      <li role="presentation"><a role="menuitem" tabindex="-1" href="buyTakeOrder.do">발주내역</a></li>
    </ul>
  </div>
  <div class="dropdown">
    <button class="btn btn-default dropdown-toggle" type="button" id="menu4" data-toggle="dropdown">생산관리
    <span class="caret"></span></button>
    <ul class="dropdown-menu" role="menu" aria-labelledby="menu4">
      <li role="presentation"><a role="menuitem" tabindex="-1" href="production.do">생산지시</a></li>
      <li role="presentation"><a role="menuitem" tabindex="-1" href="prodcutionLine.do">공정관리</a></li>
      <li role="presentation"><a role="menuitem" tabindex="-1" href="#">생산현황관리</a></li>
    </ul>
  </div>
  <div class="dropdown">
    <button class="btn btn-default dropdown-toggle" type="button" id="menu5" data-toggle="dropdown">품질관리
    <span class="caret"></span></button>
    <ul class="dropdown-menu" role="menu" aria-labelledby="menu5">
      <li role="presentation"><a role="menuitem" tabindex="-1" href="#">품질관리</a></li>
    </ul>
  </div>
  <div class="dropdown">
    <button class="btn btn-default dropdown-toggle" type="button" id="menu6" data-toggle="dropdown">자재/창고관리
    <span class="caret"></span></button>
    <ul class="dropdown-menu" role="menu" aria-labelledby="menu6">
      <li role="presentation"><a role="menuitem" tabindex="-1" href="itemstockInout.do">자재입출고현황</a></li>
      <li role="presentation"><a role="menuitem" tabindex="-1" href="itemstockOutOrder.do">자재불출관리</a></li>
      <li role="presentation"><a role="menuitem" tabindex="-1" href="itemstock.do">자재재고현황</a></li>
    </ul>
  </div>
  <div class="dropdown">
    <button class="btn btn-default dropdown-toggle" type="button" id="menu7" data-toggle="dropdown">물류관리
    <span class="caret"></span></button>
    <ul class="dropdown-menu" role="menu" aria-labelledby="menu7">
      <li role="presentation"><a role="menuitem" tabindex="-1" href="productInventory.do">제품재고관리</a></li>
      <li role="presentation"><a role="menuitem" tabindex="-1" href="releaseOrder.do">출고지시</a></li>
      <li role="presentation"><a role="menuitem" tabindex="-1" href="releaseOut.do">출고내역</a></li>
    </ul>
  </div>
</div>