package com.mes.dao;

import static com.mes.db.JDBCUtility.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.sql.DataSource;

import com.mes.vo.Product;

public class ProductDAO {

	private ProductDAO() {}
	private static ProductDAO productDAO;
	public static ProductDAO getInstance() {
		
		if(productDAO == null) productDAO = new ProductDAO();
		return productDAO;
		
	}
	
	Connection conn = null;
	DataSource ds = null;
	
	public void setConnection(Connection conn) {
		this.conn = conn;
	}
	
	public ArrayList<Product> selectProductList(){
		
		ArrayList<Product> productList = new ArrayList<Product>();
		Product product = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from product";
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				product = new Product();
				product.setProductCd(rs.getString("product_cd"));// 제품코드
				product.setProductName(rs.getString("product_name"));// 제품명
				product.setProductSpec(rs.getString("product_spec"));// 제품스펙
				product.setRemark(rs.getString("remark"));// 비고
				productList.add(product);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Product리스트 조회 실패!!" + e.getMessage());
		}
		
		return productList;
		
	}
	
}
