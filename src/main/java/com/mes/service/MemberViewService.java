package com.mes.service;

import static com.mes.db.JDBCUtility.close;
import static com.mes.db.JDBCUtility.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import com.mes.dao.MemberViewDAO;
import com.mes.vo.Member;

public class MemberViewService {

	public ArrayList<Member> getMemberList(){
		
		ArrayList<Member> memberList = null;
		
		Connection conn = getConnection();
		MemberViewDAO memberViewDAO = MemberViewDAO.getInstance();
		memberViewDAO.setConnection(conn);
		memberList = memberViewDAO.selectMemberList();
		
		close(conn);
		
		return memberList;
		
	}
	
}
