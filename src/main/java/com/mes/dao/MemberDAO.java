package com.mes.dao;

import static com.mes.db.JDBCUtility.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.DataSource;

import com.mes.vo.Member;


public class MemberDAO {

	private MemberDAO() {}
	private static MemberDAO memberDAO;
	public static MemberDAO getInstance() {
		if(memberDAO == null) memberDAO = new MemberDAO();
		return memberDAO;
	}

	Connection conn = null;
	DataSource ds = null;

	// DB커넥션
	public void setConnection(Connection conn) {
		this.conn = conn;
	}

	public Member loginCheck(String id, String password) {
		Member member = new Member();
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from member where user_id = ? and password = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, password);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				member.setUserId(rs.getString("user_id"));
				member.setPassword(rs.getString("password"));
				member.setUserName(rs.getString("user_name"));
			 }
			
		} catch (Exception e) {
			System.out.println("아이디나 패스워드를 확인해 주세요!! " + e.getMessage());
		} finally {
			close(pstmt, rs);
		}
		
		return member; 
	}
	
	
	
	
	
	
	
	
	
	
	
}
