package com.mes.action;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mes.service.ItemStockInoutService;
import com.mes.service.ItemStockService;
import com.mes.utility.Action;
import com.mes.utility.ActionForward;
import com.mes.vo.ItemStock;
import com.mes.vo.ItemStockInout;
import com.mes.vo.Member;

public class ItemStockAction implements Action{

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
			ArrayList<ItemStock> itemStockList = new ArrayList<ItemStock>();
			ItemStockService itemStockService = new ItemStockService();
			itemStockList = itemStockService.getItemStockList();
			
			req.setAttribute("itemStockList", itemStockList);
			forward.setPath("/itemstock/itemStock.jsp");
			
		}
		
		return forward;
	}

}
