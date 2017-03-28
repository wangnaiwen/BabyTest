package service.dao;

import dao.ReceAddressDAO;

public class BaseReceAddressServiceDAO {
	private ReceAddressDAO receAddressDAO;

	public ReceAddressDAO getReceAddressDAO() {
		return receAddressDAO;
	}

	public void setReceAddressDAO(ReceAddressDAO receAddressDAO) {
		this.receAddressDAO = receAddressDAO;
	}
	
	
}
