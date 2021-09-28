package com.mes.service;

import static com.mes.db.JDBCUtility.*;

import java.sql.Connection;
import java.util.ArrayList;

import com.mes.dao.ProductInventoryDAO;
import com.mes.vo.ReleaseStatement;

public class ReleaseOutService {

	public ArrayList<ReleaseStatement> getReleaseOutList() {
		
		ArrayList<ReleaseStatement> ReleaseOutList = null;
		Connection conn = getConnection();
		ProductInventoryDAO productInventoryDAO = ProductInventoryDAO.getInstance();
		productInventoryDAO.setConnection(conn);
		ReleaseOutList = productInventoryDAO.selectReleaseOutList();
		close(conn);
		return ReleaseOutList;
	}
}
