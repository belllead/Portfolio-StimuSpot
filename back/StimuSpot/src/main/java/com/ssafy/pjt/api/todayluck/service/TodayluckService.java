package com.ssafy.pjt.api.todayluck.service;

import com.ssafy.pjt.model.dto.TodayLuckDto;

public interface TodayluckService {

	TodayLuckDto getRandomLuck(int luckId);
}
