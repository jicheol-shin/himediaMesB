package com.mes.service;

import static com.mes.db.JDBCUtility.*;



import java.sql.Connection;
import java.util.ArrayList;

import com.mes.dao.ProductionLineInputDAO;
import com.mes.vo.ProductionLineInput;



public class ProductionLineInputService {
	
	public boolean registProductionInput(ProductionLineInput productionLineInput) {
		
		boolean isWriteSuccess = false;
		
		Connection conn = getConnection();
		ProductionLineInputDAO productionLineInputDAO = ProductionLineInputDAO.getInstance();
		productionLineInputDAO.setConnection(conn);
		int insertCount = productionLineInputDAO.updateProduction(productionLineInput);
		
				if(insertCount>0) {
					commit(conn);
					isWriteSuccess = true;
				} else {
					rollback(conn);
				}
				
				return isWriteSuccess;
				
			}
		
		
		
	}


