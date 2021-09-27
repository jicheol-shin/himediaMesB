package com.mes.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mes.service.ProductionCurrentService;
import com.mes.utility.Action;
import com.mes.utility.ActionForward;
import com.mes.vo.ProductionCurrent;


public class ProductionCurrentAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		// TODO Auto-generated method stub
		ArrayList<ProductionCurrent> ProductionCurrentList = new ArrayList<ProductionCurrent>();
		ProductionCurrentService productionCurrentService = new ProductionCurrentService();
		
		ProductionCurrentList = productionCurrentService.getProductionCurrentList();
		
		req.setAttribute("productionCurrentList", productionCurrentService);
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(true);
		forward.setPath("/productionpercent/productionpercent.jsp");
		
		return forward;
	}

}
