package com.easyfestival.www.domain;

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
public class MemberShipVO {
	
	private String id;
	private long totalPrice;
	private long point;
	private String grade;
	
	public void setTotalPrice(long totalPrice) {
		this.totalPrice = totalPrice;
	}
	
}