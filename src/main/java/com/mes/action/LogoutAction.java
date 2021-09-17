package com.mes.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mes.utility.Action;
import com.mes.utility.ActionForward;
import com.mes.vo.Member;


public class LogoutAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		ActionForward forward= null;
		
		HttpSession session = req.getSession();
		Member member = (Member) session.getAttribute("login_info");
		
		if(member== null) {
			req.setAttribute("error_message", "로그인하지 않았습니다!!");
			
		} else {
			session.invalidate();  //세션종료
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("index.do");
		}
		return forward;
	}
}
