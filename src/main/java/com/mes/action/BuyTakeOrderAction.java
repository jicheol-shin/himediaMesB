package com.mes.action;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mes.service.OrderStatementService;
import com.mes.utility.Action;
import com.mes.utility.ActionForward;
import com.mes.utility.Pager;
import com.mes.vo.Member;
import com.mes.vo.OrderStatement;

public class BuyTakeOrderAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		ActionForward forward = null;
		
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
			
			int page = 1;
			int limit = 10;
			String ordCd = null;
			if(req.getParameter("page") != null) page = Integer.parseInt(req.getParameter("page"));
			if(req.getParameter("ordCd") != null) ordCd = req.getParameter("ordCd");
			
			forward = new ActionForward();
			ArrayList<OrderStatement> orderStatementList = new ArrayList<OrderStatement>();
			OrderStatementService orderStatementService = new OrderStatementService();
			
			int listCount = orderStatementService.getListCount(ordCd);
			
			orderStatementList = orderStatementService.getOrderStatementList(page, limit, ordCd);
			
			Pager pageInfo = new Pager(page, listCount, 10, 10);
			
			req.setAttribute("pageInfo", pageInfo);
			req.setAttribute("orderStatementList", orderStatementList);
			forward.setRedirect(true);
			forward.setPath("/purchase/buyTakeOrder.jsp");
		}
		
		return forward;
	}

}
