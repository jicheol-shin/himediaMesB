package com.mes.service;


import static com.mes.db.JDBCUtility.*;

import java.sql.Connection;
import java.util.ArrayList;

import com.mes.dao.QualityDAO;
import com.mes.vo.ProductionLine;
import com.mes.vo.Quality;

public class QualityTestService {
	
	public ArrayList<ProductionLine> getQualityList() {
		
		ArrayList<ProductionLine> QualityList = null;
		
		Connection conn = getConnection();
		QualityDAO qualityDAO = QualityDAO.getInstance();
		qualityDAO.setConnection(conn);
		QualityList = qualityDAO.selectQualityList();
		
		close(conn);
		
				
		
		return QualityList;

	}
}
