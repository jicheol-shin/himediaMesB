package com.mes.service;

import static com.mes.db.JDBCUtility.close;
import static com.mes.db.JDBCUtility.getConnection;

import java.sql.Connection;
import java.sql.SQLException;

import com.mes.dao.ItemStockDAO;

public class ItemStockOutService {

	public void registeItemStockOut(String workOrderNo, String productCd) throws SQLException {
		Connection conn = getConnection();
		ItemStockDAO itemstockDAO = ItemStockDAO.getInstance();		
		itemstockDAO.setConnection(conn);
		itemstockDAO.insertItemstockOut(workOrderNo,productCd);
		close(conn);
		
	}

}
