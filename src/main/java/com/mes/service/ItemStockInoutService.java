package com.mes.service;

import static com.mes.db.JDBCUtility.*;

import java.sql.Connection;
import java.util.ArrayList;

import com.mes.dao.ItemStockDAO;
import com.mes.vo.ItemStockInout;

public class ItemStockInoutService {


	public ArrayList<ItemStockInout> getItemStockInoutList() {
		ArrayList<ItemStockInout> itemStockInoutList = null;
		Connection conn = getConnection();
		ItemStockDAO itemstockDAO = ItemStockDAO.getInstance();		
		itemstockDAO.setConnection(conn);
		itemStockInoutList = itemstockDAO.selectItemstockList();
		close(conn);
		return itemStockInoutList; 
	}
	
	
	
}
