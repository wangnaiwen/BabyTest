package dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jdbc.JDBCConnection;
import dao.BaseDAO;
import dao.SearchDAO;
import domain.Search;

public class SearchImpl extends BaseDAO implements SearchDAO{

	@Override
	public boolean insertSearch(Search search) {
		JDBCConnection jdbcConnection = getJdbcConnection();
		jdbcConnection.OpenConn();
	    String sql = "insert into lb_search values(null,"+search.getUserId()+",'"+search.getKey()+"')";
	    System.out.println(sql);
		boolean result = jdbcConnection.insert(sql);
		jdbcConnection.close();
		return result;
	}

	@Override
	public List<Search> findSearchByUserId(int userId) {
		List<Search> searchList = null;
		JDBCConnection jdbcConnection = getJdbcConnection();
		jdbcConnection.OpenConn();
	    String sql = "select * from lb_search where userId="+userId + " order by id desc limit 0, 10";
		ResultSet rs = jdbcConnection.find(sql);
		try {
			while(rs.next()) {
				Search search = new Search();
				search.setId(rs.getInt("id"));
				search.setUserId(rs.getInt("userId"));
				search.setKey(rs.getString("key"));
				if(searchList == null){
					searchList = new ArrayList<>();
				}
				searchList.add(search);
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
		return searchList;
	}
	
}
