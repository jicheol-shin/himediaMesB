package com.mes.vo;

import java.util.Date;

public class TakeOrder {

	private String ordCd;// 수주코드
	private Date ordDate;// 수주일자
	private String vendorCd;// 거래처코드
	private String productCd;// 제품코드
	private String process; // 진행상태
	private Date ordDelDate;// 납품예정일
	private int ordCnt;// 수주수량
	private String remark;// 비고
	
	private String productName; // 제품명
	
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
	public String getVendorCd() {
		return vendorCd;
	}
	public void setVendorCd(String vendorCd) {
		this.vendorCd = vendorCd;
	}
	public String getProductCd() {
		return productCd;
	}
	public void setProductCd(String productCd) {
		this.productCd = productCd;
	}
	public String getProcess() {
		return process;
	}
	public void setProcess(String process) {
		this.process = process;
	}
	public Date getOrdDelDate() {
		return ordDelDate;
	}
	public void setOrdDelDate(Date ordDelDate) {
		this.ordDelDate = ordDelDate;
	}
	public int getOrdCnt() {
		return ordCnt;
	}
	public void setOrdCnt(int ordCnt) {
		this.ordCnt = ordCnt;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}

}
