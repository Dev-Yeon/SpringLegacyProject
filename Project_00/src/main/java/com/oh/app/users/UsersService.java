package com.oh.app.users;

import java.util.List;

public interface UsersService {

	void insertUsers(UsersVO vo);

	void updateUsers(UsersVO vo);

	void deleteUsers(UsersVO vo);

	UsersVO getUsers(UsersVO vo);

	List<UsersVO> getUsersList(UsersVO vo);

}