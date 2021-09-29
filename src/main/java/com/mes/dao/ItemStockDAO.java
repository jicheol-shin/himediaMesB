package com.mes.dao;

import static com.mes.db.JDBCUtility.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import com.mes.vo.ItemStock;
import com.mes.vo.ItemStockInout;
import com.mes.vo.ItemStockOutOrder;


public class ItemStockDAO {

	private ItemStockDAO() {}
	private static ItemStockDAO itemstockDAO;
	public static ItemStockDAO getInstance() {
		if(itemstockDAO == null) itemstockDAO = new ItemStockDAO();
		return itemstockDAO;
	}

	Connection conn = null;
	DataSource ds = null;

	// DB커넥션
	public void setConnection(Connection conn) {
		this.conn = conn;
	}

	// 자재 재고현황 조회
	public ArrayList<ItemStockInout> selectItemstockList(int page, int limit, String stockInout) {
		
		ArrayList<ItemStockInout> itemStockInoutList = new ArrayList<ItemStockInout>();
		ItemStockInout itemStockInout= null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select a.*, b.vendor_name from itemstock_inout as a" ;	
		       sql += " left join vendor as b  on a.vendor_cd = b.vendor_cd";     
		       if(stockInout != null) sql += " where inout_type = '"+stockInout +"'";       
		       sql += " limit ?," + limit;
		
		int startRow = (page-1) * limit;       
		       
		       
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				itemStockInout = new ItemStockInout();
				itemStockInout.setNum(rs.getInt("num"));
				itemStockInout.setInoutCd(rs.getString("inout_cd"));
				itemStockInout.setItemCd(rs.getString("item_cd"));
				itemStockInout.setItemName(rs.getString("item_name"));
				itemStockInout.setIntoutDate(rs.getDate("inout_date"));
				itemStockInout.setInoutType(rs.getString("inout_type"));
				itemStockInout.setStoreCd(rs.getString("store_cd"));
				itemStockInout.setInoutPlant(rs.getString("inout_plant"));
				itemStockInout.setItemCnt(rs.getInt("item_cnt"));
				itemStockInout.setVendorName(rs.getString("vendor_name"));
				itemStockInout.setRemark(rs.getString("remark"));
				itemStockInoutList.add(itemStockInout);
			}
			
		} catch (Exception e) {
			System.out.println(" 부품 리스트 조회 실패 : " + e.getMessage());
		} finally {
			close(pstmt, rs);
		}		
		return itemStockInoutList; 	
	}

    // 작업지시 테이블에서  작업지시  내역 조회
	public ArrayList<ItemStockOutOrder> selectItemStockOutOrderList() {
		
		ArrayList<ItemStockOutOrder> itemStockOutOrderList = new ArrayList<ItemStockOutOrder>();
		ItemStockOutOrder itemStockOutOrder= null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from production where process='작업지시' "; 
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				itemStockOutOrder = new ItemStockOutOrder();
				itemStockOutOrder.setWorkOrderDate(rs.getDate("work_order_date"));
				itemStockOutOrder.setWorkOrderNo(rs.getString("work_order_no"));
				itemStockOutOrder.setProductCd(rs.getString("product_cd"));
				itemStockOutOrder.setLineNo(rs.getString("line_cd"));
				itemStockOutOrder.setWorkQty(rs.getInt("work_qty"));
				
				itemStockOutOrderList.add(itemStockOutOrder);
			}
			
		} catch (Exception e) {
			System.out.println(" 작업지시 조회 실패 : " + e.getMessage());
		} finally {
			close(pstmt, rs);
		}		
		return itemStockOutOrderList; 	
	}
	
	// 작업지시에 따라  자재 불출 및  불출내역 테이블 입력
	public void insertItemstockOut(String workOrderNo) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ResultSet rs_work = null;
		String productCd = null;
		String lineCd=null;
		int workQty=0;
		
		String sql_work = "select * from production where work_order_no = '"+ workOrderNo +"'";
		try {
			pstmt = conn.prepareStatement(sql_work);
			rs_work = pstmt.executeQuery();
			while(rs_work.next()) {
				productCd = rs_work.getString("product_cd");
				lineCd = rs_work.getString("line_cd");
				workQty = rs_work.getInt("work_qty");
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		} finally {
			close(pstmt, rs_work);
		}				
	
		String sql = "select * from bom where product_cd = '"+ productCd +"'";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				String sql1 = "insert into itemstock_inout(inout_cd,item_cd, item_name, inout_date,inout_type,store_cd,inout_plant,item_cnt,vendor_cd) " + 
							  " values(?, ?, ?, now(), ?, ?, ?, ?, ?)";
				PreparedStatement pstmt1 = conn.prepareStatement(sql1);
				try {
					pstmt1.setString(1, workOrderNo);            // 작업지시번호
					pstmt1.setString(2, rs.getString("item_cd"));
					pstmt1.setString(3, rs.getString("item_name"));
					pstmt1.setString(4, "OUT");
					pstmt1.setString(5, "원부자재창고");
					pstmt1.setString(6, lineCd);
					pstmt1.setInt(7, rs.getInt("item_cnt") * workQty);
					pstmt1.setString(8, rs.getString("vendor_cd"));
					pstmt1.executeUpdate();
				
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					close(pstmt1);
				}			
					
				String sql2 = "update itemstock set good_cnt = good_cnt - ?  where item_cd = ?";				
				PreparedStatement pstmt2 = conn.prepareStatement(sql2);
				try {
					pstmt2.setInt(1, rs.getInt("item_cnt")* workQty);
					pstmt2.setString(2, rs.getString("item_cd"));    
					pstmt2.executeUpdate();
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					close(pstmt2);
				}			
			}	
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt, rs);
		}	
		
		String sql_update = "update production set process='자재불출완료' where work_order_no='"+ workOrderNo+"'";
		try {
			pstmt = conn.prepareStatement(sql_update);
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("생산지시 UPDATE 실패 !!" + e.getMessage());
			
		} finally {
			close(pstmt);
		}				
	   
	}

	
	
	//자재 재고 현황 조회
	public ArrayList<ItemStock> selectItemStockList() {
		
		ArrayList<ItemStock> itemStockList = new ArrayList<ItemStock>();
		ItemStock itemStock= null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from itemstock"; 
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				itemStock = new ItemStock();
				itemStock.setNum(rs.getInt("num"));
				itemStock.setItemCd(rs.getString("item_cd"));
				itemStock.setItemName(rs.getString("item_name"));
				itemStock.setUnitPrice(rs.getDouble("unit_price"));
				itemStock.setStoreCd(rs.getString("store_cd"));
				itemStock.setLocalCd(rs.getString("local_cd"));
				itemStock.setGoodCnt(rs.getInt("good_cnt"));
				itemStock.setBadCnt(rs.getInt("bad_cnt"));
				itemStock.setRemark(rs.getString("remark"));
				itemStockList.add(itemStock);
			}
			
		} catch (Exception e) {
			System.out.println(" 부품 리스트 조회 실패 : " + e.getMessage());
		} finally {
			close(pstmt, rs);
		}		
		return itemStockList; 	
	}

	public int selectListCount(String stockInout) {
		int listCount = 0;
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select count(*) from itemstock_inout";
		if(stockInout != null) sql += " where inout_type = '"+stockInout +"'";       
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) listCount = rs.getInt(1);
		} catch (SQLException e) {
			System.out.println("갯수 가져오기 실패!! " + e.getMessage());
		} finally {
			close(pstmt, rs);
		}
		return listCount; 
	}

	
}
