package com.mes.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.sql.DataSource;

import com.mes.vo.ProductionCurrent;

public class ProductionCurrentDAO {
	
	private ProductionCurrentDAO() {}
	private static ProductionCurrentDAO productionCurrentDAO;
	public static ProductionCurrentDAO getInstance() {
		
	
		if(productionCurrentDAO == null) productionCurrentDAO = new ProductionCurrentDAO();
		return productionCurrentDAO;
		
	}
	
	Connection conn = null;
	DataSource ds = null;
	
	public void setConnection(Connection conn) {
		this.conn = conn;
	}
	
	
	public ArrayList<ProductionCurrent> selectProductionCurrentList(){
		ArrayList<ProductionCurrent> productionCurrentList = new ArrayList<ProductionCurrent>();
		ProductionCurrent productionCurrent = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from productioncurrent";
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				productionCurrent = new ProductionCurrent();
				productionCurrent.setWorkOrderNo(rs.getString("work_order_no"));
				productionCurrent.setProductCd(rs.getString("product_cd"));
				productionCurrent.setWorkQty(rs.getInt("work_qty"));
				productionCurrent.setQtyPercent(rs.getInt("qty_percent"));
				productionCurrentList.add(productionCurrent);
			}
		}catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Production current리스트 조회 실패!!" + e.getMessage());
		}
			
		return productionCurrentList;
}
}
		
		
		
		
		
		
		
		
	
	
	
