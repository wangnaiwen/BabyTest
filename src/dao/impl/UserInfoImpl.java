package dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import jdbc.JDBCConnection;
import dao.BaseDAO;
import dao.UserInfoDAO;
import domain.UserInfo;

/**
 * Creator:WNW
 * Time:2016/11/29
 * */


public class UserInfoImpl extends BaseDAO implements UserInfoDAO{

	/**
	 * insert the user's information
	 * */
	
	@Override
	public boolean insertUserInfo(UserInfo userInfo) {
		JDBCConnection jdbcConnection = getJdbcConnection();
		jdbcConnection.OpenConn();
	    String sql = "insert into user_info values(null,"+userInfo.getUserId()+",'ÄÐ'," + userInfo.getUserImg()+
	    		"," +userInfo.getNickName()+","+userInfo.getBirthday()+","+userInfo.getEmail()+","+userInfo.getHobby()+","+userInfo.getPersonalizedSignature()+")";
		System.out.println(sql);
	    boolean result = jdbcConnection.insert(sql);
		jdbcConnection.close();
		return result;
	}

	/**
	 * update the user's information
	 * */
	
	@Override
	public boolean updateUserInfo(UserInfo userInfo) {
		JDBCConnection jdbcConnection = getJdbcConnection();
		jdbcConnection.OpenConn();
	    String sql = "update user_info set sex='"+userInfo.getSex()+"',user_img='"+userInfo.getUserImg()+"',nickname='" + userInfo.getNickName()+ 
	    		"',birthday='" + userInfo.getBirthday()+ "',email='" + userInfo.getEmail()+ "',hobby='" + userInfo.getHobby()+ 
	    		"',personalized_signature='" + userInfo.getPersonalizedSignature()+ "' where id="+userInfo.getId();
		System.out.print(sql);
	    boolean result = jdbcConnection.update(sql);
		jdbcConnection.close();
		return result;
	}

	/**
	 * delete user's information
	 * */
	
	@Override
	public boolean deleteUserInfo(UserInfo userInfo) {
		JDBCConnection jdbcConnection = getJdbcConnection();
		jdbcConnection.OpenConn();
	    String sql = "delete from user_info where id="+userInfo.getId();
		boolean result = jdbcConnection.delete(sql);
		jdbcConnection.close();
		return result;
	}

	/**
	 * find a user's information by the id
	 * */
	
	@Override
	public UserInfo findUserInfoById(int id) {
		UserInfo userInfo = null;
		JDBCConnection jdbcConnection = getJdbcConnection();
		jdbcConnection.OpenConn();
	    String sql = "select * from user_info where id="+id;
		ResultSet rs = jdbcConnection.find(sql);
		try {
			if(rs.next()) {
				userInfo = new UserInfo();
				userInfo.setId(rs.getInt("id"));
				userInfo.setUserId(rs.getInt("user_id"));
				userInfo.setSex(rs.getString("sex"));
				userInfo.setUserImg(rs.getString("user_img"));
				userInfo.setNickName(rs.getString("nickname"));
				userInfo.setEmail(rs.getString("email"));
				userInfo.setBirthday(rs.getString("birthday"));
				userInfo.setHobby(rs.getString("hobby"));
				userInfo.setPersonalizedSignature(rs.getString("personalized_signature"));
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
		return userInfo;
	}

	/**
	 * find a user's information by user_id
	 * */
	@Override
	public UserInfo findUserInfoByUserId(int userId) {
		UserInfo userInfo = null;
		JDBCConnection jdbcConnection = getJdbcConnection();
		jdbcConnection.OpenConn();
	    String sql = "select * from user_info where user_id="+userId;
		ResultSet rs = jdbcConnection.find(sql);
		try {
			if(rs.next()) {
				userInfo = new UserInfo();
				userInfo.setId(rs.getInt("id"));
				userInfo.setUserId(rs.getInt("user_id"));
				userInfo.setSex(rs.getString("sex"));
				userInfo.setUserImg(rs.getString("user_img"));
				userInfo.setNickName(rs.getString("nickname"));
				userInfo.setEmail(rs.getString("email"));
				userInfo.setBirthday(rs.getString("birthday"));
				userInfo.setHobby(rs.getString("hobby"));
				userInfo.setPersonalizedSignature(rs.getString("personalized_signature"));
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
		return userInfo;
	}
}
