package com.mes.action;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mes.service.ProductService;
import com.mes.utility.Action;
import com.mes.utility.ActionForward;
import com.mes.vo.Product;
import com.mes.vo.Member;

public class ProductAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res)
			throws Exception {
		// TODO Auto-generated method stub
		ActionForward forward = null;
		
		HttpSession session = req.getSession();
		Member member = (Member) session.getAttribute("login_info");
		
		if(member==null) {
			res.setContentType("text/html; charset=utf-8");
			PrintWriter out = res.getWriter();
			out.println("<script>");
			out.println("alert('로그인해 주세요!')");
			out.println("history.back()");
			out.println("</script>");
		} else {
			forward = new ActionForward();
			ArrayList<Product> productList = new ArrayList<Product>();
			ProductService productService = new ProductService();
			
			productList = productService.getProductList();
			
			req.setAttribute("productList", productList);
			forward.setRedirect(true);
			forward.setPath("/product/productView.jsp");
		}
		
		return forward;
	}

	
}
