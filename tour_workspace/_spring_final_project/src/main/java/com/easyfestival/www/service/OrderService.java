package com.easyfestival.www.service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.json.simple.parser.ParseException;
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

	public OrderDTO adminList(OrderDTO orderDTO) {
		
		return orderDAO.adminList(orderDTO);
	}

	public int payMentCancle(PayDTO payDTO) {
		
		return orderDAO.payMentCancle(payDTO.getOrderNum());
	}

	public int orderCancle(OrderDTO orderDTO) throws Exception {
		System.out.println("1 : " + orderDTO);
		System.out.println("2 : " + orderDTO.getOrderNum());
		System.out.println("3 : " + orderDTO.getImpUid());
		if(!orderDTO.getImpUid().equals("")) {
			String token = payService.getToken(); 
			Long price = orderDTO.getTotalPrice();
			Long refundPrice = price ;
			System.out.println("Test ss");
			payService.payMentCancle(token, orderDTO.getImpUid(), refundPrice+"", "환불");
			System.out.println("Test ss2222");
		}
		
		return orderDAO.orderCancle((orderDTO.getOrderNum()));
	}


	}


