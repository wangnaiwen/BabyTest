package dao;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import jdbc.JDBCConnection;
import domain.ReceAddress;

public class ReceAddressImpl extends BaseDAO implements ReceAddressDAO{

	@Override
	public boolean insertReceAddress(ReceAddress address) {
		JDBCConnection jdbcConnection = getJdbcConnection();
		jdbcConnection.OpenConn();
		String sql = "insert into rece_add values(null,"+address.getUserId()+",'"+address.getReceiver()+
				"','"+address.getAddress()+"','" +address.getPhone() +"'," +address.getPostcode()+")";
		boolean result = jdbcConnection.insert(sql);
		jdbcConnection.close();
		return result;
	}

	@Override
	public boolean updateReceAddress(ReceAddress address) {
		JDBCConnection jdbcConnection = getJdbcConnection();
		jdbcConnection.OpenConn();
		String sql = "update rece_add set receiver='"+ address.getReceiver()+"',address='" + address.getAddress() + 
				"',phone='"+address.getPhone() + "',postcode=" + address.getPostcode() +" where id=" + address.getId();
		boolean result = jdbcConnection.update(sql);
		jdbcConnection.close();
		return result;
	}

	@Override
	public boolean deleteReceAddress(ReceAddress address) {
		JDBCConnection jdbcConnection = getJdbcConnection();
		jdbcConnection.OpenConn();
		String sql = "delete from rece_add where id=" + address.getId();
		boolean result = jdbcConnection.delete(sql);
		jdbcConnection.close();
		return result;
	}

	@Override
	public ReceAddress findReceAddressById(int id) {
		ReceAddress address = null;
		JDBCConnection jdbcConnection = getJdbcConnection();
		jdbcConnection.OpenConn();
	    String sql = "select * from rece_add where id="+id;
		ResultSet rs = jdbcConnection.find(sql);
		try {
			if(rs.next()) {
				address = new ReceAddress();
				address.setId(rs.getInt("id"));
				address.setUserId(rs.getInt("user_id"));
				address.setReceiver(rs.getString("receiver"));
				address.setAddress(rs.getString("address"));
				address.setPhone(rs.getString("phone"));
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
	    String sql = "select * from rece_add where user_id="+userId;
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
				address.setAddress(rs.getString("address"));
				address.setPhone(rs.getString("phone"));
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

}
