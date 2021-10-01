package com.mes.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mes.service.ItemService;
import com.mes.service.ProductService;
import com.mes.service.VendorService;
import com.mes.utility.Action;
import com.mes.utility.ActionForward;
import com.mes.vo.Item;
import com.mes.vo.Product;
import com.mes.vo.Vendor;

public class BomInputFormAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res)
			throws Exception {
		// TODO Auto-generated method stub
		ActionForward actionForward = new ActionForward();
		
		// Product 불러오기
		ArrayList<Product> productList = new ArrayList<Product>();
		ProductService productService = new ProductService();
		productList = productService.getProductList();
		// Item 불러오기
		ArrayList<Item> itemList = new ArrayList<Item>();
		ItemService itemService = new ItemService();
		itemList = itemService.getItemList();
		// Vendor 불러오기
		ArrayList<Vendor> vendorList = new ArrayList<Vendor>();
		VendorService vendorService = new VendorService();
		vendorList = vendorService.getVendorList();
		
		req.setAttribute("vendorList", vendorList);
		req.setAttribute("productList", productList);
		req.setAttribute("itemList", itemList);
		
		actionForward.setRedirect(true);
		actionForward.setPath("/bom/bomInput.jsp");
		return actionForward;
	}

}
