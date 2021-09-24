package com.mes.service;

import static com.mes.db.JDBCUtility.*;

import java.sql.Connection;

import com.mes.dao.TakeOrderDAO;
import com.mes.vo.TakeOrder;

public class TakeOrderInputService {
	
	public boolean registTakeOrder(TakeOrder takeOrder) {
		
		boolean isWriteSuccess = false;
		
		Connection conn = getConnection();
		TakeOrderDAO takeOrderDAO = TakeOrderDAO.getInstance();
		takeOrderDAO.setConnection(conn);
		int insertCount = takeOrderDAO.insertTakeOrder(takeOrder);
		
		if(insertCount>0) {
			commit(conn);
			isWriteSuccess = true;
		} else {
			rollback(conn);
		}
		
		return isWriteSuccess;
		
	}

}
