package com.mes.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mes.utility.Action;
import com.mes.utility.ActionForward;


public class LogoutAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		ActionForward forward= new ActionForward();
		
		HttpSession session = req.getSession();
		session.invalidate();  
		forward.setRedirect(true);
		forward.setPath("index.do");
		return forward;
	}
}
