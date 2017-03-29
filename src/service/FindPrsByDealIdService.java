package service;

import java.util.List;

import dao.PrDAO;
import domain.Pr;
import service.dao.BasePrServiceDAO;
import service.dao.FindPrsByDealIdServiceDAO;

public class FindPrsByDealIdService extends BasePrServiceDAO implements FindPrsByDealIdServiceDAO{

	@Override
	public List<Pr> findPrsByDealId(int dealId) {
		PrDAO prDAO = getPrDAO();
		return prDAO.findPrsByDealId(dealId);
	}

}
