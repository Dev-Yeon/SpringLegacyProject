package com.oh.app.users;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class UsersClient {
	public static void main(String[] args) {
		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");

		UsersService us = (UsersService)factory.getBean("UsersService");
		UsersVO vo = new UsersVO();
		
		/*vo.setId("oso");
		vo.setPassword("1234");
		vo.setName("피카츄");
		vo.setRole("USER");
		us.insertUsers(vo);*/

		/*
		UsersVO data = us.getUsers(vo);
		System.out.println(data);*/
		
		/*
		vo.setId("oso");
		vo.setPassword("1111");
		vo.setName("팀쿡");
		us.updateUsers(vo);*/
		
		/*
		vo.setId("oso");
		us.deleteUsers(vo);*/
		
		vo.setId("oh");
		UsersVO data = us.getUsers(vo);
		System.out.println(data);
		
		List<UsersVO> datas = us.getUsersList(vo);
		for(UsersVO v:datas) {
			System.out.println(v);
		}
	}
}
