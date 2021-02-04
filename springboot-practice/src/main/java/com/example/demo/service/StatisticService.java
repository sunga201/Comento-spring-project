package com.example.demo.service;

import java.util.HashMap;
import java.util.List;
 
public interface StatisticService {
    public HashMap<String, Object> yearLoginNum(String year);
    public HashMap<String, Object> monthLoginNum(String month); 
    public HashMap<String, Object> dayLoginNum(String day);    
    public List<HashMap<String, Object>> averageLoginNum();
    public HashMap<String, Object> exceptHolidayNum(String year, String month);
    public HashMap<String, Object> departmentMonthLoginNum(String dep, String month);
}
