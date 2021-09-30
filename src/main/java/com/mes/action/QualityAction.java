package com.mes.action;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mes.service.QualityTestService;
import com.mes.utility.Action;
import com.mes.utility.ActionForward;
import com.mes.vo.Member;
import com.mes.vo.ProductionLine;
import com.mes.vo.Quality;

public class QualityAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

		ActionForward forward= null;
		
		HttpSession session = req.getSession();
		Member member = (Member) session.getAttribute("login_info");
		
		if(member== null) {
			res.setContentType("text/html; charset=utf-8");
			PrintWriter out = res.getWriter();
			out.println("<script>");
			out.println("alert('로그인해 주세요!')");
			out.println("history.back()");
			out.println("</script>");
			
		} else {
		
			ArrayList<Quality> qualityList = new ArrayList<Quality>();
			QualityTestService qualityService = new QualityTestService();
			
			qualityList = qualityService.getQualityList();
			
			req.setAttribute("qualityList", qualityList);
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("/quality/quality.jsp");
			
		}	
			
		return forward;
	}

}
