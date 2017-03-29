package service;

import dao.McDAO;
import domain.Mc;
import service.dao.BaseMcServiceDAO;
import service.dao.FindMcByIdServiceDAO;

public class FindMcByIdService extends BaseMcServiceDAO implements FindMcByIdServiceDAO{

	@Override
	public Mc findMcById(int id) {
		McDAO mcDAO = getMcDAO();
		return mcDAO.findMcById(id);
	}

}
