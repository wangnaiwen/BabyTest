package action;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.json.annotations.JSON;

import service.dao.FindSentOrderServiceDAO;

import com.opensymphony.xwork2.ActionSupport;


public class FindBeSentOrderAction extends ActionSupport{
	
	private Map<String,Object> dataMap;  
	private String key = "Just see see";
	private static final long serialVersionUID = 1L;
	
	private int page;
	private FindSentOrderServiceDAO findSentOrderServiceDAO;

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public FindSentOrderServiceDAO getFindSentOrderServiceDAO() {
		return findSentOrderServiceDAO;
	}

	public void setFindSentOrderServiceDAO(
			FindSentOrderServiceDAO findSentOrderServiceDAO) {
		this.findSentOrderServiceDAO = findSentOrderServiceDAO;
	}

	@Override
	public String execute() throws Exception {
		dataMap = new HashMap<String, Object>();  
   		dataMap.put("findBeSentOrders", findSentOrderServiceDAO.findbeSentOrders(page));
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
