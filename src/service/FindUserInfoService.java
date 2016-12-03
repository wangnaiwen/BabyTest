package service;

import dao.UserInfoDAO;
import domain.UserInfo;

public class FindUserInfoService extends BaseUserInfoServiceDAO implements FindUserInfoServiceDAO{

	@Override
	public UserInfo findUserInfoById(int id) {
		UserInfoDAO userInfoDAO = getUserInfoDAO();
		return userInfoDAO.findUserInfoById(id);
	}

}
