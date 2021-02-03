package com.example.demo.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.StatisticMapper;
 
@Service
public class StatisticServiceImpl implements StatisticService {
    
    
    @Autowired
    private StatisticMapper uMapper;
    
    @Override
    public HashMap<String, Object> yearLoginNum (String year) {
        HashMap<String, Object> retVal = new HashMap<String,Object>();
        
        try {
            retVal = uMapper.selectYearLogin(year);
            retVal.put("year", year);
            retVal.put("is_success", true);
            
        }
        catch(Exception e) {
            retVal.put("totCnt", -999);
            retVal.put("year", year);
            retVal.put("is_success", false);
        }
        
        return retVal;
    }

    @Override
    public HashMap<String, Object> monthLoginNum(String month){
    	HashMap<String, Object> retVal = new HashMap<String,Object>();
    	month=addZero(month); 
    	
        try {
            retVal = uMapper.selectMonthLogin(month);
            retVal.put("month", (month.charAt(0) == '0' ? month.charAt(1) : month)); // 1일~9일 사이면 앞에 0 빼고 출력
            retVal.put("is_success", true);
        }
        catch(Exception e) {
            retVal.put("totCnt", -999);
            retVal.put("month", (month.charAt(0) == '0' ? month.charAt(1) : month));
            retVal.put("is_success", false);
        }     
        
        return retVal;
    }    
    
    @Override
    public HashMap<String, Object> dayLoginNum(String day){
    	HashMap<String, Object> retVal = new HashMap<String,Object>();
    	day=addZero(day); // 1일 ~ 9일 사이면 앞에 0 붙여서 검색
    	
        try {
            retVal = uMapper.selectDayLogin(day);
            retVal.put("day", (day.charAt(0) == '0' ? day.charAt(1) : day)); // 1일~9일 사이면 앞에 0 빼고 출력
            retVal.put("is_success", true);
        }
        catch(Exception e) {
            retVal.put("totCnt", -999);
            retVal.put("day", (day.charAt(0) == '0' ? day.charAt(1) : day));
            retVal.put("is_success", false);
        }
        
        return retVal;
    }
    
    @Override
    public List<HashMap<String, Object>> averageLoginNum(){
    	List<HashMap<String, Object>> retVal;
    	try {
            retVal = uMapper.selectAverageLogin();
            System.out.println("retVal : " + retVal);
        }
        catch(Exception e) {
        	e.printStackTrace();
        	return null;
        }     
        
        return retVal;
    }

    /*@Override
    public List<HashMap<String, Object>> exceptHolidayNum(String year, String month){
        HashMap<String, Object> retVal = new HashMap<String,Object>();
        month=addZero(month); // 1월 ~ 9월 사이면 앞에 0 붙여서 검색
        
        try {
	        URL url = new URL(String.format(
	        			"http://apis.data.go.kr/B090041/openapi/service/SpcdeInfoService/getHoliDeInfo?solYear=%s&solMonth=%s&ServiceKey=%s&_type=json"
	        			, year, month, "tLU04vgsMUUbX2%2FcJRFDEvPcH5ytARHAo2l06%2Bo7DjwAfckb5vxYKH58LLPOP50%2FhGvFFLZ5orMR14GZNDEK3Q%3D%3D"));
	        
	        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	
	        conn.setRequestMethod("GET");
	        conn.setRequestProperty("Content-Type", "application/json");
	
	        int responseCode = conn.getResponseCode();
	        if (responseCode == 400) {
	            System.out.println("400:: 해당 명령을 실행할 수 없음");
	        } else if (responseCode == 500) {
	            System.out.println("500:: 서버 에러");
	        } else { // 성공 후 응답 JSON 데이터받기
	            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
	            StringBuilder sb = new StringBuilder();
	            String line = "";
	            while ((line = br.readLine()) != null) {
	                sb.append(line);
	            }
	            
	            JSONObject responseJson = new JSONObject(sb.toString());
	        }
        }
	    catch(Exception e) {
	    	e.printStackTrace();
	    }
        
        try {
            retVal = uMapper.selectExceptHolidayLogin(year, month);
            retVal.put("year", year);
            retVal.put("month", (month.charAt(0) == '0' ? month.charAt(1) : month)); // 1일~9일 사이면 앞에 0 빼고 출력
            retVal.put("is_success", true);
        }
        catch(Exception e) {
            retVal.put("totCnt", -999);
            retVal.put("year", year);            
            retVal.put("month", (month.charAt(0) == '0' ? month.charAt(1) : month));
            retVal.put("is_success", false);
        }
            
        return retVal;
    }*/
    
    @Override
    public HashMap<String, Object> departmentMonthLoginNum(String dep, String month){
    	HashMap<String, Object> retVal = new HashMap<String,Object>();
    	month=addZero(month); // 1일 ~ 9일 사이면 앞에 0 붙여서 검색        
    	
        try {
            retVal = uMapper.selectDepartmentMonthLogin(dep, month);
            retVal.put("department", dep);
            retVal.put("month", (month.charAt(0) == '0' ? month.charAt(1) : month)); // 1일~9일 사이면 앞에 0 빼고 출력
            retVal.put("is_success", true);
        }
        catch(Exception e) {
            retVal.put("totCnt", -999);
            retVal.put("department", null);
            retVal.put("month", null); // 1일~9일 사이면 앞에 0 빼고 출력
            retVal.put("is_success", false);
        }
        
        return retVal;
    }
    
    public String addZero(String num) {
    	if(num.length()==1) num = "0" + num;
    	return num;
    }
}