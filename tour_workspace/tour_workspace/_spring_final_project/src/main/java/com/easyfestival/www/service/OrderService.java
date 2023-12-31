package com.easyfestival.www.service;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.easyfestival.www.domain.OllPayDTO;
import com.easyfestival.www.domain.OrderVO;
import com.easyfestival.www.domain.PayDTO;
import com.easyfestival.www.domain.ProductListDTO;
import com.easyfestival.www.handler.PagingHandler;
import com.easyfestival.www.repository.OrderDAO;
import com.easyfestival.www.repository.PackageDAO;
import com.easyfestival.www.security.UserVO;

@Service
public class OrderService {
	
	@Autowired
	private OrderDAO orderDAO;
	
	@Autowired
	private PayService payService;
	

	public int insert_pay(OrderVO orderVO) throws Exception{
		
		
		return orderDAO.insert_pay(orderVO);
	}

	public int insert_payinfo(PayDTO payVO) throws Exception{
		
		return orderDAO.insert_payinfo(payVO);
	}

	public PayDTO getLastPay(PayDTO payVO) throws Exception{
		
		return orderDAO.getLastPay(payVO);
	}

	public PayDTO getPay(long payNum) {
		// TODO Auto-generated method stub
		return orderDAO.getPay(payNum);
	}


	public OrderVO adminList(OrderVO orderVO) {
		
		return orderDAO.adminList(orderVO);
	}

	public int payMentCancle(PayDTO payVO) {
		
		return orderDAO.payMentCancle(payVO.getOrderNum());
	}
	
	@Transactional
	public int orderCancle(OrderVO orderVO) throws Exception {
		System.out.println("1 : " + orderVO);
		System.out.println("2 : " + orderVO.getOrderNum());
		System.out.println("3 : " + orderVO.getImpUid());
		if(!orderVO.getImpUid().equals("")) {
			String token = payService.getToken(); 
			Long price = orderVO.getTotalPrice();
			Long refundPrice = price ;
			System.out.println("Test ss");
			payService.payMentCancle(token, orderVO.getImpUid(), refundPrice+"", "환불");
			System.out.println("Test ss2222");
		}
		
		return orderDAO.orderCancle((orderVO.getOrderNum()));
	}

	public int OrderCount(String svNum) {
		// TODO Auto-generated method stub
		return orderDAO.OrderCount(svNum);
	}

	public List<OrderVO> getOrder(PagingHandler ph, String svNum) {
		// TODO Auto-generated method stub
		return orderDAO.getOrder(ph, svNum);
	}

	public List<OllPayDTO> ollOrder(PagingHandler ph, String svNum) {
		// TODO Auto-generated method stub
		return orderDAO.ollOrder(ph, svNum);
	}

	public List<OllPayDTO> ollList(long orderNum) {
		// TODO Auto-generated method stub
		return orderDAO.ollList(orderNum);
	}



}
