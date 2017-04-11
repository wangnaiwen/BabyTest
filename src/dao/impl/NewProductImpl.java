package dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jdbc.JDBCConnection;
import dao.BaseDAO;
import dao.NewProductDAO;
import domain.NewProduct;

public class NewProductImpl extends BaseDAO implements NewProductDAO{

	@Override
	public boolean insertNewProduct(NewProduct newPrduct) {
		JDBCConnection jdbcConnection = getJdbcConnection();
		jdbcConnection.OpenConn();
	    String sql = "insert into lb_new_product values(null, "+newPrduct.getProductId()+",'"+newPrduct.getTime()+"')";
	    System.out.println(sql);
		boolean result = jdbcConnection.insert(sql);
		jdbcConnection.close();
		return result;
	}

	@Override
	public List<NewProduct> findNewProducts() {
		List<NewProduct> newProducts = null;
		JDBCConnection jdbcConnection = getJdbcConnection();
		jdbcConnection.OpenConn();
		//找最顶上的四个
	    String sql = "SELECT * FROM lb_new_product ORDER BY id DESC LIMIT 0,4;";
		ResultSet rs = jdbcConnection.find(sql);
		try {
			while(rs.next()) {
				NewProduct newProduct = new NewProduct();
				newProduct.setId(rs.getInt("id"));
				newProduct.setProductId(rs.getInt("product_id"));
				newProduct.setTime(rs.getString("time"));
				
				if(newProducts == null){
					newProducts = new ArrayList<NewProduct>();
				}
				newProducts.add(newProduct);
			}
			jdbcConnection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			if(rs != null){
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return newProducts;
	}

}
