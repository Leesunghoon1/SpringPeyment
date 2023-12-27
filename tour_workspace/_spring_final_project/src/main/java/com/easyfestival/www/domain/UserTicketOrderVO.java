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
public class UserTicketOrderVO {
	
	private long utNo;
	private long pkNo;
	private String id;
	private String productName;
	private String cityName;

}
