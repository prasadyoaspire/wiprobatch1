package com.demoapp.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.demoapp.dto.Product;
import com.demoapp.util.DBUtil;

public class ProductDao {

	public boolean save(Product product) {

		boolean flag = false;	
		String sql = "insert into product_tbl values(?,?,?,?,?)";
		Connection con = null;
		PreparedStatement ps = null;
		try {	
			con = DBUtil.getOracelDBConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, product.getProductId());
			ps.setString(2, product.getProductName());
			ps.setDouble(3, product.getProductPrice());
			ps.setDate(4, Date.valueOf(product.getMfd()));
			ps.setString(5, product.getCategory());
			
			ps.executeUpdate();
			System.out.println("product inserted");
			
			flag = true;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				ps.close();
				con.close();
				System.out.println("connection closed");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return flag;
	}
}
