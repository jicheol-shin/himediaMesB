package com.mes.dao;

import static com.mes.db.JDBCUtility.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mes.vo.ProductionLineInput;

public class ProductionLineInputDAO {

	private ProductionLineInputDAO(){}
	private static ProductionLineInputDAO productionLineInputDAO;
	public static ProductionLineInputDAO getInstance() {
		
		if(productionLineInputDAO == null) productionLineInputDAO = new ProductionLineInputDAO();
		return productionLineInputDAO;
	}
	
	Connection conn = null;
	DataSource ds = null;
	
	public void setConnection(Connection conn) {
		this.conn = conn;
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
