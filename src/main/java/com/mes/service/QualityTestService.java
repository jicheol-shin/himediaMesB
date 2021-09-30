package com.mes.service;


import static com.mes.db.JDBCUtility.*;

import java.sql.Connection;
import java.util.ArrayList;

import com.mes.dao.QualityDAO;
import com.mes.vo.ProductionLine;
import com.mes.vo.Quality;

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

	public void registrQualityTest(String workOrderNo, String userId) {
		Connection conn = getConnection();
		QualityDAO qualityDAO = QualityDAO.getInstance();
		qualityDAO.setConnection(conn);
		qualityDAO.insertQualityTestInput(workOrderNo,userId);
		close(conn);
	}

	public ArrayList<Quality> getQualityList() {

		ArrayList<Quality> qualitytList = null;
		
		Connection conn = getConnection();
		QualityDAO qualityDAO = QualityDAO.getInstance();
		qualityDAO.setConnection(conn);
		qualitytList = qualityDAO.selectQualityList();
		
		close(conn);
		return qualitytList;
	}
	
}
