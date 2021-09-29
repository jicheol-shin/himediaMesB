package com.mes.dao;

import static com.mes.db.JDBCUtility.close;
import static com.mes.db.JDBCUtility.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import com.mes.vo.Bom;

public class BomDAO {

	private BomDAO() {}
	private static BomDAO bomDAO;
	// 하나의 객체생성을 위한 getInstance
	public static BomDAO getInstance() {
		
		if(bomDAO == null) bomDAO = new BomDAO();
		return bomDAO;
		
	}
	
	// DB연결
	Connection conn = null;
	DataSource ds = null;
	
	public void setConnection(Connection conn) {
		this.conn = conn;
	}	
	
	// 리스트를 불러오기
	public ArrayList<Bom> selectBomList(int page, int limit, String productCd){
		
		ArrayList<Bom> bomList = new ArrayList<Bom>();
		Bom bom = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from bom";
 
		if(productCd != null) sql += " where product_cd = '"+productCd +"'";       
								sql += " limit ?," + limit;

		int startRow = (page-1) * limit;   

		System.out.println("BomDAO = productCd: " + productCd);
			
		try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, startRow);
				rs = pstmt.executeQuery();
				
				while (rs.next()) {
					bom = new Bom();
					bom.setProductCd(rs.getString("product_cd"));// 제품코드
					bom.setItemCd(rs.getString("item_cd"));// 부품코드
					bom.setItemName(rs.getString("item_name"));// 부품명
					bom.setItemCnt(rs.getInt("item_cnt"));// 소요량
					bom.setUnit(rs.getString("unit"));// 단위
					bom.setUnitPrice(rs.getDouble("unit_price"));// 단가
					bom.setVendorCd(rs.getString("vendor_cd"));// 거래처코드
					bom.setRemark(rs.getString("remark"));// 비고
					bomList.add(bom);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Bom리스트 조회 실패!!" + e.getMessage());
		} finally {
			close(pstmt, rs);
		}
		
		return bomList;
		
	}
	
	// Bom 등록
	public int insertBom(Bom bom) {
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "insert into bom(product_cd, item_cd, item_name, item_cnt, unit, unit_price, vendor_cd, remark) " + 
						" values(?, ?, ?, ?, ?, ?, ?, ?)";
		
		// insertCount - 입력되는 행을 위한 변수
		int insertCount = 0;
		
		try {
			// prepareStatement - sql문 호출
			pstmt = conn.prepareStatement(sql);
			
			// 값 넣기
			pstmt.setString(1, bom.getProductCd());// 제품코드
			pstmt.setString(2, bom.getItemCd());// 부품코드
			pstmt.setString(3, bom.getItemName());// 부품명
			pstmt.setInt(4, bom.getItemCnt());// 소요량
			pstmt.setString(5, bom.getUnit());// 단위
			pstmt.setDouble(6, bom.getUnitPrice());// 단가
			pstmt.setString(7, bom.getVendorCd());// 거래처코드
			pstmt.setString(8, bom.getRemark());// 비고
			// executeUpdate - 리턴값이 int(n행을 리턴)
			insertCount = pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Bom 입력 실패!!" + e.getMessage());
		} finally {
			close(pstmt,rs);
		}
		
		return insertCount;
		
	}
	
	// Bom 글 갯수 구하기
	public int selectListCount() {
		
		int listCount = 0;
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select count(*) from bom";
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) listCount = rs.getInt(1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Bom갯수 가져오기 실패!! " + e.getMessage());
		} finally {
			close(pstmt, rs);
		}
		return listCount; 
	}
	
}
