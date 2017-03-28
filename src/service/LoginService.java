package service;

import service.dao.BaseUserServiceDAO;
import service.dao.LoginServiceDAO;
import dao.UserDAO;
import domain.User;

public class LoginService extends BaseUserServiceDAO implements LoginServiceDAO{

	@Override
	public User login(User user) {
		UserDAO userDAO = getUserDAO();
		return userDAO.validateUser(user);
	}
	
}
