package com.easyfestival.www.service;

import com.easyfestival.www.domain.MemberShipVO;
import com.easyfestival.www.domain.OrderDTO;
import com.easyfestival.www.security.UserVO;

public interface MemberShipService {

	void insert_point(OrderDTO orderDTO);

	MemberShipVO getmemberShip(String id);


	int updateMemberShip(String id, Long point);

	int pointCancle(String id, Long totalPrice);


	void insertId(String id);


}
