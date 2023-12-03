package com.easyfestival.www.service;

import org.springframework.stereotype.Service;

import com.easyfestival.www.repository.UserDAO;
import com.easyfestival.www.security.UserVO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

	private final UserDAO udao;

	@Override
	public int userJoin(UserVO uvo) {
		return udao.join(uvo);
	}

	@Override
	public UserVO getId(String id) {
		return udao.selectId(id);
	}

	@Override
	public int authUser(String id) {
		return udao.authUser(id);
	}

	
	
}
