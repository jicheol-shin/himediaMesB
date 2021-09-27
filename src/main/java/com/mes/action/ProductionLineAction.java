package com.mes.action;

import java.util.ArrayList;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mes.service.ProductionLineService;
import com.mes.utility.Action;
import com.mes.utility.ActionForward;
import com.mes.vo.ProductionLine;

public class ProductionLineAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		// TODO Auto-generated method stub
		ArrayList<ProductionLine> productionLineList = new ArrayList<ProductionLine>();
		ProductionLineService productionLineService  = new ProductionLineService();
		
		productionLineList = productionLineService.getProductionLineList();
		
		req.setAttribute("productionLineList", productionLineList);
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(true);
		forward.setPath("/pro_line/productionline.jsp");
		
		return forward;
	}

}
