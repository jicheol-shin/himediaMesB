package com.mes.action;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mes.service.TakeOrderInputService;
import com.mes.utility.Action;
import com.mes.utility.ActionForward;
import com.mes.vo.TakeOrder;

public class TakeOrderInputAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res)
			throws Exception {
		// TODO Auto-generated method stub
		ActionForward forward = null;
		// String -> Date
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		
		TakeOrder takeOrder = new TakeOrder();
		
		takeOrder.setOrdCd(req.getParameter("ordCd"));// 수주코드
		takeOrder.setOrdDate(format.parse(req.getParameter("ordDate")));// 수주일자
		takeOrder.setVendorCd(req.getParameter("vendorCd"));// 거래처코드
		takeOrder.setProductCd(req.getParameter("productCd"));// 제품코드
		takeOrder.setProcess(req.getParameter("process"));// 진행상태
		takeOrder.setOrdDelDate(format.parse(req.getParameter("ordDelDate")));// 납품예정일
		takeOrder.setOrdCnt(Integer.parseUnsignedInt(req.getParameter("ordCnt")));// 수주수량
		takeOrder.setRemark(req.getParameter("remark"));// 비고
		TakeOrderInputService takeOrderInputService = new TakeOrderInputService();
		boolean isWriteSuccess = takeOrderInputService.registTakeOrder(takeOrder);
		
		if(!isWriteSuccess) {
			// isWriteSuccess가 true가 아니라면
			res.setContentType("text/html; charset=utf-8");
			PrintWriter out = res.getWriter();
			out.println("<script>");
			out.println("alert('TakeOrder 등록 실패!!')");
			out.println("history.back()");
			out.println("</script>");
		} else {
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("takeOrderView.do");
		}
		
		return forward;
	}

}
