package service;

import dao.ScDAO;
import domain.Sc;
import service.dao.BaseScServiceDAO;
import service.dao.InsertScServiceDAO;

public class InsertScService extends BaseScServiceDAO implements InsertScServiceDAO{

	@Override
	public boolean insertSc(Sc sc) {
		ScDAO scDAO = getScDAO();
		return scDAO.insertSc(sc);
	}

}
