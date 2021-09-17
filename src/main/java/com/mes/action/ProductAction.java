package com.mes.action;

import java.util.ArrayList;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mes.service.ProductService;
import com.mes.utility.Action;
import com.mes.utility.ActionForward;
import com.mes.vo.Product;

public class ProductAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res)
			throws Exception {
		// TODO Auto-generated method stub
		ArrayList<Product> productList = new ArrayList<Product>();
		ProductService productService = new ProductService();
		
		productList = productService.getProductList();
		
		req.setAttribute("productList", productList);
		
		ActionForward forward = new ActionForward();
		forward.setPath("/product/productView.jsp");
		
		return forward;
	}

	
}
