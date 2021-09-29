package com.mes.service;

import static com.mes.db.JDBCUtility.close;
import static com.mes.db.JDBCUtility.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import com.mes.dao.ProductionViewDAO;
import com.mes.vo.ProductionView;

public class ProductionViewService {

	public ArrayList<ProductionView> getProductionViewList(){
		
		 ArrayList<ProductionView> productionViewList = null;
		 
		 Connection conn = getConnection();
		 ProductionViewDAO  productionViewDAO = ProductionViewDAO.getInstance();
		 productionViewDAO.setConnection(conn);
		 productionViewList = productionViewDAO.selectProductionViewList();

		 close(conn); //jdbc임포트하기

		return productionViewList;
	}
}
