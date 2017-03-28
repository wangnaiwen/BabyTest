package action;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.json.annotations.JSON;

import com.opensymphony.xwork2.ActionSupport;

import service.dao.FindFinalReceAddressByUserIdServiceDAO;
import service.dao.InsertReceAddressServiceDAO;
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
    private FindFinalReceAddressByUserIdServiceDAO finalReceAddressByUserIdServiceDAO;
    private int userId;
    private String receiver;
    private String province;
    private String city;
    private String county;
    private String detailAddress;
    private String phone;
    private int postcode; 
	
	public FindFinalReceAddressByUserIdServiceDAO getFinalReceAddressByUserIdServiceDAO() {
		return finalReceAddressByUserIdServiceDAO;
	}
	public void setFinalReceAddressByUserIdServiceDAO(
			FindFinalReceAddressByUserIdServiceDAO finalReceAddressByUserIdServiceDAO) {
		this.finalReceAddressByUserIdServiceDAO = finalReceAddressByUserIdServiceDAO;
	}
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

	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getCounty() {
		return county;
	}
	public void setCounty(String county) {
		this.county = county;
	}
	public String getDetailAddress() {
		return detailAddress;
	}
	public void setDetailAddress(String detailAddress) {
		this.detailAddress = detailAddress;
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
		receAddress.setProvince(province);
		receAddress.setCity(city);
		receAddress.setCounty(county);
		receAddress.setDetailAddress(detailAddress);
		receAddress.setPhone(phone);
		receAddress.setPostcode(postcode);
		dataMap = new HashMap<String, Object>();  
		boolean isSuccess = insertReceAddressServiceDAO.insertReceAddress(receAddress);
		if(isSuccess){
			dataMap.put("insertReceAdd", finalReceAddressByUserIdServiceDAO.findFinalReceAddressByUserId(userId));
		}else {
			dataMap.put("insertReceAdd", null);
		}
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
