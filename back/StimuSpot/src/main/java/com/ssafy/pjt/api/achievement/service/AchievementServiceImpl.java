package com.ssafy.pjt.api.achievement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.pjt.model.dao.AchievementDao;
import com.ssafy.pjt.model.dto.AchievementDto;

@Service
public class AchievementServiceImpl implements AchievementService{
	
	@Autowired
	private AchievementDao achievementDao;

	@Override
	public List<AchievementDto> getAchievementList() {
		return achievementDao.selectAll();
	}

	@Override
	public List<AchievementDto> getAchievementByUser(int userNum) {
		return achievementDao.selectByUser(userNum);
	}
}
