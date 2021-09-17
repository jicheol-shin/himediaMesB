package com.mes.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mes.service.ItemService;
import com.mes.utility.Action;
import com.mes.utility.ActionForward;
import com.mes.vo.Item;

public class ItemAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res)
			throws Exception {
		// TODO Auto-generated method stub
		ArrayList<Item> itemList = new ArrayList<Item>();
		ItemService itemService = new ItemService();
		
		itemList = itemService.getItemList();
		
		req.setAttribute("itemList", itemList);

		ActionForward forward = new ActionForward();
		forward.setPath("/item/itemView.jsp");

		return forward;
	}

}
