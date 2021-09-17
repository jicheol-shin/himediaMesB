package com.mes.vo;

public class Quality {
	
	private String PartNo;// 작업지시번호
	private String ItemCd;// 제품코드
	private String Quantity;// 수량
	private String InUsrId;// 검수자
	private String FinCd;// 완제품코드
	private String TestDate;// 검사일
	public String getPartNo() {
		return PartNo;
	}
	public void setPartNo(String partNo) {
		PartNo = partNo;
	}
	public String getItemCd() {
		return ItemCd;
	}
	public void setItemCd(String itemCd) {
		ItemCd = itemCd;
	}
	public String getQuantity() {
		return Quantity;
	}
	public void setQuantity(String quantity) {
		Quantity = quantity;
	}
	public String getInUsrId() {
		return InUsrId;
	}
	public void setInUsrId(String inUsrId) {
		InUsrId = inUsrId;
	}
	public String getFinCd() {
		return FinCd;
	}
	public void setFinCd(String finCd) {
		FinCd = finCd;
	}
	public String getTestDate() {
		return TestDate;
	}
	public void setTestDate(String testDate) {
		TestDate = testDate;
	}

	
	
	
}
