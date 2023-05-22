package com.ssafy.pjt.model.dao;

import java.util.List;

import com.ssafy.pjt.model.dto.Diary;

public interface DiaryDao {

	public List<Diary> selectAll();

	public Diary selectOneById(int id);
	
	public Diary selectOneByDate(String date);

	public int insertDiary(Diary diary);

	public int deleteDiary(int id);

	public int updateDiary(int id);
}
