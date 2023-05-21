package com.ssafy.pjt.achievement.model.dao;

import java.util.List;

import com.ssafy.pjt.achievement.model.dto.Achievement;

public interface AchievementDao {
	
	public List<Achievement> selectAll();
	
	public List<Achievement> selectByUser(int id);
}
