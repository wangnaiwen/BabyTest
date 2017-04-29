package dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import jdbc.JDBCConnection;
import dao.AdminDAO;
import dao.BaseDAO;
import domain.Admin;

public class AdminImpl extends BaseDAO implements AdminDAO{

	@Override
	public boolean findAdmin(Admin admin) {
		boolean result = false;
		JDBCConnection jdbcConnection = getJdbcConnection();
		jdbcConnection.OpenConn();
	    String sql = "select * from lb_admin where name='"+admin.getName()
	    		+"' and password='"+admin.getPassword()+"'";
		ResultSet rs = jdbcConnection.find(sql);
		try {
			if(rs.next()) {
				result = true;
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
		return result;
	}
}
