package com.mes.vo;

import java.sql.Date;

public class FReleaseStatement {

	private int num;          // 순번
	private String shipCd;    // 출고요청코드
	private String finCd;     // 제품코드
	private String finName;   // 제품명
	private int shipCnt;      // 수량
	private String custName;  // 납품처
	private Date shipDate;    // 출고일
	private String remark;    // 비고
	
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getShipCd() {
		return shipCd;
	}
	public void setShipCd(String shipCd) {
		this.shipCd = shipCd;
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
	public int getShipCnt() {
		return shipCnt;
	}
	public void setShipCnt(int shipCnt) {
		this.shipCnt = shipCnt;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public Date getShipDate() {
		return shipDate;
	}
	public void setShipDate(Date shipDate) {
		this.shipDate = shipDate;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
}
