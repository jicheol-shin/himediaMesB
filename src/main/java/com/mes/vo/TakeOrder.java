package com.mes.vo;

import java.util.Date;

public class TakeOrder {

	private String ordCd;// 수주코드
	private Date ordDate;// 수주일자
	private String custCd;// 거래처코드
	private String compCd;// 제품코드
	private Date ordDelDate;// 납품예정일
	private Integer ordCnt;// 수주수량
	private String remark;// 비고
	
	public String getOrdCd() {
		return ordCd;
	}
	public void setOrdCd(String ordCd) {
		this.ordCd = ordCd;
	}
	public Date getOrdDate() {
		return ordDate;
	}
	public void setOrdDate(Date ordDate) {
		this.ordDate = ordDate;
	}
	public String getCustCd() {
		return custCd;
	}
	public void setCustCd(String custCd) {
		this.custCd = custCd;
	}
	public String getCompCd() {
		return compCd;
	}
	public void setCompCd(String compCd) {
		this.compCd = compCd;
	}
	public Date getOrdDelDate() {
		return ordDelDate;
	}
	public void setOrdDelDate(Date ordDelDate) {
		this.ordDelDate = ordDelDate;
	}
	public Integer getOrdCnt() {
		return ordCnt;
	}
	public void setOrdCnt(Integer ordCnt) {
		this.ordCnt = ordCnt;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
}
