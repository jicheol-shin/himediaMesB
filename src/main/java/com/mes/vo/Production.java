package com.mes.vo;

import java.util.Date;

public class Production {
	private Date workOrderDate;  // 작업지시일
	private String workOrderNo;  // 작업지시번호
	private String productCd;    // 제품코드
	private String ordCd;        // 수주코드
	private String lineCd;       // 라인코드
	private String inUsrId;      // 작업자
	private int workQty;         // 생산수량
	private int ordCnt;          // 수주수량
	private String workProcess;  // 작업진행현황 
	private Date startDate;      //생산시작일
	private Date endDate;        //생산완료일

	
	
	public Date getWorkOrderDate() {
		return workOrderDate;
	}
	public void setWorkOrderDate(Date workOrderDate) {
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
	public String getOrdCd() {
		return ordCd;
	}
	public void setOrdCd(String ordCd) {
		this.ordCd = ordCd;
	}
	public String getLineCd() {
		return lineCd;
	}
	public void setLineCd(String lineCd) {
		this.lineCd = lineCd;
	}
	public String getInUsrId() {
		return inUsrId;
	}
	public void setInUsrId(String inUsrId) {
		this.inUsrId = inUsrId;
	}
	public int getWorkQty() {
		return workQty;
	}
	public void setWorkQty(int workQty) {
		this.workQty = workQty;
	}
	public int getOrdCnt() {
		return ordCnt;
	}
	public void setOrdCnt(int ordCnt) {
		this.ordCnt = ordCnt;
	}
	public String getWorkProcess() {
		return workProcess;
	}
	public void setWorkProcess(String workProcess) {
		this.workProcess = workProcess;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	
	
	
	
}
