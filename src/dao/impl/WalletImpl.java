package dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import jdbc.JDBCConnection;
import dao.BaseDAO;
import dao.WalletDAO;
import domain.Wallet;

public class WalletImpl extends BaseDAO implements WalletDAO{

	@Override
	public boolean insertWallet(Wallet wallet) {
		JDBCConnection jdbcConnection = getJdbcConnection();
		jdbcConnection.OpenConn();
	    String sql = "insert into lb_user_wallet values(null, "+wallet.getUserId()+","+wallet.getMoney() +",'"
		+wallet.getPassword()+ "')";
	    System.out.println(sql);
		boolean result = jdbcConnection.insert(sql);
		jdbcConnection.close();
		return result;
	}

	@Override
	public boolean updateWalletPassword(int userId, String password) {
		JDBCConnection jdbcConnection = getJdbcConnection();
		jdbcConnection.OpenConn();
	    String sql = "update lb_user_wallet set password = '" +password + "' where user_id = " +userId;
	    System.out.println(sql);
		boolean result = jdbcConnection.update(sql);
		jdbcConnection.close();
		return result;
	}

	@Override
	public boolean subWalletMoney(int userId, int money) {
		JDBCConnection jdbcConnection = getJdbcConnection();
		jdbcConnection.OpenConn();
	    String sql = "update lb_user_wallet set money = ( money - " +money + ") where user_id="+ userId;
	    System.out.println(sql);
		boolean result = jdbcConnection.update(sql);
		jdbcConnection.close();
		return result;
	}

	@Override
	public boolean addWalletMoney(int userId, int money) {
		JDBCConnection jdbcConnection = getJdbcConnection();
		jdbcConnection.OpenConn();
	    String sql = "update lb_user_wallet set money = ( money + " +money + ") where user_id = " +userId;
	    System.out.println(sql);
		boolean result = jdbcConnection.update(sql);
		jdbcConnection.close();
		return result;
	}

	@Override
	public boolean valiteWallet(int userId, String password) {
		boolean result = false;
		JDBCConnection jdbcConnection = getJdbcConnection();
		jdbcConnection.OpenConn();
	    String sql = "select * from lb_user_wallet where user_id="+userId + " and password = '"+password+"'";
		ResultSet rs = jdbcConnection.find(sql);
		try {
			result = rs.next();
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

	@Override
	public int findWalletMoneyByUserId(int userId) {
		int result = 0;
		JDBCConnection jdbcConnection = getJdbcConnection();
		jdbcConnection.OpenConn();
	    String sql = "select money from lb_user_wallet where user_id="+userId;
		ResultSet rs = jdbcConnection.find(sql);
		try {
			if(rs.next()){
				result = rs.getInt("money");
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
