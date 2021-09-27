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
		String sql = "select * from quality";
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				quality = new Quality();
				quality.setWorkOrderNo(rs.getString("work_order_no")); // 작업지시번호
				quality.setProductCd(rs.getString("product_cd")); // 제품코드
				quality.setWorkQty(rs.getInt("work_qty")); // 수량
				quality.setInUserId(rs.getString("in_user_id")); // 검수자
				quality.setProcess(rs.getString("process")); // 프로세스
				quality.setTestDate(rs.getString("test_date")); // 검사일
				qualityList.add(quality);
			}
		}catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Quality리스트 조회 실패!!" + e.getMessage());
		}
		
		return qualityList;
		
		
	}
}
