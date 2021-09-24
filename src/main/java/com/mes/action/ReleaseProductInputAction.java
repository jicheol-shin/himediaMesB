package com.mes.action;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mes.service.ReleaseProductInputService;
import com.mes.utility.Action;
import com.mes.utility.ActionForward;
import com.mes.vo.ReleaseProduct;

public class ReleaseProductInputAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res)
			throws Exception {
		// TODO Auto-generated method stub
		ActionForward forward = null;
		// String -> Date
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		
		ReleaseProduct releaseProduct = new ReleaseProduct();
		
		releaseProduct.setReleCd(req.getParameter("releCd"));// 출고요청코드
		releaseProduct.setReleDate((java.sql.Date) format.parse(req.getParameter("releDate")));// 출하요청일자
		releaseProduct.setOrdCd(req.getParameter("ordCd"));// 수주코드
		releaseProduct.setCustomer(req.getParameter("customer"));// 거래처
		releaseProduct.setProductCd(req.getParameter("productCd"));// 제품코드
		releaseProduct.setProcess(req.getParameter("process"));// 진행상태
		releaseProduct.setReqCnt(Integer.parseUnsignedInt(req.getParameter("reqCnt")));// 요청수량
		releaseProduct.setReleCnt(Integer.parseUnsignedInt(req.getParameter("releCnt")));// 출하수량
		releaseProduct.setBackCnt(Integer.parseUnsignedInt(req.getParameter("backCnt")));// 요청잔량
		releaseProduct.setReleDelDate((java.sql.Date) format.parse(req.getParameter("releDelDate")));// 납품예정일
		releaseProduct.setRemark(req.getParameter("remark"));// 비고
		ReleaseProductInputService releaseProductInputService = new ReleaseProductInputService();
		boolean isWriteSuccess = releaseProductInputService.registReleaseProduct(releaseProduct);
		
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
			forward.setPath("releaseProductView.do");
		}
		
		return forward;
	}

}
