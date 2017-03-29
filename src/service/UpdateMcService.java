package service;

import dao.McDAO;
import domain.Mc;
import service.dao.BaseMcServiceDAO;
import service.dao.UpdateMcServiceDAO;

public class UpdateMcService extends BaseMcServiceDAO implements UpdateMcServiceDAO{

	@Override
	public boolean updateMc(Mc mc) {
		McDAO mcDAO = getMcDAO();
		return mcDAO.updateMc(mc);
	}

}
