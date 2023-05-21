package com.ssafy.pjt.api.diary.service;

import java.util.List;

import com.ssafy.pjt.model.dto.Diary;



public interface DiaryService {
	
	// 전체 다이어리 조회
	public List<Diary> getDiaryList();
	
	// id로 다이어리 조희 
	public Diary readDiaryById(int id); 
	
	// date로 다이어리 조회
	public Diary readDiaryByDate(String date);
	
	// 다이어리 작성
	public boolean writeDiary(Diary diary);
	
	// 다이어리 삭제 
	public boolean removeDiary(int id);
	
	// 다이어리 수정
	public boolean modifyDiary(int id);

}
