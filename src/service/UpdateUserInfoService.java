package service;

import dao.UserInfoDAO;
import domain.UserInfo;

public class UpdateUserInfoService extends BaseUserInfoServiceDAO implements UpdateUserInfoServiceDAO{

	@Override
	public boolean updateUserInfo(UserInfo userInfo) {
		UserInfoDAO userInfoDAO = getUserInfoDAO();
		return userInfoDAO.updateUserInfo(userInfo);
	}

}
