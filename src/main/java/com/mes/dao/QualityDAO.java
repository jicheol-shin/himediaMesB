package com.mes.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.sql.DataSource;

import com.mes.vo.ProductionLine;

public class QualityDAO {
	
	private QualityDAO() {}
	private static QualityDAO qualityDAO;
	public static QualityDAO getInstance() {
		
		if(qualityDAO == null) qualityDAO = new QualityDAO();
		return qualityDAO;
		
	}
	
	Connection conn = null;
	DataSource ds = null;
	
	public void setConnection(Connection conn) {
		this.conn = conn;
	}
	
	public ArrayList<ProductionLine> selectQualityList(){
		
		ArrayList<ProductionLine> qualityTestList = new ArrayList<ProductionLine>();
		ProductionLine productionLine = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from pro_line where process = '생산완료'";
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				productionLine = new ProductionLine();
				productionLine.setWorkOrderNo(rs.getString("work_order_no")); 
				productionLine.setProductCd(rs.getString("product_cd"));
				productionLine.setProductionQty(rs.getInt("production_qty")); 
				productionLine.setInUserId(rs.getString("in_user_id")); 
				productionLine.setProcess(rs.getString("process")); 
				productionLine.setEndDate(rs.getString("end_date")); 
				qualityTestList.add(productionLine);
			}
		}catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Quality리스트 조회 실패!!" + e.getMessage());
		}
		
		return qualityTestList;
		
		
	}
}
