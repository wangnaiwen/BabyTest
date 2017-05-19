package dao;

import domain.UserInfo;

/**
 * Creator:WNW
 * Time:2016.11.29
 * */
public interface UserInfoDAO {
	boolean insertUserInfo(UserInfo userInfo);
	boolean updateUserInfo(UserInfo userInfo);
	boolean deleteUserInfo(UserInfo userInfo);
	UserInfo findUserInfoById(int id);
	UserInfo findUserInfoByUserId(int userId);
	boolean updateUserImg(int userId,String image);
}
