package action;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.json.annotations.JSON;

import service.dao.UpdateShopServiceDAO;

import com.opensymphony.xwork2.ActionSupport;

import domain.Shop;

public class UpdateShopAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    private Map<String,Object> dataMap;  
    private String key = "Just see see";
    private UpdateShopServiceDAO updateShopServiceDAO;
    private int id;
    private int userId;
	private String name;
	private String owner;
	private String wechat;
	private long money;
	private String idCard;
	private int reviewType;
	private int invitee;
	
	public UpdateShopServiceDAO getUpdateShopServiceDAO() {
		return updateShopServiceDAO;
	}
	public void setUpdateShopServiceDAO(UpdateShopServiceDAO updateShopServiceDAO) {
		this.updateShopServiceDAO = updateShopServiceDAO;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getWechat() {
		return wechat;
	}
	public void setWechat(String wechat) {
		this.wechat = wechat;
	}
	public long getMoney() {
		return money;
	}
	public void setMoney(long money) {
		this.money = money;
	}
	public String getIdCard() {
		return idCard;
	}
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
	public int getReviewType() {
		return reviewType;
	}
	public void setReviewType(int reviewType) {
		this.reviewType = reviewType;
	}
	
	public int getInvitee() {
		return invitee;
	}
	public void setInvitee(int invitee) {
		this.invitee = invitee;
	}
	@Override
	public String execute() throws Exception{
		Shop shop = new Shop();
		shop.setId(id);
		shop.setUserId(userId);
		shop.setIdCard(idCard);
		shop.setName(name);
		shop.setMoney(money);
		shop.setReviewType(reviewType);
		shop.setOwner(owner);
		shop.setWechat(wechat);
		shop.setInvitee(invitee);
		dataMap = new HashMap<String, Object>();  
		dataMap.put("updateShop", updateShopServiceDAO.updateShop(shop));
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
