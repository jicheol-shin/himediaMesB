package com.mes.service;

import static com.mes.db.JDBCUtility.*;

import java.sql.Connection;
import java.util.ArrayList;

import com.mes.dao.ProductInventoryDAO;
import com.mes.vo.ProductInventory;

public class ProductInventoryService {

	public ArrayList<ProductInventory> getProductInventoryList() {
		
		ArrayList<ProductInventory> ProductInventoryList = null;
		Connection conn = getConnection();
		ProductInventoryDAO productInventoryDAO = ProductInventoryDAO.getInstance();
		productInventoryDAO.setConnection(conn);
		ProductInventoryList = productInventoryDAO.selectProductInventoryList();
		close(conn);
		return ProductInventoryList;
	}
}
