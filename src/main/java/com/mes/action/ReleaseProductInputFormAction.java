package com.mes.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mes.service.ItemService;
import com.mes.service.ProductService;
import com.mes.service.ReleaseProductViewService;
import com.mes.service.TakeOrderViewService;
import com.mes.service.VendorService;
import com.mes.utility.Action;
import com.mes.utility.ActionForward;
import com.mes.vo.Item;
import com.mes.vo.Product;
import com.mes.vo.ReleaseProduct;
import com.mes.vo.TakeOrder;
import com.mes.vo.Vendor;

public class ReleaseProductInputFormAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		// TODO Auto-generated method stub
		
		ActionForward actionForward = new ActionForward();
		
		// ReleaseProduct 불러오기
		ArrayList<ReleaseProduct> releaseProductList = new ArrayList<ReleaseProduct>();
		ReleaseProductViewService releaseProductViewService = new ReleaseProductViewService();
		releaseProductList = releaseProductViewService.getReleaseProductList();
		// TakeOrder 불러오기
		ArrayList<TakeOrder> takeOrderList = new ArrayList<TakeOrder>();
		TakeOrderViewService takeOrderViewService = new TakeOrderViewService();
		takeOrderList = takeOrderViewService.getTakeOrderList();
		// Vendor 불러오기
		ArrayList<Vendor> vendorList = new ArrayList<Vendor>();
		VendorService vendorService = new VendorService();
		vendorList = vendorService.getVendorList();
		// Product 불러오기
		ArrayList<Product> productList = new ArrayList<Product>();
		ProductService productService = new ProductService();
		productList = productService.getProductList();
		
		req.setAttribute("releaseProductList", releaseProductList);
		req.setAttribute("takeOrderList", takeOrderList);
		req.setAttribute("vendorList", vendorList);
		req.setAttribute("productList", productList);
		
		actionForward.setRedirect(true);
		actionForward.setPath("/releaseProduct/releaseProductInput.jsp");
		return actionForward;
	}

}
