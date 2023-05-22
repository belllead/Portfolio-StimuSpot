package com.ssafy.pjt.model.dao;

import com.ssafy.pjt.model.dto.TodayLuckDto;

public interface TodayLuckDao {

	TodayLuckDto selectRandomLuck(int luckId);
	
}
