package service.dao;

import domain.UserInfo;

public interface FindUserInfoByUserIdServiceDAO {
	UserInfo findUserInfoByUserId(int userId);
}
