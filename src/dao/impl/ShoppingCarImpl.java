package dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jdbc.JDBCConnection;
import dao.BaseDAO;
import dao.ShoppingCarDAO;
import domain.ShoppingCar;

public class ShoppingCarImpl extends BaseDAO implements ShoppingCarDAO{

	@Override
	public boolean insertShoppingCar(ShoppingCar car) {
		JDBCConnection jdbcConnection = getJdbcConnection();
		jdbcConnection.OpenConn();
	    String sql = "insert into shopping_car values(null, "+car.getUserId()+","+car.getProductId()+",'"
		+car.getProductName()+ "','"+ car.getProductCover()+"',"+car.getRetailPrice()+","
	    		+car.getProductCount()+")";
	    System.out.println(sql);
		boolean result = jdbcConnection.insert(sql);
		jdbcConnection.close();
		return result;
	}

	@Override
	public boolean updateShoppingCar(ShoppingCar car) {
		JDBCConnection jdbcConnection = getJdbcConnection();
		jdbcConnection.OpenConn();
	    String sql = "update shopping_car set user_id="+car.getUserId()+",product_id="+car.getProductId()
	    		+",product_name='"+car.getProductName()+ "',product_cover='"+ car.getProductCover()
	    		+"',retail_price="+car.getRetailPrice()+",product_count="+car.getProductCount()
	    		+" where id="+car.getId();
	    System.out.println(sql);
		boolean result = jdbcConnection.update(sql);
		jdbcConnection.close();
		return result;
	}

	@Override
	public boolean deleteShoppingCar(int id) {
		JDBCConnection jdbcConnection = getJdbcConnection();
		jdbcConnection.OpenConn();
	    String sql = "delete from shopping_car where id=" +id;
	    System.out.println(sql);
		boolean result = jdbcConnection.delete(sql);
		jdbcConnection.close();
		return result;
	}

	@Override
	public List<ShoppingCar> findShoppingCarByUserId(int userId) {
		List<ShoppingCar> carList = null;
		JDBCConnection jdbcConnection = getJdbcConnection();
		jdbcConnection.OpenConn();
	    String sql = "select * from shopping_car where user_id="+userId;
		ResultSet rs = jdbcConnection.find(sql);
		try {
			while(rs.next()) {
				ShoppingCar car = new ShoppingCar();
				car.setId(rs.getInt("id"));
				car.setUserId(rs.getInt("user_id"));
				car.setProductId(rs.getInt("product_id"));
				car.setProductName(rs.getString("product_name"));
				car.setProductCover(rs.getString("product_cover"));
				car.setRetailPrice(rs.getInt("retail_price"));
				car.setProductCount(rs.getInt("product_count"));
				if(carList == null){
					carList = new ArrayList<ShoppingCar>();
				}
				carList.add(car);
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
		return carList;
	}

}
