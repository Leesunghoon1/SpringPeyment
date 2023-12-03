package com.easyfestival.www.repository;

import java.util.List;

import com.easyfestival.www.domain.PackageVO;

public interface PackageDAO {

	void insert(PackageVO pkvo);

	long selectPkNo();

	List<PackageVO> getList();

	PackageVO getPackageDetail(long pkNo);





}
