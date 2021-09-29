package com.mes.action;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mes.service.BomViewService;
import com.mes.utility.Action;
import com.mes.utility.ActionForward;
import com.mes.utility.Pager;
import com.mes.vo.Bom;
import com.mes.vo.Member;

public class BomViewAction implements Action{

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
			
			int page = 1;
			int limit = 10;
			String productCd = null;
			if(req.getParameter("page") != null) page = Integer.parseInt(req.getParameter("page"));
			if(req.getParameter("productCd") != null) productCd = req.getParameter("productCd");
			
			forward = new ActionForward();
			ArrayList<Bom> bomList = new ArrayList<Bom>();
			BomViewService bomViewService = new BomViewService();
			
			int listCount = bomViewService.getListCount();
			
			bomList = bomViewService.getBomList(page, limit, productCd);
			
			Pager pageInfo = new Pager(page,listCount,10,10);
			
			req.setAttribute("pageInfo", pageInfo);
			
			req.setAttribute("bomList", bomList);
			forward.setRedirect(true);
			forward.setPath("/bom/bomView.jsp");
			
		}
		
		return forward;
	}

}
