package com.easyfestival.www.service;

import java.util.List;

import com.easyfestival.www.domain.reviewVO;

public interface ReviewService {


	int reviewRegister(reviewVO rvo);

	List<reviewVO> list();

	reviewVO detail(int rvNo);

	int remove(int rvNo);

	int modify(reviewVO rvo);

	int readCountUp(int rvNo);

	

}
