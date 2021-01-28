package com.example.demo.dao;

import java.util.HashMap;

public interface  StatisticMapper {
    public HashMap<String, Object> selectYearLogin(String year);
    public HashMap<String, Object> selectMonthLogin(String month);
    public HashMap<String, Object> selectDayLogin(String day);
    public HashMap<String, Object> selectDepartmentMonthLogin(String dep, String month);
}