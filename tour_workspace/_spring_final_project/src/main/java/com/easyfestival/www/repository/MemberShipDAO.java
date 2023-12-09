package com.easyfestival.www.repository;

import org.apache.ibatis.annotations.Param;



public interface MemberShipDAO {
	
	void saveGrade(@Param("id") String id, @Param("grade") String grade);

	void savePoints(@Param("id") String id, @Param("point") long point, @Param("totalPrice") Long totalPrice);


}
