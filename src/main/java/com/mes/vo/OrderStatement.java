package com.mes.vo;

import java.sql.Date;

public class OrderStatement {

	private int num;           // 순번
	private String ordCd;      // 수주코드
	private String itemCd;     // 부품코드
	private String itemName;   // 부품명
	private Date orderDate;    // 발주일
	private int itemCnt;       // 재고량
	private int orderCnt;      // 발주량
	private double unitPrice;  // 단가
	private double sumPrice;   // 합계
	private String vendorCd;   // 거래처코드
	private int leadTime;      // 소요일
	private String remark;     // 비고
	
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getOrdCd() {
		return ordCd;
	}
	public void setOrdCd(String ordCd) {
		this.ordCd = ordCd;
	}
	public String getItemCd() {
		return itemCd;
	}
	public void setItemCd(String itemCd) {
		this.itemCd = itemCd;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public int getitemCnt() {
		return itemCnt;
	}
	public void setitemCnt(int itemCnt) {
		this.itemCnt = itemCnt;
	}
	public int getOrderCnt() {
		return orderCnt;
	}
	public void setOrderCnt(int orderCnt) {
		this.orderCnt = orderCnt;
	}
	public double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}
	public double getSumPrice() {
		return sumPrice;
	}
	public void setSumPrice(double sumPrice) {
		this.sumPrice = sumPrice;
	}
	public String getvendorCd() {
		return vendorCd;
	}
	public void setvendorCd(String vendorCd) {
		this.vendorCd = vendorCd;
	}
	public int getLeadTime() {
		return leadTime;
	}
	public void setLeadTime(int leadTime) {
		this.leadTime = leadTime;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
}
