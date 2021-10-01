package com.mes.action;

import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mes.service.PrudctionInputService;
import com.mes.utility.Action;
import com.mes.utility.ActionForward;
import com.mes.vo.Member;

public class ProductionInputAction  implements Action{

	@SuppressWarnings("unused")
	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

		ActionForward forward = null;
		
		HttpSession session = req.getSession();
		Member member = (Member) session.getAttribute("login_info");
		String name = member.getUserName();
		
		if(member== null) {
			res.setContentType("text/html; charset=utf-8");
			PrintWriter out = res.getWriter();
			out.println("<script>");
			out.println("alert('로그인해 주세요!')");
			out.println("history.back()");
			out.println("</script>");
			
		} else {
			String ordCd = req.getParameter("ordCd");
			
			forward= new ActionForward();
			PrudctionInputService prudctionInputService = new PrudctionInputService();
			prudctionInputService.registPrudctionInput(ordCd,name);
			
			forward.setRedirect(true);
			forward.setPath("prodcutionLine.do");
		}
		return forward;
	}
	

}
