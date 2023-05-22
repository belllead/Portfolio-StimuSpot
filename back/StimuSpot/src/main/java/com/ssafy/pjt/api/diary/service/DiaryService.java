package com.ssafy.pjt.api.diary.service;

import java.util.List;

import com.ssafy.pjt.model.dto.DiaryDto;
import com.ssafy.pjt.model.dto.DiaryQueryDto;

public interface DiaryService {
	
	// 전체 다이어리 조회
	List<DiaryDto> getDiaryList(DiaryQueryDto diaryList);
	
	// date와 userNum으로 다이어리 하나 조회
	DiaryDto readDiary(DiaryQueryDto diaryOne);
	
	// 다이어리 작성
	boolean writeDiary(DiaryDto diary);
	
	// 다이어리 삭제 
	boolean removeDiary(int id);
	
	// 다이어리 수정
	boolean modifyDiary(DiaryDto diary);

}
