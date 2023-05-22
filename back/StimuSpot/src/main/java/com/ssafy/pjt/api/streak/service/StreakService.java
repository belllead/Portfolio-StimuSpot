package com.ssafy.pjt.api.streak.service;

import java.text.ParseException;
import java.util.List;

public interface StreakService {

	List<String> get30DayStreak() throws ParseException;
	
	int getLongestStreak();
	
	int getCurrentStreak() throws ParseException;
}
