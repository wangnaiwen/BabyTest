package action;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.json.annotations.JSON;

import com.opensymphony.xwork2.ActionSupport;

import service.FindReceAddressServiceDAO;

public class FindReceAddressAction extends ActionSupport{
	/**
	 *  creator:Wnw
	 *  time:2016/12/2
	 */
	
    private Map<String,Object> dataMap;  
    private String key = "Just see see";
    
	private static final long serialVersionUID = 1L;
	
	private int id;
	private FindReceAddressServiceDAO findReceAddressServiceDAO;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public FindReceAddressServiceDAO getFindReceAddressServiceDAO() {
		return findReceAddressServiceDAO;
	}
	public void setFindReceAddressServiceDAO(
			FindReceAddressServiceDAO findReceAddressServiceDAO) {
		this.findReceAddressServiceDAO = findReceAddressServiceDAO;
	}
	
	@Override
	public String execute() throws Exception{
			
		dataMap = new HashMap<String, Object>();  
		dataMap.put("findReceAdd", findReceAddressServiceDAO.findReceAddressById(id));
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
