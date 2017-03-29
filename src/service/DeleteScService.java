package service;

import dao.ScDAO;
import service.dao.BaseScServiceDAO;
import service.dao.DeleteScServiceDAO;

public class DeleteScService extends BaseScServiceDAO implements DeleteScServiceDAO{

	@Override
	public boolean deleteSc(int id) {
		ScDAO scDAO = getScDAO();
		return scDAO.deleteSc(id);
	}
	
}
