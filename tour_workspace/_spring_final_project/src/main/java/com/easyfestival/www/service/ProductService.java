package com.easyfestival.www.service;



import java.util.List;

import com.easyfestival.www.domain.AirplaneVO;
import com.easyfestival.www.domain.FestivalVO;
import com.easyfestival.www.domain.HotelVO;
import com.easyfestival.www.domain.PackageVO;
import com.easyfestival.www.domain.PlaceVO;
import com.easyfestival.www.domain.ProductDTO;
import com.easyfestival.www.domain.ProductFileVO;
import com.easyfestival.www.domain.ProductListDTO;


public interface ProductService {

	int register(ProductDTO productDTO);

	List<PackageVO> getList();

	long selectMax();

	List<ProductFileVO> getFileList();

	ProductFileVO getFile();

	List<ProductFileVO> getImgList();

	List<PlaceVO> getPlace();

	ProductDTO getDetail(long pkNo);

	PlaceVO getPlaceDetail(long pkNo);

	HotelVO getHotelDetail(long pkNo);

	AirplaneVO getAirplaneDetail(long pkNo);

	FestivalVO getFestivalVoDetail(long pkNo);

	PackageVO getPackageDetail(long pkNo);









	

	



	

	

}
