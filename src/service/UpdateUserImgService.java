package service;

import dao.UserInfoDAO;
import service.dao.BaseUserInfoServiceDAO;
import service.dao.UpdateUserImgServiceDAO;

public class UpdateUserImgService extends BaseUserInfoServiceDAO implements UpdateUserImgServiceDAO{

	@Override
	public boolean updateUserImg(int userId, String image) {
		UserInfoDAO userInfoDAO = getUserInfoDAO();
		return userInfoDAO.updateUserImg(userId, image);
	}

}
