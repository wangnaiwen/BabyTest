package dao.impl;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jdbc.JDBCConnection;
import dao.BaseDAO;
import dao.ReceAddressDAO;
import domain.ReceAddress;

public class ReceAddressImpl extends BaseDAO implements ReceAddressDAO{

	@Override
	public boolean insertReceAddress(ReceAddress address) {
		JDBCConnection jdbcConnection = getJdbcConnection();
		jdbcConnection.OpenConn();
		String sql = "insert into lb_rece_add values(null,"+address.getUserId()+",'"+address.getReceiver()+
				"','"+address.getPhone() +"','"+address.getProvince()+"','"+address.getCity()+"','"+address.getCounty()
				+"','"+address.getDetailAddress()+"',"  +address.getPostcode()+")";
		System.out.println(sql);
		boolean result = jdbcConnection.insert(sql);
		jdbcConnection.close();
		return result;
	}

	@Override
	public boolean updateReceAddress(ReceAddress address) {
		JDBCConnection jdbcConnection = getJdbcConnection();
		jdbcConnection.OpenConn();
		String sql = "update lb_rece_add set receiver='"+ address.getReceiver()+"',phone='"+address.getPhone() 
				+ "',province='" + address.getProvince() + "',city='" + address.getCity() 
				+ "',county='" + address.getCounty()+ "',detail_address='" + address.getDetailAddress()+ "',postcode=" + address.getPostcode() +" where id=" + address.getId();
		boolean result = jdbcConnection.update(sql);
		jdbcConnection.close();
		return result;
	}

	@Override
	public boolean deleteReceAddress(ReceAddress address) {
		JDBCConnection jdbcConnection = getJdbcConnection();
		jdbcConnection.OpenConn();
		String sql = "delete from lb_rece_add where id=" + address.getId();
		boolean result = jdbcConnection.delete(sql);
		jdbcConnection.close();
		return result;
	}

	@Override
	public ReceAddress findReceAddressById(int id) {
		ReceAddress address = null;
		JDBCConnection jdbcConnection = getJdbcConnection();
		jdbcConnection.OpenConn();
	    String sql = "select * from lb_rece_add where id="+id;
		ResultSet rs = jdbcConnection.find(sql);
		try {
			while(rs.next()) {
				address = new ReceAddress();
				address.setId(rs.getInt("id"));
				address.setUserId(rs.getInt("user_id"));
				address.setReceiver(rs.getString("receiver"));
				address.setPhone(rs.getString("phone"));
				address.setProvince(rs.getString("province"));
				address.setCity(rs.getString("city"));
				address.setCounty(rs.getString("county"));
				address.setDetailAddress(rs.getString("detail_address"));
				address.setPostcode(rs.getInt("postcode"));
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
		return address;
	}

	@Override
	public List<ReceAddress> findReceAddressByUserId(int userId) {
		List<ReceAddress> addressList = null;
		JDBCConnection jdbcConnection = getJdbcConnection();
		jdbcConnection.OpenConn();
	    String sql = "select * from lb_rece_add where user_id="+userId;
		ResultSet rs = jdbcConnection.find(sql);
		try {
			while(rs.next()) {
				if(addressList == null){
					addressList = new ArrayList<ReceAddress>();
				}
				ReceAddress address = new ReceAddress();
				address.setId(rs.getInt("id"));
				address.setUserId(rs.getInt("user_id"));
				address.setReceiver(rs.getString("receiver"));
				address.setPhone(rs.getString("phone"));
				address.setProvince(rs.getString("province"));
				address.setCity(rs.getString("city"));
				address.setCounty(rs.getString("county"));
				address.setDetailAddress(rs.getString("detail_address"));
				address.setPostcode(rs.getInt("postcode"));
				addressList.add(address);
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
		return addressList;
	}

	@Override
	public ReceAddress findFinalReceAddressByUserId(int userId) {
		ReceAddress address = null;
		JDBCConnection jdbcConnection = getJdbcConnection();
		jdbcConnection.OpenConn();
	    String sql = "select * from lb_rece_add where id=(select max(id) from lb_rece_add where user_id="+userId + ")";
		ResultSet rs = jdbcConnection.find(sql);
		try {
			if(rs.next()) {
				address = new ReceAddress();
				address.setId(rs.getInt("id"));
				address.setUserId(rs.getInt("user_id"));
				address.setReceiver(rs.getString("receiver"));
				address.setPhone(rs.getString("phone"));
				address.setProvince(rs.getString("province"));
				address.setCity(rs.getString("city"));
				address.setCounty(rs.getString("county"));
				address.setDetailAddress(rs.getString("detail_address"));
				address.setPostcode(rs.getInt("postcode"));
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
		return address;
	}

}
