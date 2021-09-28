package com.mes.action;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mes.service.ItemStockInoutService;
import com.mes.utility.Action;
import com.mes.utility.ActionForward;
import com.mes.utility.Pager;
import com.mes.vo.ItemStockInout;
import com.mes.vo.Member;

public class ItemStockInoutAction implements Action {

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
			
			int page  = 1;
			int limit = 10;
			String stockInout = null;
			if(req.getParameter("page") != null) page = Integer.parseInt(req.getParameter("page"));
			if(req.getParameter("stockInout") != null) stockInout = req.getParameter("stockInout");
						
			forward= new ActionForward();	
			ArrayList<ItemStockInout> itemStockInoutList = new ArrayList<ItemStockInout>();
			ItemStockInoutService itemStockInoutService = new ItemStockInoutService();
			
			
			int listCount = itemStockInoutService.getListCount(stockInout);
			
			itemStockInoutList = itemStockInoutService.getItemStockInoutList(page,limit,stockInout);
			
			// 총페이지수
			int totalPage = (int)((double)listCount / limit + 0.95);
			// 현재페이지의 시작페이지수(1, 11, 21...)
			int stratPage = (((int) ((double)page / 10 + 0.9))-1) * 10 + 1;
			// 현재페이지에 보여줄 마지막페이지수
			int endPage = stratPage + 10 - 1;
			if(endPage > totalPage) endPage = totalPage;
			
			
			Pager pageInfo = new Pager(page,totalPage,10,10);
			pageInfo.setEndPage(endPage);
			pageInfo.setTotalPage(totalPage);
			pageInfo.setPageNum(page);
			pageInfo.setStartPage(stratPage);
			
			req.setAttribute("pageInfo", pageInfo);
			req.setAttribute("itemStockInoutList", itemStockInoutList);
			forward.setRedirect(true);
			forward.setPath("/itemstock/itemStockInout.jsp");
			
		}
		
		return forward;
	}

}
