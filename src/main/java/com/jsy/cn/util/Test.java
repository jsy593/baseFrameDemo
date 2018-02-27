package com.jsy.cn.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jsy.cn.entity.User;

public class Test {
	public static void main(String[] args) throws JsonProcessingException {
		List<User> listData = getListData();
		Collections.sort(listData, new Comparator<User>() {
			 @Override
			    public int compare(User p1, User p2) {
			        return (int) (p1.getLevel() - p2.getLevel());
			    }
        });
		ObjectMapper objectMapper  = new ObjectMapper();
		System.out.println(objectMapper.writeValueAsString(listData));
		for(int i = 0;i<listData.size();i++){
			  findChildren(listData.get(i),listData);
		}
		System.out.println(objectMapper.writeValueAsString(listData));
	}
	
	public static void findChildren(User user,List<User> listData){
		List<User> users =new  ArrayList<>();
		for(int i = 0;i<listData.size();i++){
			if(user.getPkid() == listData.get(i).getParentId()){
				users.add(listData.get(i));
				findChildren(listData.get(i), listData);
			}
		}
		user.setChildren(users);
		listData.removeAll(users);//删除当前节点的所有子节点
	}
	
	public static List<User>  getListData(){
		List<User> listData = new ArrayList<>();
		User user1 = new User();
		User user2 = new User();
		User user3 = new User();
		User user4 = new User();
		User user5 = new User();
		User user6 = new User();
		User user7 = new User();
		listData.add(user7);
		listData.add(user3);
		listData.add(user6);
		listData.add(user4);
		listData.add(user5);
		listData.add(user2);
		listData.add(user1);
		user1.setLevel(1l);
		user2.setLevel(1l);
		user3.setLevel(2l);
		user4.setLevel(2l);
		user5.setLevel(3l);
		user6.setLevel(4l);
		user7.setLevel(5l);
		user1.setPkid(1l);
		user2.setPkid(2l);
		user3.setPkid(3l);
		user4.setPkid(4l);
		user5.setPkid(5l);
		user6.setPkid(6l);
		user7.setPkid(7l);
		user1.setParentId(0l);//顶级
		user2.setParentId(0l);//顶级
		user3.setParentId(1l);//二级
		user4.setParentId(2l);//二级
		user5.setParentId(3l);//三级
		user6.setParentId(5l);//四级
		user7.setParentId(5l);//四级
		return listData;
	}
}
