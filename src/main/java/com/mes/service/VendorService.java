package com.mes.service;

import static com.mes.db.JDBCUtility.close;
import static com.mes.db.JDBCUtility.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import com.mes.dao.VendorDAO;
import com.mes.vo.Vendor;

public class VendorService {

	public ArrayList<Vendor> getVendorList(){
		
		ArrayList<Vendor> VendorList = null;
		
		Connection conn = getConnection();
		VendorDAO vendorDAO = VendorDAO.getInstance();
		vendorDAO.setConnection(conn);
		VendorList = vendorDAO.selectVendorList();
		
		close(conn);
		
		return VendorList;
	
	}
	
}
