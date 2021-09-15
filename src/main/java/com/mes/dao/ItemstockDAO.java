package com.mes.dao;

import static com.mes.db.JDBCUtility.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.sql.DataSource;

import com.mes.vo.ItemStockInout;


public class ItemstockDAO {

	private ItemstockDAO() {}
	private static ItemstockDAO itemstockDAO;
	public static ItemstockDAO getInstance() {
		if(itemstockDAO == null) itemstockDAO = new ItemstockDAO();
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
		String sql = "select * from itemstock_inout" ;	
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				itemStorkInout = new ItemStockInout();
				itemStorkInout.setNum(rs.getInt("num"));
				itemStorkInout.setItemInoutCd(rs.getString("iteminout_cd"));
				itemStorkInoutList.add(itemStorkInout);
			}
			
		} catch (Exception e) {
			System.out.println(" 부품 리스트 조회 실패 : " + e.getMessage());
		} finally {
			close(pstmt, rs);
		}		
		return itemStorkInoutList; 	
	}
	
	
	
	
}
