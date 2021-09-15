package com.mes.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mes.service.ItemStockInoutService;
import com.mes.utility.Action;
import com.mes.utility.ActionForward;
import com.mes.vo.ItemStockInout;

public class ItemstockInoutAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		ArrayList<ItemStockInout> itemStockList = new ArrayList<ItemStockInout>();
		
		ItemStockInoutService itemStockInoutService = new ItemStockInoutService();
		
		itemStockList = itemStockInoutService.getItemStockList();
	
		req.setAttribute("itemStockList", itemStockList);
		
		ActionForward forward = new ActionForward();
	
		forward.setPath("/itemstock/itemstockInout.jsp");
		return forward;
	}


}
