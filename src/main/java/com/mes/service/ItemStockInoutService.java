package com.mes.service;

import static com.mes.db.JDBCUtility.*;

import java.sql.Connection;
import java.util.ArrayList;

import com.mes.dao.ItemStockDAO;
import com.mes.vo.ItemStockInout;

public class ItemStockInoutService {


	public ArrayList<ItemStockInout> getItemStockInoutList(int page, int limit, String stockInout) {
		ArrayList<ItemStockInout> itemStockInoutList = null;
		Connection conn = getConnection();
		ItemStockDAO itemstockDAO = ItemStockDAO.getInstance();		
		itemstockDAO.setConnection(conn);
		itemStockInoutList = itemstockDAO.selectItemstockList(page,limit,stockInout);
		close(conn);
		return itemStockInoutList; 
	}

	public int getListCount(String stockInout) {
		
		int listCount = 0;
		Connection conn = getConnection();
		ItemStockDAO itemStockDAO = ItemStockDAO.getInstance();
		itemStockDAO.setConnection(conn);
		listCount = itemStockDAO.selectListCount(stockInout);
		close(conn);
		return listCount; 
	}
	
	
	
}
