package com.mes.service;

import static com.mes.db.JDBCUtility.*;

import java.sql.Connection;
import java.util.ArrayList;

import com.mes.dao.PurchaseDAO;
import com.mes.vo.OrderStatement;

public class OrderStatementService {

	public ArrayList<OrderStatement> getOrderStatementList() {
		
		ArrayList<OrderStatement> orderStatementList = null;
		Connection conn = getConnection();
		PurchaseDAO purchaseDAO = PurchaseDAO.getInstance();
		purchaseDAO.setConnection(conn);
		orderStatementList = purchaseDAO.selectOrderStatementList();
		close(conn);
		return orderStatementList;
	}
}
