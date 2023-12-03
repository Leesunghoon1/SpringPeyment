package com.easyfestival.www.service;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.easyfestival.www.domain.AirplaneVO;
import com.easyfestival.www.domain.FestivalVO;
import com.easyfestival.www.domain.HotelVO;
import com.easyfestival.www.domain.PackageVO;
import com.easyfestival.www.domain.PlaceVO;
import com.easyfestival.www.domain.ProductBoardVO;
import com.easyfestival.www.domain.ProductDTO;
import com.easyfestival.www.domain.ProductFileVO;
import com.easyfestival.www.domain.ProductListDTO;
import com.easyfestival.www.repository.PackageDAO;
import com.easyfestival.www.repository.ProductDAO;
import com.easyfestival.www.repository.ProductFileDAO;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ProductServiceImpl implements ProductService{
	
	@Inject
	private ProductDAO pdao;
	
	@Inject
	private ProductFileDAO pfdao;
	
	@Inject
	private PackageDAO packdao;
	
	

	@Override
	public int register(ProductDTO pdto) {
		
		PackageVO pkvo = new PackageVO();
		pkvo.setPkName(pdto.getPbvo().getPdTitle());
		pkvo.setPkPrice(pdto.getPbvo().getFvPrice()+pdto.getPbvo().getHtPrice()+pdto.getPbvo().getApPrice());
		packdao.insert(pkvo);
		
		long pknumber = packdao.selectPkNo();
		
		log.info("pknumber >>" + pknumber);
		
		pdto.getPbvo().setPkNo(pknumber);
		
		int isUp = pdao.register(pdto.getPbvo());
		
		if(pdto.getPflist() == null) {
			isUp *= 1;
			return isUp;
		}
		
		if(isUp > 0 && pdto.getPflist().size() > 0) {
			long pdNo = pdao.selectPdNo();
			
			for(ProductFileVO pfvo : pdto.getPflist()) {
				pfvo.setPdNo(pdNo);
				isUp *= pfdao.insertFile(pfvo);
			}
		}
		
		
		return isUp;
	}



	@Override
	public List<PackageVO> getList() {
		// TODO Auto-generated method stub
		return packdao.getList();
	}



	@Override
	public long selectMax() {
		// TODO Auto-generated method stub
		return pdao.selectMax();
	}



	@Override
	public List<ProductFileVO> getFileList() {
		// TODO Auto-generated method stub
		return pfdao.getFileList();
	}



	@Override
	public ProductFileVO getFile() {
		// TODO Auto-generated method stub
		return pfdao.getFile();
	}



	@Override
	public List<ProductFileVO> getImgList() {
		// TODO Auto-generated method stub
		return pfdao.getImgList();
	}



	@Override
	public List<PlaceVO> getPlace() {
		// TODO Auto-generated method stub
		return pdao.getPlace();
	}



	@Override
	public ProductDTO getDetail(long pkNo) {
		// productvo , filevo
		ProductBoardVO pbvo = pdao.getDetail(pkNo);
		List<ProductFileVO> pfvo = pfdao.getImgDetail(pkNo);
		
		return new ProductDTO(pbvo,pfvo);
	}



	@Override
	public PlaceVO getPlaceDetail(long pkNo) {
		// TODO Auto-generated method stub
		return pdao.getPlaceDetail(pkNo);
	}



	@Override
	public HotelVO getHotelDetail(long pkNo) {
		// TODO Auto-generated method stub
		return pdao.getHotelDetail(pkNo);
	}



	@Override
	public AirplaneVO getAirplaneDetail(long pkNo) {
		// TODO Auto-generated method stub
		return pdao.getAirplaneDetail(pkNo);
	}



	@Override
	public FestivalVO getFestivalVoDetail(long pkNo) {
		// TODO Auto-generated method stub
		return pdao.getFestivalVoDetail(pkNo);
	}



	@Override
	public PackageVO getPackageDetail(long pkNo) {
		// TODO Auto-generated method stub
		return packdao.getPackageDetail(pkNo);
	}







	



	


	



	




	



	

	

	

	

	
	
	
	
	
	


}
