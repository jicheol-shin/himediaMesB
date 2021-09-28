package com.mes.dao;

import static com.mes.db.JDBCUtility.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
			   sql += " where a.process='체결'";
		
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
		String sql = "select * from order_statement where ord_cd='" + ordCd+ "'";
		
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
				orderStatement.setOrderCnt(rs.getInt("order_cnt"));      // 발주량
				orderStatement.setUnitPrice(rs.getDouble("unit_price")); // 단가
				orderStatement.setSumPrice(rs.getDouble("sum_price"));   // 합계
				orderStatement.setvendorCd(rs.getString("vendor_cd"));   // 거래처코드
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
	
	
	// Order Statement 내용 입력
	public void insertOrderStatementList(String ordCd) {
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ResultSet rs_ord = null;
		String productCd = null;
		int ordCnt = 0;
		
		// take order 테이블 컬럼 불러오기(product_cd, ord_cnt)
		String sql_ord = "select * from take_order where ord_cd='" + ordCd + "'";
		
		try {
			pstmt = conn.prepareStatement(sql_ord);
			rs_ord = pstmt.executeQuery();
			while(rs_ord.next()) {
				productCd = rs_ord.getString("product_cd");
				ordCnt = rs_ord.getInt("ord_cnt");
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		} finally {
			close(pstmt, rs_ord);
		}
		
		
		// OrderStatement 테이블에 insert
		String sql = "select * from bom where product_cd = '" + productCd + "'";
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String sql1 = "insert into order_statement(ord_cd, item_cd, item_name, order_date, order_cnt, unit_price, sum_price, vendor_cd, remark) " +
						" values(?, ?, ?, now(), ?, ?, ?, ?, ?)";
				
				PreparedStatement pstmt1 = conn.prepareStatement(sql1);
				try {
					pstmt1.setString(1, ordCd);
					pstmt1.setString(2, rs.getString("item_cd"));
					pstmt1.setString(3, rs.getString("item_name"));
					pstmt1.setInt(4, ordCnt);
					pstmt1.setDouble(5, rs.getDouble("unit_price"));
					pstmt1.setDouble(6, rs.getInt("item_cnt")* ordCnt * rs.getDouble("unit_price"));
					pstmt1.setString(7, rs.getString("vendor_cd"));
					pstmt1.setInt(8, rs.getInt("lead_time"));
					pstmt1.executeUpdate();
					
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					close(pstmt1);
				}
				
				String sql2 = "insert into itemstock_inout(inout_cd,item_cd, item_name, inout_date, inout_type, store_cd, inout_plant, item_cnt, vendor_cd)" +
							  " values(?, ?, ?, now(), ?, ?, ?, ?, ?)";
				
				PreparedStatement pstmt2 = conn.prepareStatement(sql2);
				try {
					pstmt2.setString(1, rs.getString("inout_cd"));
					pstmt2.setString(2, rs.getString("item_cd"));
					pstmt2.setString(3, rs.getString("item_name"));
					pstmt2.setString(4, "IN");
				} catch (SQLException e) {
					System.out.println(" IN 입력 실패 : " + e.getMessage());
				} finally {
					close(pstmt2);
				}
			}
			
		} catch (SQLException e) {
				e.printStackTrace();
		} finally {
			close(pstmt, rs);
		}
		// 영업table - Process : 구매발주완료 로 업데이트 
		String sql_update = "update take_order set process ='구매발주완료' where ord_cd='" + ordCd+ "'";
		try {
			pstmt = conn.prepareStatement(sql_update);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("구매발주완료 UPDATE 실패 !!" + e.getMessage());
		} finally {
			close(pstmt);
		}
   }
	
	
	
	
	
	
	
}