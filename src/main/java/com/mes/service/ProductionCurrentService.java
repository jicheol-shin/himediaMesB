package com.mes.service;

import static com.mes.db.JDBCUtility.*;


import java.sql.Connection;
import java.util.ArrayList;

import com.mes.dao.ProductionCurrentDAO;
import com.mes.vo.ProductionCurrent;



public class ProductionCurrentService {
public ArrayList<ProductionCurrent> getProductionCurrentList(){
		
		ArrayList<ProductionCurrent> ProductionCurrentList = null;
		
		Connection conn = getConnection();
		ProductionCurrentDAO productionCurrentDAO = ProductionCurrentDAO.getInstance();
		productionCurrentDAO.setConnection(conn);
		ProductionCurrentList = productionCurrentDAO.selectProductionCurrentList();
		
		close(conn); //jdbc임포트하기
		
		
		
		return ProductionCurrentList;
		
	
}
}
