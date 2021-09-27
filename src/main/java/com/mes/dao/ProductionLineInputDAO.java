package com.mes.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

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
	
	public ArrayList<ProductionLineInput> selectProductionLineInputList(){
		ArrayList<ProductionLineInput> productionLineInputList = new ArrayList<ProductionLineInput>();
		ProductionLineInput productionLineInput = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from pro_line_input"	;
				
				try {
					pstmt = conn.prepareStatement(sql);
					rs = pstmt.executeQuery();
					
					while (rs.next()) {
						productionLineInput = new ProductionLineInput();
						productionLineInput.setWorkOrderNo(rs.getString("work_order_no")); //작업지시번호
						productionLineInput.setProductCd(rs.getString("product_cd"));
						productionLineInput.setWorkQty(rs.getInt("work_qty"));
					
					}
				}catch (Exception e) {
					// TODO Auto-generated catch block
					System.out.println("Production Line리스트 조회 실패!!" + e.getMessage());
				}
			
		return productionLineInputList;
	}

}
