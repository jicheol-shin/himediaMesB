package com.mes.dao;

import static com.mes.db.JDBCUtility.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.sql.DataSource;

import com.mes.vo.OrderStatement;
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
	
	// Take Order 리스트 불러오기
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

	
	
	// Order Statement 불러오기
	public ArrayList<OrderStatement> selectOrderStatementList(String ordCd) {
		
		ArrayList<OrderStatement> orderStatementList = new ArrayList<OrderStatement> ();
		OrderStatement orderStatement = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from order_statement where ord_cd='" + ordCd+"'";
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				orderStatement = new OrderStatement();
				orderStatement.setNum(rs.getInt("num"));                 // 순번
				orderStatement.setOrdCd(rs.getString("ord_cd"));         // 수주코드
				orderStatement.setItemCd(rs.getString("item_cd"));       // 부품코드
				orderStatement.setItemName(rs.getString("item_name"));   // 부품명
				orderStatement.setOrderDate(rs.getDate("order_date"));   // 발주일
				orderStatement.setitemCnt(rs.getInt("item_cnt"));        // 재고량
				orderStatement.setOrderCnt(rs.getInt("order_cnt"));      // 발주량
				orderStatement.setUnitPrice(rs.getDouble("unit_price")); // 단가
				orderStatement.setSumPrice(rs.getDouble("sum_price"));   // 합계
				orderStatement.setvendorCd(rs.getString("vendor_cd"));   // 거래처코드
				orderStatement.setLeadTime(rs.getInt("lead_time"));      // 소요일
				orderStatement.setRemark(rs.getString("remark"));        // 비고
				orderStatementList.add(orderStatement);
			}
		} catch (Exception e) {
			System.out.println("Order Statement 리스트 조회 실패 : " + e.getMessage());
		} finally {
			close(pstmt, rs);
		}
		return orderStatementList;
	}
	
	
	

}
