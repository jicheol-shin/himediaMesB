package com.mes.service;

import static com.mes.db.JDBCUtility.close;
import static com.mes.db.JDBCUtility.getConnection;

import java.sql.Connection;

import com.mes.dao.ProductionDAO;
public class PrudctionInputService {

	public void registPrudctionInput(String workOrderNo, String name) {
		
		Connection conn = getConnection();
		ProductionDAO productionDAO = ProductionDAO.getInstance();
		productionDAO.setConnection(conn);
		productionDAO.insertProductionInput(workOrderNo,name);
		close(conn);
		
	}

}
