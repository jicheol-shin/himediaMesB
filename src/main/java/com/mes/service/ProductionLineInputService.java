package com.mes.service;

import static com.mes.db.JDBCUtility.close;
import static com.mes.db.JDBCUtility.getConnection;

import java.sql.Connection;

import com.mes.dao.ProductionLineDAO;

public class ProductionLineInputService {
	
	public void registPrudctionLineInput(String workOrderNo, String userId) {
		
		Connection conn = getConnection();
		ProductionLineDAO productionLineDAO = ProductionLineDAO.getInstance();
		productionLineDAO.setConnection(conn);
		productionLineDAO.insertProductionLineInput(workOrderNo,userId);
		close(conn);
	}

}
