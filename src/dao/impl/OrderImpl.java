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
	    String sql = "insert into lb_order values(null,"+order.getShopId()+","+order.getUserId() +",'"+order.getOrderNumber()+
	    		"',"+order.getOrderType()+",'"+order.getCreateTime()+"','"+order.getPayTime()+"','"+order.getFinishTime()+"',"
	    	+order.getAddressId()+",'"+order.getRemark()+"')";
	    System.out.println(sql);
		boolean result = jdbcConnection.insert(sql);
		jdbcConnection.close();
		return result;
	}

	@Override
	public boolean updateOrder(Order order) {
		JDBCConnection jdbcConnection = getJdbcConnection();
		jdbcConnection.OpenConn();
	    String sql = "update lb_order set shop_id="+order.getShopId()+",user_id="+order.getUserId() +",order_number='"+order.getOrderNumber()+
	    		"',order_type="+order.getOrderType()+",create_time='"+order.getCreateTime()+"',pay_time='"+order.getPayTime()+"',finish_time='"+order.getFinishTime()
	    		+"',address_id="+ order.getAddressId()+",remark='"+order.getRemark()+"' where id=" +order.getId();
	    System.out.println(sql);
		boolean result = jdbcConnection.update(sql);
		jdbcConnection.close();
		return result;
	}

	@Override
	public boolean deleteOrder(int id) {
		JDBCConnection jdbcConnection = getJdbcConnection();
		jdbcConnection.OpenConn();
	    String sql = "delete from lb_order where id=" + id;
		boolean result = jdbcConnection.delete(sql);
		jdbcConnection.close();
		return result;
	}

	@Override
	public Order findOrderById(int id) {
		Order order = null;
		JDBCConnection jdbcConnection = getJdbcConnection();
		jdbcConnection.OpenConn();
	    String sql = "select * from lb_order where id="+id;
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
				order.setAddressId(rs.getInt("address_id"));
				order.setRemark(rs.getString("remark"));
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
	public Order findOrderByNumbering(String order_number) {
		Order order = null;
		JDBCConnection jdbcConnection = getJdbcConnection();
		jdbcConnection.OpenConn();
	    String sql = "select * from lb_order where order_number='"+order_number +"'";
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
				order.setAddressId(rs.getInt("address_id"));
				order.setRemark(rs.getString("remark"));
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
	    String sql = "select * from lb_order where user_id="+userId +" and order_type != 0"; 
		ResultSet rs = jdbcConnection.find(sql);
		try {
			while(rs.next()) {
				Order order = new Order();
				order.setId(rs.getInt("id"));
				order.setShopId(rs.getInt("shop_id"));
				order.setUserId(rs.getInt("user_id"));
				order.setOrderNumber(rs.getString("order_number"));
				order.setOrderType(rs.getInt("order_type"));
				order.setCreateTime(rs.getString("create_time"));
				order.setPayTime(rs.getString("pay_time"));
				order.setFinishTime(rs.getString("finish_time"));
				order.setAddressId(rs.getInt("address_id"));
				order.setRemark(rs.getString("remark"));
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
	public List<Order> findOrderByShopId(int shopId, int number) {
		List<Order> orders = null;
		JDBCConnection jdbcConnection = getJdbcConnection();
		jdbcConnection.OpenConn();
	    String sql = "select * from lb_order where shop_id = "+shopId +" and order_type = 5 order by id desc limit "+((number-1)*10)+","+number*10;
		ResultSet rs = jdbcConnection.find(sql);
		try {
			while(rs.next()) {
				Order order = new Order();
				order.setId(rs.getInt("id"));
				order.setShopId(rs.getInt("shop_id"));
				order.setUserId(rs.getInt("user_id"));
				order.setOrderNumber(rs.getString("order_number"));
				order.setOrderType(rs.getInt("order_type"));
				order.setCreateTime(rs.getString("create_time"));
				order.setPayTime(rs.getString("pay_time"));
				order.setFinishTime(rs.getString("finish_time"));
				order.setAddressId(rs.getInt("address_id"));
				order.setRemark(rs.getString("remark"));
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
	public List<Order> findOrderByInvitee(int invitee, int number) {
		List<Order> orders = null;
		JDBCConnection jdbcConnection = getJdbcConnection();
		jdbcConnection.OpenConn();
	    String sql = "SELECT * from lb_order where shop_id IN "
	    		+ "(SELECT id FROM lb_shop where invitee = "+invitee+") and order_type = 5 order by id desc limit "+((number-1)*10)+","+number*10 ;
		ResultSet rs = jdbcConnection.find(sql);
		try {
			while(rs.next()) {
				Order order = new Order();
				order.setId(rs.getInt("id"));
				order.setShopId(rs.getInt("shop_id"));
				order.setUserId(rs.getInt("user_id"));
				order.setOrderNumber(rs.getString("order_number"));
				order.setOrderType(rs.getInt("order_type"));
				order.setCreateTime(rs.getString("create_time"));
				order.setPayTime(rs.getString("pay_time"));
				order.setFinishTime(rs.getString("finish_time"));
				order.setAddressId(rs.getInt("address_id"));
				order.setRemark(rs.getString("remark"));
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
