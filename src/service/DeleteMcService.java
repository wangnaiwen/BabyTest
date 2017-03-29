package service;

import dao.McDAO;
import service.dao.BaseMcServiceDAO;
import service.dao.DeleteMcServiceDAO;

public class DeleteMcService extends BaseMcServiceDAO implements DeleteMcServiceDAO{

	@Override
	public boolean deleteMc(int id) {
		McDAO mcDAO = getMcDAO();
		return mcDAO.deleteMc(id);
	}

}
