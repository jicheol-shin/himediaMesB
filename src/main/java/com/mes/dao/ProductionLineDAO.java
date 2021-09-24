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
				productionLine.setPartNo(rs.getString("partNo")); //작업지시번호
				productionLine.setLine(rs.getString("line")); //공정라인
				productionLine.setQuantity(rs.getInt("Quantity")); //생산수량
				productionLine.setInUsrId(rs.getString("InUsrId")); // 작업자
				productionLine.setStarDate(rs.getString("StarDate")); // 시작시간
				productionLine.setEndDate(rs.getString("EndDate"));  // 완료
			}
		}catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Product리스트 조회 실패!!" + e.getMessage());
		}
				
														

		
		return productionLineList;
		
	}
	
	
	
	
	
	
	
}
