package com.easyfestival.www.repository;

import java.util.List;

import com.easyfestival.www.handler.PagingHandler;
import com.easyfestival.www.security.AuthVO;
import com.easyfestival.www.security.UserVO;

public interface UserDAO {

	UserVO selectId(String username);

	List<AuthVO> selectAuths(String username);

	int join(UserVO uvo);

	int authUser(AuthVO avo);

	List<UserVO> getList();

	int modifyUser(UserVO uvo);

	int deleteUser(String id);

	int getUserCount();

	List<UserVO> getUserList(PagingHandler ph);


}