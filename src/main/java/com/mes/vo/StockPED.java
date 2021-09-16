package com.mes.vo;

public class StockPED {
	
	private int num;              //순번
	private String partNo;        //작업지시번호
	private String finCd;         //제품코드
	private String finName;       //제품명
	private String lineNo;        //라인번호
	private int    quantity;      //작업지시 수량
	private String remark;        //비고

	
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getPartNo() {
		return partNo;
	}
	public void setPartNo(String partNo) {
		this.partNo = partNo;
	}
	public String getFinCd() {
		return finCd;
	}
	public void setFinCd(String finCd) {
		this.finCd = finCd;
	}
	public String getFinName() {
		return finName;
	}
	public void setFinName(String finName) {
		this.finName = finName;
	}
	public String getLineNo() {
		return lineNo;
	}
	public void setLineNo(String lineNo) {
		this.lineNo = lineNo;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}

	
	
	

}
