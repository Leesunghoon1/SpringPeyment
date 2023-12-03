package com.easyfestival.www.repository;

import java.util.List;
import java.util.Map;

public interface OrderDAO {

	int insert_pay(OrderDTO orderDTO);

	int insert_payinfo(PayDTO payDTO);

	PayDTO getLastPay(PayDTO payDTO);

	PayDTO getPay(long payNum);

	List<Long> myOrderCount(String saveNUM);

	OrderDTO adminList(OrderDTO orderDTO);

	int payMentCancle(Long orderNum);

	int orderCancle(Long long1);


}
