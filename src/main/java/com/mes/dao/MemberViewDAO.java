package com.mes.dao;

import static com.mes.db.JDBCUtility.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.sql.DataSource;

import com.mes.vo.Member;

public class MemberViewDAO {

	private MemberViewDAO() {}
	private static MemberViewDAO memberViewDAO;
	// 하나의 객체생성을 위한 getInstance
	public static MemberViewDAO getInstance() {
		
		if(memberViewDAO == null) memberViewDAO = new MemberViewDAO();
		return memberViewDAO;
		
	}
	
	// DB연결
	Connection conn = null;
	DataSource ds = null;
	
	public void setConnection(Connection conn) {
		this.conn = conn;
	}
	
	// 리스트불러오기
	public ArrayList<Member> selectMemberList(){
		
		ArrayList<Member> memberList = new ArrayList<Member>();
		Member member = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from Member";
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			// rs.next가 true일 동안 리스트내용 가져오기
			while (rs.next()) {
				member = new Member();
				member.setUserId(rs.getString("user_id"));// 사용자ID
				member.setPassword(rs.getString("password"));// 사용자비밀번호
				member.setUserName(rs.getString("user_name"));// 사용자명
				member.setEmail(rs.getString("email"));// 이메일
				member.setTel(rs.getString("tel"));// 전화번호
				member.setDep(rs.getString("dep"));// 부서
				member.setRank(rs.getString("rank"));// 직급
				member.setRemark(rs.getString("remark"));// 비고
				memberList.add(member);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Member리스트 조회 실패!!" + e.getMessage());
		} finally {
			close(pstmt, rs);
		}
		
		return memberList;
	
	}
}
