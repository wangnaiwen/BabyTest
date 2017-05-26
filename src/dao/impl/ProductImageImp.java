package dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jdbc.JDBCConnection;
import dao.BaseDAO;
import dao.ProductImageDAO;
import domain.ProductImage;

public class ProductImageImp extends BaseDAO implements ProductImageDAO{

	@Override
	public boolean insertProductImage(ProductImage image) {
		JDBCConnection jdbcConnection = getJdbcConnection();
		jdbcConnection.OpenConn();
	    String sql = "insert into lb_product_image values(null, "+image.getProductId()+",'"+image.getPath()+"')";
	    System.out.println(sql);
		boolean result = jdbcConnection.insert(sql);
		jdbcConnection.close();
		return result;
	}

	@Override
	public List<ProductImage> findImagesByProductId(int productId) {
		List<ProductImage> images = null;
		JDBCConnection jdbcConnection = getJdbcConnection();
		jdbcConnection.OpenConn();
	    String sql = "select * from lb_product_image where product_id="+productId;
		ResultSet rs = jdbcConnection.find(sql);
		try {
			while(rs.next()) {
				ProductImage image = new ProductImage();
				image.setId(rs.getInt("id"));
				image.setProductId(rs.getInt("product_id"));
				image.setPath(rs.getString("path"));
			
				if(images == null){
					images = new ArrayList<ProductImage>();
				}
				images.add(image);
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
		return images;
	}

}
