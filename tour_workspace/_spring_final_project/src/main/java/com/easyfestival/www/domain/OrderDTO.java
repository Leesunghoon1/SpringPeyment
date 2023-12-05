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
public class OrderDTO {

	private Long orderNum;
	private Long productNum;
	private String id;
	private String pkNo;
	private Date orderDate;
	private Long totalPrice;
	private String impUid;
	
	
	
}