package com.mes.service;

import static com.mes.db.JDBCUtility.*;

import java.sql.Connection;
import java.util.ArrayList;

import com.mes.dao.TakeOrderDAO;
import com.mes.vo.TakeOrder;

public class TakeOrderViewService {

	public ArrayList<TakeOrder> getTakeOrderList(){
		
		ArrayList<TakeOrder> takeOrderList = null;
		
		Connection conn = getConnection();
		TakeOrderDAO takeOrderDAO = TakeOrderDAO.getInstance();
		takeOrderDAO.setConnection(conn);
		takeOrderList = takeOrderDAO.selectTakeOrderList();
		
		close(conn);
		
		return takeOrderList;
		
	}
	
}
