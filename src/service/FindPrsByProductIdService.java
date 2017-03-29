package service;

import java.util.List;

import dao.PrDAO;
import domain.Pr;
import service.dao.BasePrServiceDAO;
import service.dao.FindPrsByProductIdServiceDAO;

public class FindPrsByProductIdService extends BasePrServiceDAO implements FindPrsByProductIdServiceDAO{

	@Override
	public List<Pr> findPrsByProductId(int productId) {
		PrDAO prDAO = getPrDAO();
		return prDAO.findPrsByProductId(productId);
	}

}
