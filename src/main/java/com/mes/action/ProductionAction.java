package com.mes.action;

import java.util.ArrayList;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mes.service.ProductionService;
import com.mes.utility.Action;
import com.mes.utility.ActionForward;
import com.mes.vo.Production;
import com.mes.vo.TakeOrder;

public class ProductionAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		// TODO Auto-generated method stub
		ArrayList<TakeOrder> takeOrderList = new ArrayList<TakeOrder>();
		ProductionService productionService = new ProductionService();
		
		takeOrderList = productionService.gettakeOrderList();
		
		req.setAttribute("takeOrderList", takeOrderList);
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(true);
		forward.setPath("/production/production.jsp");
		
		return forward;
	}

}
