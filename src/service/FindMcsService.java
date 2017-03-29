package service;

import java.util.List;

import dao.McDAO;
import domain.Mc;
import service.dao.BaseMcServiceDAO;
import service.dao.FindMcsServiceDAO;

public class FindMcsService extends BaseMcServiceDAO implements FindMcsServiceDAO{

	@Override
	public List<Mc> findMcs() {
		McDAO mcDAO = getMcDAO();
		return mcDAO.findMcs();
	}

}
