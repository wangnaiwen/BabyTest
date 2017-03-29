package service.dao;

import dao.DealDAO;

public class BaseDealServiceDAO {
	private DealDAO dealDAO;

	public DealDAO getDealDAO() {
		return dealDAO;
	}

	public void setDealDAO(DealDAO dealDAO) {
		this.dealDAO = dealDAO;
	}
	
}
