package com.mes.service;

import static com.mes.db.JDBCUtility.*;
import java.sql.Connection;

import com.mes.dao.ProductionLineDAO;
import com.mes.vo.ProductionLineInput;



public class ProductionLineInputService {
	
	public boolean registProductionInput(ProductionLineInput productionLineInput) {
		
		boolean isWriteSuccess = false;
		
		Connection conn = getConnection();
		ProductionLineDAO productionLineDAO = ProductionLineDAO.getInstance();
		productionLineDAO.setConnection(conn);
		int insertCount = productionLineDAO.updateProduction(productionLineInput);
		
				if(insertCount>0) {
					commit(conn);
					isWriteSuccess = true;
				} else {
					rollback(conn);
				}
				
				return isWriteSuccess;
				
			}
		
		
		
	}


