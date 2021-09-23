package com.mes.dao;

import static com.mes.db.JDBCUtility.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
				itemStorkInout.setItemInoutCd(rs.getString("iteminout_cd"));
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


	public ArrayList<ItemStockOutOrder> selectItemStockOutOrderList() {
		
		ArrayList<ItemStockOutOrder> itemStockOutOrderList = new ArrayList<ItemStockOutOrder>();
		ItemStockOutOrder itemStockOutOrder= null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from itemstock_outorder"; 
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				itemStockOutOrder = new ItemStockOutOrder();
				itemStockOutOrder.setNum(rs.getInt("num"));
				itemStockOutOrder.setWorkOrderDate(rs.getDate("work_order_date"));
				itemStockOutOrder.setItemStockOutDate(rs.getDate("itemstock_out_date"));
				itemStockOutOrder.setWorkOrderNo(rs.getString("work_order_no"));
				itemStockOutOrder.setProductCd(rs.getString("item_cd"));
				itemStockOutOrder.setLineNo(rs.getString("line_no"));
				itemStockOutOrder.setWorkQty(rs.getInt("workQty"));
				itemStockOutOrder.setIssue(rs.getString("issue"));
				itemStockOutOrder.setRemark(rs.getString("remark"));
				
				itemStockOutOrderList.add(itemStockOutOrder);
			}
			
		} catch (Exception e) {
			System.out.println(" 작업지시 조회 실패 : " + e.getMessage());
		} finally {
			close(pstmt, rs);
		}		
		return itemStockOutOrderList; 	
	}
	
	
}
