package dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jdbc.JDBCConnection;
import dao.BaseDAO;
import dao.DealDAO;
import domain.Deal;

public class DealImpl extends BaseDAO implements DealDAO{

	@Override
	public boolean insertDeal(Deal deal) {
		JDBCConnection jdbcConnection = getJdbcConnection();
		jdbcConnection.OpenConn();
	    String sql = "insert into deal values(null, "+deal.getOrderId()+","+deal.getProductId() +",'"
		+deal.getProductName()+"',"+deal.getProductCount()+","+deal.getSumPrice()+")";
	    System.out.println(sql);
		boolean result = jdbcConnection.insert(sql);
		jdbcConnection.close();
		return result;
	}

	@Override
	public boolean updateDeal(Deal deal) {
		JDBCConnection jdbcConnection = getJdbcConnection();
		jdbcConnection.OpenConn();
	    String sql = "update deal set order_id="+deal.getOrderId()+",product_id="+deal.getProductId() +",product_name='"
		+deal.getProductName()+"',product_count="+deal.getProductCount()+",sum_price="+deal.getSumPrice()+" where id="
		+deal.getId();
	    System.out.println(sql);
		boolean result = jdbcConnection.insert(sql);
		jdbcConnection.close();
		return result;
	}

	@Override
	public boolean deleteDeal(int id) {
		JDBCConnection jdbcConnection = getJdbcConnection();
		jdbcConnection.OpenConn();
	    String sql = "delete from deal where id=" + id;
	    System.out.println(sql);
		boolean result = jdbcConnection.insert(sql);
		jdbcConnection.close();
		return result;
	}

	@Override
	public Deal findDealById(int id) {
		Deal deal = null;
		JDBCConnection jdbcConnection = getJdbcConnection();
		jdbcConnection.OpenConn();
	    String sql = "select * from deal where id="+id;
		ResultSet rs = jdbcConnection.find(sql);
		try {
			if(rs.next()) {
				deal = new Deal();
				deal.setId(rs.getInt("id"));
				deal.setOrderId(rs.getInt("order_id"));
				deal.setProductId(rs.getInt("product_id"));
				deal.setProductName(rs.getString("product_name"));
				deal.setProductCount(rs.getInt("product_count"));
				deal.setSumPrice(rs.getInt("sum_price"));
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
		return deal;
	}

	@Override
	public List<Deal> findDealByOrderId(int orderId) {
		List<Deal> deals = null;
		
		JDBCConnection jdbcConnection = getJdbcConnection();
		jdbcConnection.OpenConn();
	    String sql = "select * from deal where order_id="+orderId;
		ResultSet rs = jdbcConnection.find(sql);
		try {
			if(rs.next()) {
				Deal deal = new Deal();
				deal.setId(rs.getInt("id"));
				deal.setOrderId(rs.getInt("order_id"));
				deal.setProductId(rs.getInt("product_id"));
				deal.setProductName(rs.getString("product_name"));
				deal.setProductCount(rs.getInt("product_count"));
				deal.setSumPrice(rs.getInt("sum_price"));
				
				if(deals == null){
					deals = new ArrayList<Deal>();
				}
				deals.add(deal);
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
		return deals;
	}

}
