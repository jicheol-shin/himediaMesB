package com.mes.vo;

import java.sql.Date;

public class FinishedInventory {

	private int num;           // 순번
	private String finCd;      // 제품코드
	private String finName;    // 제품명
	private int goodCnt;       // 양품수량
	private int badCnt;        // 불량수량
	private Date whgDate;      // 입고일
	private String storeCd;    // 보관창고
	private String remark;     // 비고
	
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
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
	public int getGoodCnt() {
		return goodCnt;
	}
	public void setGoodCnt(int goodCnt) {
		this.goodCnt = goodCnt;
	}
	public int getBadCnt() {
		return badCnt;
	}
	public void setBadCnt(int badCnt) {
		this.badCnt = badCnt;
	}
	public Date getWhgDate() {
		return whgDate;
	}
	public void setWhgDate(Date whgDate) {
		this.whgDate = whgDate;
	}
	public String getStoreCd() {
		return storeCd;
	}
	public void setStoreCd(String storeCd) {
		this.storeCd = storeCd;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
}
