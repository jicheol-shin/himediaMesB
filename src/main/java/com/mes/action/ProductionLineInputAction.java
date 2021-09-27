package com.mes.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mes.service.ProductionLineInputService;
import com.mes.utility.Action;
import com.mes.utility.ActionForward;
import com.mes.vo.ProductionLineInput;


public class ProductionLineInputAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		// TODO Auto-generated method stub
		ArrayList<ProductionLineInput> productionLineInputList = new ArrayList<ProductionLineInput>();
		ProductionLineInputService productionLineInputService  = new ProductionLineInputService();
		
		productionLineInputList = productionLineInputService.getProductionLineInputList();
		
		req.setAttribute("productionLineInputList", productionLineInputList);
		
		ActionForward forward = new ActionForward();
		forward.setPath("/pro_line/productionlineInput.jsp");
		
		return forward;
	}

}
