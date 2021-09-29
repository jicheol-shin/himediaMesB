package com.mes.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.sql.DataSource;

import com.mes.vo.Vendor;

public class VendorDAO {

	private VendorDAO() {}
	private static VendorDAO vendorDAO;
	public static VendorDAO getInstance() {
		
		if(vendorDAO == null) vendorDAO = new VendorDAO();
		return vendorDAO;
		
	}
	
	Connection conn = null;
	DataSource ds = null;
	
	public void setConnection(Connection conn) {
		this.conn = conn;
	}
	
	public ArrayList<Vendor> selectVendorList(){
		
		ArrayList<Vendor> vendorList = new ArrayList<Vendor>();
		Vendor vendor = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from vendor";
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				vendor = new Vendor();
				vendor.setVendorCd(rs.getString("vendor_cd"));// 거래처코드
				vendor.setVendorName(rs.getString("vendor_name"));// 거래처명
				vendor.setVendorType(rs.getString("vendor_type"));// 거래처유형
				vendor.setVendorNum(rs.getString("vendor_num"));// 사업자등록번호
				vendor.setRepName(rs.getString("rep_name"));// 대표자
				vendor.setSectors(rs.getString("sectors"));// 업종
				vendor.setEmail(rs.getString("email"));// 이메일
				vendor.setTel(rs.getString("tel"));// 전화번호
				vendor.setRemark(rs.getString("remark"));// 비고
				vendorList.add(vendor);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Vendor리스트 조회 실패!!" + e.getMessage());
		}
		
		return vendorList;
		
	}
	
}
