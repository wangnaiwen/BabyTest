package action;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.util.HashMap;
import java.util.Map;

import jdbc.SqlConfig;

import org.apache.struts2.json.annotations.JSON;

import com.opensymphony.xwork2.ActionSupport;

public class BackupAction extends ActionSupport{
    private Map<String,Object> dataMap;  
    private String key = "Just see see";
	private static final long serialVersionUID = 1L;
	
	@Override
	public String execute() throws Exception{
		dataMap = new HashMap<String, Object>(); 
		
		 try {  
			 String path = "mysqldump";
			 //String savePath = "e:////love_baby.sql"; 
			 String savePath = "/www/love_baby.sql";  
			 String DB_NAME = "love_baby";
			    String[] execCMD = new String[] {path, "-u" + SqlConfig.USER, "-p" + SqlConfig.PASSWORD, DB_NAME,  
			            "-r" + savePath};  
			    Process process = Runtime.getRuntime().exec(execCMD);  
			    LineNumberReader br = new LineNumberReader(new InputStreamReader(  
                        process.getInputStream()));  
			    StringBuffer sb = new StringBuffer();  
                String line;  
                while ((line = br.readLine()) != null) {  
                    System.out.println(line);  
                    sb.append(line).append("\r\n");  
                }
                dataMap.put("backup", true);
             return "success";  
         } catch (Exception e) {  
        	 dataMap.put("backup", false);
             e.printStackTrace();  
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
