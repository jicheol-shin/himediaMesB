package com.mes.dao;

import static com.mes.db.JDBCUtility.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
		
		ArrayList<ProductInventory> productInventoryList = new ArrayList<ProductInventory>();
		ProductInventory productInventory = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from product_inventory";
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				productInventory = new ProductInventory();
				productInventory.setNum(rs.getInt("num"));
				productInventory.setProductCd(rs.getString("product_cd"));
				productInventory.setProductName(rs.getString("product_name"));
				productInventory.setgoodCount(rs.getInt("good_count"));
				productInventory.setbadCount(rs.getInt("bad_count"));
				productInventory.setStoreCd(rs.getString("store_cd"));
				productInventory.setRemark(rs.getString("remark"));
				productInventoryList.add(productInventory);
			}
		} catch (Exception e) {
			System.out.println("Product Inventory 리스트 조회 실패 : " + e.getMessage());
		} finally {
			close(pstmt, rs);
		}
		return productInventoryList;
	}
	
	// ReleaseOrder리스트(영업관리- Release Product 테이블 불러오기)
	public ArrayList<ReleaseProduct> selectReleaseOrderList() {
		
		ArrayList<ReleaseProduct> releaseOrderList = new ArrayList<ReleaseProduct>();
		ReleaseProduct releaseOrder = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from release_product";
			   sql += " where process='출하준비완료'";
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				releaseOrder = new ReleaseProduct();
				releaseOrder.setReleDate(rs.getDate("rele_date"));
				releaseOrder.setReleCd(rs.getString("rele_cd"));
				releaseOrder.setCustomer(rs.getString("customer"));
				releaseOrder.setProductCd(rs.getString("product_cd"));
				releaseOrder.setProcess(rs.getString("process"));
				releaseOrder.setReqCnt(rs.getInt("req_cnt"));
				releaseOrder.setRemark(rs.getString("remark"));
				releaseOrderList.add(releaseOrder);
			}
		} catch (Exception e) {
			System.out.println("ReleaseOrder 리스트 조회 실패 : " + e.getMessage());
		} finally {
			close(pstmt, rs);
		}
		return releaseOrderList;
	}
	
	// ReleaseOut(Release Statement 테이블 불러오기)
	public ArrayList<ReleaseStatement> selectReleaseOutList() {
		
		ArrayList<ReleaseStatement> releaseOutList = new ArrayList<ReleaseStatement>();
		ReleaseStatement releaseOut = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from release_statement";
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				releaseOut = new ReleaseStatement();
				releaseOut.setNum(rs.getInt("num"));
				releaseOut.setReleCd(rs.getString("rele_cd"));
				releaseOut.setProductCd(rs.getString("product_cd"));
				releaseOut.setProductName(rs.getString("product_name"));
				releaseOut.setReqCnt(rs.getInt("req_cnt"));
				releaseOut.setCustomer(rs.getString("customer"));
				releaseOut.setReleDelDate(rs.getDate("rele_del_date"));
				releaseOut.setRemark(rs.getString("remark"));
				releaseOutList.add(releaseOut);
			}
		} catch (Exception e) {
			System.out.println("ReleaseOut 리스트 조회 실패 : " + e.getMessage());
		} finally {
			close(pstmt, rs);
		}
		return releaseOutList;
	}
	
	
	
	
	
}
