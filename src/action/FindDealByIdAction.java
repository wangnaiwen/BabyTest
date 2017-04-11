package action;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.json.annotations.JSON;

import service.dao.FindDealByIdServiceDAO;

import com.opensymphony.xwork2.ActionSupport;


public class FindDealByIdAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    private Map<String,Object> dataMap;  
    private String key = "Just see see";
    private int id;
    private FindDealByIdServiceDAO findDealByIdServiceDAO;
    
    public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public FindDealByIdServiceDAO getFindDealByIdServiceDAO() {
		return findDealByIdServiceDAO;
	}
	public void setFindDealByIdServiceDAO(
			FindDealByIdServiceDAO findDealByIdServiceDAO) {
		this.findDealByIdServiceDAO = findDealByIdServiceDAO;
	}
	@Override
	public String execute() throws Exception{
		dataMap = new HashMap<String, Object>(); 
		dataMap.put("findDealById", findDealByIdServiceDAO.findDealById(id));
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
