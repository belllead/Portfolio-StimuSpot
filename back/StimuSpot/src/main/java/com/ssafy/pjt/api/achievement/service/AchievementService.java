package com.ssafy.pjt.api.achievement.service;

import java.util.List;

import com.ssafy.pjt.model.dto.Achievement;

public interface AchievementService {

	// 전체 업적 조회
	public List<Achievement> getAchievementList();
		
	// user 정보로 업적 조희 
	public List<Achievement> getAchievementByUser(int id); 
}
