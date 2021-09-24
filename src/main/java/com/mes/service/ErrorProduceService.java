package com.mes.service;

import static com.mes.db.JDBCUtility.*;

import java.sql.Connection;
import java.util.ArrayList;

import com.mes.dao.ErrorProduceDAO;
import com.mes.vo.ErrorProduce;

public class ErrorProduceService {

	public ArrayList<ErrorProduce> getErrorProduceList(){
		
		ArrayList<ErrorProduce> ErrorProduceList = null;
		
		Connection conn = getConnection();
		ErrorProduceDAO errorProduceDAO = ErrorProduceDAO.getInstance();
		errorProduceDAO.setConnection(conn);
		ErrorProduceList = errorProduceDAO.selectErrorProduceList();
		
		close(conn);
		
		return ErrorProduceList;
		
	}
	
}
