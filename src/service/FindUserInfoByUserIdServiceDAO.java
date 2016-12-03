package service;

import domain.UserInfo;

public interface FindUserInfoByUserIdServiceDAO {
	UserInfo findUserInfoByUserId(int userId);
}
