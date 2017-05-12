package action;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.json.annotations.JSON;

import service.dao.InsertMcServiceDAO;

import com.opensymphony.xwork2.ActionSupport;

import domain.Mc;

public class InsertMcAction extends ActionSupport{

    private Map<String,Object> dataMap;  
    private String key = "Just see see";
	private static final long serialVersionUID = 1L;

	private String name;
	private InsertMcServiceDAO insertMcServiceDAO;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public InsertMcServiceDAO getInsertMcServiceDAO() {
		return insertMcServiceDAO;
	}

	public void setInsertMcServiceDAO(InsertMcServiceDAO insertMcServiceDAO) {
		this.insertMcServiceDAO = insertMcServiceDAO;
	}

	public Map<String, Object> getDataMap() {  
        return dataMap;  
	}
	    
	//设置key属性不作为json的内容返回  
    @JSON(serialize=false)  
    public String getKey() {  
        return key;  
    }
	@Override
	public String execute() throws Exception{
		dataMap = new HashMap<String, Object>();  
		Mc mc = new Mc();
		mc.setName(name);
		dataMap.put("insertMc",insertMcServiceDAO.insertMc(mc));
		return "success";
	}
}
