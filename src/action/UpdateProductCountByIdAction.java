package action;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.json.annotations.JSON;
import service.dao.UpdateProductCountByIdServiceDAO;
import com.opensymphony.xwork2.ActionSupport;

public class UpdateProductCountByIdAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    private Map<String,Object> dataMap;  
    private String key = "Just see see";
    private int id;
    private int count;
    private UpdateProductCountByIdServiceDAO updateProductCountByIdServiceDAO;
    
    public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public UpdateProductCountByIdServiceDAO getUpdateProductCountByIdServiceDAO() {
		return updateProductCountByIdServiceDAO;
	}
	public void setUpdateProductCountByIdServiceDAO(
			UpdateProductCountByIdServiceDAO updateProductCountByIdServiceDAO) {
		this.updateProductCountByIdServiceDAO = updateProductCountByIdServiceDAO;
	}
	public Map<String, Object> getDataMap() {  
        return dataMap;  
	}
	//设置key属性不作为json的内容返回  
    @JSON(serialize=false)  
    public String getKey() {  
        return key;  
    }  
	@Override
	public String execute() throws Exception {
		dataMap = new HashMap<String, Object>();  
   		dataMap.put("updateProductCount", updateProductCountByIdServiceDAO.updateProductCountById(id, count));
   		return "success";
	}
}
