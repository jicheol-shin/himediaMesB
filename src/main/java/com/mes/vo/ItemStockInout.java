package com.mes.vo;

import java.util.Date;

public class ItemStockInout {
	
	private int num;              //순번
	private String itemInoutCd;   //입출고코드
	private String itemCd;        //부품 코드
	private String itemName;      //부품명
	private Date   intoutDate;    //입출고일자
	private String inoutType;     //입출고 유형
	private String storeCd;       //창고명
	private String localCd;       //구역명
	private String inoutPlant;    //이동창고
	private int    itemCnt;       //입출고 수량
	private String vendorCd;      //제조사(납품처) 코드
	private String remark;        //비고

	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getItemInoutCd() {
		return itemInoutCd;
	}
	public void setItemInoutCd(String itemInoutCd) {
		this.itemInoutCd = itemInoutCd;
	}
	public String getItemCd() {
		return itemCd;
	}
	public void setItemCd(String itemCd) {
		this.itemCd = itemCd;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public Date getIntoutDate() {
		return intoutDate;
	}
	public void setIntoutDate(Date intoutDate) {
		this.intoutDate = intoutDate;
	}
	public String getInoutType() {
		return inoutType;
	}
	public void setInoutType(String inoutType) {
		this.inoutType = inoutType;
	}
	public String getStoreCd() {
		return storeCd;
	}
	public void setStoreCd(String storeCd) {
		this.storeCd = storeCd;
	}
	public String getLocalCd() {
		return localCd;
	}
	public void setLocalCd(String localCd) {
		this.localCd = localCd;
	}
	public String getInoutPlant() {
		return inoutPlant;
	}
	public void setInoutPlant(String inoutPlant) {
		this.inoutPlant = inoutPlant;
	}
	public int getItemCnt() {
		return itemCnt;
	}
	public void setItemCnt(int itemCnt) {
		this.itemCnt = itemCnt;
	}
	public String getVendorCd() {
		return vendorCd;
	}
	public void setVendorCd(String vendorCd) {
		this.vendorCd = vendorCd;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}

	
	
	
	

}
