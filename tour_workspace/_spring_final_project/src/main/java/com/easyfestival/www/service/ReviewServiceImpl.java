package com.easyfestival.www.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;


import com.easyfestival.www.domain.reviewVO;
import com.easyfestival.www.repository.ReviewDAO;

@Service
public class ReviewServiceImpl implements ReviewService{

	@Inject
	private ReviewDAO rdao;

	@Override
	public int reviewRegister(reviewVO rvo) {
		return rdao.reviewRegister(rvo);
	}

	@Override
	public List<reviewVO> list() {
		return rdao.list();
	}

	@Override
	public reviewVO detail(int rvNo) {
		return rdao.detail(rvNo);
	}

	@Override
	public int remove(int rvNo) {
		return rdao.remove(rvNo);
	}

	@Override
	public int modify(reviewVO rvo) {
		return rdao.modify(rvo);
	}

	@Override
	public int readCountUp(int rvNo) {
		return rdao.readCountUp(rvNo);
	}

	
}
