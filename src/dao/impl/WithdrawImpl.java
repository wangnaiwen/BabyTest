package dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import jdbc.JDBCConnection;
import dao.BaseDAO;
import dao.WithdrawDAO;
import domain.Withdraw;

public class WithdrawImpl extends BaseDAO implements WithdrawDAO{

	@Override
	public boolean insertWithdraw(Withdraw withdraw) {
		JDBCConnection jdbcConnection = getJdbcConnection();
		jdbcConnection.OpenConn();
	    boolean result;
		String sql = "insert into lb_withdraw values(null, "+withdraw.getUserId()+","+withdraw.getMoney() +")";
	    String sql1 = "update lb_user_wallet set money = ( money + " +withdraw.getMoney() + ") where user_id = " +withdraw.getUserId();
	    System.out.println(sql);
		if(jdbcConnection.insert(sql)){
			result = jdbcConnection.update(sql1);
		}else {
			result = false;
		}
		jdbcConnection.close();
		return result;
	}

	@Override
	public int findMoneyByuserId(int userId) {
		int money = 0;
		JDBCConnection jdbcConnection = getJdbcConnection();
		jdbcConnection.OpenConn();
	    String sql = "SELECT SUM(money) FROM lb_withdraw WHERE userId = "+userId;
		ResultSet rs = jdbcConnection.find(sql);
		try {
			if(rs.next()){
				money = rs.getInt("SUM(money)");
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
		return money;
	}
	
}
