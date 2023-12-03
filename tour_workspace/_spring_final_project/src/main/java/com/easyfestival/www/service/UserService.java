package com.easyfestival.www.service;

import com.easyfestival.www.security.UserVO;

public interface UserService {
	
	int userJoin(UserVO uvo);

	UserVO getId(String id);

	int authUser(String id);
}
