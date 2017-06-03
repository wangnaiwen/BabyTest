package action;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

import jdbc.SqlConfig;

import org.apache.struts2.json.annotations.JSON;

import com.opensymphony.xwork2.ActionSupport;

public class RecoverAction extends ActionSupport{
    private Map<String,Object> dataMap;  
    private String key = "Just see see";
	private static final long serialVersionUID = 1L;
	
	@Override
	public String execute() throws Exception{
		dataMap = new HashMap<String, Object>(); 
		 try {  
			Runtime runtime = Runtime.getRuntime();
				
			Process process = runtime.exec("mysql -u"+SqlConfig.USER+" -p"+SqlConfig.PASSWORD+" --default-character-set=utf8 test");
			String path = "/www/love_baby.sql";
			OutputStream outputStream = process.getOutputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(path)));
			String str = null;
			StringBuffer sb = new StringBuffer();
			while((str = br.readLine()) != null){
				sb.append(str+"\r\n");
			}
			str = sb.toString();
			System.out.println(str);
			OutputStreamWriter writer = new OutputStreamWriter(outputStream,"utf-8");				writer.write(str);
			writer.flush();
			outputStream.close();
			br.close();
			writer.close();
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
