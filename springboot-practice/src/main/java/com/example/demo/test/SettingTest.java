package com.example.demo.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.service.StatisticService;

@Controller
public class SettingTest {
    @Autowired
    private StatisticService service;
    
    @ResponseBody 
    @RequestMapping("/sqlyearStatistic")
    public Map<String, Object> callByYear(String year) throws Exception{ 
        
        return service.yearLoginNum(year);
    }
    
    @ResponseBody 
    @RequestMapping("/sqlMonthStatistic")
    public Map<String, Object> callByMonth(String month) throws Exception{ 
        
        return service.monthLoginNum(month);
    }    
        
    @ResponseBody 
    @RequestMapping("/sqlDayStatistic")
    public Map<String, Object> callByDay(String day) throws Exception{ 
        
        return service.dayLoginNum(day);
    }    
    
    @ResponseBody 
    @RequestMapping("/sqlDepartmentMonthStatistic")
    public Map<String, Object> callByDepartmentMonth(String dep, String month) throws Exception{ 
        
        return service.departmentMonthLoginNum(dep, month);
    }  
    @RequestMapping("/test") 
    public ModelAndView test() throws Exception{ 
        ModelAndView mav = new ModelAndView("test"); 
        mav.addObject("name", "devfunpj"); 
        List<String> resultList = new ArrayList<String>(); 
        resultList.add("!!!HELLO WORLD!!!"); 
        resultList.add("설정 TEST!!!"); 
        resultList.add("설정 TEST!!!"); 
        resultList.add("설정 TEST!!!!!"); 
        resultList.add("설정 TEST!!!!!!"); 
        mav.addObject("list", resultList); 
        return mav; 
    }
 
}