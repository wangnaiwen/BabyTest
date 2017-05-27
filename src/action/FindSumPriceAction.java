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
		
		Calendar ca = Calendar.getInstance();// �õ�һ��Calendar��ʵ��  
		
		ArrayList<Integer> months = new ArrayList<Integer>();
		ArrayList<Integer> days = new ArrayList<Integer>();
		
		//�����ʮ��
		//ca.setTime(new Date()); // ����ʱ��Ϊ��ǰʱ��  
		for (int i = 1; i <= 30; i++) {
			ca.add(Calendar.YEAR,0); // ��ݼ�1  
			ca.add(Calendar.MONTH,0);// �·ݼ�1  
			ca.add(Calendar.DATE, -1);// ���ڼ�1  
			Date resultDate = ca.getTime(); // ���  
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");  
			String startDay = sdf.format(resultDate)+"000000000";
			String endDay = sdf.format(resultDate) + "235959999";
			days.add(findSumPriceServiceDAO.findSumPriceByDay(startDay, endDay));
		}
		
		Calendar ca1 = Calendar.getInstance();// �õ�һ��Calendar��ʵ�� 
		//�������
		for (int i = 1; i <= 12; i++) {
			ca1.add(Calendar.YEAR,0);   
			ca1.add(Calendar.MONTH,-1);// �·ݼ�1  
			Date resultDate = ca1.getTime(); // ���  
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");  
			String startDay = sdf.format(resultDate)+"01000000000";
			
			ca1.add(Calendar.MONTH,+1);// �·�+1  
			Date resultDate1 = ca1.getTime(); // ���  
			String endDay = sdf.format(resultDate1) + "01000000000";
			
			months.add(findSumPriceServiceDAO.findSumPriceByDay(startDay, endDay));
			ca1.add(Calendar.MONTH,-1);// �·�-1  
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
