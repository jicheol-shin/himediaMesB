package com.mes.service;
import static com.mes.db.JDBCUtility.*;

import java.sql.Connection;

import com.mes.dao.MemberDAO;
import com.mes.vo.Member;

public class MemberService {

	public Member loginMember(String id, String password) {
		Member member = new Member();
		Connection conn = getConnection();
		MemberDAO memberDAO = MemberDAO.getInstance();
		memberDAO.setConnection(conn);
		member = memberDAO.loginCheck(id,password);
		
		close(conn);
	
		return member; 	
	}

}
