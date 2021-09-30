package com.mes.vo;
//변수첫글자 소문자
public class ProductionView {
	private String workOrderDate;  // 수주일자
	private String workOrderNo;   // 작업지시번호
	private String productCd;   // 제품코드
	private String lineCd;   // 라인코드
	private String inUserId;  // 작업자
	private int workQty; 
	private int productionQty; 
	private Double progress;
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
	public String getLineCd() {
		return lineCd;
	}
	public void setLineCd(String lineCd) {
		this.lineCd = lineCd;
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
	public int getProductionQty() {
		return productionQty;
	}
	public void setProductionQty(int productionQty) {
		this.productionQty = productionQty;
	}
	public Double getProgress() {
		return progress;
	}
	public void setProgress(Double progress) {
		this.progress = progress;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	
	
}
