package com.easyfestival.www.domain;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ProductListDTO {
	
	private List<PackageVO> packList;
	private List<ProductFileVO> pfList;
	//private ProductFileVO pfvo;
	
	
	
}
