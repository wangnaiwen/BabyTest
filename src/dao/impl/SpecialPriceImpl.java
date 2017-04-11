package dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jdbc.JDBCConnection;
import dao.BaseDAO;
import dao.SpecialPriceDAO;
import domain.SpecialPrice;

public class SpecialPriceImpl extends BaseDAO implements SpecialPriceDAO{

	@Override
	public boolean insertSpecialPrice(SpecialPrice specialPrice) {
		JDBCConnection jdbcConnection = getJdbcConnection();
		jdbcConnection.OpenConn();
	    String sql = "insert into lb_special_price values(null, "+specialPrice.getProductId()+",'"+specialPrice.getTime()+"')";
	    System.out.println(sql);
		boolean result = jdbcConnection.insert(sql);
		jdbcConnection.close();
		return result;
	}

	@Override
	public List<SpecialPrice> findSpecialPrices() {
		List<SpecialPrice> specialPrices = null;
		JDBCConnection jdbcConnection = getJdbcConnection();
		jdbcConnection.OpenConn();
		//找最顶上的四个
	    String sql = "SELECT * FROM lb_special_price ORDER BY id DESC LIMIT 0,4;";
		ResultSet rs = jdbcConnection.find(sql);
		try {
			while(rs.next()) {
				SpecialPrice specialPrice = new SpecialPrice();
				specialPrice.setId(rs.getInt("id"));
				specialPrice.setProductId(rs.getInt("product_id"));
				specialPrice.setTime(rs.getString("time"));
				
				if(specialPrices == null){
					specialPrices = new ArrayList<SpecialPrice>();
				}
				specialPrices.add(specialPrice);
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
		return specialPrices;
	}

}
