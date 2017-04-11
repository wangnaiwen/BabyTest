package action;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.json.annotations.JSON;

import service.dao.FindOrderByIdServiceDAO;

import com.opensymphony.xwork2.ActionSupport;

public class FindOrderByIdAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    private Map<String,Object> dataMap;  
    private String key = "Just see see";
	private int id;
	private FindOrderByIdServiceDAO findOrderByIdServiceDAO;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public FindOrderByIdServiceDAO getFindOrderByIdServiceDAO() {
		return findOrderByIdServiceDAO;
	}
	public void setFindOrderByIdServiceDAO(
			FindOrderByIdServiceDAO findOrderByIdServiceDAO) {
		this.findOrderByIdServiceDAO = findOrderByIdServiceDAO;
	}
	
	@Override
	public String execute() throws Exception{
		dataMap = new HashMap<String, Object>();  
		dataMap.put("findOrderById", findOrderByIdServiceDAO.findOrderById(id));
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
