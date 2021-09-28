package com.mes.dao;

import java.sql.Connection;
import java.util.ArrayList;

import javax.sql.DataSource;

import com.mes.vo.ProductInventory;
import com.mes.vo.ReleaseProduct;
import com.mes.vo.ReleaseStatement;

public class ProductInventoryDAO {

	private ProductInventoryDAO() {}
	private static ProductInventoryDAO productInventoryDAO;
	public static ProductInventoryDAO getInstance() {
		
		if(productInventoryDAO == null) productInventoryDAO = new ProductInventoryDAO();
		return productInventoryDAO;
	}
	// DB 연결
	Connection conn = null;
	DataSource ds = null;
		
	public void setConnection(Connection conn) {
		this.conn = conn;
	}
	
	
	// ProductInventory 리스트 불러오기
	public ArrayList<ProductInventory> selectProductInventoryList() {
		
		return null;
	}
	
	// ReleaseOrder리스트(영업관리- Release Product 테이블 불러오기)
	public ArrayList<ReleaseProduct> selectReleaseOrderList() {
		
		return null;
	}
	
	// ReleaseOut(Release Statement 테이블 불러오기)
	public ArrayList<ReleaseStatement> selectReleaseOutList() {
		
		return null;
	}
	
	
	
	
	
}
