package com.mes.service;

import static com.mes.db.JDBCUtility.*;

import java.sql.Connection;
import java.util.ArrayList;

import com.mes.dao.ReleaseProductDAO;
import com.mes.vo.ReleaseProduct;

public class ReleaseProductViewService {

	public ArrayList<ReleaseProduct> getReleaseProductList(){
		
		ArrayList<ReleaseProduct> releaseProductList = null;
		
		Connection conn = getConnection();
		ReleaseProductDAO releaseProductDAO = ReleaseProductDAO.getInstance();
		releaseProductDAO.setConnection(conn);
		releaseProductList = releaseProductDAO.selectReleaseProductList();
		
		close(conn);
		
		return releaseProductList;
		
	}
	
}
