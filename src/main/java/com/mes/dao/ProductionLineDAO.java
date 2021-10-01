package com.mes.dao;

import static com.mes.db.JDBCUtility.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import com.mes.vo.Production;
import com.mes.vo.ProductionLine;
import com.mes.vo.ProductionLineInput;

public class ProductionLineDAO {
	
	private ProductionLineDAO() {}
	private static ProductionLineDAO productionLineDAO;
	public static ProductionLineDAO getInstance() {
		
		if(productionLineDAO == null) productionLineDAO = new ProductionLineDAO();
		return productionLineDAO;
	}
	
	Connection conn = null;
	DataSource ds = null;
	
	public void setConnection(Connection conn) {
		this.conn = conn;
	}
	
	public ArrayList<Production> selectProductionList(){
		ArrayList<Production> productionList = new ArrayList<Production>();
		Production production = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from production where process ='자재불출완료'";
		
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				production = new Production();
				production.setWorkOrderNo(rs.getString("work_order_no")); //작업지시번호
				production.setProductCd(rs.getString("product_cd")); 
				production.setLineCd(rs.getString("line_cd")); //공정라인
				production.setWorkQty(rs.getInt("work_qty")); //생산수량
				production.setProcess(rs.getString("process")); //
				production.setStartDate(rs.getString("start_date")); 
				production.setEndDate(rs.getString("end_date"));  // 완료
				productionList.add(production);
			}
		}catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Production Line리스트 조회 실패!!" + e.getMessage());
		}
	
		return productionList;
		
	}
	public int updateProduction(ProductionLineInput productionLineInput) {
		int updateCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql ="update production set work_qty "+
		        " where WORK_ORDER_NO = PARK_1" ;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, productionLineInput.getWorkQty());
			updateCount = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("업데이트 실패 !!" + e.getMessage());
		} finally {
			close(pstmt, rs);
		}
		
    	return updateCount; 
	}
	
	
	
	
	
	
}
