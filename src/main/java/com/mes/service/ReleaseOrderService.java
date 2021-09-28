package com.mes.service;

import static com.mes.db.JDBCUtility.*;

import java.sql.Connection;
import java.util.ArrayList;

import com.mes.dao.ProductInventoryDAO;
import com.mes.vo.ReleaseProduct;

public class ReleaseOrderService {

	public ArrayList<ReleaseProduct> getReleaseOrderList() {
		
		ArrayList<ReleaseProduct> ReleaseOrderList = null;
		Connection conn = getConnection();
		ProductInventoryDAO productInventoryDAO = ProductInventoryDAO.getInstance();
		productInventoryDAO.setConnection(conn);
		ReleaseOrderList = productInventoryDAO.selectReleaseOrderList();
		close(conn);
		return ReleaseOrderList;
	}
}
