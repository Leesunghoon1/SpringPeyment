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
	private Long num;
	private String productName;
	private Date orderDate;
	private Long totalPrice;
	private String imp_uid;
	private Long resurNum;
	
	
	
}