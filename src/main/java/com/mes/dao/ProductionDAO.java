package com.mes.dao;

import static com.mes.db.JDBCUtility.close;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import com.mes.vo.TakeOrder;

public class ProductionDAO {
	
	private ProductionDAO() {}
	private static ProductionDAO productionDAO;
	public static ProductionDAO getInstance() {
		
		if(productionDAO == null) productionDAO = new ProductionDAO();
		return productionDAO;
	}
	
	Connection conn = null;
	DataSource ds = null;
	
	public void setConnection(Connection conn) {
		this.conn = conn;
	}
	
	public ArrayList<TakeOrder> selectProductionList(){
		ArrayList<TakeOrder> takeOrderList = new ArrayList<TakeOrder>();
		TakeOrder takeOrder = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select a.*, b.product_name from take_order as a ";
        sql += " left join product as b on a.product_cd = b.product_cd";
        sql += " where  a.process = '구매발주완료'";
			
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				takeOrder = new TakeOrder();
				takeOrder.setOrdCd(rs.getString("ord_cd")); 
				takeOrder.setProductCd(rs.getString("product_cd")); 
				takeOrder.setProductName(rs.getString("product_name")); 
				takeOrder.setProcess(rs.getString("process")); 
				takeOrder.setOrdCnt(rs.getInt("ord_cnt")); 
		    	takeOrderList.add(takeOrder);
			}
		}catch (Exception e) {
			System.out.println("Production리스트 조회 실패!!" + e.getMessage());
		}
			
		return takeOrderList;
		
	}

	public void insertProductionInput(String ordCd, String name) {

		PreparedStatement pstmt = null;
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
		
		String sql1 = "insert into production(work_order_date, work_order_no, product_cd, order_cd, line_cd, in_usr_id, work_qty, ord_cnt,process,start_date, end_date) "+
				" values(now(), ?, ?, ?, ?, ?, ?, ?, ?, now(), DATE_ADD(NOW(), INTERVAL 1 MONTH) )";
		try {
			PreparedStatement pstmt1 = conn.prepareStatement(sql1);
			pstmt1.setString(1, "WO_"+ordCd);
			pstmt1.setString(2, productCd);
			pstmt1.setString(3, ordCd);
			pstmt1.setString(4, "LINE1");
			pstmt1.setString(5, name);
			pstmt1.setInt(6, ordCnt);
			pstmt1.setInt(7, ordCnt);
			pstmt1.setString(8, "작업지시");
			pstmt1.executeUpdate();
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		String sql_update = "update take_order set process ='생산지시완료' where ord_cd='" + ordCd+ "'";
		try {
			pstmt = conn.prepareStatement(sql_update);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("생산지시완료 UPDATE 실패 !!" + e.getMessage());
		} finally {
			close(pstmt);
		}
		
	}
	
}
