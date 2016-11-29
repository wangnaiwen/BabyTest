package dao;

import domain.User;

public interface UserDAO {
	boolean insertUser(User user);
	boolean updateUser(User user);
	boolean deleteUser(User user);
	User findUserById(int id);
	User findUserByPhone(String phone);
	User validateUser(User user);
}
