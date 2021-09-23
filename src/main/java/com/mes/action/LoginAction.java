package com.mes.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mes.service.MemberService;
import com.mes.utility.Action;
import com.mes.utility.ActionForward;
import com.mes.vo.Member;

public class LoginAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

		ActionForward forward= null;
		
		String id = req.getParameter("userId");
		String password = req.getParameter("password");
		
		Member member = new Member();
		
		MemberService memberService = new MemberService();
		member = memberService.loginMember(id,password);
			
		if( member.getUserId() == null) {
			res.setContentType("text/html; charset=utf-8");
			PrintWriter out = res.getWriter();
			out.println("<script>");
			out.println("alert('아이디나 패스워드를 확인해 주세요!')");
			out.println("history.back()");
			out.println("</script>");
			
		} else {
			HttpSession session = req.getSession();
			session.setAttribute("login_info", member);
			
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("index.do");
			
		}		

		return forward;
	}

}
