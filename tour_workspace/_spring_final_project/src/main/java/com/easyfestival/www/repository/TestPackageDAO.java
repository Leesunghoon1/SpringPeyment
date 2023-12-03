package com.easyfestival.www.repository;

import java.util.List;

import com.easyfestival.www.domain.TestPackageVO;

public interface TestPackageDAO {

	int register(TestPackageVO pgvo);

	List<TestPackageVO> getlist();

	TestPackageVO getDetail(int pkNo);

}
