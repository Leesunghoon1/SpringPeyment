package com.easyfestival.www.service;



import java.util.List;

import com.easyfestival.www.domain.ProductDTO;
import com.easyfestival.www.domain.ProductListDTO;


public interface ProductService {

	int register(ProductDTO productDTO);

	List<ProductListDTO> getdto(String pkContinent);

	List<ProductListDTO> getdtoDetail(long pkNo);

	int modify(ProductDTO productDTO);

	int removeProduct(long pkNo);

	int update(long totalPrice, long pkNoVal);
//	ProductListDTO productDetail(long pkNo);














	

	



	

	

}
