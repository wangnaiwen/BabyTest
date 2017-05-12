package action;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.json.annotations.JSON;

import service.dao.FindAllArticleServiceDAO;

import com.opensymphony.xwork2.ActionSupport;

public class FindAllArticlesAction extends ActionSupport{
    private Map<String,Object> dataMap;  
    private String key = "Just see see";
	private static final long serialVersionUID = 1L;
	private FindAllArticleServiceDAO findAllArticleServiceDAO;
	private int page;
	
	
	public FindAllArticleServiceDAO getFindAllArticleServiceDAO() {
		return findAllArticleServiceDAO;
	}
	public void setFindAllArticleServiceDAO(
			FindAllArticleServiceDAO findAllArticleServiceDAO) {
		this.findAllArticleServiceDAO = findAllArticleServiceDAO;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	@Override
	public String execute() throws Exception{
		dataMap = new HashMap<String, Object>(); 
		dataMap.put("findAllArticle", findAllArticleServiceDAO.findAllArticles(page));
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

