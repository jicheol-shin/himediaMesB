package com.mes.vo;

public class Quality {
	
	private String workOrderNo;// 작업지시번호
	private String productCd;// 제품코드
	private int workQty;// 수량
	private String inUserId;// 검수자
	private String process;// 프로세스
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
	public int getWorkQty() {
		return workQty;
	}
	public void setWorkQty(int workQty) {
		this.workQty = workQty;
	}
	public String getInUserId() {
		return inUserId;
	}
	public void setInUserId(String inUserId) {
		this.inUserId = inUserId;
	}
	public String getProcess() {
		return process;
	}
	public void setProcess(String process) {
		this.process = process;
	}
	public String getTestDate() {
		return TestDate;
	}
	public void setTestDate(String testDate) {
		TestDate = testDate;
	}
	

	
	
	
}
