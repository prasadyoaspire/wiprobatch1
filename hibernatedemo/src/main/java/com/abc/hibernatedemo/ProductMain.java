package com.abc.hibernatedemo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

import com.abc.hibernatedemo.entity.Product;
import com.abc.hibernatedemo.util.DBUtil;

public class ProductMain {

	public static void main(String[] args) {
		
		Product product1 = new Product();
		product1.setProductId(101);
		product1.setProductName("Samsung GalaxyM50");
		product1.setProductPrice(38000);
		product1.setMfd(LocalDate.of(2024, 04, 8));
		product1.setCategory("Mobile");
		
		//how to persist ( save to database)
		
		String sql = "insert into product_tbl values(?,?,?,?,?)";
		
		try(Connection con= DBUtil.getOracelDBConnection();
			PreparedStatement ps = con.prepareStatement(sql);) {
			ps.setInt(1, product1.getProductId());
			ps.setString(2, product1.getProductName() );
			ps.setDouble(3, product1.getProductPrice());
			ps.setDate(4, Date.valueOf(product1.getMfd()));
			ps.setString(5, product1.getCategory());
			
			ps.executeUpdate();
			System.out.println("Product saved!");
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}

}
