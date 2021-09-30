package com.mes.dao;

import static com.mes.db.JDBCUtility.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import com.mes.vo.ProductionLine;
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
	
	public ArrayList<ProductionLine> selectQualityTestList(){
		
		ArrayList<ProductionLine> qualityTestList = new ArrayList<ProductionLine>();
		ProductionLine productionLine = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from pro_line where process = '생산완료'";
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				productionLine = new ProductionLine();
				productionLine.setWorkOrderNo(rs.getString("work_order_no")); 
				productionLine.setProductCd(rs.getString("product_cd"));
				productionLine.setProductionQty(rs.getInt("production_qty")); 
				productionLine.setInUserId(rs.getString("in_user_id")); 
				productionLine.setProcess(rs.getString("process")); 
				productionLine.setEndDate(rs.getString("end_date")); 
				qualityTestList.add(productionLine);
			}
		}catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Quality리스트 조회 실패!!" + e.getMessage());
		}
		
		return qualityTestList;
		
		
	}

	public void insertQualityTestInput(String workOrderNo, String userId) {

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from pro_line where work_order_no='" + workOrderNo + "'";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String sql1 = "insert into quality(work_order_no,product_cd,in_user_id, good_cnt, test_date) " +
						" values(?, ?, ?, ?, now())";
				
				PreparedStatement pstmt1 = conn.prepareStatement(sql1);
				try {
					pstmt1.setString(1, rs.getString("work_order_no"));
					pstmt1.setString(2, rs.getString("product_cd"));
					pstmt1.setString(3, userId);
					pstmt1.setInt(4, rs.getInt("production_qty"));
					pstmt1.executeUpdate();
					
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					close(pstmt1);
				}
		      }
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt, rs);
		}	
		
		
		// pro_line 테이블에  생산완료를  품질검사완료로 변경 
		String sql_update = "update pro_line set process ='품질검사완료' where work_order_no='" + workOrderNo + "'";
		try {
			pstmt = conn.prepareStatement(sql_update);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("품질검사완료 UPDATE 실패 !!" + e.getMessage());
		} finally {
			close(pstmt);
		}
   }

	public ArrayList<Quality> selectQualityList() {
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
				quality.setWorkOrderNo(rs.getString("work_order_no")); 
				quality.setProductCd(rs.getString("product_cd"));
				quality.setInUserId(rs.getString("in_user_id")); 
				quality.setGoodCnt(rs.getInt("good_cnt")); 
				quality.setBadCnt(rs.getInt("bad_cnt")); 
				quality.setTestDate(rs.getDate("test_date")); 
				qualityList.add(quality);
			}
		}catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Quality 조회 실패!!" + e.getMessage());
		}
		
		return qualityList;
		
	}
		
		
}
