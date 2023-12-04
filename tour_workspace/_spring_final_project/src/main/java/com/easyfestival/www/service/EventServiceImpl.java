package com.easyfestival.www.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.easyfestival.www.domain.eventVO;
import com.easyfestival.www.repository.EventDAO;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EventServiceImpl implements EventService
{
	@Inject	
	private EventDAO edao;

	@Override
	public int eventRegister(eventVO evo) {
		return edao.eventRegister(evo);
	}

	@Override
	public List<eventVO> list() {
		return edao.eventList();
	}

	@Override
	public eventVO detail(int evNo) {
		return edao.detail(evNo);
	}

	@Override
	public int eventRemove(int evNo) {
		return edao.eventRemove(evNo);
	}

	@Override
	public int eventModify(eventVO evo) {
		return edao.eventModify(evo);
	}

	

}
