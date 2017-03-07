package service;

import dao.UserDAO;

public class UpdateUserPasswordService extends BaseUserServiceDAO implements UpdateUserPasswordServiceDAO{

	@Override
	public boolean updateUserPassword(String phone, String password) {
		UserDAO userDAO = getUserDAO();
		
		return userDAO.updateUserPassword(phone, password);
	}
	
}
