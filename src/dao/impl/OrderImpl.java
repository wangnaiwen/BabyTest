package dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jdbc.JDBCConnection;
import dao.BaseDAO;
import dao.OrderDAO;
import domain.Order;

public class OrderImpl extends BaseDAO implements OrderDAO{

	@Override
	public boolean insertOrder(Order order) {
		JDBCConnection jdbcConnection = getJdbcConnection();
		jdbcConnection.OpenConn();
	    String sql = "insert into order values(null, "+order.getShopId()+","+order.getUserId() +",'"+order.getOrderNumber()+
	    		"',"+order.getOrderType()+",'"+order.getCreateTime()+"','"+order.getPayTime()+"','"+order.getFinishTime()+"')";
	    System.out.println(sql);
		boolean result = jdbcConnection.insert(sql);
		jdbcConnection.close();
		return result;
	}

	@Override
	public boolean updateOrder(Order order) {
		JDBCConnection jdbcConnection = getJdbcConnection();
		jdbcConnection.OpenConn();
	    String sql = "update order set shop_id="+order.getShopId()+",user_id="+order.getUserId() +",order_number='"+order.getOrderNumber()+
	    		"',order_type="+order.getOrderType()+",create_time='"+order.getCreateTime()+"',pay_time='"+order.getPayTime()+"',finish_time='"+order.getFinishTime()
	    		+"' where id=" +order.getId();
	    System.out.println(sql);
		boolean result = jdbcConnection.update(sql);
		jdbcConnection.close();
		return result;
	}

	@Override
	public boolean deleteOrder(int id) {
		JDBCConnection jdbcConnection = getJdbcConnection();
		jdbcConnection.OpenConn();
	    String sql = "delete from order where id=" + id;
		boolean result = jdbcConnection.delete(sql);
		jdbcConnection.close();
		return result;
	}

	@Override
	public Order findOrderById(int id) {
		Order order = null;
		JDBCConnection jdbcConnection = getJdbcConnection();
		jdbcConnection.OpenConn();
	    String sql = "select * from order where id="+id;
		ResultSet rs = jdbcConnection.find(sql);
		try {
			while(rs.next()) {
				order = new Order();
				order.setId(rs.getInt("id"));
				order.setShopId(rs.getInt("shop_id"));
				order.setUserId(rs.getInt("user_id"));
				order.setOrderNumber(rs.getString("order_number"));
				order.setOrderType(rs.getInt("order_type"));
				order.setCreateTime(rs.getString("create_time"));
				order.setPayTime(rs.getString("pay_time"));
				order.setFinishTime(rs.getString("finish_time"));
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
		return order;
	}

	@Override
	public List<Order> findOrderByUserId(int userId) {
		List<Order> orders = null;
		JDBCConnection jdbcConnection = getJdbcConnection();
		jdbcConnection.OpenConn();
	    String sql = "select * from order where user_id="+userId;
		ResultSet rs = jdbcConnection.find(sql);
		try {
			if(rs.next()) {
				Order order = new Order();
				order.setId(rs.getInt("id"));
				order.setShopId(rs.getInt("shop_id"));
				order.setUserId(rs.getInt("user_id"));
				order.setOrderNumber(rs.getString("order_number"));
				order.setOrderType(rs.getInt("order_type"));
				order.setCreateTime(rs.getString("create_time"));
				order.setPayTime(rs.getString("pay_time"));
				order.setFinishTime(rs.getString("finish_time"));
				if(orders == null){
					orders = new ArrayList<Order>();
				}
				orders.add(order);
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
		return orders;
	}

	@Override
	public List<Order> findOrderByShopId(int shopId) {
		List<Order> orders = null;
		JDBCConnection jdbcConnection = getJdbcConnection();
		jdbcConnection.OpenConn();
	    String sql = "select * from order where shop_id="+shopId;
		ResultSet rs = jdbcConnection.find(sql);
		try {
			if(rs.next()) {
				Order order = new Order();
				order.setId(rs.getInt("id"));
				order.setShopId(rs.getInt("shop_id"));
				order.setUserId(rs.getInt("user_id"));
				order.setOrderNumber(rs.getString("order_number"));
				order.setOrderType(rs.getInt("order_type"));
				order.setCreateTime(rs.getString("create_time"));
				order.setPayTime(rs.getString("pay_time"));
				order.setFinishTime(rs.getString("finish_time"));
				if(orders == null){
					orders = new ArrayList<Order>();
				}
				orders.add(order);
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
		return orders;
	}

}
