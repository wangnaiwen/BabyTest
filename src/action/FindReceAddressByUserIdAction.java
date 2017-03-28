package action;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.json.annotations.JSON;

import com.opensymphony.xwork2.ActionSupport;

import service.dao.FindReceAddressByUserIdServiceDAO;

public class FindReceAddressByUserIdAction extends ActionSupport{
	/**
	 *  creator:Wnw
	 *  time:2016/12/2
	 */
	
    private Map<String,Object> dataMap;  
    private String key = "Just see see";
    
	private static final long serialVersionUID = 1L;
	
	private int userId;
	private FindReceAddressByUserIdServiceDAO findReceAddressByUserIdServiceDAO;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public FindReceAddressByUserIdServiceDAO getFindReceAddressByUserIdServiceDAO() {
		return findReceAddressByUserIdServiceDAO;
	}
	public void setFindReceAddressByUserIdServiceDAO(
			FindReceAddressByUserIdServiceDAO findReceAddressByUserIdServiceDAO) {
		this.findReceAddressByUserIdServiceDAO = findReceAddressByUserIdServiceDAO;
	}
	@Override
	public String execute() throws Exception{
			
		dataMap = new HashMap<String, Object>();  
		dataMap.put("findReceAdd", findReceAddressByUserIdServiceDAO.findReceAddressByUserId(userId));
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
