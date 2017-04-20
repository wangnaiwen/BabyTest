package action;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.json.annotations.JSON;

import service.dao.FindMcByIdServiceDAO;

import com.opensymphony.xwork2.ActionSupport;

public class FindMcByIdAction extends ActionSupport{

    private Map<String,Object> dataMap;  
    private String key = "Just see see";
	private static final long serialVersionUID = 1L;
	private int id;
	private FindMcByIdServiceDAO findMcByIdServiceDAO;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public FindMcByIdServiceDAO getFindMcByIdServiceDAO() {
		return findMcByIdServiceDAO;
	}
	public void setFindMcByIdServiceDAO(FindMcByIdServiceDAO findMcByIdServiceDAO) {
		this.findMcByIdServiceDAO = findMcByIdServiceDAO;
	}
	@Override
	public String execute() throws Exception{
		
		dataMap = new HashMap<String, Object>();  
		dataMap.put("findMcById", findMcByIdServiceDAO.findMcById(id));
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
