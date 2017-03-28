package service;

import service.dao.BaseUserServiceDAO;
import service.dao.UpdateUserTypeServiceDAO;
import dao.UserDAO;

public class UpdateUserTypeService extends BaseUserServiceDAO implements UpdateUserTypeServiceDAO{

	@Override
	public boolean updateUserType(String phone, int type) {
		UserDAO userDAO = getUserDAO();
		return userDAO.updateUserType(phone, type);
	}

}
