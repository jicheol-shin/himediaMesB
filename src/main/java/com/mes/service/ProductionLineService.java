package com.mes.service;

import static com.mes.db.JDBCUtility.*;




import java.sql.Connection;
import java.util.ArrayList;

import com.mes.dao.ProductionLineDAO;
import com.mes.vo.ProductionLine;

public class ProductionLineService {
	
	public ArrayList<ProductionLine> getProductionLineList(){
		
		ArrayList<ProductionLine> ProductionLineList = null;
		
		Connection conn = getConnection();
		ProductionLineDAO productionLineDAO = ProductionLineDAO.getInstance();
		productionLineDAO.setConnection(conn);
		ProductionLineList = productionLineDAO.selectProductionLineList();
		
		close(conn); //jdbc임포트하기
		
		
		
		return ProductionLineList;
		
		
	}
}
