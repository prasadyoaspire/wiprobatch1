package com.demoapp.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.demoapp.dto.Product;
import com.demoapp.util.DBUtil;

public class ProductDao {

	public Product findProductById(int productId) {

		Product product = null;
		String sql = "select * from product_tbl where product_id = ?";

		try (Connection con = DBUtil.getOracelDBConnection(); 
				PreparedStatement ps = con.prepareStatement(sql);) {

			ps.setInt(1, productId);			
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				int pid = rs.getInt(1);
				String pname = rs.getString(2);
				double pprice = rs.getDouble(3);
				Date mfd = rs.getDate(4);
				String category = rs.getString(5);
				
				product = new Product();
				product.setProductId(pid);
				product.setProductName(pname);
				product.setProductPrice(pprice);
				product.setMfd(mfd.toLocalDate());
				product.setCategory(category);

			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return product;
	}

	public List<Product> findAllProducts() {
		List<Product> products = new ArrayList<>();
		String sql = "select * from product_tbl";

		try (Connection con = DBUtil.getOracelDBConnection();
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(sql);) {

			while (rs.next()) {
				int pId = rs.getInt(1);
				String pname = rs.getString(2);
				double pprice = rs.getDouble(3);
				Date mfd = rs.getDate(4);
				String category = rs.getString(5);

				Product product = new Product();
				product.setProductId(pId);
				product.setProductName(pname);
				product.setProductPrice(pprice);
				product.setMfd(mfd.toLocalDate());
				product.setCategory(category);

				products.add(product);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return products;
	}

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
			System.out.println("qury executing");

			int result = ps.executeUpdate();
			con.commit();
			System.out.println("product inserted " + result);

			flag = true;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
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
