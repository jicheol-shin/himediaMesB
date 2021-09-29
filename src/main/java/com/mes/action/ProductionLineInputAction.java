package com.mes.action;

import java.io.PrintWriter;

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
ActionForward forward = null;
		
		ProductionLineInput productionLineInput = new ProductionLineInput();
		
		productionLineInput.setWorkOrderNo(req.getParameter("workOrderNo"));
		productionLineInput.setProductCd(req.getParameter("productCd"));
		productionLineInput.setWorkQty(Integer.parseUnsignedInt("workQty"));
		ProductionLineInputService productionLineInputService = new ProductionLineInputService();
		boolean isWriteSuccess = productionLineInputService.registProductionInput(productionLineInput);
		
		
				if(!isWriteSuccess) {
					// isWriteSuccess가 true가 아니라면
					res.setContentType("text/html; charset=utf-8");
					PrintWriter out = res.getWriter();
					out.println("<script>");
					out.println("alert('prodcutionLine 등록 실패!!')");
					out.println("history.back()");
					out.println("</script>");
				} else {
					forward = new ActionForward();
					forward.setRedirect(true);
					forward.setPath("prodcutionLine.do");
				}
		
		
		
		return forward;
	}

}
