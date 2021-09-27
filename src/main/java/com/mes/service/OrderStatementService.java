package com.mes.service;

import static com.mes.db.JDBCUtility.*;

import java.sql.Connection;
import java.util.ArrayList;

import com.mes.dao.PurchaseDAO;
import com.mes.vo.OrderStatement;

public class OrderStatementService {

	public ArrayList<OrderStatement> getOrderStatementList(String ordCd) {
		
		ArrayList<OrderStatement> OrderStatementList = null;
		Connection conn = getConnection();
		PurchaseDAO purchaseDAO = PurchaseDAO.getInstance();
		purchaseDAO.setConnection(conn);
		OrderStatementList = purchaseDAO.selectOrderStatementList(ordCd); 
		close(conn);
		return OrderStatementList;
	}
}
