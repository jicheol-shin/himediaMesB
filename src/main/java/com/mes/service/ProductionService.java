package com.mes.service;

import static com.mes.db.JDBCUtility.getConnection;

import static com.mes.db.JDBCUtility.*;
import java.sql.Connection;
import java.util.ArrayList;

import com.mes.dao.ProductionDAO;
import com.mes.vo.Production;
import com.mes.vo.TakeOrder;

public class ProductionService {
	
	public ArrayList<TakeOrder> gettakeOrderList(){
		
		ArrayList<TakeOrder> takeOrderList = null;
		
		Connection conn = getConnection();
		ProductionDAO productionDAO = ProductionDAO.getInstance();
		productionDAO.setConnection(conn);
		takeOrderList = productionDAO.selectProductionList();
		
		close(conn); //jdbc임포트하기
		
		
		
		
		return takeOrderList;
		
	}

}
