package action;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.json.annotations.JSON;

import service.dao.FindScByIdServiceDAO;

import com.opensymphony.xwork2.ActionSupport;

public class FindScByIdAction extends ActionSupport{

	/**
	 * 
	 */
    private Map<String,Object> dataMap;  
    private String key = "Just see see";
	private static final long serialVersionUID = 1L;
	private int id;
	private FindScByIdServiceDAO findScByIdServiceDAO;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public FindScByIdServiceDAO getFindScByIdServiceDAO() {
		return findScByIdServiceDAO;
	}
	public void setFindScByIdServiceDAO(FindScByIdServiceDAO findScByIdServiceDAO) {
		this.findScByIdServiceDAO = findScByIdServiceDAO;
	}
	@Override
	public String execute() throws Exception{
		dataMap = new HashMap<String, Object>();  
		dataMap.put("findScById", findScByIdServiceDAO.findScById(id));
		return "success";
	}
	public Map<String, Object> getDataMap() {  
        return dataMap;  
	}
	    
	//����key���Բ���Ϊjson�����ݷ���  
    @JSON(serialize=false)  
    public String getKey() {  
        return key;  
    }  
}
