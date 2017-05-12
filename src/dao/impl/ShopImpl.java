package dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jdbc.JDBCConnection;
import dao.BaseDAO;
import dao.ShopDAO;
import domain.Shop;

public class ShopImpl extends BaseDAO implements ShopDAO{

	@Override
	public boolean insertShop(Shop shop) {
		JDBCConnection jdbcConnection = getJdbcConnection();
		jdbcConnection.OpenConn();
		String sql = null;
		if(shop.getInvitee() == 0){
			sql = "insert into lb_shop values(null, "+shop.getUserId()+",'"+shop.getName()+"','"+shop.getOwner()+"','"
		    		+ shop.getWechat()+ "',"+shop.getMoney()+ ",'"+shop.getIdCard()+"',"+shop.getReviewType()+",null)";
		}else {
			sql = "insert into lb_shop values(null, "+shop.getUserId()+",'"+shop.getName()+"','"+shop.getOwner()+"','"
		    		+ shop.getWechat()+ "',"+shop.getMoney()+ ",'"+shop.getIdCard()+"',"+shop.getReviewType()+","+shop.getInvitee()+ ")";
		}
	    System.out.println(sql);
		boolean result = jdbcConnection.insert(sql);
		jdbcConnection.close();
		return result;
	}

	@Override
	public boolean updateShop(Shop shop) {
		JDBCConnection jdbcConnection = getJdbcConnection();
		jdbcConnection.OpenConn();
		String sql = null;
		if(shop.getInvitee() == 0){
			sql = "update lb_shop set name='"+shop.getName()+"',owner='"+shop.getOwner()+ "',wechat='"+shop.getWechat()+"',money="
					+shop.getMoney()+",id_card='"+shop.getIdCard()+"',review_type=" +shop.getReviewType()
					+",invitee = null where id="+ shop.getId();
		}else{
			sql = "update lb_shop set name='"+shop.getName()+"',owner='"+shop.getOwner()+ "',wechat='"+shop.getWechat()+"',money="
					+shop.getMoney()+",id_card='"+shop.getIdCard()+"',review_type=" +shop.getReviewType() 
					+",invitee=" +shop.getInvitee()+" where id="+ shop.getId();
		}
	    System.out.println(sql);
		boolean result = jdbcConnection.update(sql);
		jdbcConnection.close();
		return result;
	}

	@Override
	public boolean deleteShop(int id) {
		JDBCConnection jdbcConnection = getJdbcConnection();
		jdbcConnection.OpenConn();
	    String sql = "delete from lb_shop where id="+id;
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
	    String sql = "select * from lb_shop where user_id="+userId;
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
				shop.setInvitee(rs.getInt("invitee"));
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
	    String sql = "select * from lb_shop where id="+id;
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
				shop.setInvitee(rs.getInt("invitee"));
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
	public List<Shop> findShopByInvitee(int invitee) {
		List<Shop> shopList = null;
		JDBCConnection jdbcConnection = getJdbcConnection();
		jdbcConnection.OpenConn();
	    String sql = "select * from lb_shop where invitee="+invitee;
		ResultSet rs = jdbcConnection.find(sql);
		try {
			while(rs.next()) {
				Shop shop = new Shop();
				shop.setId(rs.getInt("id"));
				shop.setName(rs.getString("name"));
				shop.setOwner(rs.getString("owner"));
				shop.setUserId(rs.getInt("user_id"));
				shop.setMoney(rs.getLong("money"));
				shop.setWechat(rs.getString("wechat"));
				shop.setIdCard(rs.getString("id_card"));
				shop.setReviewType(rs.getInt("review_type"));
				shop.setInvitee(rs.getInt("invitee"));
				if(shopList == null){
					shopList = new ArrayList<Shop>();
				}
				shopList.add(shop);
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
		return shopList;
	}

	@Override
	public List<Shop> findShopByType(int type, int page) {
		List<Shop> shopList = null;
		JDBCConnection jdbcConnection = getJdbcConnection();
		jdbcConnection.OpenConn();
	    String sql = "select * from lb_shop where review_type="+type+" limit "+((page-1)*10)+","+page*10;
		ResultSet rs = jdbcConnection.find(sql);
		try {
			while(rs.next()) {
				Shop shop = new Shop();
				shop.setId(rs.getInt("id"));
				shop.setName(rs.getString("name"));
				shop.setOwner(rs.getString("owner"));
				shop.setUserId(rs.getInt("user_id"));
				shop.setMoney(rs.getLong("money"));
				shop.setWechat(rs.getString("wechat"));
				shop.setIdCard(rs.getString("id_card"));
				shop.setReviewType(rs.getInt("review_type"));
				shop.setInvitee(rs.getInt("invitee"));
				if(shopList == null){
					shopList = new ArrayList<Shop>();
				}
				shopList.add(shop);
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
		return shopList;
	}

	@Override
	public boolean updateShopType(int id, int type) {
		JDBCConnection jdbcConnection = getJdbcConnection();
		jdbcConnection.OpenConn();
		String sql = "update lb_shop set review_type = " + type + " where id = " + id;
	    System.out.println(sql);
		boolean result = jdbcConnection.update(sql);
		jdbcConnection.close();
		return result;
	}
}
