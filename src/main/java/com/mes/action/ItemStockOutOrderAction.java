package com.mes.action;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mes.service.ItemStockInoutService;
import com.mes.service.ItemStockOutOrderService;
import com.mes.utility.Action;
import com.mes.utility.ActionForward;
import com.mes.vo.ItemStockInout;
import com.mes.vo.ItemStockOutOrder;
import com.mes.vo.Member;

public class ItemStockOutOrderAction implements Action{

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
			
			forward= new ActionForward();	
			ArrayList<ItemStockOutOrder> itemStockOutOrderList = new ArrayList<ItemStockOutOrder>();
			ItemStockOutOrderService itemStockOutOrderService = new ItemStockOutOrderService();
			itemStockOutOrderList = itemStockOutOrderService.getItemStockOutOrderList();
			
			req.setAttribute("itemStockOutOrderList", itemStockOutOrderList);
			forward.setPath("/itemstock/itemStockOutOrder.jsp");
			
		}
		
		return forward;
	}


}
