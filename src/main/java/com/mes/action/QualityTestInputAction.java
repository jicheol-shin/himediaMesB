package com.mes.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mes.service.QualityTestService;
import com.mes.utility.Action;
import com.mes.utility.ActionForward;
import com.mes.vo.Member;

public class QualityTestInputAction implements Action{

	@SuppressWarnings("unused")
	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		ActionForward forward= null;
		
		HttpSession session = req.getSession();
		Member member = (Member) session.getAttribute("login_info");
		
		String userId = member.getUserId();
		
		if(member== null) {
			res.setContentType("text/html; charset=utf-8");
			PrintWriter out = res.getWriter();
			out.println("<script>");
			out.println("alert('로그인해 주세요!')");
			out.println("history.back()");
			out.println("</script>");
			
		} else {
		
			String workOrderNo = req.getParameter("workOrderNo");
			
			forward= new ActionForward();
			QualityTestService qualityService = new QualityTestService();
			qualityService.registrQualityTest(workOrderNo,userId);
			forward.setRedirect(true);
			forward.setPath("/quality.do");
			
		}	
			
		return forward;
	}
}
