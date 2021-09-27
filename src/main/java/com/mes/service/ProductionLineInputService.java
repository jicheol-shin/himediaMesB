package com.mes.service;

import static com.mes.db.JDBCUtility.*;



import java.sql.Connection;
import java.util.ArrayList;

import com.mes.dao.ProductionLineInputDAO;
import com.mes.vo.ProductionLineInput;



public class ProductionLineInputService {
	
	public ArrayList<ProductionLineInput> getProductionLineInputList(){
	
	
	ArrayList<ProductionLineInput> ProductionLineInputList = null;
	
	
	Connection conn = getConnection();
	ProductionLineInputDAO productionLineInputDAO = ProductionLineInputDAO.getInstance();
	productionLineInputDAO.setConnection(conn);
	ProductionLineInputList = productionLineInputDAO.selectProductionLineInputList();
	
	close(conn); //jdbc임포트하기
	
	
	
	return ProductionLineInputList;
}
}
