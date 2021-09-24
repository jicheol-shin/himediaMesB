package com.mes.service;

import static com.mes.db.JDBCUtility.*;

import java.sql.Connection;
import java.util.ArrayList;

import com.mes.dao.ProductDAO;
import com.mes.vo.Product;

public class ProductService {

	public ArrayList<Product> getProductList(){
		
		ArrayList<Product> ProductList = null;
		
		Connection conn = getConnection();
		ProductDAO productDAO = ProductDAO.getInstance();
		productDAO.setConnection(conn);
		ProductList = productDAO.selectProductList();
		
		close(conn);
		
		return ProductList;
	
	}
	
}
