package action;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.json.annotations.JSON;
import service.dao.FindProductByScIdServiceDAO;

import com.opensymphony.xwork2.ActionSupport;

public class FindProductByScIdAction extends ActionSupport{
	/**
	 *  creator:Wnw
	 *  time:2016/12/2
	 */
	
    private Map<String,Object> dataMap;  
    private String key = "Just see see";
	private static final long serialVersionUID = 1L;
	private int scId;
	private int number;
	private FindProductByScIdServiceDAO findProductByScIdServiceDAO;
	
	public int getScId() {
		return scId;
	}
	public void setScId(int scId) {
		this.scId = scId;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public FindProductByScIdServiceDAO getFindProductByScIdServiceDAO() {
		return findProductByScIdServiceDAO;
	}
	public void setFindProductByScIdServiceDAO(
			FindProductByScIdServiceDAO findProductByScIdServiceDAO) {
		this.findProductByScIdServiceDAO = findProductByScIdServiceDAO;
	}
	@Override
	public String execute() throws Exception{
		dataMap = new HashMap<String, Object>();  
		dataMap.put("findProductByscId", findProductByScIdServiceDAO.findProductByScId(scId, number));
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
