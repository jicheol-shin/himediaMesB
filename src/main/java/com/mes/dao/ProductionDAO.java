package com.mes.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
        sql += " where  a.process = '구매발주'";
			
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				takeOrder = new TakeOrder();
				takeOrder.setOrdCd(rs.getString("ord_cd")); // 수주번호
				takeOrder.setProductCd(rs.getString("product_cd")); // 수주번호
				takeOrder.setProductName(rs.getString("product_name")); // 수주번호
				takeOrder.setProcess(rs.getString("process")); // 수주번호
				takeOrder.setOrdCnt(rs.getInt("ord_cnt")); // 수주번호
			takeOrderList.add(takeOrder);
			}
			}catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("Production리스트 조회 실패!!" + e.getMessage());
			}
			
			
			
			
		return takeOrderList;
		
		
	}
	
}
