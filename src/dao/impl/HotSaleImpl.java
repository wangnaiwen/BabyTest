package dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jdbc.JDBCConnection;
import dao.BaseDAO;
import dao.HotSaleDAO;
import domain.HotSale;

public class HotSaleImpl extends BaseDAO implements HotSaleDAO{

	@Override
	public boolean insertHotSale(HotSale hotSale) {
		JDBCConnection jdbcConnection = getJdbcConnection();
		jdbcConnection.OpenConn();
	    String sql = "insert into hot_sale values(null, "+hotSale.getProductId()+",'"+hotSale.getTime()+"')";
	    System.out.println(sql);
		boolean result = jdbcConnection.insert(sql);
		jdbcConnection.close();
		return result;
	}

	@Override
	public List<HotSale> findHotSales() {
		List<HotSale> hosHotSales = null;
		JDBCConnection jdbcConnection = getJdbcConnection();
		jdbcConnection.OpenConn();
		//����ϵ��ĸ�
	    String sql = "SELECT * FROM hot_sale ORDER BY id DESC LIMIT 0,4;  ";
		ResultSet rs = jdbcConnection.find(sql);
		try {
			while(rs.next()) {
				HotSale hosHotSale = new HotSale();
				hosHotSale.setId(rs.getInt("id"));
				hosHotSale.setProductId(rs.getInt("product_id"));
				hosHotSale.setTime(rs.getString("time"));
				
				if(hosHotSales == null){
					hosHotSales = new ArrayList<HotSale>();
				}
				hosHotSales.add(hosHotSale);
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
		return hosHotSales;
	}

}