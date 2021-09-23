package com.mes.dao;

import static com.mes.db.JDBCUtility.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.sql.DataSource;

import com.mes.vo.Product;
import com.mes.vo.TakeOrder;

public class PurchaseDAO {

	private PurchaseDAO() {}
	private static PurchaseDAO purchaseDAO;
	public static PurchaseDAO getInstance() {
		
		if(purchaseDAO == null) purchaseDAO = new PurchaseDAO();
		return purchaseDAO;
	}
	
	// DB 연결
	Connection conn = null;
	DataSource ds = null;
	
	public void setConnection(Connection conn) {
		this.conn = conn;
	}
	
	// Item 리스트 불러오기
	public ArrayList<TakeOrder> selectTakeOrderList() {
		
		ArrayList<TakeOrder> takeOrderList = new ArrayList<TakeOrder> ();
		TakeOrder takeOrder = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select a.*, b.product_name from take_order as a" ;
			   sql += " left join product as b on a.product_cd = b.product_cd";
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				takeOrder = new TakeOrder();
				takeOrder.setOrdCd(rs.getString("ord_cd"));          // 수주코드
				takeOrder.setProductCd(rs.getString("product_cd"));  // 제품코드
				takeOrder.setProductName(rs.getString("product_name"));// 제품이름
				takeOrder.setProcess(rs.getString("process"));       // 진행상태
				takeOrder.setOrdCnt(rs.getInt("ord_cnt"));           // 수주수량
				takeOrder.setRemark(rs.getString("remark"));         // 비고
				takeOrderList.add(takeOrder);
			}
		} catch (Exception e) {
			System.out.println("Take Order 리스트 조회 실패 : " + e.getMessage());
		} finally {
			close(pstmt, rs);
		}
		return takeOrderList;
	}
	

}
