package service;

import dao.PrDAO;
import service.dao.BasePrServiceDAO;
import service.dao.DeletePrServiceDAO;

public class DeletePrService extends BasePrServiceDAO implements DeletePrServiceDAO{

	@Override
	public boolean deletePr(int id) {
		PrDAO prDAO = getPrDAO();
		return prDAO.deletePr(id);
	}

}
