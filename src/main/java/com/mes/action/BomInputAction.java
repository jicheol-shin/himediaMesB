package com.mes.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mes.service.BomInputService;
import com.mes.utility.Action;
import com.mes.utility.ActionForward;
import com.mes.vo.Bom;

public class BomInputAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res)
			throws Exception {
		// TODO Auto-generated method stub
		ActionForward forward = null;
		
		Bom bom = new Bom();
		
		bom.setProductCd(req.getParameter("productCd"));// 제품코드
		bom.setItemCd(req.getParameter("itemCd"));// 부품코드
		bom.setItemName(req.getParameter("itemName"));// 부품명
		bom.setItemCnt(Integer.parseUnsignedInt(req.getParameter("itemCnt")));// 소요량
		bom.setUnit(req.getParameter("unit"));// 단위
		bom.setUnitPrice(Double.parseDouble(req.getParameter("unitPrice")));// 단가
		bom.setVendorCd(req.getParameter("vendorCd"));// 거래처코드
		bom.setRemark(req.getParameter("remark"));// 비고
		BomInputService bomInputService = new BomInputService();
		boolean isWriteSuccess = bomInputService.registBom(bom);
		
		if(!isWriteSuccess) {
			// isWriteSuccess가 true가 아니라면
			res.setContentType("text/html; charset=utf-8");
			PrintWriter out = res.getWriter();
			out.println("<script>");
			out.println("alert('Bom 등록 실패!!')");
			out.println("history.back()");
			out.println("</script>");
		} else {
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("bomView.do");
		}
		
		return forward;
	}

}
