package action;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.json.annotations.JSON;

import com.opensymphony.xwork2.ActionSupport;

import service.dao.InsertUserInfoServiceDAO;
import domain.UserInfo;

public class InsertUserInfoAction extends ActionSupport{
	/**
	 * creator:WNW
	 * time:2016.12.02
	 */
	private static final long serialVersionUID = 1L;
	
	
    private Map<String,Object> dataMap;  
    private String key = "Just see see";
    
    private InsertUserInfoServiceDAO insertUserInfoServiceDAO;
    private int userId;
    private String sex;
    private String userImg;
	private String nickName;
	private String birthday;
	private String email;
	private String hobby;
	private String personalizedSignature;
	
	public InsertUserInfoServiceDAO getInsertUserInfoServiceDAO() {
		return insertUserInfoServiceDAO;
	}
	public void setInsertUserInfoServiceDAO(
			InsertUserInfoServiceDAO insertUserInfoServiceDAO) {
		this.insertUserInfoServiceDAO = insertUserInfoServiceDAO;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getUserImg() {
		return userImg;
	}
	public void setUserImg(String userImg) {
		this.userImg = userImg;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	public String getPersonalizedSignature() {
		return personalizedSignature;
	}
	public void setPersonalizedSignature(String personalizedSignature) {
		this.personalizedSignature = personalizedSignature;
	}
	@Override
	public String execute() throws Exception{
		
		UserInfo u = new UserInfo();
		u.setUserId(userId);
		u.setSex(sex);
		u.setNickName(nickName);
		u.setBirthday(birthday);
		u.setEmail(email);
		u.setUserImg(userImg);
		u.setHobby(hobby);
		u.setPersonalizedSignature(personalizedSignature);
		dataMap = new HashMap<String, Object>();  
		
		dataMap.put("insertUserInfo", insertUserInfoServiceDAO.insertUserInfo(u));
		return "success";
	}
	public Map<String, Object> getDataMap() {  
        return dataMap;  
	}
	    
	//设置key属性不作为json的内容返回  
    @JSON(serialize=false)  
    public String getKey() {  
        return key;  
    }  
}
