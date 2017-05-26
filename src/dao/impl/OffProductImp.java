package dao.impl;

import jdbc.JDBCConnection;
import dao.BaseDAO;
import dao.OffProductDAO;
import domain.Product;

public class OffProductImp extends BaseDAO implements OffProductDAO{

	@Override
	public boolean insertOffProduct(Product product) {
		JDBCConnection jdbcConnection = getJdbcConnection();
		jdbcConnection.OpenConn();
	    String sql = "insert into lb_off_product values( "+product.getId()+","+product.getScId()+",'"+product.getNumbering()+"','"+product.getName() +"','"
	    		+product.getBrand()+"',"+product.getRetailPrice()+","+product.getStandardPrice()+",'"
	    		+product.getDescription()+"','"+product.getCoverImg()+"',"+product.getCount()+")";
	    System.out.println(sql);
		boolean result = jdbcConnection.insert(sql);
		jdbcConnection.close();
		return result;
	}
	
}
