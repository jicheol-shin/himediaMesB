package com.mes.vo;

import java.sql.Date;

public class ReleaseStatement {

	private int num;         // 순번
	private String finCd;    // 제품코드
	private String finName;  // 제품명
	private Date orderDate;  // 발주날짜
	private int goodCnt;     // 재고량
	private int orderCnt;    // 발주량
	private double price;    // 단가
	private double sumPrice; // 합계
	private String remark;   // 비고
	
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getFinCd() {
		return finCd;
	}
	public void setFinCd(String finCd) {
		this.finCd = finCd;
	}
	public String getFinName() {
		return finName;
	}
	public void setFinName(String finName) {
		this.finName = finName;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public int getGoodCnt() {
		return goodCnt;
	}
	public void setGoodCnt(int goodCnt) {
		this.goodCnt = goodCnt;
	}
	public int getOrderCnt() {
		return orderCnt;
	}
	public void setOrderCnt(int orderCnt) {
		this.orderCnt = orderCnt;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getSumPrice() {
		return sumPrice;
	}
	public void setSumPrice(double sumPrice) {
		this.sumPrice = sumPrice;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
}
