package action;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.json.annotations.JSON;

import service.dao.FindScByMcIdServiceDAO;

import com.opensymphony.xwork2.ActionSupport;

public class FindScByMcIdAction extends ActionSupport{

    private Map<String,Object> dataMap;  
    private String key = "Just see see";
	private static final long serialVersionUID = 1L;
	private int mcId;
	private FindScByMcIdServiceDAO findScByMcIdServiceDAO;
	
	public int getMcId() {
		return mcId;
	}
	public void setMcId(int mcId) {
		this.mcId = mcId;
	}
	public FindScByMcIdServiceDAO getFindScByMcIdServiceDAO() {
		return findScByMcIdServiceDAO;
	}
	public void setFindScByMcIdServiceDAO(
			FindScByMcIdServiceDAO findScByMcIdServiceDAO) {
		this.findScByMcIdServiceDAO = findScByMcIdServiceDAO;
	}
	@Override
	public String execute() throws Exception{
		dataMap = new HashMap<String, Object>();  
		dataMap.put("findScByMcId",findScByMcIdServiceDAO.findScsByMcId(mcId));
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
