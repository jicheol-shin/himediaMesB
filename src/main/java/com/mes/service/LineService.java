package com.mes.service;

import static com.mes.db.JDBCUtility.*;

import java.sql.Connection;
import java.util.ArrayList;

import com.mes.dao.LineDAO;
import com.mes.vo.Line;

public class LineService {

	public ArrayList<Line> getLineList(){
		
		ArrayList<Line> LineList = null;
		
		Connection conn = getConnection();
		LineDAO lineDAO = LineDAO.getInstance();
		lineDAO.setConnection(conn);
		LineList = lineDAO.selectLineList();
		
		close(conn);
		
		return LineList;
		
	}
	
}
