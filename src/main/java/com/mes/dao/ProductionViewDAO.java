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
		String sql = "select a.*, b.production_qty, b.end_date from production as a";
		       sql += " inner join  pro_line as b";
		       sql += " where a.work_order_no = b.work_order_no";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				productionView = new ProductionView();
				productionView.setWorkOrderDate(rs.getString("work_order_date"));
				productionView.setWorkOrderNo(rs.getString("work_order_no"));
				productionView.setProductCd(rs.getString("product_cd"));
				productionView.setLineCd(rs.getString("line_cd"));
				productionView.setInUserId(rs.getString("in_usr_id"));
				productionView.setWorkQty(rs.getInt("work_qty"));
				productionView.setProductionQty(rs.getInt("production_qty"));
				productionView.setProgress(rs.getDouble("production_qty")/rs.getInt("work_qty"));
				productionView.setEndDate(rs.getString("end_date"));
				productionViewList.add(productionView);
			}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		System.out.println("Production 리스트 조회 실패!!" + e.getMessage());
	}

	return productionViewList;

	}
	
}
