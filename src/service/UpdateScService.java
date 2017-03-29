package service;

import dao.ScDAO;
import domain.Sc;
import service.dao.BaseScServiceDAO;
import service.dao.UpdateScServiceDAO;

public class UpdateScService extends BaseScServiceDAO implements UpdateScServiceDAO{

	@Override
	public boolean updateSc(Sc sc) {
		ScDAO scDAO = getScDAO();
		return scDAO.updateSc(sc);
	}
	
}
