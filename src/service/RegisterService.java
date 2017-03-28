package service;

import service.dao.BaseUserServiceDAO;
import service.dao.RegisterServiceDAO;
import dao.UserDAO;
import domain.User;

public class RegisterService extends BaseUserServiceDAO implements RegisterServiceDAO{

	@Override
	public boolean register(User user) {
		UserDAO userDAO = getUserDAO();
		return userDAO.insertUser(user);
	}
	
}
