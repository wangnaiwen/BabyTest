package service;

import service.dao.BaseUserInfoServiceDAO;
import service.dao.InsertUserInfoServiceDAO;
import dao.UserInfoDAO;
import domain.UserInfo;

public class InsertUserInfoService extends BaseUserInfoServiceDAO implements InsertUserInfoServiceDAO{

	@Override
	public boolean insertUserInfo(UserInfo userInfo) {
		UserInfoDAO userInfoDAO = getUserInfoDAO();
		return userInfoDAO.insertUserInfo(userInfo);
	}

}
