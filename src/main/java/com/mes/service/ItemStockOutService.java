package com.mes.service;

import static com.mes.db.JDBCUtility.close;
import static com.mes.db.JDBCUtility.getConnection;

import java.sql.Connection;

import com.mes.dao.ItemStockDAO;

public class ItemStockOutService {

	public void registeItemStockOut(String workOrderNo){
		Connection conn = getConnection();
		ItemStockDAO itemstockDAO = ItemStockDAO.getInstance();		
		itemstockDAO.setConnection(conn);
		itemstockDAO.insertItemstockOut(workOrderNo);
		close(conn);
		
	}

}
