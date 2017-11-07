package com.jsy.cn.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jsy.cn.dao.StaffMapper;
import com.jsy.cn.dao.UserMapper;
import com.jsy.cn.entity.Staff;
import com.jsy.cn.entity.User;

@Service
public class TestService {
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private StaffMapper staffMapper;
	
	@Transactional
	public void testAdd(Long userPkid,Long staffPkid){
		User user = new User();
		user.setPkid(userPkid);
		user.setAddedName("test2017");
		user.setUserName("test2017");
		user.setPassword("12321");
		userMapper.insertSelective(user);
		Staff staff = new Staff();
		staff.setPkid(staffPkid);
		staff.setMobile("11111111111231");
		staffMapper.insertSelective(staff);
	}
}
