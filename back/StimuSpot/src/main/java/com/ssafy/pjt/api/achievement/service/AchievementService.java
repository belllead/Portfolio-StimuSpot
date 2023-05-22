package com.ssafy.pjt.api.achievement.service;

import java.util.List;

import com.ssafy.pjt.model.dto.AchievementDto;

public interface AchievementService {

	// 전체 업적 조회
	List<AchievementDto> getAchievementList();
		
	// user 정보로 업적 조희 
	List<AchievementDto> getAchievementByUser(int userNum); 
}
