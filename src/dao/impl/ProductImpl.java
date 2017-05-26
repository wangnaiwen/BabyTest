package dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jdbc.JDBCConnection;
import dao.BaseDAO;
import dao.ProductDAO;
import domain.Product;

public class ProductImpl extends BaseDAO implements ProductDAO{

	@Override
	public boolean insertProduct(Product product) {
		JDBCConnection jdbcConnection = getJdbcConnection();
		jdbcConnection.OpenConn();
	    String sql = "insert into lb_product values(null, "+product.getScId()+",'"+product.getNumbering()+"','"+product.getName() +"','"
	    		+product.getBrand()+"',"+product.getRetailPrice()+","+product.getStandardPrice()+",'"
	    		+product.getDescription()+"','"+product.getCoverImg()+"',"+product.getCount()+")";
	    System.out.println(sql);
		boolean result = jdbcConnection.insert(sql);
		jdbcConnection.close();
		return result;
	}

	@Override
	public boolean updateProduct(Product product) {
		JDBCConnection jdbcConnection = getJdbcConnection();
		jdbcConnection.OpenConn();
	    String sql = "update lb_product set sc_id="+product.getScId()+",numbering='"+product.getNumbering()+"',name='"+product.getName() +"',brand='"
	    		+product.getBrand()+"',retail_price="+product.getRetailPrice()+",standard_price="+product.getStandardPrice()+",description='"
	    		+product.getDescription()+"',cover_img='"+product.getCoverImg()+"' where id=" +product.getId();
	    System.out.println(sql);
		boolean result = jdbcConnection.update(sql);
		jdbcConnection.close();
		return result;
	}

	@Override
	public boolean deleteProduct(int id) {
		JDBCConnection jdbcConnection = getJdbcConnection();
		jdbcConnection.OpenConn();
	    String sql = "delete from lb_product where id=" + id;
	    System.out.println(sql);
		boolean result = jdbcConnection.delete(sql);
		jdbcConnection.close();
		return result;
	}

	@Override
	public Product findProductById(int id) {
		Product p = null;
		JDBCConnection jdbcConnection = getJdbcConnection();
		jdbcConnection.OpenConn();
	    String sql = "select * from lb_product where id="+id;
		ResultSet rs = jdbcConnection.find(sql);
		try {
			if(rs.next()) {
				p = new Product();
				p.setId(rs.getInt("id"));
				p.setScId(rs.getInt("sc_id"));
				p.setNumbering(rs.getString("numbering"));
				p.setName(rs.getString("name"));
				p.setBrand(rs.getString("brand"));
				p.setDescription(rs.getString("description"));
				p.setStandardPrice(rs.getInt("standard_price"));
				p.setRetailPrice(rs.getInt("retail_price"));
				p.setCount(rs.getInt("count"));
				p.setCoverImg(rs.getString("cover_img"));
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
		return p;
	}

	@Override
	public Product findProductByNumbering(String numbering) {
		Product p = null;
		JDBCConnection jdbcConnection = getJdbcConnection();
		jdbcConnection.OpenConn();
	    String sql = "select * from lb_product where numbering='"+numbering +"' ORDER BY id DESC  LIMIT 0, 1";
		ResultSet rs = jdbcConnection.find(sql);
		try {
			if(rs.next()) {
				p = new Product();
				p.setId(rs.getInt("id"));
				p.setScId(rs.getInt("sc_id"));
				p.setNumbering(rs.getString("numbering"));
				p.setName(rs.getString("name"));
				p.setBrand(rs.getString("brand"));
				p.setDescription(rs.getString("description"));
				p.setStandardPrice(rs.getInt("standard_price"));
				p.setRetailPrice(rs.getInt("retail_price"));
				p.setCoverImg(rs.getString("cover_img"));
				p.setCount(rs.getInt("count"));
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
		return p;
	}

	@Override
	public List<Product> findProductByScId(int scId, int number) {
		List<Product> products = null;
		JDBCConnection jdbcConnection = getJdbcConnection();
		jdbcConnection.OpenConn();
	    String sql = "select * from lb_product where sc_id="+scId+" order by id desc limit "+ ((number-1)*10)+","+number*10;
		ResultSet rs = jdbcConnection.find(sql);
		try {
			while(rs.next()) {
				Product p = new Product();
				p.setId(rs.getInt("id"));
				p.setScId(rs.getInt("sc_id"));
				p.setNumbering(rs.getString("numbering"));
				p.setName(rs.getString("name"));
				p.setBrand(rs.getString("brand"));
				p.setDescription(rs.getString("description"));
				p.setStandardPrice(rs.getInt("standard_price"));
				p.setRetailPrice(rs.getInt("retail_price"));
				p.setCoverImg(rs.getString("cover_img"));
				p.setCount(rs.getInt("count"));
				if(products == null){
					products = new ArrayList<Product>();
				}
				products.add(p);
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
		return products;
	}

	//Ä£ºý²éÑ¯
	@Override
	public List<Product> findProductByKey(String key) {
		List<Product> products = null;
		JDBCConnection jdbcConnection = getJdbcConnection();
		jdbcConnection.OpenConn();
	    String sql = "select * from lb_product where name LIKE '%"+key+"%' LIMIT 0, 10";
		ResultSet rs = jdbcConnection.find(sql);
		try {
			while(rs.next()) {
				Product p = new Product();
				p.setId(rs.getInt("id"));
				p.setScId(rs.getInt("sc_id"));
				p.setNumbering(rs.getString("numbering"));
				p.setName(rs.getString("name"));
				p.setBrand(rs.getString("brand"));
				p.setDescription(rs.getString("description"));
				p.setStandardPrice(rs.getInt("standard_price"));
				p.setRetailPrice(rs.getInt("retail_price"));
				p.setCoverImg(rs.getString("cover_img"));
				p.setCount(rs.getInt("count"));
				if(products == null){
					products = new ArrayList<Product>();
				}
				products.add(p);
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
		return products;
	}

	@Override
	public int findProductCountById(int id) {
		int count = 0;
		JDBCConnection jdbcConnection = getJdbcConnection();
		jdbcConnection.OpenConn();
	    String sql = "select count from lb_product where id="+id;
		ResultSet rs = jdbcConnection.find(sql);
		try {
			if(rs.next()) {
				count = rs.getInt("count");
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
		return count;
	}

	@Override
	public boolean updateProductCountById(int id, int count) {
		JDBCConnection jdbcConnection = getJdbcConnection();
		jdbcConnection.OpenConn();
	    String sql = "update lb_product set count = (count -"+ count +") where id =" + id;
	    System.out.println(sql);
		boolean result = jdbcConnection.update(sql);
		jdbcConnection.close();
		return result;
	}

}
