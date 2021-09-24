package com.mes.dao;

import static com.mes.db.JDBCUtility.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import com.mes.vo.Line;

public class LineDAO {

	private LineDAO() {}
	private static LineDAO lineDAO;
	// 하나의 객체생성을 위한 getInstance
	public static LineDAO getInstance() {
		
		if(lineDAO == null) lineDAO = new LineDAO();
		return lineDAO;
		
	}
	
	// DB연결
	Connection conn = null;
	DataSource ds = null;
	
	public void setConnection(Connection conn) {
		this.conn = conn;
	}
	
	// 리스트불러오기
	public ArrayList<Line> selectLineList(){
		
		ArrayList<Line> lineList = new ArrayList<Line>();
		Line line = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from line";
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			// rs.next가 true일 동안 리스트내용 가져오기
			while (rs.next()) {
				line = new Line();
				line.setLineCd(rs.getString("line_cd"));// 라인코드
				line.setLineName(rs.getString("line_name"));// 라인명
				line.setLineType(rs.getString("line_type"));// 라인분류
				line.setEquipment(rs.getString("equipment"));// 설비사용
				line.setTest(rs.getString("test"));// 검사유무
				line.setErrorCnt(rs.getInt("error_cnt"));// 불량수
				line.setRemark(rs.getString("remark"));// 비고
				lineList.add(line);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Line리스트 조회 실패!!" + e.getMessage());
		} finally {
			close(pstmt, rs);
		}
		
		return lineList;
		
	}
	
}
