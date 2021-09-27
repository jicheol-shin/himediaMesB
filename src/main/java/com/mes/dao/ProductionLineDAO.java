package com.mes.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.sql.DataSource;

import com.mes.vo.ProductionLine;

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
	
	public ArrayList<ProductionLine> selectProductionLineList(){
		ArrayList<ProductionLine> productionLineList = new ArrayList<ProductionLine>();
		ProductionLine productionLine = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from pro_line";
		
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				productionLine = new ProductionLine();
				productionLine.setWorkOrderNo(rs.getString("work_order_no")); //작업지시번호
				productionLine.setLineCd(rs.getString("line_cd")); //공정라인
				productionLine.setWorkQty(rs.getInt("work_qty")); //생산수량
				productionLine.setInUserId(rs.getString("in_user_id")); // 작업자
				productionLine.setStarDate(rs.getString("start_date")); // 시작시간
				productionLine.setEndDate(rs.getString("end_date"));  // 완료
				productionLineList.add(productionLine);
			}
		}catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Production Line리스트 조회 실패!!" + e.getMessage());
		}
				
														

		
		return productionLineList;
		
	}
	
	
	
	
	
	
	
}
