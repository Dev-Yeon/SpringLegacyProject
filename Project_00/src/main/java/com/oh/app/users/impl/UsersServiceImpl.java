package com.oh.app.users.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oh.app.users.UsersService;
import com.oh.app.users.UsersVO;

@Service("UsersService")
public class UsersServiceImpl implements UsersService{
	
	@Autowired
	private UsersDAO1 usersDAO;
	
	@Override
	public void insertUsers(UsersVO vo) {
		usersDAO.insertUsers(vo);
	}

	@Override
	public void updateUsers(UsersVO vo) {
		usersDAO.updateUsers(vo);
	}

	@Override
	public void deleteUsers(UsersVO vo) {
		usersDAO.deleteUsers(vo);
	}

	@Override
	public UsersVO getUsers(UsersVO vo) {
		return usersDAO.getUsers(vo);
	}

	@Override
	public List<UsersVO> getUsersList(UsersVO vo) {
		return usersDAO.getUsersList(vo);
	}

}
