package dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jdbc.JDBCConnection;
import dao.BaseDAO;
import dao.PrDAO;
import domain.Pr;

public class PrImpl extends BaseDAO implements PrDAO{

	@Override
	public boolean insertPr(Pr pr) {
		JDBCConnection jdbcConnection = getJdbcConnection();
		jdbcConnection.OpenConn();
	    String sql = "insert into pr values(null, "+pr.getDealId()+",'"+pr.getUserNickName()+"',"+pr.getProductId() +","+pr.getUserId()+
	    		","+pr.getServiceScore()+","+pr.getLogisticsScore()+",'"+pr.getEvalution()+"',"+pr.getTime()+")";
	    System.out.println(sql);
		boolean result = jdbcConnection.insert(sql);
		jdbcConnection.close();
		return result;
	}

	/*@Override
	public boolean updatePr(Pr pr) {
		JDBCConnection jdbcConnection = getJdbcConnection();
		jdbcConnection.OpenConn();
	    String sql = "update pr set "+pr.getDealId()+","+pr.getProductId() +","+pr.getUserId()+
	    		","+pr.getServiceScore()+","+pr.getLogisticsScore()+","+pr.getProductScore()+",'"+pr.getEvalution()+"')";
	    System.out.println(sql);
		boolean result = jdbcConnection.insert(sql);
		jdbcConnection.close();
		return result;
	}
*/
	@Override
	public boolean deletePr(int id) {
		JDBCConnection jdbcConnection = getJdbcConnection();
		jdbcConnection.OpenConn();
	    String sql = "delete from pr where id=" + id;
	    System.out.println(sql);
		boolean result = jdbcConnection.delete(sql);
		jdbcConnection.close();
		return result;
	}

	@Override
	public Pr findPrById(int id) {
		Pr pr = null;
		JDBCConnection jdbcConnection = getJdbcConnection();
		jdbcConnection.OpenConn();
	    String sql = "select * from pr where id="+id;
		ResultSet rs = jdbcConnection.find(sql);
		try {
			if(rs.next()) {
				pr = new Pr();
				pr.setId(rs.getInt("id"));
				pr.setDealId(rs.getInt("deal_id"));
				pr.setUserId(rs.getInt("user_id"));
				pr.setUserNickName(rs.getString("user_nickname"));
				pr.setProductId(rs.getInt("product_id"));
				pr.setServiceScore(rs.getInt("service_score"));
				pr.setLogisticsScore(rs.getInt("logistics_score"));
				pr.setProductScore(rs.getInt("product_score"));
				pr.setEvalution(rs.getString("evalution"));
				pr.setTime(rs.getString("time"));
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
		return pr;
	}

	@Override
	public List<Pr> findPrsByUserId(int userId) {
		List<Pr> prList = null;
		JDBCConnection jdbcConnection = getJdbcConnection();
		jdbcConnection.OpenConn();
	    String sql = "select * from pr where user_id="+userId;
		ResultSet rs = jdbcConnection.find(sql);
		try {
			while(rs.next()) {
				Pr pr = new Pr();
				pr.setId(rs.getInt("id"));
				pr.setDealId(rs.getInt("deal_id"));
				pr.setUserId(rs.getInt("user_id"));
				pr.setProductId(rs.getInt("product_id"));
				pr.setServiceScore(rs.getInt("service_score"));
				pr.setLogisticsScore(rs.getInt("logistics_score"));
				pr.setProductScore(rs.getInt("product_score"));
				pr.setEvalution(rs.getString("evalution"));
				pr.setTime(rs.getString("time"));
				if(prList == null){
					prList = new ArrayList<Pr>();
				}
				prList.add(pr);
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
		return prList;
	}

	@Override
	public List<Pr> findPrsByDealId(int dealId) {
		List<Pr> prList = null;
		JDBCConnection jdbcConnection = getJdbcConnection();
		jdbcConnection.OpenConn();
	    String sql = "select * from pr where deal_id="+dealId;
		ResultSet rs = jdbcConnection.find(sql);
		try {
			if(rs.next()) {
				Pr pr = new Pr();
				pr.setId(rs.getInt("id"));
				pr.setDealId(rs.getInt("deal_id"));
				pr.setUserId(rs.getInt("user_id"));
				pr.setProductId(rs.getInt("product_id"));
				pr.setServiceScore(rs.getInt("service_score"));
				pr.setLogisticsScore(rs.getInt("logistics_score"));
				pr.setProductScore(rs.getInt("product_score"));
				pr.setEvalution(rs.getString("evalution"));
				pr.setTime(rs.getString("time"));
				if(prList == null){
					prList = new ArrayList<Pr>();
				}
				prList.add(pr);
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
		return prList;
	}

	@Override
	public List<Pr> findPrsByProductId(int productId) {
		List<Pr> prList = null;
		JDBCConnection jdbcConnection = getJdbcConnection();
		jdbcConnection.OpenConn();
	    String sql = "select * from pr where product_id="+productId;
		ResultSet rs = jdbcConnection.find(sql);
		try {
			if(rs.next()) {
				Pr pr = new Pr();
				pr.setId(rs.getInt("id"));
				pr.setDealId(rs.getInt("deal_id"));
				pr.setUserId(rs.getInt("user_id"));
				pr.setProductId(rs.getInt("product_id"));
				pr.setServiceScore(rs.getInt("service_score"));
				pr.setLogisticsScore(rs.getInt("logistics_score"));
				pr.setProductScore(rs.getInt("product_score"));
				pr.setEvalution(rs.getString("evalution"));
				pr.setTime(rs.getString("time"));
				if(prList == null){
					prList = new ArrayList<Pr>();
				}
				prList.add(pr);
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
		return prList;
	}

}
