package com.mes.dao;

import static com.mes.db.JDBCUtility.*;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;

import javax.sql.DataSource;

import com.mes.vo.ReleaseProduct;

public class ReleaseProductDAO {

	private ReleaseProductDAO() {}
	private static ReleaseProductDAO releaseProductDAO;
	public static ReleaseProductDAO getInstance() {
		
		if(releaseProductDAO == null) releaseProductDAO = new ReleaseProductDAO();
		return releaseProductDAO;
		
	}
	
	// DB연결
	Connection conn = null;
	DataSource ds = null;
	
	public void setConnection(Connection conn) {
		this.conn = conn;
	}	
	
	// 리스트를 불러오기
	public ArrayList<ReleaseProduct> selectReleaseProductList(){
		
		ArrayList<ReleaseProduct> releaseProductList = new ArrayList<ReleaseProduct>();
		ReleaseProduct releaseProduct = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
//		String sql = "select * from release_product";
		String sql = "select a.*, b.good_count from release_product as a" ;
		   sql += " left join product_inventory as b on a.product_cd = b.product_cd";
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				releaseProduct = new ReleaseProduct();
				releaseProduct.setReleCd(rs.getString("rele_cd"));// 출고요청코드
				releaseProduct.setReleDate(rs.getDate("rele_date"));// 출고요청일자
				releaseProduct.setOrdCd(rs.getString("ord_cd"));// 수주코드
				releaseProduct.setCustomer(rs.getString("customer"));// 거래처
				releaseProduct.setProductCd(rs.getString("product_cd"));// 제품코드
				releaseProduct.setProcess(rs.getString("process"));// 진행상태
				releaseProduct.setReqCnt(rs.getInt("req_cnt"));// 요청수량
				releaseProduct.setReleCnt(rs.getInt("rele_cnt"));// 출하수량
				releaseProduct.setReleCnt(rs.getInt("good_count"));// 재고수량
				releaseProduct.setBackCnt(rs.getInt("back_cnt"));// 요청잔량
				releaseProduct.setReleDelDate(rs.getDate("rele_del_date"));// 납품예정일
				releaseProduct.setRemark(rs.getString("remark"));// 비고
				releaseProductList.add(releaseProduct);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("ReleaseProduct리스트 조회 실패!!" + e.getMessage());
		} finally {
			close(pstmt, rs);
		}
		
		return releaseProductList;
		
	}
	
	// ReleaseProduct 등록
	public int insertReleateProduct(ReleaseProduct releaseProduct) {
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "insert into release_product(rele_cd, rele_date, ord_cd, customer, product_cd" + 
					" process, req_cnt, rele_cnt, back_cnt, rele_del_date, remark) " + 
					" values(?,?,?,?,?,?,?,?,?,?,?)";

		// insertCount - 입력되는 행을 위한 변수
		int insertCount = 0;
		// String -> Date
		SimpleDateFormat format = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);
		SimpleDateFormat reformat = new SimpleDateFormat("yyyy-MM-dd", Locale.KOREA);
		
		// prepareStatement - sql문 호출
		try {
			pstmt = conn.prepareStatement(sql);
			
			// 값 넣기
			pstmt.setString(1, releaseProduct.getReleCd());// 출고요청코드
			pstmt.setDate(2, (Date) releaseProduct.getReleDate());// 출하요청일자
			pstmt.setString(3, releaseProduct.getOrdCd());// 수주코드
			pstmt.setString(4, releaseProduct.getCustomer());// 거래처
			pstmt.setString(5, releaseProduct.getProductCd());// 제품코드
			pstmt.setString(6, releaseProduct.getProcess());// 진행상태
			pstmt.setInt(7, releaseProduct.getReqCnt());// 요청수량
			pstmt.setInt(8, releaseProduct.getReleCnt());// 출하수량
			pstmt.setInt(9, releaseProduct.getBackCnt());// 요청잔량
			pstmt.setDate(10, (Date) releaseProduct.getReleDelDate());// 납품예정일
			pstmt.setString(11, releaseProduct.getRemark());// 비고
			// executeUpdate - 리턴값이 int(n행을 리턴)
			insertCount = pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("ReleasetProduct 입력 실패!!" + e.getMessage());
		} finally {
			close(pstmt,rs);
		}
		
		return insertCount;
	}
	
}
