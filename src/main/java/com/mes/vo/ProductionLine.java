package com.mes.vo;

public class ProductionLine {

		private String  partNo;   // 작업시지번호
		private String  line;     // 공정라인
		private int  Quantity; // 생산수량
		private String  InUsrId;  // 작업자
		private String  StarDate; // 시작시간
		private String  EndDate ; // 완료시간
		public String getPartNo() {
			return partNo;
		}
		public void setPartNo(String partNo) {
			this.partNo = partNo;
		}
		public String getLine() {
			return line;
		}
		public void setLine(String line) {
			this.line = line;
		}
		public int getQuantity() {
			return Quantity;
		}
		public void setQuantity(int quantity) {
			Quantity = quantity;
		}
		public String getInUsrId() {
			return InUsrId;
		}
		public void setInUsrId(String inUsrId) {
			InUsrId = inUsrId;
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
