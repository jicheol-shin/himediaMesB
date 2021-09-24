package com.mes.service;

import static com.mes.db.JDBCUtility.*;

import java.sql.Connection;
import java.util.ArrayList;

import com.mes.dao.BomDAO;
import com.mes.vo.Bom;

public class BomViewService {

	public ArrayList<Bom> getBomList(){

		ArrayList<Bom> BomList = null;

		Connection conn = getConnection();
		BomDAO bomDAO = BomDAO.getInstance();
		bomDAO.setConnection(conn);
		BomList = bomDAO.selectBomList();
		
		close(conn);	
		
		return BomList;
		
	}
	
	
}
