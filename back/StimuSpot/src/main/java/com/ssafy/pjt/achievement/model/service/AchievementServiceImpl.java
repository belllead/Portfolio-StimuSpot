package com.ssafy.pjt.achievement.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.pjt.achievement.model.dao.AchievementDao;
import com.ssafy.pjt.achievement.model.dto.Achievement;

@Service
public class AchievementServiceImpl implements AchievementService{
	
	private AchievementDao achievementDao;

	@Autowired
	public void setAchievementDao(AchievementDao achievementDao) {
		this.achievementDao = achievementDao;
	}

	@Override
	public List<Achievement> getAchievementList() {
		return achievementDao.selectAll();
	}

	@Override
	public List<Achievement> getAchievementByUser(int id) {
		return achievementDao.selectByUser(id);
	}
}
