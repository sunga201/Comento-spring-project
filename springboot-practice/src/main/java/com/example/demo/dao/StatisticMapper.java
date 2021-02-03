package com.example.demo.dao;

import java.util.HashMap;
import java.util.List;

public interface  StatisticMapper {
    public HashMap<String, Object> selectYearLogin(String year);
    public HashMap<String, Object> selectMonthLogin(String month);
    public HashMap<String, Object> selectDayLogin(String day);
    public List<HashMap<String, Object>> selectAverageLogin();
    public HashMap<String, Object> selectExceptHolidayLogin(String year, String month);
    public HashMap<String, Object> selectDepartmentMonthLogin(String dep, String month);
}