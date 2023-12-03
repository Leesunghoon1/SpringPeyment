package com.easyfestival.www.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.easyfestival.www.domain.TestPackageVO;
import com.easyfestival.www.repository.TestPackageDAO;

import lombok.extern.slf4j.Slf4j;

@Service
public class TestPackageServiceImpl implements TestPackageService{
	
	@Inject
	private TestPackageDAO pdao;

	@Override
	public int register(TestPackageVO pgvo) {
		// TODO Auto-generated method stub	
		return pdao.register(pgvo);
	}

	@Override
	public List<TestPackageVO> getList() {
		// TODO Auto-generated method stub
		return pdao.getlist();
	}

	@Override
	public TestPackageVO getDetail(int pkNo) {
		// TODO Auto-generated method stub
		return pdao.getDetail(pkNo);
	}
	
	

}
