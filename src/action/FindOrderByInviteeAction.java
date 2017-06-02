package action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.json.annotations.JSON;

import service.dao.FindDealByOrderIdServiceDAO;
import service.dao.FindOrderByInviteeServiceDAO;

import com.opensymphony.xwork2.ActionSupport;

import domain.Order;

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
	private FindDealByOrderIdServiceDAO findDealByOrderIdServiceDAO;
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
	public FindDealByOrderIdServiceDAO getFindDealByOrderIdServiceDAO() {
		return findDealByOrderIdServiceDAO;
	}
	public void setFindDealByOrderIdServiceDAO(
			FindDealByOrderIdServiceDAO findDealByOrderIdServiceDAO) {
		this.findDealByOrderIdServiceDAO = findDealByOrderIdServiceDAO;
	}
	@Override
	public String execute() throws Exception{
		dataMap = new HashMap<String, Object>();  
		List<String> nameList = null;
		List<Order> orders =findOrderByInviteeServiceDAO.findOrderByInvitee(invitee, number);
		dataMap.put("findOrderByInvitee", orders);
		if (orders != null) {
			int length = orders.size();
			nameList = new ArrayList<String>();
			for (int i = 0; i < length; i++) {
				nameList.add(findDealByOrderIdServiceDAO.findDealByOrderId(orders.get(i).getId()).get(0).getProductName());
			}
		}
		dataMap.put("nameList",nameList);
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
