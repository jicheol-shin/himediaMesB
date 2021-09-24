package com.mes.dao;

import static com.mes.db.JDBCUtility.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import com.mes.vo.ErrorProduce;

public class ErrorProduceDAO {

	private ErrorProduceDAO() {}
	private static ErrorProduceDAO errorProduceDAO;
	// 하나의 객체생성을 위한 getInstance
	public static ErrorProduceDAO getInstance() {
		
		if(errorProduceDAO == null) errorProduceDAO = new ErrorProduceDAO();
		return errorProduceDAO;
		
	}
	
	// DB연결
	Connection conn = null;
	DataSource ds = null;
	
	public void setConnection(Connection conn) {
		this.conn = conn;
	}
	
	// 리스트불러오기
	public ArrayList<ErrorProduce> selectErrorProduceList(){
		
		ArrayList<ErrorProduce> errorProducesList = new ArrayList<ErrorProduce>();
		ErrorProduce errorProduce = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from error_produce";
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			// rs.next가 true일 동안 리스트내용 가져오기
			while (rs.next()) {
				errorProduce = new ErrorProduce();
				errorProduce.setErrorCd(rs.getString("error_cd"));// 불량코드
				errorProduce.setErrorName(rs.getString("error_name"));// 불량내용
				errorProduce.setRemark(rs.getString("remark"));// 비고
				errorProducesList.add(errorProduce);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("ErrorProduce리스트 조회 실패!!" + e.getMessage());
		}
		
		return errorProducesList;
		
	}
	
}
