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
	public ArrayList<ItemStockInout> selectItemstockList() {
		
		ArrayList<ItemStockInout> itemStockInoutList = new ArrayList<ItemStockInout>();
		ItemStockInout itemStockInout= null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select a.*, b.vendor_name from itemstock_inout as a" ;	
		       sql += " left join vendor as b  on a.vendor_cd = b.vendor_cd"; 
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				itemStockInout = new ItemStockInout();
				itemStockInout.setNum(rs.getInt("num"));
				itemStockInout.setItemCd(rs.getString("item_cd"));
				itemStockInout.setItemName(rs.getString("item_name"));
				itemStockInout.setIntoutDate(rs.getDate("iteminout_date"));
				itemStockInout.setInoutType(rs.getString("iteminout_type"));
				itemStockInout.setStoreCd(rs.getString("store_cd"));
				itemStockInout.setLocalCd(rs.getString("local_cd"));
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
		String sql = "select * from production where process='작업지시서' "; 
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
	public void insertItemstockOut(String workOrderNo,String productCd) throws SQLException {
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ResultSet rs_work = null;
		
		String sql_work = "select * from production where work_order_no = '"+ workOrderNo +"'";
		System.out.println("sql_work  :"+sql_work);
		pstmt = conn.prepareStatement(sql_work);
		rs_work = pstmt.executeQuery();
		
		
		String sql = "select * from bom where product_cd = '"+ productCd +"'";
		System.out.println("sql  :"+sql);
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
						
				String sql1 = "insert into itemstock_inout(inout_cd,item_cd, item_name, inout_date,inout_type,store_cd,local_cd,inout_plant,item_cnt,vendor_cd) " + 
							  " values(?, ?, ?, now(), ?, ?, ?, ?, ?, ?)";
				System.out.println("sql1  :"+sql1);
				pstmt = conn.prepareStatement(sql1);
				pstmt.setString(1, workOrderNo);            // 작업지시번호
				pstmt.setString(2, rs.getString("item_cd"));
				pstmt.setString(3, rs.getString("item_name"));
				pstmt.setString(4, "OUT");
				pstmt.setString(5, rs.getString("store_cd"));
				pstmt.setString(6, rs.getString("local_cd"));
				pstmt.setString(7, rs_work.getString("line_cd"));
				pstmt.setInt(8, rs.getInt("item_cnt")*rs_work.getInt("work_qty"));
				pstmt.setString(9, rs.getString("vendor_cd"));
				pstmt.executeUpdate();
				
					
				String sql2 = "update itemStock set good_cnt = good_cnt - ?  where item_cd = '"+rs.getString("item_cd")+"'";
				pstmt = conn.prepareStatement(sql2);
				pstmt.setInt(1, rs.getInt("item_cnt")*rs_work.getInt("work_qty"));     
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
	
	
}
