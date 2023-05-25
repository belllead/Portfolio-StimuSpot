package com.ssafy.pjt.model.dao;

public interface UserPartDao {

	String getLastWorkout(int userNum, int partId);
	
	int updateLastWorkout(int userNum, int partId, String lastWorkout);
}
