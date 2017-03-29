package service;

import dao.McDAO;
import domain.Mc;
import service.dao.BaseMcServiceDAO;
import service.dao.InsertMcServiceDAO;

public class InsertMcService extends BaseMcServiceDAO implements InsertMcServiceDAO{

	@Override
	public boolean insertMc(Mc mc) {
		McDAO mcDAO = getMcDAO();
		return mcDAO.insertMc(mc);
	}

}
