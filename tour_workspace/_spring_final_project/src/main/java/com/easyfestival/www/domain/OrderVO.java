package com.easyfestival.www.domain;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OrderVO {

	private Long orderNum;
	private String id;
	private Date orderDate;
	private Long totalPrice;
	private String impUid;
	private Long userCount;
	private Long usePoint;
	private char confirmation;
    private String orderType;
    private long pkNo;
    
    
    private String productContent;
    private String pkContinent;
    private String productName;
    private String cityName;
    private String pkContent;
    
	
}