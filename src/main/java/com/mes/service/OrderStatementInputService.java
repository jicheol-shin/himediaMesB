package com.mes.service;

import static com.mes.db.JDBCUtility.*;

import java.sql.Connection;
import com.mes.dao.PurchaseDAO;

public class OrderStatementInputService {

	public void registOrderStatement(String ordCd) {
		Connection conn = getConnection();
		PurchaseDAO purchaseDAO = PurchaseDAO.getInstance();
		purchaseDAO.setConnection(conn);
		purchaseDAO.insertOrderStatementList(ordCd);
		close(conn);
	}
}
