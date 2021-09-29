package com.mes.service;

import static com.mes.db.JDBCUtility.*;

import java.sql.Connection;
import java.util.ArrayList;

import com.mes.dao.ProductInventoryDAO;
import com.mes.vo.ReleaseStatement;

public class ReleaseStatementInputService {

	public ArrayList<ReleaseStatement> getReleaseStatementList() {
		
		ArrayList<ReleaseStatement> releaseStatementList = null;
		Connection conn = getConnection();
		ProductInventoryDAO productInventoryDAO = ProductInventoryDAO.getInstance();
		productInventoryDAO.setConnection(conn);
		releaseStatementList = productInventoryDAO.selectReleaseOutList();
		close(conn);
		
		return releaseStatementList;
	}

	public void registReleaseStatement(String releCd) {
		Connection conn = getConnection();
		ProductInventoryDAO productInventoryDAO = ProductInventoryDAO.getInstance();
		productInventoryDAO.setConnection(conn);
		productInventoryDAO.insertReleaseOutList(releCd);
		close(conn);
		
	}
}
