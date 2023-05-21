package com.ssafy.pjt.model.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ssafy.pjt.model.dto.Achievement;

public interface AchievementDao {
	
	public List<Achievement> selectAll();
	
	public List<Achievement> selectByUser(int id);
}
