package com.example.demo.service;

import java.util.HashMap;
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
        
        try {
        	month=addZero(month);
            retVal = uMapper.selectMonthLogin(month);
            retVal.put("month", (month.charAt(0) == '0' ? month.charAt(1) : month)); // 1일~9일 사이면 앞에 0 빼고 출력
            retVal.put("is_success", true);
        }
        catch(Exception e) {
            retVal.put("totCnt", -999);
            retVal.put("month", month);
            retVal.put("is_success", false);
        }     
        
        return retVal;
    }    
    
    @Override
    public HashMap<String, Object> dayLoginNum(String day){
    	HashMap<String, Object> retVal = new HashMap<String,Object>();
        
        try {
        	day=addZero(day); // 1일 ~ 9일 사이면 앞에 0 붙여서 검색
            retVal = uMapper.selectDayLogin(day);
            retVal.put("day", (day.charAt(0) == '0' ? day.charAt(1) : day)); // 1일~9일 사이면 앞에 0 빼고 출력
            retVal.put("is_success", true);
        }
        catch(Exception e) {
            retVal.put("totCnt", -999);
            retVal.put("day", day);
            retVal.put("is_success", false);
        }
        
        return retVal;
    }
    
    @Override
    public HashMap<String, Object> departmentMonthLoginNum(String dep, String month){
    	HashMap<String, Object> retVal = new HashMap<String,Object>();
        
        try {
        	month=addZero(month); // 1일 ~ 9일 사이면 앞에 0 붙여서 검색
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