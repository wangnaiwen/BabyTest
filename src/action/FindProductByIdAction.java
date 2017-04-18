package action;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.json.annotations.JSON;

import service.dao.FindProductByIdServiceDAO;

import com.opensymphony.xwork2.ActionSupport;

public class FindProductByIdAction extends ActionSupport{
	/**
	 *  creator:Wnw
	 *  time:2016/12/2
	 */
	
    private Map<String,Object> dataMap;  
    private String key = "Just see see";
	private static final long serialVersionUID = 1L;
	private int id;
	private FindProductByIdServiceDAO findProductByIdServiceDAO;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public FindProductByIdServiceDAO getFindProductByIdServiceDAO() {
		return findProductByIdServiceDAO;
	}
	public void setFindProductByIdServiceDAO(
			FindProductByIdServiceDAO findProductByIdServiceDAO) {
		this.findProductByIdServiceDAO = findProductByIdServiceDAO;
	}
	
	@Override
	public String execute() throws Exception{
		dataMap = new HashMap<String, Object>();  
		dataMap.put("findProductById", findProductByIdServiceDAO.findProductById(id));
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
