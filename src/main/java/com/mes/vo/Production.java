package com.mes.vo;

public class Production {
	private String OrdDate;  // 수주번호
	private String PartNo;   // 작업지시번호
	private String ItemCd;   // 제품코드
	private String OrdCd;    // 수주코드
	private String LineCd;   // 라인코드
	private String InUsrId;  // 작업자
	private int Quantity; // 생산수량
	private int BackCnt;  // 수주수량
	private String StartDate; //생산시작일
	private String EndDate;   //생산완료일
	
	public String getOrdDate() {
		return OrdDate;
	}
	public void setOrdDate(String ordDate) {
		OrdDate = ordDate;
	}
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
	public String getOrdCd() {
		return OrdCd;
	}
	public void setOrdCd(String ordCd) {
		OrdCd = ordCd;
	}
	public String getLineCd() {
		return LineCd;
	}
	public void setLineCd(String lineCd) {
		LineCd = lineCd;
	}
	public String getInUsrId() {
		return InUsrId;
	}
	public void setInUsrId(String inUsrId) {
		InUsrId = inUsrId;
	}
	public int getQuantity() {
		return Quantity;
	}
	public void setQuantity(int quantity) {
		Quantity = quantity;
	}
	public int getBackCnt() {
		return BackCnt;
	}
	public void setBackCnt(int backCnt) {
		BackCnt = backCnt;
	}
	public String getStartDate() {
		return StartDate;
	}
	public void setStartDate(String startDate) {
		StartDate = startDate;
	}
	public String getEndDate() {
		return EndDate;
	}
	public void setEndDate(String endDate) {
		EndDate = endDate;
	}
	
	
	
}
