package com.mes.action;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mes.service.MemberViewService;
import com.mes.utility.Action;
import com.mes.utility.ActionForward;
import com.mes.vo.Member;

public class MemberViewAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res)
			throws Exception {
		// TODO Auto-generated method stub
		ActionForward forward = null;
		
		HttpSession session = req.getSession();
		Member member = (Member) session.getAttribute("login_info");
		
		if(member==null) {
			res.setContentType("text/html; charset=utf-8");
			PrintWriter out = res.getWriter();
			out.println("<script>");
			out.println("alert('로그인해 주세요!')");
			out.println("history.back()");
			out.println("</script>");
		} else {
			forward = new ActionForward();
			ArrayList<Member> memberList = new ArrayList<Member>();
			MemberViewService memberViewService = new MemberViewService();
			memberList = memberViewService.getMemberList();
			
			req.setAttribute("memberList", memberList);
			forward.setPath("/member/memberView.jsp");
		
		}	
			
		return forward;
	}

}
