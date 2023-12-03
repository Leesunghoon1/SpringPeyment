package com.easyfestival.www.repository;


import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.easyfestival.www.domain.AirplaneVO;
import com.easyfestival.www.domain.FestivalVO;
import com.easyfestival.www.domain.HotelVO;
import com.easyfestival.www.domain.PlaceVO;
import com.easyfestival.www.domain.ProductBoardVO;



public interface ProductDAO {

	int register(ProductBoardVO pbvo);

	long selectPdNo();

	long selectMax();

	List<PlaceVO> getPlace();

	ProductBoardVO getDetail(long pkNo);

	PlaceVO getPlaceDetail(long pkNo);

	HotelVO getHotelDetail(long pkNo);

	AirplaneVO getAirplaneDetail(long pkNo);

	FestivalVO getFestivalVoDetail(long pkNo);

	


	



}
