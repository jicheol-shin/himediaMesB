package com.mes.vo;
//변수첫글자 소문자
public class ProductionView {
	private String workOrderDate;  // 수주일자
	private String workOrderNo;   // 작업지시번호
	private String productCd;   // 제품코드
	private String orderCd;    // 수주코드
	private String lineCd;   // 라인코드
	private String inUserId;  // 작업자
	private int workQty; // 생산수량
	private int orderCnt;  // 수주수량
	private String process;// 프로세스
	private String startDate; //생산시작일
	private String endDate;   //생산완료일
	
	public String getWorkOrderDate() {
		return workOrderDate;
	}
	public void setWorkOrderDate(String workOrderDate) {
		this.workOrderDate = workOrderDate;
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
	public String getOrderCd() {
		return orderCd;
	}
	public void setOrderCd(String orderCd) {
		this.orderCd = orderCd;
	}
	public String getLineCd() {
		return lineCd;
	}
	public void setLineCd(String lineCd) {
		lineCd = lineCd;
	}
	public String getInUserId() {
		return inUserId;
	}
	public void setInUserId(String inUserId) {
		this.inUserId = inUserId;
	}
	public int getWorkQty() {
		return workQty;
	}
	public void setWorkQty(int workQty) {
		this.workQty = workQty;
	}
	public int getOrderCnt() {
		return orderCnt;
	}
	public void setOrderCnt(int orderCnt) {
		this.orderCnt = orderCnt;
	}
	public String getProcess() {
		return process;
	}
	public void setProcess(String process) {
		this.process = process;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		endDate = endDate;
	}
	

	
	
}
