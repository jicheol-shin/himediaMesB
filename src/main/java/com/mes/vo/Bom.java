package com.mes.vo;

public class Bom {

	private String compCd;// 제품코드
	private String itemCd;// 부품코드
	private String itemName;// 부품명
	private Integer itemCnt;// 소요량
	private String unit;// 단위
	private Integer price;// 단가
	private String custCd;// 거래처코드
	private String remark;// 비고
	
	public String getCompCd() {
		return compCd;
	}
	public void setCompCd(String compCd) {
		this.compCd = compCd;
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
	public Integer getItemCnt() {
		return itemCnt;
	}
	public void setItemCnt(Integer itemCnt) {
		this.itemCnt = itemCnt;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public String getCustCd() {
		return custCd;
	}
	public void setCustCd(String custCd) {
		this.custCd = custCd;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
}
