package service;

import dao.PrDAO;
import domain.Pr;
import service.dao.BasePrServiceDAO;
import service.dao.FindPrByIdServiceDAO;

public class FindPrByIdService extends BasePrServiceDAO implements FindPrByIdServiceDAO{

	@Override
	public Pr findPrById(int id) {
		PrDAO prDAO = getPrDAO();
		return prDAO.findPrById(id);
	}

}
