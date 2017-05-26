package service.dao;

import dao.OffProductDAO;

public class BaseOffProductServiceDAO {
	private OffProductDAO offProductDAO;

	public OffProductDAO getOffProductDAO() {
		return offProductDAO;
	}

	public void setOffProductDAO(OffProductDAO offProductDAO) {
		this.offProductDAO = offProductDAO;
	}
	
}
