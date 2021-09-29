package com.mes.dao;

import static com.mes.db.JDBCUtility.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
	
	
	// ProductInventory 리스트 불러오기(ProductInventory.jsp)
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
				productInventory.setGoodCount(rs.getInt("good_count"));
				productInventory.setBadCount(rs.getInt("bad_count"));
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
			   sql += " where process='미결'";
		
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
	
	
	// ReleaseStatement에 내용 입력 하기
		public void insertReleaseOutList(String releCd) {
			
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			// releaseProduct 테이블 칼럼 불러오기(rele_cd)
//			String sql = "select * from release_product where rele_cd='" + releCd + "'";
//			try {
//				pstmt = conn.prepareStatement(sql);
//				rs = pstmt.executeQuery();
//				while(rs.next()) {
//					releCd1 = rs.getString("rele_cd");
//				}
//			} catch (SQLException e) {
//				e.printStackTrace();
//			} finally {
//				close(pstmt, rs);
//			}
			
			// release_statement 테이블에 insert
			String sql1 = "select a.*, b.product_name from release_product as a";
			       sql1 += " left join product as b on a.product_cd = b.product_cd";
				   sql1	+= " where rele_cd='" + releCd + "'";
			try {
				pstmt = conn.prepareStatement(sql1);
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					String sql2 = "insert into release_statement(rele_cd, product_cd, product_name, req_cnt, customer, rele_del_date) " +
							    " values(?, ?, ?, ?, ?, now())" ;
					
					PreparedStatement pstmt1 = conn.prepareStatement(sql2);
					try {
						pstmt1.setString(1, releCd);
						pstmt1.setString(2, rs.getString("product_cd"));
						pstmt1.setString(3, rs.getString("product_name"));
						pstmt1.setInt(4, rs.getInt("req_cnt"));
						pstmt1.setString(5, rs.getString("customer"));
						pstmt1.executeUpdate();
						
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						close(pstmt1);
					}
					
					String sql3 = "update product_inventory set good_count = good_count - ?  where product_cd = ?";				
					PreparedStatement pstmt3 = conn.prepareStatement(sql3);
					try {
						pstmt3.setInt(1, rs.getInt("req_cnt"));
						pstmt3.setString(2, rs.getString("product_cd"));    
						pstmt3.executeUpdate();
					} catch (SQLException e) {
						e.printStackTrace();
					} finally {
						close(pstmt3);
					}	
					
					String sql4 = "update release_product set process='출고완료' where rele_cd='" + releCd + "'";				
					PreparedStatement pstmt4 = conn.prepareStatement(sql4);
					try {    
						pstmt4.executeUpdate();
					} catch (SQLException e) {
						e.printStackTrace();
					} finally {
						close(pstmt4);
					}	
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(pstmt);
			}
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
