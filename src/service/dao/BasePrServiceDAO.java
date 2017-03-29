package service.dao;

import dao.PrDAO;

public class BasePrServiceDAO {
	private PrDAO prDAO;

	public PrDAO getPrDAO() {
		return prDAO;
	}

	public void setPrDAO(PrDAO prDAO) {
		this.prDAO = prDAO;
	}
	
}
