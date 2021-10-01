package com.mes.dao;

import static com.mes.db.JDBCUtility.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import com.mes.vo.Production;


public class ProductionLineDAO {
	
	private ProductionLineDAO() {}
	private static ProductionLineDAO productionLineDAO;
	public static ProductionLineDAO getInstance() {
		
		if(productionLineDAO == null) productionLineDAO = new ProductionLineDAO();
		return productionLineDAO;
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
		String sql = "select * from production where process ='자재불출완료'";
		
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				production = new Production();
				production.setWorkOrderNo(rs.getString("work_order_no")); //작업지시번호
				production.setProductCd(rs.getString("product_cd")); 
				production.setLineCd(rs.getString("line_cd")); //공정라인
				production.setWorkQty(rs.getInt("work_qty")); //생산수량
				production.setProcess(rs.getString("process")); //
				production.setStartDate(rs.getString("start_date")); 
				production.setEndDate(rs.getString("end_date"));  // 완료
				productionList.add(production);
			}
		}catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Production Line리스트 조회 실패!!" + e.getMessage());
		}
	
		return productionList;
		
	}
	

	public void insertProductionLineInput(String workOrderNo, String useId) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from production where work_order_no = '"+ workOrderNo +"'";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
					
				String sql1 = "insert into pro_line( work_order_no, product_cd, line_cd,production_qty,in_user_id,process, end_date) "+
						" values( ?, ?, ?, ?, ?, ?, now())";
				PreparedStatement pstmt1 = conn.prepareStatement(sql1);
				try {
					pstmt1.setString(1, workOrderNo);
					pstmt1.setString(2, rs.getString("product_cd"));
					pstmt1.setString(3, rs.getString("line_cd"));
					pstmt1.setInt(4, rs.getInt("work_qty"));
					pstmt1.setString(5, useId);
					pstmt1.setString(6, "생산완료");
					pstmt1.executeUpdate();
					
				} catch (SQLException e) {
					System.out.println("생산공정 등록 실패 !!" + e.getMessage());
				} finally {
					close(pstmt1);
				}
			}
		
			String sql_update = "update production set process ='생산완료' where work_order_no='" + workOrderNo+ "'";
			PreparedStatement  pstmt2 = conn.prepareStatement(sql_update);
			try {
				pstmt2.executeUpdate();
			} catch (SQLException e) {
				System.out.println("생산지시 UPDATE 실패 !!" + e.getMessage());
			} finally {
				close(pstmt2);
			}
		
		} catch (SQLException e) {
			System.out.println("생산완료 등록 실패 !!" + e.getMessage());
		} finally {
			close(pstmt,rs);
		}
		
	}
	
}
