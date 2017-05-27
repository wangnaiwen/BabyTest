package action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.json.annotations.JSON;

import service.dao.FindSumPriceServiceDAO;

import com.opensymphony.xwork2.ActionSupport;

public class FindSumPriceAction  extends ActionSupport{

	/**
	 * 
	 */
    private Map<String,Object> dataMap;  
    private String key = "Just see see";
	private static final long serialVersionUID = 1L;
	
	private FindSumPriceServiceDAO findSumPriceServiceDAO;
	
	public FindSumPriceServiceDAO getFindSumPriceServiceDAO() {
		return findSumPriceServiceDAO;
	}
	public void setFindSumPriceServiceDAO(
			FindSumPriceServiceDAO findSumPriceServiceDAO) {
		this.findSumPriceServiceDAO = findSumPriceServiceDAO;
	}
	
	@Override
	public String execute() throws Exception{

		dataMap = new HashMap<String, Object>();
		
		Calendar ca = Calendar.getInstance();// 得到一个Calendar的实例  
		
		ArrayList<Integer> months = new ArrayList<Integer>();
		ArrayList<Integer> days = new ArrayList<Integer>();
		
		//最近三十天
		//ca.setTime(new Date()); // 设置时间为当前时间  
		for (int i = 1; i <= 30; i++) {
			ca.add(Calendar.YEAR,0); // 年份减1  
			ca.add(Calendar.MONTH,0);// 月份减1  
			ca.add(Calendar.DATE, -1);// 日期减1  
			Date resultDate = ca.getTime(); // 结果  
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");  
			String startDay = sdf.format(resultDate)+"000000000";
			String endDay = sdf.format(resultDate) + "235959999";
			days.add(findSumPriceServiceDAO.findSumPriceByDay(startDay, endDay));
		}
		
		Calendar ca1 = Calendar.getInstance();// 得到一个Calendar的实例 
		//最近七天
		for (int i = 1; i <= 12; i++) {
			ca1.add(Calendar.YEAR,0);   
			ca1.add(Calendar.MONTH,-1);// 月份减1  
			Date resultDate = ca1.getTime(); // 结果  
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");  
			String startDay = sdf.format(resultDate)+"01000000000";
			
			ca1.add(Calendar.MONTH,+1);// 月份+1  
			Date resultDate1 = ca1.getTime(); // 结果  
			String endDay = sdf.format(resultDate1) + "01000000000";
			
			months.add(findSumPriceServiceDAO.findSumPriceByDay(startDay, endDay));
			ca1.add(Calendar.MONTH,-1);// 月份-1  
		}
		dataMap.put("months", months);
		dataMap.put("days",days);
		return "success";		
	}
	public Map<String, Object> getDataMap() {  
        return dataMap;  
	}
	    
    @JSON(serialize=false)  
    public String getKey() {  
        return key;  
    }  
	
}
