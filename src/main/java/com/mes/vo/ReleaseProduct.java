package com.mes.vo;

import java.util.Date;

public class ReleaseProduct {

	private String releCd;// 출고요청코드
	private Date releDate;// 출하요청일자
	private String ordCd;// 수주코드
	private String customer;// 거래처
	private String productCd;// 제품코드
	private String process;// 진행상태
	private int reqCnt;// 요청수량
	private int releCnt;// 출하수량
	private int backCnt;// 요청잔량
	private Date releDelDate;// 납품예정일
	private String remark;// 비고
	
	private int goodCount;// 재고수량
	private String productName;
	
	public String getReleCd() {
		return releCd;
	}
	public void setReleCd(String releCd) {
		this.releCd = releCd;
	}
	public Date getReleDate() {
		return releDate;
	}
	public void setReleDate(Date releDate) {
		this.releDate = releDate;
	}
	public String getOrdCd() {
		return ordCd;
	}
	public void setOrdCd(String ordCd) {
		this.ordCd = ordCd;
	}
	public String getCustomer() {
		return customer;
	}
	public void setCustomer(String customer) {
		this.customer = customer;
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
	public int getReqCnt() {
		return reqCnt;
	}
	public void setReqCnt(int reqCnt) {
		this.reqCnt = reqCnt;
	}
	public int getReleCnt() {
		return releCnt;
	}
	public void setReleCnt(int releCnt) {
		this.releCnt = releCnt;
	}
	public int getBackCnt() {
		return backCnt;
	}
	public void setBackCnt(int backCnt) {
		this.backCnt = backCnt;
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
	public int getGoodCount() {
		return goodCount;
	}
	public void setGoodCount(int goodCount) {
		this.goodCount = goodCount;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}       	


}
