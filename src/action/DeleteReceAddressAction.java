package action;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.json.annotations.JSON;

import service.dao.DeleteReceAddressServiceDAO;
import service.dao.FindReceAddressServiceDAO;

import com.opensymphony.xwork2.ActionSupport;

import domain.ReceAddress;

public class DeleteReceAddressAction extends ActionSupport{

	/**
	 *  creator:Wnw
	 *  time:2016/12/2
	 */
	
    private Map<String,Object> dataMap;  
    private String key = "Just see see";
    
	private static final long serialVersionUID = 1L;
	
	private int id;
	private FindReceAddressServiceDAO findReceAddressServiceDAO;
	private DeleteReceAddressServiceDAO deleteReceAddressServiceDAO;
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
	public DeleteReceAddressServiceDAO getDeleteReceAddressServiceDAO() {
		return deleteReceAddressServiceDAO;
	}
	public void setDeleteReceAddressServiceDAO(
			DeleteReceAddressServiceDAO deleteReceAddressServiceDAO) {
		this.deleteReceAddressServiceDAO = deleteReceAddressServiceDAO;
	}
	
	@Override
	public String execute() throws Exception{
		
		ReceAddress receAddress = findReceAddressServiceDAO.findReceAddressById(id);
	
		dataMap = new HashMap<String, Object>();  
		if(receAddress != null){
			dataMap.put("deleteReceAdd", deleteReceAddressServiceDAO.deleteReceAddress(receAddress));
			return "success";
		}
		dataMap.put("deleteReceAdd", false);
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
