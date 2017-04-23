package action;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.json.annotations.JSON;

import service.dao.FindOrderByInviteeServiceDAO;

import com.opensymphony.xwork2.ActionSupport;

public class FindOrderByInviteeAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    private Map<String,Object> dataMap;  
    private String key = "Just see see";
	private int invitee;
	private int number;
	private FindOrderByInviteeServiceDAO findOrderByInviteeServiceDAO;
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public int getInvitee() {
		return invitee;
	}
	public void setInvitee(int invitee) {
		this.invitee = invitee;
	}
	public FindOrderByInviteeServiceDAO getFindOrderByInviteeServiceDAO() {
		return findOrderByInviteeServiceDAO;
	}
	public void setFindOrderByInviteeServiceDAO(
			FindOrderByInviteeServiceDAO findOrderByInviteeServiceDAO) {
		this.findOrderByInviteeServiceDAO = findOrderByInviteeServiceDAO;
	}
	@Override
	public String execute() throws Exception{
		dataMap = new HashMap<String, Object>();  
		dataMap.put("findOrderByInvitee", findOrderByInviteeServiceDAO.findOrderByInvitee(invitee, number));
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
