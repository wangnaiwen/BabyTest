package action;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.json.annotations.JSON;

import service.dao.FindIncomeByInviteeServiceDAO;

import com.opensymphony.xwork2.ActionSupport;

public class FindIncomeByInviteeAction extends ActionSupport{

	/**
	 * 
	 */
    private Map<String,Object> dataMap;  
    private String key = "Just see see";
	private static final long serialVersionUID = 1L;
	private int invitee;
	private FindIncomeByInviteeServiceDAO findIncomeByInviteeServiceDAO;
	
	public int getInvitee() {
		return invitee;
	}
	public void setInvitee(int invitee) {
		this.invitee = invitee;
	}
	
	public FindIncomeByInviteeServiceDAO getFindIncomeByInviteeServiceDAO() {
		return findIncomeByInviteeServiceDAO;
	}
	public void setFindIncomeByInviteeServiceDAO(
			FindIncomeByInviteeServiceDAO findIncomeByInviteeServiceDAO) {
		this.findIncomeByInviteeServiceDAO = findIncomeByInviteeServiceDAO;
	}
	@Override
	public String execute() throws Exception{
		dataMap = new HashMap<String, Object>(); 
		dataMap.put("findIncomeByInvitee", findIncomeByInviteeServiceDAO.findIncomeByInvitee(invitee));
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
