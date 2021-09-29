package com.mes.service;

import static com.mes.db.JDBCUtility.*;

import java.sql.Connection;
import java.util.ArrayList;

import com.mes.dao.ItemStockDAO;
import com.mes.vo.ItemStockOutOrder;


public class ItemStockOutOrderService {


	public ArrayList<ItemStockOutOrder> getItemStockOutOrderList() {
		ArrayList<ItemStockOutOrder> itemStockOutOrderList = null;
		Connection conn = getConnection();
		ItemStockDAO itemstockDAO = ItemStockDAO.getInstance();		
		itemstockDAO.setConnection(conn);
		itemStockOutOrderList = itemstockDAO.selectItemStockOutOrderList();
		close(conn);
		return itemStockOutOrderList; 
	}
	
}
