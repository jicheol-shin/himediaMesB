package com.mes.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.sql.DataSource;

import com.mes.vo.Quality;

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
	
	public ArrayList<Quality> selectQualityList(){
		
		ArrayList<Quality> qualityList = new ArrayList<Quality>();
		Quality quality = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from pro_line";
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				quality = new Quality();
				quality.setPartNo(rs.getString("PartNo")); // 작업지시번호
				quality.setItemCd(rs.getString("ItemCd")); // 제품코드
				quality.setQuantity(rs.getInt("Quantity")); // 수량
				quality.setInUsrId(rs.getString("InUsrId")); // 검수자
				quality.setFinCd(rs.getString("FinCd")); // 완제품코드
				quality.setTestDate(rs.getString("TestDate")); // 검사일
			}
		}catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Quality리스트 조회 실패!!" + e.getMessage());
		}
		
		return qualityList;
		
		
	}
}
