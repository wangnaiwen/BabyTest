package domain;

public class Pr {
	private int id;
	private int dealId;
	private int userId;
	private int productId;
	private int serviceScore;
	private int logisticsScore;
	private int productScore;
	private String evalution;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getDealId() {
		return dealId;
	}
	public void setDealId(int dealId) {
		this.dealId = dealId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
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
	public String getEvalution() {
		return evalution;
	}
	public void setEvalution(String evalution) {
		this.evalution = evalution;
	}
	
}
