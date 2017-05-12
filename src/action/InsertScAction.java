package action;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.json.annotations.JSON;

import service.dao.InsertScServiceDAO;

import com.opensymphony.xwork2.ActionSupport;

import domain.Sc;

public class InsertScAction extends ActionSupport{

    private Map<String,Object> dataMap;  
    private String key = "Just see see";
	private static final long serialVersionUID = 1L;
	private String name;
	private int mcId;
	private String image;
	private InsertScServiceDAO insertScServiceDAO;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public int getMcId() {
		return mcId;
	}

	public void setMcId(int mcId) {
		this.mcId = mcId;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public InsertScServiceDAO getInsertScServiceDAO() {
		return insertScServiceDAO;
	}
	public void setInsertScServiceDAO(InsertScServiceDAO insertScServiceDAO) {
		this.insertScServiceDAO = insertScServiceDAO;
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
	public String execute() throws Exception{
		dataMap = new HashMap<String, Object>();  
		Sc sc = new Sc();
		sc.setImage(image);
		sc.setMcId(mcId);
		sc.setName(name);
		dataMap.put("insertSc", insertScServiceDAO.insertSc(sc));
		return "success";
	}
}
