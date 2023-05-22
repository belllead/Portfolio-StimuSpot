package com.ssafy.pjt.model.dao;

import java.util.List;

import com.ssafy.pjt.model.dto.StreakDto;

public interface StreakDao {

	List<StreakDto> select20Streak();
	
	int selectLongestStreak();
	
	StreakDto selectRecentStreak();
}
