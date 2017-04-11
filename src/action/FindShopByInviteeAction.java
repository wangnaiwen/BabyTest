package action;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.json.annotations.JSON;

import service.dao.FindShopByInviteeServiceDAO;

import com.opensymphony.xwork2.ActionSupport;

public class FindShopByInviteeAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    private Map<String,Object> dataMap;  
    private String key = "Just see see";
    private int invitee;
    private FindShopByInviteeServiceDAO findShopByInviteeServiceDAO;
    
	public int getInvitee() {
		return invitee;
	}
	public void setInvitee(int invitee) {
		this.invitee = invitee;
	}
	public FindShopByInviteeServiceDAO getFindShopByInviteeServiceDAO() {
		return findShopByInviteeServiceDAO;
	}
	public void setFindShopByInviteeServiceDAO(
			FindShopByInviteeServiceDAO findShopByInviteeServiceDAO) {
		this.findShopByInviteeServiceDAO = findShopByInviteeServiceDAO;
	}
	@Override
	public String execute() throws Exception{
	
		dataMap = new HashMap<String, Object>();  
		dataMap.put("findShopByInvitee", findShopByInviteeServiceDAO.findShopByInvitee(invitee));
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

