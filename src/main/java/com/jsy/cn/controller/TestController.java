package com.jsy.cn.controller;

import java.io.IOException;
import java.util.Date;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Response;

import org.apache.commons.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jsy.cn.service.TestService;

@Controller
public class TestController {
	@Autowired
	private TestService testService;
	@RequestMapping("test/{userPkid}/{staffPkid}")
	public void test(@PathVariable Long userPkid,@PathVariable Long staffPkid,HttpServletResponse res) throws IOException{
		try {
			testService.testAdd(userPkid,staffPkid);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	@RequestMapping("testPage")
	public ModelAndView testPage(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("test/test");
		return modelAndView;
	}
}
