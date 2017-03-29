package service;

import dao.ScDAO;
import domain.Sc;
import service.dao.BaseScServiceDAO;
import service.dao.FindScByIdServiceDAO;

public class FindScByIdService extends BaseScServiceDAO implements FindScByIdServiceDAO{

	@Override
	public Sc findScById(int id) {
		ScDAO scDAO = getScDAO();
		return scDAO.findScById(id);
	}
	

}
