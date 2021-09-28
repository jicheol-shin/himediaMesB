package com.mes.service;

import static com.mes.db.JDBCUtility.*;

import java.sql.Connection;
import java.util.ArrayList;

import com.mes.dao.PurchaseDAO;
import com.mes.vo.OrderStatement;

public class OrderStatementInputService {
	
	public ArrayList<OrderStatement> getOrderStatementList(String ordCd) {
		
		ArrayList<OrderStatement> orderStatementList = null;
		Connection conn = getConnection();
		PurchaseDAO purchaseDAO = PurchaseDAO.getInstance();
		purchaseDAO.setConnection(conn);
		orderStatementList = purchaseDAO.selectOrderStatementList(ordCd);
		close(conn);
		
		return orderStatementList;
	}

	public void registOrderStatement(String ordCd) {
		Connection conn = getConnection();
		PurchaseDAO purchaseDAO = PurchaseDAO.getInstance();
		purchaseDAO.setConnection(conn);
		purchaseDAO.insertOrderStatementList(ordCd);
		close(conn);
	}
}
