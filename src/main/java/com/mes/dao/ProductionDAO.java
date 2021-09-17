package com.mes.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.sql.DataSource;

import com.mes.vo.Product;
import com.mes.vo.Production;

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
	
	public ArrayList<Production> selectProductionList(){
		ArrayList<Production> productionList = new ArrayList<Production>();
		Production production = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from production";
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
			production = new Production();
			production.setOrdDate(rs.getString("OrdDate")); // 수주번호
			production.setPartNo(rs.getString("PartNo"));// 작업지시번호
			production.setItemCd(rs.getString("ItemCd"));// 제품코드
			production.setOrdCd(rs.getString("OrdCd"));// 수주코드
			production.setLineCd(rs.getString("LineCd"));// 라인코드
			production.setInUsrId(rs.getString("InUsrId"));// 작업자
			production.setQuantity(rs.getInt("Quantity"));// 수량
			production.setBackCnt(rs.getInt("BackCnt"));// 수주수량
			production.setDelDate(rs.getString("DelDate"));// 납품예정일
			
			}
			}catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("Product리스트 조회 실패!!" + e.getMessage());
			}
			
			
			
			
		return productionList;
		
		
	}
	
}
