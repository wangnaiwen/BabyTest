package service;

import service.dao.BaseUserInfoServiceDAO;
import service.dao.UpdateUserInfoServiceDAO;
import dao.UserInfoDAO;
import domain.UserInfo;

public class UpdateUserInfoService extends BaseUserInfoServiceDAO implements UpdateUserInfoServiceDAO{

	@Override
	public boolean updateUserInfo(UserInfo userInfo) {
		UserInfoDAO userInfoDAO = getUserInfoDAO();
		return userInfoDAO.updateUserInfo(userInfo);
	}

}
