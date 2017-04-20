package action;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.json.annotations.JSON;

import service.dao.FindMcsServiceDAO;

import com.opensymphony.xwork2.ActionSupport;

public class FindMcsAction extends ActionSupport{

    private Map<String,Object> dataMap;  
    private String key = "Just see see";
	private static final long serialVersionUID = 1L;
	private FindMcsServiceDAO findMcsServiceDAO;
	
	public FindMcsServiceDAO getFindMcsServiceDAO() {
		return findMcsServiceDAO;
	}
	public void setFindMcsServiceDAO(FindMcsServiceDAO findMcsServiceDAO) {
		this.findMcsServiceDAO = findMcsServiceDAO;
	}
	@Override
	public String execute() throws Exception{
		dataMap = new HashMap<String, Object>();  
		dataMap.put("findMcs", findMcsServiceDAO.findMcs());
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
