package service.dao;

import dao.ScDAO;

public class BaseScServiceDAO {
	private ScDAO scDAO;

	public ScDAO getScDAO() {
		return scDAO;
	}

	public void setScDAO(ScDAO scDAO) {
		this.scDAO = scDAO;
	}
	
}
