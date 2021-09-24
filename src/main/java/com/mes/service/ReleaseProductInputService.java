package com.mes.service;

import static com.mes.db.JDBCUtility.commit;
import static com.mes.db.JDBCUtility.getConnection;
import static com.mes.db.JDBCUtility.rollback;

import java.sql.Connection;

import com.mes.dao.ReleaseProductDAO;
import com.mes.vo.ReleaseProduct;

public class ReleaseProductInputService {
	
	public boolean registReleaseProduct(ReleaseProduct releaseProduct) {
		
		boolean isWriteSuccess = false;
		
		Connection conn = getConnection();
		ReleaseProductDAO releaseProductDAO = ReleaseProductDAO.getInstance();
		releaseProductDAO.setConnection(conn);
		int insertCount = releaseProductDAO.insertReleateProduct(releaseProduct);
		
		if(insertCount>0) {
			commit(conn);
			isWriteSuccess = true;
		} else {
			rollback(conn);
		}
		
		return isWriteSuccess;
		
	}

}
