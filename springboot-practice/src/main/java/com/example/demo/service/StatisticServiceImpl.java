package com.example.demo.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

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

    @Override
    public HashMap<String, Object> exceptHolidayNum(String year, String month){
        HashMap<String, Object> retVal = new HashMap<String,Object>();
        month=addZero(month); // 1월 ~ 9월 사이면 앞에 0 붙여서 검색
        List<HttpMessageConverter<?>> converters = new ArrayList<HttpMessageConverter<?>>();
        converters.add(new FormHttpMessageConverter());
        converters.add(new StringHttpMessageConverter());
     
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setMessageConverters(converters);
     
        try {
			String serviceKey = URLDecoder.decode("FS5iTqDxs7yuQkhHeEyFp6K8LY0%2FFe3%2FJtYFdaL%2Fjk4YWUlmVqiJ0m25cSJiWBj37PcmedzprJQPzN2uuDY0NQ%3D%3D", "UTF-8");
			// REST API 호출
	        String result = restTemplate.getForObject(String.format(
	    			"http://apis.data.go.kr/B090041/openapi/service/SpcdeInfoService/getRestDeInfo?solYear=%s&solMonth=%s&ServiceKey=%s&_type=json"
	    			, "20"+year, month, serviceKey), String.class);
	        System.out.println("------------------ TEST 결과 ------------------");
	        System.out.println(result);
	        JSONParser parser = new JSONParser();
	        JSONObject jsonObject = (JSONObject) parser.parse(result);
	        JSONObject jsonObject2 = (JSONObject) jsonObject.get("response");
	        JSONObject body = (JSONObject) jsonObject2.get("body");
	        System.out.println(body);
	        int num = Integer.parseInt(body.get("totalCount").toString());
	        JSONObject items = null;
	        if(num!=0)  items = (JSONObject) body.get("items");
	        
	        ArrayList<String> list = new ArrayList<>();
	        
	        if(num==1) {
	        	JSONObject item = (JSONObject) items.get("item");
	        	list.add(item.get("locdate").toString().substring(2)); // 공휴일 년, 월 더하기
	        }
	        else if(num!=0){
	        	JSONArray itemList = (JSONArray) items.get("item");
		        
		       	for(int i=0; i<itemList.size(); i++) {
		       		JSONObject tmp = (JSONObject)itemList.get(i);
		       		list.add(tmp.get("locdate").toString().substring(2)); // 공휴일 년, 월 더하기
		       	}
	        }
	       
	       	for(int i=0; i<list.size(); i++) {
	       		System.out.println(list.get(i));
	       	}
	       	try {
	            retVal = uMapper.selectExceptHolidayLogin(year, month, list);
	            retVal.put("year", year);
	            retVal.put("month", (month.charAt(0) == '0' ? month.charAt(1) : month)); // 1일~9일 사이면 앞에 0 빼고 출력
	            retVal.put("is_success", true);
	        }
	        catch(Exception e) {
	        	e.printStackTrace();
	            retVal.put("totCnt", -999);
	            retVal.put("year", year);            
	            retVal.put("month", (month.charAt(0) == '0' ? month.charAt(1) : month));
	            retVal.put("is_success", false);
	        }
	            
	        return retVal;
	        
        } catch (Exception e1) {
			e1.printStackTrace();
			return null;
		}   
    }
    
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