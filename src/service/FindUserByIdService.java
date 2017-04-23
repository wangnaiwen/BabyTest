package service;

import dao.UserDAO;
import domain.User;
import service.dao.BaseUserServiceDAO;
import service.dao.FindUserByIdServiceDAO;

public class FindUserByIdService extends BaseUserServiceDAO implements FindUserByIdServiceDAO{

	@Override
	public User findUserById(int id) {
		UserDAO userDAO = getUserDAO();
		return userDAO.findUserById(id);
	}
}
