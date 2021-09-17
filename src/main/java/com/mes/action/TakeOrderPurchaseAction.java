package com.mes.action;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mes.service.TakeOrderPurchaseService;
import com.mes.utility.Action;
import com.mes.utility.ActionForward;
import com.mes.vo.Member;
import com.mes.vo.TakeOrder;

public class TakeOrderPurchaseAction implements Action{

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
			
			forward = new ActionForward();
			ArrayList<TakeOrder> takeOrderList = new ArrayList<TakeOrder>();
			TakeOrderPurchaseService takeOrderPurchaseService = new TakeOrderPurchaseService();
			takeOrderList = takeOrderPurchaseService.getTakeOrderList();
			
			req.setAttribute("takeOrderList", takeOrderList);
			forward.setPath("/purchase/takeOrder.jsp");
		}
		return forward;
	}

}
