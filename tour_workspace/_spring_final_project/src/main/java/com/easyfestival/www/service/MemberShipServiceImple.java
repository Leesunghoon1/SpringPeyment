package com.easyfestival.www.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easyfestival.www.domain.MemberShipVO;
import com.easyfestival.www.domain.OrderDTO;
import com.easyfestival.www.repository.MemberShipDAO;

@Service
public class MemberShipServiceImple implements MemberShipService {

	@Autowired
	private MemberShipDAO mdao;

	// MemberShipServiceImple.java

	@Override
	public void insert_point(OrderDTO orderDTO) {
	    // 1. 결제 금액에 따라 포인트 계산
	    long point = calculatePoints(orderDTO.getTotalPrice());

	    // 2. 적립된 포인트를 데이터베이스에 저장
	    mdao.savePoints(orderDTO.getId(), point, orderDTO.getTotalPrice());

	    // 3. 등급을 결정하고 데이터베이스에 저장
	    String grade = determineGrade(orderDTO.getTotalPrice());
	    System.out.println("getTotalPrice+++++++++" + orderDTO.getTotalPrice());
	    mdao.saveGrade(orderDTO.getId(), grade);
	}

	private long calculatePoints(Long totalPrice) {
	    // 포인트 계산 로직
	    // 예: 1%의 적립 비율로 계산
	    double pointRate = 0.01;
	    return (long) (totalPrice * pointRate);

	}

	private String determineGrade(Long totalPrice) {
	    // 등급 결정 로직
	    // 예: 각 등급에 필요한 최소 누적금액 기준을 설정하고 이에 따라 등급을 반환
	    // 이 메서드는 프로젝트의 실제 요구사항에 맞게 구현되어야 합니다.
	    // 여기서는 단순히 누적금액에 따라 브론즈, 실버, 골드, 다이아 등급을 구분하는 예시를 보여줍니다.
	    if (totalPrice >= 100000) {
	        return "골드";
	    } else if (totalPrice >= 50000) {
	        return "실버";
	    } else {
	        return "브론즈";
	    }
	}

	@Override
	public MemberShipVO getmemberShip(String id) {
		
		return mdao.getmemberShip(id);
	}

}
