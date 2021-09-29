package com.mes.dao;

import static com.mes.db.JDBCUtility.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.sql.DataSource;
import com.mes.vo.TakeOrder;

public class TakeOrderDAO {

	private TakeOrderDAO() {}
	private static TakeOrderDAO takeOrderDAO;
	public static TakeOrderDAO getInstance() {
		
		if(takeOrderDAO == null) takeOrderDAO = new TakeOrderDAO();
		return takeOrderDAO;
		
	}
	
	// DB연결
	Connection conn = null;
	DataSource ds = null;
	
	public void setConnection(Connection conn) {
		this.conn = conn;
	}	
	
	// 리스트를 불러오기
	public ArrayList<TakeOrder> selectTakeOrderList(){
		
		ArrayList<TakeOrder> takeOrderList = new ArrayList<TakeOrder>();
		TakeOrder takeOrder = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from take_order";
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				takeOrder = new TakeOrder();
				takeOrder.setOrdCd(rs.getString("ord_cd"));// 수주코드
				takeOrder.setOrdDate(rs.getDate("ord_date"));// 수주일자
				takeOrder.setVendorCd(rs.getString("vendor_cd"));// 거래처코드
				takeOrder.setProductCd(rs.getString("product_cd"));// 제품코드
				takeOrder.setProcess(rs.getString("process"));// 진행상태
				takeOrder.setOrdDelDate(rs.getDate("ord_del_date"));// 납품예정일
				takeOrder.setOrdCnt(rs.getInt("ord_cnt"));// 수주수량
				takeOrder.setRemark(rs.getString("remark"));// 비고
				takeOrderList.add(takeOrder);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("TakeOrder리스트 조회 실패!!" + e.getMessage());
		} finally {
			close(pstmt, rs);
		}
		
		return takeOrderList;
		
	}
	
	// TakeOrder 등록
	public int insertTakeOrder(TakeOrder takeOrder) {
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "insert into take_order(ord_cd, ord_date, vendor_cd, product_cd, " + 
					" process, ord_del_date, ord_cnt, remark) " + 
					" values(?, now(), ?, ?, ?, ?, ?, ?)";

		// insertCount - 입력되는 행을 위한 변수
		int insertCount = 0;
		// String -> Date
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		
		// prepareStatement - sql문 호출
		try {
			pstmt = conn.prepareStatement(sql);
			
			// 값 넣기
			pstmt.setString(1, takeOrder.getOrdCd());// 수주코드
			pstmt.setString(2, takeOrder.getVendorCd());// 거래처코드
			pstmt.setString(3, takeOrder.getProductCd());// 제품코드
			pstmt.setString(4, takeOrder.getProcess());// 진행상태
			System.out.println("TakeOrder_DAO - " + format.format(takeOrder.getOrdDelDate()));
			// util -> sql
			java.sql.Date date1 = java.sql.Date.valueOf(format.format(takeOrder.getOrdDelDate()));
			pstmt.setDate(5, date1);// 납품예정일
			pstmt.setInt(6, takeOrder.getOrdCnt());// 수주수량
			pstmt.setString(7, takeOrder.getRemark());// 비고
			// executeUpdate - 리턴값이 int(n행을 리턴)
			insertCount = pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("TakeOrder 입력 실패!!" + e.getMessage());
		} finally {
			close(pstmt,rs);
		}
		
		return insertCount;
	}
	
}
