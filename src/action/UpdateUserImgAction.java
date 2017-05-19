package action;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.json.annotations.JSON;
import service.dao.UpdateUserImgServiceDAO;
import com.opensymphony.xwork2.ActionSupport;

public class UpdateUserImgAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    private Map<String,Object> dataMap;  
    private String key = "Just see see";
	
    private int userId;
    private String image;
    private UpdateUserImgServiceDAO updateUserImgServiceDAO;
    
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public UpdateUserImgServiceDAO getUpdateUserImgServiceDAO() {
		return updateUserImgServiceDAO;
	}
	public void setUpdateUserImgServiceDAO(
			UpdateUserImgServiceDAO updateUserImgServiceDAO) {
		this.updateUserImgServiceDAO = updateUserImgServiceDAO;
	}
	@Override
	public String execute() throws Exception{
		dataMap = new HashMap<String, Object>();  
		dataMap.put("updateUserImg", updateUserImgServiceDAO.updateUserImg(userId, image));
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