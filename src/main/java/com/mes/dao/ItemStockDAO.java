package com.mes.dao;

import static com.mes.db.JDBCUtility.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

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
	public ArrayList<ItemStockInout> selectItemstockList() {
		
		ArrayList<ItemStockInout> itemStorkInoutList = new ArrayList<ItemStockInout>();
		ItemStockInout itemStorkInout= null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select a.*, b.vendor_name from itemstock_inout as a" ;	
		       sql += " left join vendor as b  on a.vendor_cd = b.vendor_cd"; 
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				itemStorkInout = new ItemStockInout();
				itemStorkInout.setNum(rs.getInt("num"));
				itemStorkInout.setItemCd(rs.getString("item_cd"));
				itemStorkInout.setItemName(rs.getString("item_name"));
				itemStorkInout.setIntoutDate(rs.getDate("iteminout_date"));
				itemStorkInout.setInoutType(rs.getString("iteminout_type"));
				itemStorkInout.setStoreCd(rs.getString("store_cd"));
				itemStorkInout.setLocalCd(rs.getString("local_cd"));
				itemStorkInout.setInoutPlant(rs.getString("inout_plant"));
				itemStorkInout.setItemCnt(rs.getInt("item_cnt"));
				itemStorkInout.setVendorName(rs.getString("vendor_name"));
				itemStorkInout.setRemark(rs.getString("remark"));
				itemStorkInoutList.add(itemStorkInout);
			}
			
		} catch (Exception e) {
			System.out.println(" 부품 리스트 조회 실패 : " + e.getMessage());
		} finally {
			close(pstmt, rs);
		}		
		return itemStorkInoutList; 	
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
	@SuppressWarnings("resource")
	public void insertItemstockOut(String workOrderNo,String productCd) {
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from bom where product_cd = "+ productCd;

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
						
				String sql1 = "insert into itemStockInout(item_inout_cd, item_cd, item_name, inout_date,inout_type,store_cd,local_cd,inout_plant,item_cnt,vendor_cd) " + 
							  " values(?, ?, ?, now(), ?, ?, ?, ?, ?, ?)";

				pstmt = conn.prepareStatement(sql1);
				pstmt.setString(1, workOrderNo);            // 작업지시번호
				pstmt.setString(2, rs.getString("item_cd"));
				pstmt.setString(3, rs.getString("item_name"));
				pstmt.setString(4, "out");
				pstmt.setString(5, rs.getString("store_cd"));
				pstmt.setString(6, rs.getString("local_cd"));
//				pstmt.setString(7, );
//				pstmt.setString(8, );
				pstmt.setString(9, rs.getString("vendor_cd"));
				pstmt.executeUpdate();
				
					
				String sql2 = "update itemStock set good_cnt = good_cnt - ?  where item_cd = '"+rs.getString("item_cd")+"'";
				pstmt = conn.prepareStatement(sql2);
				//pstmt2.setString(1, workQty);     
				pstmt.executeUpdate();
		
			}	
				
				String sql3 = "update production set process = '자재출고완료'  where work_order_no = '"+workOrderNo+"'";
				pstmt = conn.prepareStatement(sql3);
				pstmt.executeUpdate();
					
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt, rs);
		}		
	
	}		
	
	
}
