package action;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.json.annotations.JSON;

import com.opensymphony.xwork2.ActionSupport;
import service.dao.FindPrsByUserIdServiceDAO;

public class FindPrsByUserIdAction extends ActionSupport{

	/**
	 * 
	 */
    private Map<String,Object> dataMap;  
    private String key = "Just see see";
	private static final long serialVersionUID = 1L;
	private FindPrsByUserIdServiceDAO findPrsByUserIdServiceDAO;
	private int userId;          
	private int number;    //这个number记录了第几次查询，一次查询20条数据
	
	public FindPrsByUserIdServiceDAO getFindPrsByUserIdServiceDAO() {
		return findPrsByUserIdServiceDAO;
	}
	public void setFindPrsByUserIdServiceDAO(
			FindPrsByUserIdServiceDAO findPrsByUserIdServiceDAO) {
		this.findPrsByUserIdServiceDAO = findPrsByUserIdServiceDAO;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	@Override
	public String execute() throws Exception{
		
		dataMap = new HashMap<String, Object>();  
		
		dataMap.put("findPrByUserId", findPrsByUserIdServiceDAO.findPrsByUserId(userId, number));
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