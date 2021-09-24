package com.mes.vo;

import java.sql.Date;

public class ReleaseStatement {

	private int num;             // 순번
	private String releCd;       // 출고요청코드
	private String productCd;    // 제품코드
	private String productName;  // 제품명
	private int reqCnt;          // 수량
	private String customer;     // 거래처
	private Date releDelDate;    // 출고일
	private String remark;       // 비고
	
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getReleCd() {
		return releCd;
	}
	public void setReleCd(String releCd) {
		this.releCd = releCd;
	}
	public String getProductCd() {
		return productCd;
	}
	public void setProductCd(String productCd) {
		this.productCd = productCd;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getReqCnt() {
		return reqCnt;
	}
	public void setReqCnt(int reqCnt) {
		this.reqCnt = reqCnt;
	}
	public String getCustomer() {
		return customer;
	}
	public void setCustomer(String customer) {
		this.customer = customer;
	}
	public Date getReleDelDate() {
		return releDelDate;
	}
	public void setReleDelDate(Date releDelDate) {
		this.releDelDate = releDelDate;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
}
