package service;

import java.util.List;

import dao.ScDAO;
import domain.Sc;
import service.dao.BaseScServiceDAO;
import service.dao.FindScByMcIdServiceDAO;

public class FindScsByMcIdService extends BaseScServiceDAO implements FindScByMcIdServiceDAO{

	@Override
	public List<Sc> findScsByMcId(int mcId) {
		ScDAO scDAO = getScDAO();
		return scDAO.findScsByMcId(mcId);
	}

}
