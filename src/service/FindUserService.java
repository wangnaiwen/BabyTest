package service;

import service.dao.BaseUserServiceDAO;
import service.dao.FindUserServiceDAO;
import dao.UserDAO;
import domain.User;

public class FindUserService extends BaseUserServiceDAO implements FindUserServiceDAO{

	@Override
	public User findUserByPhone(String phone) {
		UserDAO userDAO = getUserDAO();
		return userDAO.findUserByPhone(phone);
	}
	
}
