package action;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.json.annotations.JSON;

import com.opensymphony.xwork2.ActionSupport;

import service.InsertReceAddressServiceDAO;
import domain.ReceAddress;

public class InsertReceAddressAction extends ActionSupport{
	
	/**
	 * creator:WNW
	 * time:2016.11.29
	 */
	
	private static final long serialVersionUID = 1L;
	
    private Map<String,Object> dataMap;  
    private String key = "Just see see";
    
    private InsertReceAddressServiceDAO insertReceAddressServiceDAO;
    private int userId;
    private String receiver;
    private String address;
    private String phone;
    private int postcode; 
	
	public InsertReceAddressServiceDAO getInsertReceAddressServiceDAO() {
		return insertReceAddressServiceDAO;
	}
	public void setInsertReceAddressServiceDAO(
			InsertReceAddressServiceDAO insertReceAddressServiceDAO) {
		this.insertReceAddressServiceDAO = insertReceAddressServiceDAO;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getReceiver() {
		return receiver;
	}
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getPostcode() {
		return postcode;
	}
	public void setPostcode(int postcode) {
		this.postcode = postcode;
	}
	@Override
	public String execute() throws Exception{
		
		ReceAddress receAddress = new ReceAddress();
		receAddress.setUserId(userId);
		receAddress.setReceiver(receiver);
		receAddress.setAddress(address);
		receAddress.setPhone(phone);
		receAddress.setPostcode(postcode);
		dataMap = new HashMap<String, Object>();  
		dataMap.put("insertReceAdd", insertReceAddressServiceDAO.insertReceAddress(receAddress));
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
