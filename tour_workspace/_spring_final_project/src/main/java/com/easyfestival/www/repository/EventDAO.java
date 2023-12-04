package com.easyfestival.www.repository;

import java.util.List;

import com.easyfestival.www.domain.eventVO;

public interface EventDAO 
{

	int eventRegister(eventVO evo);

	List<eventVO> eventList();

	eventVO detail(int evNo);

	int eventRemove(int evNo);

	int eventModify(eventVO evo);

}
