package action;


import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.json.annotations.JSON;

import service.dao.FindAdminServiceDAO;

import com.opensymphony.xwork2.ActionSupport;

import domain.Admin;

public class AdminLoginAction extends ActionSupport{
    private Map<String,Object> dataMap;  
    private String key = "Just see see";
	private static final long serialVersionUID = 1L;
	private String name;
	private String password;
	private FindAdminServiceDAO findAdminServiceDAO;
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public FindAdminServiceDAO getFindAdminServiceDAO() {
		return findAdminServiceDAO;
	}
	public void setFindAdminServiceDAO(FindAdminServiceDAO findAdminServiceDAO) {
		this.findAdminServiceDAO = findAdminServiceDAO;
	}
	@Override
	public String execute() throws Exception {
		Admin admin = new Admin();
		admin.setName(name);
		admin.setPassword(password);		
   		dataMap = new HashMap<String, Object>();  
   		dataMap.put("adminLogin", findAdminServiceDAO.findAdmin(admin));
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
