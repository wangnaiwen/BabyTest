package service;

import dao.PrDAO;
import domain.Pr;
import service.dao.BasePrServiceDAO;
import service.dao.InsertPrServiceDAO;

public class InsertPrService extends BasePrServiceDAO implements InsertPrServiceDAO{

	@Override
	public boolean insertPr(Pr pr) {
		PrDAO prDAO = getPrDAO();
		return prDAO.insertPr(pr);
	}

}
