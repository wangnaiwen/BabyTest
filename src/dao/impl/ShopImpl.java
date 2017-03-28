package dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import jdbc.JDBCConnection;
import dao.BaseDAO;
import dao.ShopDAO;
import domain.Shop;

public class ShopImpl extends BaseDAO implements ShopDAO{

	@Override
	public boolean insertShop(Shop shop) {
		JDBCConnection jdbcConnection = getJdbcConnection();
		jdbcConnection.OpenConn();
	    String sql = "insert into shop values(null, "+shop.getUserId()+",'"+shop.getName()+",'"+shop.getOwner()+"','"
	    		+ shop.getWechat()+ "',"+shop.getMoney()+ ",'"+shop.getIdCard()+"',"+shop.getReviewType()+ ")";
	    System.out.println(sql);
		boolean result = jdbcConnection.insert(sql);
		jdbcConnection.close();
		return result;
	}

	@Override
	public boolean updateShop(Shop shop) {
		JDBCConnection jdbcConnection = getJdbcConnection();
		jdbcConnection.OpenConn();
	    String sql = "update shop set name='"+shop.getName()+"',owner='"+shop.getOwner()+ "',wechat='"+shop.getWechat()+"',money="
		+shop.getMoney()+",id_card='"+shop.getIdCard()+"',review_type=" +shop.getReviewType() +" where id="+ shop.getId();
	    System.out.println(sql);
		boolean result = jdbcConnection.insert(sql);
		jdbcConnection.close();
		return result;
	}

	@Override
	public boolean deleteShop(int id) {
		JDBCConnection jdbcConnection = getJdbcConnection();
		jdbcConnection.OpenConn();
	    String sql = "delete from shop where id="+id;
	    System.out.println(sql);
		boolean result = jdbcConnection.delete(sql);
		jdbcConnection.close();
		return result;
	}

	@Override
	public Shop findShopByUserId(int userId) {
		Shop shop = null;
		JDBCConnection jdbcConnection = getJdbcConnection();
		jdbcConnection.OpenConn();
	    String sql = "select * from shop where user_id="+userId;
		ResultSet rs = jdbcConnection.find(sql);
		try {
			if(rs.next()) {
				shop = new Shop();
				shop.setId(rs.getInt("id"));
				shop.setName(rs.getString("name"));
				shop.setOwner(rs.getString("owner"));
				shop.setUserId(rs.getInt("user_id"));
				shop.setMoney(rs.getLong("money"));
				shop.setWechat(rs.getString("wechat"));
				shop.setIdCard(rs.getString("id_card"));
				shop.setReviewType(rs.getInt("review_type"));
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
		return shop;
	}

	@Override
	public Shop findShopById(int id) {
		Shop shop = null;
		JDBCConnection jdbcConnection = getJdbcConnection();
		jdbcConnection.OpenConn();
	    String sql = "select * from shop where id="+id;
		ResultSet rs = jdbcConnection.find(sql);
		try {
			if(rs.next()) {
				shop = new Shop();
				shop.setId(rs.getInt("id"));
				shop.setName(rs.getString("name"));
				shop.setOwner(rs.getString("owner"));
				shop.setUserId(rs.getInt("user_id"));
				shop.setMoney(rs.getLong("money"));
				shop.setWechat(rs.getString("wechat"));
				shop.setIdCard(rs.getString("id_card"));
				shop.setReviewType(rs.getInt("review_type"));
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
		return shop;
	}
}
