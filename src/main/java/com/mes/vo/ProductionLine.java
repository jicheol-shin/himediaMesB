package com.mes.vo;

public class ProductionLine {

		private String  workOrderNo;   // 작업시지번호
		private String  productCd;   // 제품코드
		private String  LineCd;     // 공정라인
		private int  productionQty; // 생산수량
		private String  inUserId;  // 작업자
		private String  process;
		private String  endDate ; // 완료시간
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
			return LineCd;
		}
		public void setLineCd(String lineCd) {
			LineCd = lineCd;
		}
		public int getProductionQty() {
			return productionQty;
		}
		public void setProductionQty(int productionQty) {
			this.productionQty = productionQty;
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
		public String getEndDate() {
			return endDate;
		}
		public void setEndDate(String endDate) {
			this.endDate = endDate;
		}
		
		

	
		
}
