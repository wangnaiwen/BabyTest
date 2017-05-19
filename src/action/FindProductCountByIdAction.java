package action;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.json.annotations.JSON;
import service.dao.FindProductCountByIdServiceDAO;
import com.opensymphony.xwork2.ActionSupport;

public class FindProductCountByIdAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    private Map<String,Object> dataMap;  
    private String key = "Just see see";
    private int id;
    private FindProductCountByIdServiceDAO findProductCountByIdServiceDAO;
    
    public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public FindProductCountByIdServiceDAO getFindProductCountByIdServiceDAO() {
		return findProductCountByIdServiceDAO;
	}
	public void setFindProductCountByIdServiceDAO(
			FindProductCountByIdServiceDAO findProductCountByIdServiceDAO) {
		this.findProductCountByIdServiceDAO = findProductCountByIdServiceDAO;
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
	public String execute() throws Exception {
		dataMap = new HashMap<String, Object>();  
   		dataMap.put("findProductCountsById", findProductCountByIdServiceDAO.findProductCountById(id));
   		return "success";
	}
}
