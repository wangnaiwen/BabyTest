package dao;

import jdbc.JDBCConnection;

public class BaseDAO {
	
	private JDBCConnection jdbcConnection;
	
	public JDBCConnection getJdbcConnection() {
		if(jdbcConnection == null){
			jdbcConnection = new JDBCConnection();
		}
		return jdbcConnection;
	}

	public void setJdbcConnection(JDBCConnection jdbcConnection) {
		this.jdbcConnection = jdbcConnection;
	}
	
}
