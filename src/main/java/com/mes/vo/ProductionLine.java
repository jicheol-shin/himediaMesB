package com.mes.vo;

public class ProductionLine {

		private String  workOrderNo;   // 작업시지번호
		private String  LineCd;     // 공정라인
		private int  workQty; // 생산수량
		private String  inUserId;  // 작업자
		private String  StarDate; // 시작시간
		private String  EndDate ; // 완료시간
		public String getWorkOrderNo() {
			return workOrderNo;
		}
		public void setWorkOrderNo(String workOrderNo) {
			this.workOrderNo = workOrderNo;
		}
		public String getLineCd() {
			return LineCd;
		}
		public void setLineCd(String lineCd) {
			LineCd = lineCd;
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
		public String getStarDate() {
			return StarDate;
		}
		public void setStarDate(String starDate) {
			StarDate = starDate;
		}
		public String getEndDate() {
			return EndDate;
		}
		public void setEndDate(String endDate) {
			EndDate = endDate;
		}
		
		
		
		
		
}
