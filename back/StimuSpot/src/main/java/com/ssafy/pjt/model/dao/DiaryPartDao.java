package com.ssafy.pjt.model.dao;

import java.util.List;

import com.ssafy.pjt.model.dto.PartDto;

public interface DiaryPartDao {

	int insertDiaryPart(int diaryId, int partId);
	
	int deleteDiaryPart(int diaryId);
	
	List<PartDto> selectDiaryPart(int diaryId);
	
}
