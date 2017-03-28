package service.dao;

import domain.User;

public interface FindUserServiceDAO {
	User findUserByPhone(String phone);
}
