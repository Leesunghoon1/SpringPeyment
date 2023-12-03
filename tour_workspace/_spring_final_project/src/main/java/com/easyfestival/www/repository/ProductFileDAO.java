package com.easyfestival.www.repository;

import java.util.List;

import com.easyfestival.www.domain.ProductBoardVO;
import com.easyfestival.www.domain.ProductFileVO;

public interface ProductFileDAO {

	int insertFile(ProductFileVO pfvo);

	ProductFileVO selectFile();

	List<ProductFileVO> getFileList();

	ProductFileVO getFile();

	List<ProductFileVO> getImgList();

	List<ProductFileVO> getImgDetail(long pkNo);


}
