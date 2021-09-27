package com.mes.vo;

public class ProductInventory {

	private int num;            // 순번
	private String productCd;   // 제품코드
	private String productName; // 제품명
	private int goodCount;        // 양품수량
	private int badCount;         // 불량수량
	private String storeCd;     // 보관창고
	private String remark;      // 비고
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
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
	public int getgoodCount() {
		return goodCount;
	}
	public void setgoodCount(int goodCount) {
		this.goodCount = goodCount;
	}
	public int getbadCount() {
		return badCount;
	}
	public void setbadCount(int badCount) {
		this.badCount = badCount;
	}
	public String getStoreCd() {
		return storeCd;
	}
	public void setStoreCd(String storeCd) {
		this.storeCd = storeCd;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
}
