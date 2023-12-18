package com.easyfestival.www.repository;

import java.util.List;

import com.easyfestival.www.domain.AirplaneDTO;

public interface FreetourDAO {

	void insertList(AirplaneDTO airplaneDTO);

	List<AirplaneDTO> getSearch(String place);

	String getDepartureAirport(String departureAirport);

	String getArrivalAirport(String arrivalAirport);

}