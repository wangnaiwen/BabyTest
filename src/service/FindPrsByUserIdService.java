package service;

import java.util.List;

import dao.PrDAO;
import domain.Pr;
import service.dao.BasePrServiceDAO;
import service.dao.FindPrsByUserIdServiceDAO;

public class FindPrsByUserIdService extends BasePrServiceDAO implements FindPrsByUserIdServiceDAO{

	@Override
	public List<Pr> findPrsByUserId(int userId, int number) {
		PrDAO prDAO = getPrDAO();
		return prDAO.findPrsByUserId(userId, number);
	}
	
}
