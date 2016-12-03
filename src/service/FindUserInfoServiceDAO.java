package service;

import domain.UserInfo;

public interface FindUserInfoServiceDAO {
	UserInfo findUserInfoById(int id);
}
