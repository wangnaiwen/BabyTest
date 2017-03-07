package dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import jdbc.JDBCConnection;
import domain.User;

/**
 * Creator: WNW
 * Time: 2016.11.29 
 * */

public class UserImpl extends BaseDAO implements UserDAO{

	/**
	 * insert a user to database
	 * */
	@Override
	public boolean insertUser(User user) {
		JDBCConnection jdbcConnection = getJdbcConnection();
		jdbcConnection.OpenConn();
	    String sql = "insert into user values(null, '"+user.getPassword()+"','"+user.getPhone()+"'," + user.getType()+ ")";
		boolean result = jdbcConnection.insert(sql);
		jdbcConnection.close();
		return result;
	}

	/**
	 * update user's information to database
	 * */
	@Override
	public boolean updateUser(User user) {
		JDBCConnection jdbcConnection = getJdbcConnection();
		jdbcConnection.OpenConn();
	    String sql = "update user set password='"+user.getPassword()+"',phone='"+user.getPhone()+"',type=" + user.getType()+ " where id="+user.getId();
		boolean result = jdbcConnection.update(sql);
		jdbcConnection.close();
		return result;
	}
	
	
	/**
	 * update the user's password
	 * */
	
	@Override
	public boolean updateUserPassword(String phone, String password) {
		JDBCConnection jdbcConnection = getJdbcConnection();
		jdbcConnection.OpenConn();
	    String sql = "update user set password='"+password+"' where phone='"+phone+ "'";
		boolean result = jdbcConnection.update(sql);
		jdbcConnection.close();
		return result;
	}

	/**
	 * update the user's type
	 * */
	@Override
	public boolean updateUserType(String phone, int type) {
		JDBCConnection jdbcConnection = getJdbcConnection();
		jdbcConnection.OpenConn();
		String sql = "update user set type="+type+" where phone='"+phone+ "'";
		boolean result = jdbcConnection.update(sql);
		jdbcConnection.close();
		return result;
	}

	/**
	 * delete a user from database
	 * */
	@Override
	public boolean deleteUser(User user) {
		JDBCConnection jdbcConnection = getJdbcConnection();
		jdbcConnection.OpenConn();
	    String sql = "delete from user where id="+user.getId();
		boolean result = jdbcConnection.delete(sql);
		jdbcConnection.close();
		return result;
	}

	/**
	 * select a user from database by column of id
	 * */
	@Override
	public User findUserById(int id) {
		User user = null;
		JDBCConnection jdbcConnection = getJdbcConnection();
		jdbcConnection.OpenConn();
	    String sql = "select * from user where id="+id;
		ResultSet rs = jdbcConnection.find(sql);
		try {
			if(rs.next()) {
				user = new User();
				user.setId(rs.getInt("id"));
				user.setPassword(rs.getString("password"));
				user.setPhone(rs.getString("phone"));
				user.setType(rs.getInt("type"));
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
		return user;
	}

	/**
	 * select a user from database by column of phone
	 * */
	@Override
	public User findUserByPhone(String phone) {
		User user = null;
		JDBCConnection jdbcConnection = getJdbcConnection();
		jdbcConnection.OpenConn();
	    String sql = "select * from user where phone='"+phone +"'";
		ResultSet rs = jdbcConnection.find(sql);
		try {
			if(rs.next()) {
				user = new User();
				user.setId(rs.getInt("id"));
				user.setPassword(rs.getString("password"));
				user.setPhone(rs.getString("phone"));
				user.setType(rs.getInt("type"));
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
		return user;
	}

	/**
	 * Check the user is exist when user want login in the system
	 * 
	 * */
	@Override
	public User validateUser(User user) {
		JDBCConnection jdbcConnection = getJdbcConnection();
		jdbcConnection.OpenConn();
	    String sql = "select * from user where id=" + user.getId() + " and password='" +user.getPassword()+"'";
	    String sql2 = "select * from user where phone='"+user.getPhone() + "' and password='"+user.getPassword()+"'";
		ResultSet rs = jdbcConnection.find(sql);
		ResultSet rs2 = jdbcConnection.find(sql2);
		User user2 = null;
		try {
			if(rs.next()) {
				user2 = new User();
				user2.setId(rs.getInt("id"));
				user2.setPassword(rs.getString("password"));
				user2.setPhone(rs.getString("phone"));
				user2.setType(rs.getInt("type"));
			}
			
			if(rs2.next()){
				user2 = new User();
				user2.setId(rs2.getInt("id"));
				user2.setPassword(rs2.getString("password"));
				user2.setPhone(rs2.getString("phone"));
				user2.setType(rs2.getInt("type"));
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
			if(rs2 != null){
				try {
					rs2.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return user2;
	}
}
