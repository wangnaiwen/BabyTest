package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * This class for JDBC to connect the database
 * */

public class JDBCConnection {
	private Statement stmt = null;
	private Connection conn = null;
	
	public JDBCConnection() {
	
	}
	
	/**
	 * open the Connection of JDBC
	 * */
	public void OpenConn() {
		try {
			Class.forName(SqlConfig.CLASS_NAME);
			conn = DriverManager.getConnection(SqlConfig.URL, SqlConfig.USER, SqlConfig.PASSWORD);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * find
	 * */
	public ResultSet find(String sql) {
		ResultSet rs = null;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return rs;
	}
	
	/**
	 * update
	 * */
	public boolean update(String sql) {
		try {
			conn.setAutoCommit(false);
			stmt = conn.createStatement();
			stmt.executeUpdate(sql);
			conn.commit();
			return true;
		} catch (SQLException e) {
			try {
				conn.rollback();
				return false;
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
			return false;
		}finally{
			try {
				conn.setAutoCommit(true);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * insert
	 * */
	public boolean insert(String sql) {
		try {
			conn.setAutoCommit(false);
			stmt = conn.createStatement();
			stmt.execute(sql);
			conn.commit();
			return true;
		} catch (SQLException e) {
			try {
				conn.rollback();
				return false;
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
			return false;
		}finally{
			try {
				conn.setAutoCommit(true);
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	
	/**
	 * delete
	 * */
	public boolean delete(String sql){
		try{
			conn.setAutoCommit(false);
			stmt = conn.createStatement();
			stmt.execute(sql);
			conn.commit();
			return true;
		}catch(SQLException e){
			try {
				conn.rollback();
				return false;
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
			return false;
		}finally{
			try {
				conn.setAutoCommit(true);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * Close the Connection and the Statement
	 * */
	public void close() {
		try {
			if(stmt != null){
				stmt.close();
			}
			
			if(conn != null){
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
