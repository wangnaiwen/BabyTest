package action;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.json.annotations.JSON;
import service.dao.FindProductByKeyServiceDAO;
import com.opensymphony.xwork2.ActionSupport;

public class FindProductByKeywordAction extends ActionSupport{
	/**
	 *  creator:Wnw
	 *  time:2016/12/2
	 */
	
    private Map<String,Object> dataMap;  
    private String key = "Just see see";
	private static final long serialVersionUID = 1L;
	private String keyWord;
	private FindProductByKeyServiceDAO findProductByKeyServiceDAO;
	
	public String getKeyWord() {
		return keyWord;
	}
	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}
	public FindProductByKeyServiceDAO getFindProductByKeyServiceDAO() {
		return findProductByKeyServiceDAO;
	}
	public void setFindProductByKeyServiceDAO(
			FindProductByKeyServiceDAO findProductByKeyServiceDAO) {
		this.findProductByKeyServiceDAO = findProductByKeyServiceDAO;
	}
	
	@Override
	public String execute() throws Exception{
		dataMap = new HashMap<String, Object>();  
		dataMap.put("findProductByKeyword", findProductByKeyServiceDAO.findProductByKey(keyWord));
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
