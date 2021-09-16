package com.mes.vo;

import java.util.Date;

public class ReleaseProduct {

	private String releCd;// 출고요청코드
	private Date releDate;// 출하요청일자
	private String ordCd;// 수주코드
	private String seleCustName;// 거래처
	private String compCd;// 제품코드
	private String process;// 진행상태
	private Integer reqCnt;// 요청수량
	private Integer releCnt;// 출하수량
	private Integer backCnt;// 요청잔량
	private Date releDelDate;// 납품예정일
	private String remark;// 비고
	
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
	public String getSeleCustName() {
		return seleCustName;
	}
	public void setSeleCustName(String seleCustName) {
		this.seleCustName = seleCustName;
	}
	public String getCompCd() {
		return compCd;
	}
	public void setCompCd(String compCd) {
		this.compCd = compCd;
	}
	public String getProcess() {
		return process;
	}
	public void setProcess(String process) {
		this.process = process;
	}
	public Integer getReqCnt() {
		return reqCnt;
	}
	public void setReqCnt(Integer reqCnt) {
		this.reqCnt = reqCnt;
	}
	public Integer getReleCnt() {
		return releCnt;
	}
	public void setReleCnt(Integer releCnt) {
		this.releCnt = releCnt;
	}
	public Integer getBackCnt() {
		return backCnt;
	}
	public void setBackCnt(Integer backCnt) {
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
	
}
