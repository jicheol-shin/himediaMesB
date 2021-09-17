package com.mes.service;

import static com.mes.db.JDBCUtility.*;

import java.sql.Connection;
import java.util.ArrayList;

import com.mes.dao.PurchaseDAO;
import com.mes.vo.TakeOrder;

public class TakeOrderPurchaseService {

	public ArrayList<TakeOrder> getTakeOrderList() {
		
		ArrayList<TakeOrder> TakeOrderList = null;
		Connection conn = getConnection();
		PurchaseDAO purchaseDAO = PurchaseDAO.getInstance();
		purchaseDAO.setConnection(conn);
		TakeOrderList = purchaseDAO.selectTakeOrderList();
		close(conn);
		return TakeOrderList;
	}
}
