package com.mes.service;

import static com.mes.db.JDBCUtility.*;

import java.sql.Connection;
import java.util.ArrayList;

import com.mes.dao.ItemDAO;
import com.mes.vo.Item;

public class ItemService {

	public ArrayList<Item> getItemList(){
		
		ArrayList<Item> ItemList = null;
		
		Connection conn = getConnection();
		ItemDAO itemDAO = ItemDAO.getInstance();
		itemDAO.setConnection(conn);
		ItemList = itemDAO.selectItemList();
		
		close(conn);
		
		return ItemList;
	
	}
	
}
