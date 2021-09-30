package com.mes.vo;

public class Quality {
	
	private String workOrderNo;// 작업지시번호
	private String productCd;// 제품코드
	private String inUserId;// 검수자
	private int goodCnt;
	private int badCnt;
	private String TestDate;// 검사일
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
	public String getInUserId() {
		return inUserId;
	}
	public void setInUserId(String inUserId) {
		this.inUserId = inUserId;
	}
	public int getGoodCnt() {
		return goodCnt;
	}
	public void setGoodCnt(int goodCnt) {
		this.goodCnt = goodCnt;
	}
	public int getBadCnt() {
		return badCnt;
	}
	public void setBadCnt(int badCnt) {
		this.badCnt = badCnt;
	}
	public String getTestDate() {
		return TestDate;
	}
	public void setTestDate(String testDate) {
		TestDate = testDate;
	}
	
	
	
	
}
