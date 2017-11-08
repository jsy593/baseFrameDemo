package com.jsy.cn.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.jsy.cn.annotation.SystemLog;
import com.jsy.cn.service.TestService;

@Controller
public class TestController {
	@Autowired
	private TestService testService;
	@RequestMapping("test/{userPkid}/{staffPkid}")
	@SystemLog(operationType="test1类型",operationdesc="test1描述")
	public void test(@PathVariable Long userPkid,@PathVariable Long staffPkid,HttpServletResponse res) throws IOException{
		try {
			testService.testAdd(userPkid,staffPkid);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	@RequestMapping("testPage")
	@SystemLog(operationType="testPage类型",operationdesc="testPage描述")
	public ModelAndView testPage(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("test/test");
		return modelAndView;
	}
	@RequestMapping("testLog")
	@SystemLog(operationType="test类型",operationdesc="test描述")
	@ResponseBody
	public Map<String,Object> testLog(){
		Map<String,Object> result = new HashMap<>();
		result.put("msg", "测试成功!");
		return result;
	}
}
