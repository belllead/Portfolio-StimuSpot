package com.ssafy.pjt.api.todayluck.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.pjt.model.dao.TodayLuckDao;
import com.ssafy.pjt.model.dto.TodayLuckDto;

@Service
public class TodayluckServiceImpl implements TodayluckService{

	@Autowired
	TodayLuckDao dao;
	
	@Override
	public TodayLuckDto getRandomLuck(int luckId) {
		return dao.selectRandomLuck(luckId);
	}
}
