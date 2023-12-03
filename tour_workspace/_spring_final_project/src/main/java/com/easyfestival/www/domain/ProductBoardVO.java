package com.easyfestival.www.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ProductBoardVO {
	
	private long pdNo; // 번호
	private String pdTitle; // 상품제목
	private String pdContents; // 상품내용
	private long apPrice; // 비행기가격
	private String apArrival; // 출발
	private String apDeparture; // 도착
	private String plCountry; // 국가
	private String plName; // 지역
	private String fvName; // 축제이름
	private long fvPrice; // 축제 참가비
	private String htName; // 호텔명
	private long htPrice; // 호텔가격
	private long pkNo;
	
}
