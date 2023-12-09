package com.easyfestival.www.service;

import com.easyfestival.www.domain.MemberShipVO;
import com.easyfestival.www.domain.OrderDTO;

public interface MemberShipService {

	void insert_point(OrderDTO orderDTO);

	MemberShipVO getmemberShip(String id);


}
