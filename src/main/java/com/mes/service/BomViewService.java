package com.mes.service;

import static com.mes.db.JDBCUtility.*;

import java.sql.Connection;
import java.util.ArrayList;

import com.mes.dao.BomDAO;
import com.mes.vo.Bom;

public class BomViewService {

	public ArrayList<Bom> getBomList(int page, int limit, String productCd){

		ArrayList<Bom> BomList = null;

		Connection conn = getConnection();
		BomDAO bomDAO = BomDAO.getInstance();
		bomDAO.setConnection(conn);
		BomList = bomDAO.selectBomList(page, limit, productCd);
		
		close(conn);	
		
		return BomList;
		
	}
	
	public int getListCount() {
		
		int listCount = 0;
		Connection conn = getConnection();
		BomDAO bomDAO = BomDAO.getInstance();
		bomDAO.setConnection(conn);
		listCount = bomDAO.selectListCount();
		close(conn);
		return listCount;
		
	}
	
	
}
