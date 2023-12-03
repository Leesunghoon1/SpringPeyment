package com.easyfestival.www.service;

import java.util.List;

import com.easyfestival.www.domain.TestPackageVO;

public interface TestPackageService {

	int register(TestPackageVO pgvo);

	List<TestPackageVO> getList();

	TestPackageVO getDetail(int pkNo);


}
