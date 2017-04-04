package action;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.json.annotations.JSON;

import service.dao.InsertPrServiceDAO;

import com.opensymphony.xwork2.ActionSupport;

import domain.Pr;

public class InsertPrAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    private Map<String,Object> dataMap;  
    private String key = "Just see see";
	private InsertPrServiceDAO insertPrServiceDAO;
	private int dealId;
	private int userId;
	private String userNickName;
	private int productId;
	private int serviceScore;
	private int logisticsScore;
	private int productScore;
	private String evaluation;
	private String time;
	public InsertPrServiceDAO getInsertPrServiceDAO() {
		return insertPrServiceDAO;
	}
	public void setInsertPrServiceDAO(InsertPrServiceDAO insertPrServiceDAO) {
		this.insertPrServiceDAO = insertPrServiceDAO;
	}
	public int getDealId() {
		return dealId;
	}
	public void setDealId(int dealId) {
		this.dealId = dealId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserNickName() {
		return userNickName;
	}
	public void setUserNickName(String userNickName) {
		this.userNickName = userNickName;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getServiceScore() {
		return serviceScore;
	}
	public void setServiceScore(int serviceScore) {
		this.serviceScore = serviceScore;
	}
	public int getLogisticsScore() {
		return logisticsScore;
	}
	public void setLogisticsScore(int logisticsScore) {
		this.logisticsScore = logisticsScore;
	}
	public int getProductScore() {
		return productScore;
	}
	public void setProductScore(int productScore) {
		this.productScore = productScore;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getEvaluation() {
		return evaluation;
	}
	public void setEvaluation(String evaluation) {
		this.evaluation = evaluation;
	}
	@Override
	public String execute() throws Exception{
		
		Pr pr = new Pr();
		pr.setDealId(dealId);
		pr.setUserId(userId);
		pr.setUserNickName(userNickName);
		pr.setProductId(productId);
		pr.setProductScore(productScore);
		pr.setServiceScore(serviceScore);
		pr.setLogisticsScore(logisticsScore);
		pr.setEvalution(evaluation);
		pr.setTime(time);
		
		dataMap = new HashMap<String, Object>();  
		dataMap.put("insertPr", insertPrServiceDAO.insertPr(pr));
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
