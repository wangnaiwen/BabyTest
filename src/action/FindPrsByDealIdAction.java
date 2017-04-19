package action;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.json.annotations.JSON;

import service.dao.FindPrsByDealIdServiceDAO;

import com.opensymphony.xwork2.ActionSupport;

public class FindPrsByDealIdAction extends ActionSupport{
	
    private Map<String,Object> dataMap;  
    private String key = "Just see see";
	private static final long serialVersionUID = 1L;
	private FindPrsByDealIdServiceDAO findPrsByDealIdServiceDAO;
	private int dealId;          
	
	public FindPrsByDealIdServiceDAO getFindPrsByDealIdServiceDAO() {
		return findPrsByDealIdServiceDAO;
	}
	public void setFindPrsByDealIdServiceDAO(
			FindPrsByDealIdServiceDAO findPrsByDealIdServiceDAO) {
		this.findPrsByDealIdServiceDAO = findPrsByDealIdServiceDAO;
	}
	public int getDealId() {
		return dealId;
	}
	public void setDealId(int dealId) {
		this.dealId = dealId;
	}
	@Override
	public String execute() throws Exception{
		dataMap = new HashMap<String, Object>();  
		dataMap.put("findPrByDeal",findPrsByDealIdServiceDAO.findPrsByDealId(dealId));
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
