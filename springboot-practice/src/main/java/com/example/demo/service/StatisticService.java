package com.example.demo.service;

import java.util.HashMap;
 
public interface StatisticService {
    public HashMap<String, Object> yearLoginNum(String year);
    public HashMap<String, Object> monthLoginNum(String month); 
    public HashMap<String, Object> dayLoginNum(String day);    
    public HashMap<String, Object> departmentMonthLoginNum(String dep, String month);
}
