package com.mes.dao;

import static com.mes.db.JDBCUtility.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.sql.DataSource;

import com.mes.vo.TakeOrder;

public class PurchaseDAO {

	private PurchaseDAO() {}
	private static PurchaseDAO purchaseDAO;
	public static PurchaseDAO getInstance() {
		if(purchaseDAO == null) purchaseDAO = new PurchaseDAO();
		return purchaseDAO;
	}
	
	Connection conn = null;
	DataSource ds = null;
	
	// DB 커넥션
	public void setConnection(Connection conn) {
		this.conn = conn;
	}
	
	public ArrayList<TakeOrder> selectTakeOrderList() {
		
		ArrayList<TakeOrder> takeOrderList = new ArrayList<TakeOrder>();
		TakeOrder takeOrder = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from take_order";
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				takeOrder = new TakeOrder();
				takeOrder.setOrdCd(rs.getString("ord_cd"));
				takeOrder.setOrdDate(rs.getDate("ord_date"));
				takeOrder.setVendorCd(rs.getString("vendor_cd"));
				takeOrder.setProductCd(rs.getString("product_cd"));
				takeOrder.setProcess(rs.getString("process"));
				takeOrder.setOrdDelDate(rs.getDate("ord_del_date"));
				takeOrder.setOrdCnt(rs.getInt("ord_del_date"));
				takeOrder.setRemark(rs.getString("remark"));
				takeOrderList.add(takeOrder);
			}
		} catch (Exception e) {
			System.out.println("리스트 조회 실패 : " + e.getMessage());
		} finally {
			close(pstmt, rs);
		}
		return takeOrderList;
	}
}
