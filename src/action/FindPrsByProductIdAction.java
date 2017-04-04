package action;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.json.annotations.JSON;

import service.dao.FindPrsByProductIdServiceDAO;

import com.opensymphony.xwork2.ActionSupport;

public class FindPrsByProductIdAction extends ActionSupport{
	
	/**
	 * 
	 */
    private Map<String,Object> dataMap;  
    private String key = "Just see see";
	private static final long serialVersionUID = 1L;
	private FindPrsByProductIdServiceDAO findPrsByProductIdServiceDAO;
	private int productId;          
	private int number;    //���number��¼�˵ڼ��β�ѯ��һ�β�ѯ20������
	
	public FindPrsByProductIdServiceDAO getFindPrsByProductIdServiceDAO() {
		return findPrsByProductIdServiceDAO;
	}
	public void setFindPrsByProductIdServiceDAO(
			FindPrsByProductIdServiceDAO findPrsByProductIdServiceDAO) {
		this.findPrsByProductIdServiceDAO = findPrsByProductIdServiceDAO;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	@Override
	public String execute() throws Exception{
		
		dataMap = new HashMap<String, Object>();  
		
		dataMap.put("findPrByProductId", findPrsByProductIdServiceDAO.findPrsByProductId(productId, number));
		return "success";
	}
	public Map<String, Object> getDataMap() {  
        return dataMap;  
	}
	    
	//����key���Բ���Ϊjson�����ݷ���  
    @JSON(serialize=false)  
    public String getKey() {  
        return key;  
    }  
}
