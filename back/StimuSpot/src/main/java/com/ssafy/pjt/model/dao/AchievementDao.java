package com.ssafy.pjt.model.dao;

import java.util.List;

import com.ssafy.pjt.model.dto.AchievementDto;

public interface AchievementDao {
	
	List<AchievementDto> selectAll();
	
	List<AchievementDto> selectByUser(int userNum);
}
