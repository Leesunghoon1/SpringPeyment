package com.easyfestival.www.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easyfestival.www.domain.OrderDTO;
import com.easyfestival.www.domain.PayDTO;
import com.easyfestival.www.repository.OrderDAO;

@Service
public class OrderService {
	
	@Autowired
	private OrderDAO orderDAO;
	
	@Autowired
	private PayService payService;

	public int insert_pay(OrderDTO orderDTO) throws Exception{
		
		
		return orderDAO.insert_pay(orderDTO);
	}

	public int insert_payinfo(PayDTO payDTO) throws Exception{
		
		return orderDAO.insert_payinfo(payDTO);
	}

	public PayDTO getLastPay(PayDTO payDTO) throws Exception{
		
		return orderDAO.getLastPay(payDTO);
	}

	public PayDTO getPay(long payNum) {
		// TODO Auto-generated method stub
		return orderDAO.getPay(payNum);
	}

	public List<Long> MyOrderCount(String saveNUM) {
		// TODO Auto-generated method stub
		return orderDAO.myOrderCount(saveNUM);
	}




}
