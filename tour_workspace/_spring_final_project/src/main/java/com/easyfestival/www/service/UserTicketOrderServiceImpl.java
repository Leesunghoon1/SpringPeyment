package com.easyfestival.www.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easyfestival.www.domain.OrderVO;
import com.easyfestival.www.repository.UserTicketOrderDAO;


@Service
public class UserTicketOrderServiceImpl implements UserTicketOrderService{
	
	
	@Autowired
	UserTicketOrderDAO utdao;
	
	@Override
	public void insert_user_ticket(OrderVO orderVO) {
		
		utdao.insert_user_ticket(orderVO);
	}

}
