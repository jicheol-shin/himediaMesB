package com.mes.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mes.service.ProductionService;
import com.mes.utility.Action;
import com.mes.utility.ActionForward;
import com.mes.vo.Production;

public class ProductionAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		// TODO Auto-generated method stub
		ArrayList<Production> productionList = new ArrayList<Production>();
		ProductionService productionService = new ProductionService();
		
		productionList = productionService.getProductionList();
		
		req.setAttribute("productionList", productionList);
		
		ActionForward forward = new ActionForward();
		forward.setPath("/production/production.jsp");
		
		return forward;
	}

}
