package com.mes.vo;

public class Item {

	private String itemCd;// 부품코드
	private String itemName;// 부품명
	private String itemType;// 구분
	private String vendorCd;// 거래처코드
	private double unitPrice;// 표준단가
	private int leadTime;// 유통기한
	private String remark;// 비고
	
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
	public String getItemType() {
		return itemType;
	}
	public void setItemType(String itemType) {
		this.itemType = itemType;
	}
	public String getVendorCd() {
		return vendorCd;
	}
	public void setVendorCd(String vendorCd) {
		this.vendorCd = vendorCd;
	}
	public double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
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
