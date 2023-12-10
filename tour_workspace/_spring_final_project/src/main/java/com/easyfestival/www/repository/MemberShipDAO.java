package com.easyfestival.www.repository;

import org.apache.ibatis.annotations.Param;

import com.easyfestival.www.domain.MemberShipVO;



public interface MemberShipDAO {
	
	void saveGrade(@Param("id") String id, @Param("grade") String grade);

	void savePoints(@Param("id") String id, @Param("point") long point, @Param("totalPrice") Long totalPrice);

	MemberShipVO getmemberShip(String id);

	int UpdateMemberShip(@Param("id") String id, @Param("point") long point);


}
