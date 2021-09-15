package com.mes.service;

import static com.mes.db.JDBCUtility.*;

import java.sql.Connection;
import java.util.ArrayList;

import com.mes.dao.ItemstockDAO;
import com.mes.vo.ItemStockInout;

public class ItemStockInoutService {


	public ArrayList<ItemStockInout> getItemStockList() {
		ArrayList<ItemStockInout> ItemStorkInoutList = null;
		Connection conn = getConnection();
		ItemstockDAO itemstockDAO = ItemstockDAO.getInstance();		
		itemstockDAO.setConnection(conn);
		ItemStorkInoutList = itemstockDAO.selectItemstockList();
		close(conn);
		return ItemStorkInoutList; 
	}
	
	
	
}
