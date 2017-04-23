package action;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.json.annotations.JSON;

import service.dao.FindUserByIdServiceDAO;

import com.opensymphony.xwork2.ActionSupport;

public class FindUserByIdAction extends ActionSupport{
	
	private static final long serialVersionUID = 1L;
    private Map<String,Object> dataMap;  
    private String key = "Just see see";
    
    private int id;
    private FindUserByIdServiceDAO findUserByIdServiceDAO;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public FindUserByIdServiceDAO getFindUserByIdServiceDAO() {
		return findUserByIdServiceDAO;
	}
	public void setFindUserByIdServiceDAO(
			FindUserByIdServiceDAO findUserByIdServiceDAO) {
		this.findUserByIdServiceDAO = findUserByIdServiceDAO;
	}
	@Override
	public String execute() throws Exception{ 
		dataMap = new HashMap<String, Object>();
		dataMap.put("user", findUserByIdServiceDAO.findUserById(id));
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
