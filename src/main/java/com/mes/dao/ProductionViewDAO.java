package com.mes.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.sql.DataSource;

import com.mes.vo.ProductionView;

public class ProductionViewDAO {
	
	private ProductionViewDAO() {}
	private static ProductionViewDAO productionViewDAO;
	public static ProductionViewDAO getInstance() {
		
		if(productionViewDAO == null) productionViewDAO = new ProductionViewDAO();
		return productionViewDAO;
	}
	Connection conn = null;
	DataSource ds = null;
	
	public void setConnection(Connection conn) {
		this.conn = conn;
	}
	
	public ArrayList<ProductionView> selectProductionViewList() {
		ArrayList<ProductionView> productionViewList = new ArrayList<ProductionView>();
		ProductionView productionView = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from production";		
	

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				productionView = new ProductionView();
				productionView.setWorkOrderDate(rs.getString("work_order_date"));
				productionView.setWorkOrderNo(rs.getString("work_order_no"));
				productionView.setProductCd(rs.getString("product_cd"));
				productionView.setOrderCd(rs.getString("order_Cd"));
				productionView.setLineCd(rs.getString("line_cd"));
				productionView.setInUserId(rs.getString("in_usr_id"));
				productionView.setWorkQty(rs.getInt("work_qty"));
				productionView.setOrderCnt(rs.getInt("ord_cnt"));
				productionView.setProcess(rs.getString("process"));
				productionView.setStartDate(rs.getString("start_date"));
				productionView.setEndDate(rs.getString("end_date"));
				productionViewList.add(productionView);
			
			}
	}catch (Exception e) {
		// TODO Auto-generated catch block
		System.out.println("Production 리스트 조회 실패!!" + e.getMessage());
	}

	return productionViewList;

	}
	
}
