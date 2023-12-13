package com.easyfestival.www.repository;

import java.util.List;
import java.util.Map;

import com.easyfestival.www.domain.OrderDTO;
import com.easyfestival.www.domain.PayDTO;
import com.easyfestival.www.handler.PagingHandler;
import com.easyfestival.www.security.UserVO;

public interface OrderDAO {

	int insert_pay(OrderDTO orderDTO);

	int insert_payinfo(PayDTO payDTO);

	PayDTO getLastPay(PayDTO payDTO);
	
	PayDTO getPay(long payNum);

	OrderDTO adminList(OrderDTO orderDTO);

	int payMentCancle(Long orderNum);

	int orderCancle(Long long1);

	int OrderCount(String svNum);

	List<OrderDTO> getOrder(PagingHandler ph);



	/*
	 * public List<Long> getMyOrderList(String id, Long code);
	 */

}
