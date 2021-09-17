package com.mes.dao;

import static com.mes.db.JDBCUtility.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.sql.DataSource;

import com.mes.vo.Item;

public class ItemDAO {

	private ItemDAO() {}
	private static ItemDAO itemDAO;
	// 하나의 객체생성을 위한 getInstance
	public static ItemDAO getInstance() {
		
		if(itemDAO == null) itemDAO = new ItemDAO();
		return itemDAO;
		
	}
	
	// DB연결
	Connection conn = null;
	DataSource ds = null;
	
	public void setConnection(Connection conn) {
		this.conn = conn;
	}
	
	// Item리스트를 불러오기
	public ArrayList<Item> selectItemList(){
		
		ArrayList<Item> itemList = new ArrayList<Item>();
		Item item = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from item";
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			// rs.next가 true일 동안 item가져오기
			while (rs.next()) {
				item = new Item();
				item.setItemCd(rs.getString("item_cd"));// 부품코드
				item.setItemName(rs.getString("item_name"));// 부품명
				item.setItemType(rs.getString("item_type"));// 구분
				item.setVendorCd(rs.getString("vendor_cd"));// 거래처코드
				item.setUnitPrice(rs.getInt("unit_price"));// 표준단가
				item.setLeadTime(rs.getInt("lead_time"));// 유통기한
				item.setRemark(rs.getString("remark"));// 비고
				itemList.add(item);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Item리스트 조회 실패!! " + e.getMessage());
		} finally {
			close(pstmt, rs);
		}
		
		return itemList;
		
	}
	
}
