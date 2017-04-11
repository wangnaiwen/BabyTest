package dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jdbc.JDBCConnection;
import dao.BaseDAO;
import dao.ScDAO;
import domain.Sc;


public class ScImpl extends BaseDAO implements ScDAO{

	@Override
	public boolean insertSc(Sc sc) {
		JDBCConnection jdbcConnection = getJdbcConnection();
		jdbcConnection.OpenConn();
	    String sql = "insert into lb_sc values(null, '"+sc.getName()+"',"+sc.getMcId()+")";
	    System.out.println(sql);
		boolean result = jdbcConnection.insert(sql);
		jdbcConnection.close();
		return result;
	}

	@Override
	public boolean updateSc(Sc sc) {
		JDBCConnection jdbcConnection = getJdbcConnection();
		jdbcConnection.OpenConn();
	    String sql = "update lb_sc set name='"+sc.getName()+"',mc_id="+sc.getMcId() +" where id=" + sc.getId();
	    System.out.println(sql);
		boolean result = jdbcConnection.update(sql);
		jdbcConnection.close();
		return result;
	}

	@Override
	public boolean deleteSc(int id) {
		JDBCConnection jdbcConnection = getJdbcConnection();
		jdbcConnection.OpenConn();
	    String sql = "delete from lb_sc where id="+id;
	    System.out.println(sql);
		boolean result = jdbcConnection.delete(sql);
		jdbcConnection.close();
		return result;
	}

	@Override
	public Sc findScById(int id) {
		Sc sc = null;
		JDBCConnection jdbcConnection = getJdbcConnection();
		jdbcConnection.OpenConn();
	    String sql = "select * from sc where id="+id;
		ResultSet rs = jdbcConnection.find(sql);
		try {
			if(rs.next()) {
				sc = new Sc();
				sc.setId(rs.getInt("id"));
				sc.setName(rs.getString("name"));
				sc.setMcId(rs.getInt("mc_id"));
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
		return sc;
	}

	@Override
	public List<Sc> findScsByMcId(int mcId) {
		List<Sc> scList = null;
		JDBCConnection jdbcConnection = getJdbcConnection();
		jdbcConnection.OpenConn();
	    String sql = "select * from sc where mc_id="+mcId;
		ResultSet rs = jdbcConnection.find(sql);
		try {
			while(rs.next()) {
				Sc sc = new Sc();
				sc.setId(rs.getInt("id"));
				sc.setName(rs.getString("name"));
				sc.setMcId(rs.getInt("mc_id"));
				if(scList == null){
					scList = new ArrayList<Sc>();
				}
				scList.add(sc);
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
		return scList;
	}
}
