package com.mes.vo;

import java.util.Date;

public class ItemStockOutOrder {
	
	private int num;               //순번
	private Date workOrderDate;    //작업지시일
	private Date itemStockOutDate; //자재불출일
	private String workOrderNo;    //작업지시번호
	private String productCd;      //제품코드
	private String productName;    //제품명
	private String lineNo;         //라인번호
	private int    workQty;        //작업지시 수량
	private String issue;          //자재불출 상태	불출대기/불출완료
	private String remark;         //비고

	
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public Date getWorkOrderDate() {
		return workOrderDate;
	}
	public void setWorkOrderDate(Date workOrderDate) {
		this.workOrderDate = workOrderDate;
	}
	public Date getItemStockOutDate() {
		return itemStockOutDate;
	}
	public void setItemStockOutDate(Date itemStockOutDate) {
		this.itemStockOutDate = itemStockOutDate;
	}
	public String getWorkOrderNo() {
		return workOrderNo;
	}
	public void setWorkOrderNo(String workOrderNo) {
		this.workOrderNo = workOrderNo;
	}
	public String getProductCd() {
		return productCd;
	}
	public void setProductCd(String productCd) {
		this.productCd = productCd;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getLineNo() {
		return lineNo;
	}
	public void setLineNo(String lineNo) {
		this.lineNo = lineNo;
	}
	public int getWorkQty() {
		return workQty;
	}
	public void setWorkQty(int workQty) {
		this.workQty = workQty;
	}
	public String getIssue() {
		return issue;
	}
	public void setIssue(String issue) {
		this.issue = issue;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
}
