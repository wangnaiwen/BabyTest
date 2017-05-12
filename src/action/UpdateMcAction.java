package action;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.json.annotations.JSON;

import service.dao.UpdateMcServiceDAO;

import com.opensymphony.xwork2.ActionSupport;

import domain.Mc;

public class UpdateMcAction extends ActionSupport{

    private Map<String,Object> dataMap;  
    private String key = "Just see see";
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String name;
	private UpdateMcServiceDAO updateMcServiceDAO;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public UpdateMcServiceDAO getUpdateMcServiceDAO() {
		return updateMcServiceDAO;
	}

	public void setUpdateMcServiceDAO(UpdateMcServiceDAO updateMcServiceDAO) {
		this.updateMcServiceDAO = updateMcServiceDAO;
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
		mc.setId(id);
		mc.setName(name);
		dataMap.put("updateMc",updateMcServiceDAO.updateMc(mc));
		return "success";
	}
}
