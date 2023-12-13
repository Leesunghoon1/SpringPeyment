package com.easyfestival.www.service;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.easyfestival.www.domain.OrderDTO;
import com.easyfestival.www.domain.PayDTO;
import com.easyfestival.www.handler.PagingHandler;
import com.easyfestival.www.repository.OrderDAO;
import com.easyfestival.www.security.UserVO;

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


	public OrderDTO adminList(OrderDTO orderDTO) {
		
		return orderDAO.adminList(orderDTO);
	}

	public int payMentCancle(PayDTO payDTO) {
		
		return orderDAO.payMentCancle(payDTO.getOrderNum());
	}
	
	@Transactional
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

	public int OrderCount(String svNum) {
		// TODO Auto-generated method stub
		return orderDAO.OrderCount(svNum);
	}


	
	/*
	 * //회원의 주문 목록 // OrderService.java public Map<String, List<Long>>
	 * getMyOrderList(String id, List<Long> limitList) throws Exception {
	 * Map<String, List<Long>> orderMap = new HashMap<>();
	 * 
	 * for (Long code : limitList) { List<Long> orderList =
	 * orderDAO.getMyOrderList(id, code); orderMap.put(String.valueOf(code),
	 * orderList); }
	 * 
	 * return orderMap; }
	 */


}
