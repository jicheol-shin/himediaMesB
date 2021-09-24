package com.mes.service;

import static com.mes.db.JDBCUtility.*;

import java.sql.Connection;

import com.mes.dao.BomDAO;
import com.mes.vo.Bom;

public class BomInputService {

	public boolean registBom(Bom bom) {
		
		boolean isWriteSuccess = false;
		
		Connection conn = getConnection();
		BomDAO bomDAO = BomDAO.getInstance();
		bomDAO.setConnection(conn);
		int insertCount = bomDAO.insertBom(bom);
		
		if(insertCount>0) {
			commit(conn);
			isWriteSuccess = true;
		} else {
			rollback(conn);
		}
		
		return isWriteSuccess;
		
	}
	
}
