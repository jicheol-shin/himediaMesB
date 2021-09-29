package com.mes.service;

import static com.mes.db.JDBCUtility.close;
import static com.mes.db.JDBCUtility.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import com.mes.dao.ItemStockDAO;
import com.mes.vo.ItemStock;

public class ItemStockService {

	public ArrayList<ItemStock> getItemStockList() {
		ArrayList<ItemStock> itemStockList = null;
		Connection conn = getConnection();
		ItemStockDAO itemstockDAO = ItemStockDAO.getInstance();		
		itemstockDAO.setConnection(conn);
		itemStockList = itemstockDAO.selectItemStockList();
		close(conn);
		return itemStockList; 
	}

}
