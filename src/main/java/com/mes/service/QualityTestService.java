package com.mes.service;


import static com.mes.db.JDBCUtility.*;

import java.sql.Connection;
import java.util.ArrayList;

import com.mes.dao.QualityDAO;
import com.mes.vo.ProductionLine;

public class QualityTestService {
	
	public ArrayList<ProductionLine> getQualityTestList() {
		
		ArrayList<ProductionLine> qualityTestList = null;
		
		Connection conn = getConnection();
		QualityDAO qualityDAO = QualityDAO.getInstance();
		qualityDAO.setConnection(conn);
		qualityTestList = qualityDAO.selectQualityTestList();
		
		close(conn);
		return qualityTestList;

	}

	public void registrQualityTest(String workOrderNo) {
		Connection conn = getConnection();
		QualityDAO qualityDAO = QualityDAO.getInstance();
		qualityDAO.setConnection(conn);
		qualityDAO.insertQualityTestInput(workOrderNo);
		close(conn);
	}
	
	
	
	
	
	
	
	
	
	
}
