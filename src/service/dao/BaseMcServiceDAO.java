package service.dao;

import dao.McDAO;

public class BaseMcServiceDAO {
	private McDAO mcDAO;

	public McDAO getMcDAO() {
		return mcDAO;
	}

	public void setMcDAO(McDAO mcDAO) {
		this.mcDAO = mcDAO;
	}
	
}
