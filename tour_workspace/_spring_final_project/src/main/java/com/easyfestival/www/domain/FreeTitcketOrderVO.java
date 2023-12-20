package com.easyfestival.www.domain;

import java.sql.Date;

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
public class FreeTitcketOrderVO {
	
	  
	  private long ftNo;
	  private char airplane;
	  private String cityName;
	  private String departureDay;
	  private String arruvalDay;
	  private String seatType;
	  private String flightType;
	  private String airportCode;
	  private long ftPrice;
	  private long ftPeple;

}
