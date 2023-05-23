package com.ssafy.pjt.model.dao;

public interface DiaryPartDao {

	int insertDiaryPart(int diaryId, int partId);
	
	int deleteDiaryPart(int diaryId);
	
}
