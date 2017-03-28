package dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jdbc.JDBCConnection;
import dao.BaseDAO;
import dao.McDAO;
import domain.Mc;

public class McImpl extends BaseDAO implements McDAO{

	@Override
	public boolean insertMc(Mc mc) {
		JDBCConnection jdbcConnection = getJdbcConnection();
		jdbcConnection.OpenConn();
	    String sql = "insert into mc values(null, '"+mc.getName()+"')";
	    System.out.println(sql);
		boolean result = jdbcConnection.insert(sql);
		jdbcConnection.close();
		return result;
	}

	@Override
	public boolean updateMc(Mc mc) {
		JDBCConnection jdbcConnection = getJdbcConnection();
		jdbcConnection.OpenConn();
	    String sql = "update mc set name='"+mc.getName()+"' where id=" +mc.getId();
	    System.out.println(sql);
		boolean result = jdbcConnection.insert(sql);
		jdbcConnection.close();
		return result;
	}

	@Override
	public boolean deleteMc(int id) {
		JDBCConnection jdbcConnection = getJdbcConnection();
		jdbcConnection.OpenConn();
	    String sql = "delete from mc where id="+id;
	    System.out.println(sql);
		boolean result = jdbcConnection.delete(sql);
		jdbcConnection.close();
		return result;
	}

	@Override
	public Mc findMcById(int id) {
		Mc mc = null;
		JDBCConnection jdbcConnection = getJdbcConnection();
		jdbcConnection.OpenConn();
	    String sql = "select * from mc where id="+id;
		ResultSet rs = jdbcConnection.find(sql);
		try {
			if(rs.next()) {
				mc = new Mc();
				mc.setId(rs.getInt("id"));
				mc.setName(rs.getString("name"));
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
		return mc;
	}

	@Override
	public List<Mc> findMcs() {
		List<Mc> mcList = null;
		JDBCConnection jdbcConnection = getJdbcConnection();
		jdbcConnection.OpenConn();
	    String sql = "select * from mc";
		ResultSet rs = jdbcConnection.find(sql);
		try {
			if(rs.next()) {
				Mc mc = new Mc();
				mc.setId(rs.getInt("id"));
				mc.setName(rs.getString("name"));
				if(mcList == null){
					mcList = new ArrayList<Mc>();
				}
				mcList.add(mc);
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
		return mcList;
	}

}
