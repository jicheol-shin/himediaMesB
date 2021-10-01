package com.mes.service;

import static com.mes.db.JDBCUtility.*;





import java.sql.Connection;
import java.util.ArrayList;

import com.mes.dao.ProductionLineDAO;
import com.mes.vo.Production;
import com.mes.vo.ProductionLine;

public class ProductionLineService {
	
	public ArrayList<Production> getProductionList(){
		
		ArrayList<Production> productionList = null;
		
		Connection conn = getConnection();
		ProductionLineDAO productionLineDAO = ProductionLineDAO.getInstance();
		productionLineDAO.setConnection(conn);
		productionList = productionLineDAO.selectProductionList();
		
		close(conn); //jdbc임포트하기
		
		
		
		return productionList;
		
		
	}
}
