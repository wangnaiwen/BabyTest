package service;

import service.dao.BaseUserInfoServiceDAO;
import service.dao.FindUserInfoByUserIdServiceDAO;
import dao.UserInfoDAO;
import domain.UserInfo;

public class FindUserInfoByUserIdService extends BaseUserInfoServiceDAO implements FindUserInfoByUserIdServiceDAO{

	@Override
	public UserInfo findUserInfoByUserId(int userId) {
		UserInfoDAO userInfoDAO = getUserInfoDAO();
		return userInfoDAO.findUserInfoByUserId(userId);
	}

}
