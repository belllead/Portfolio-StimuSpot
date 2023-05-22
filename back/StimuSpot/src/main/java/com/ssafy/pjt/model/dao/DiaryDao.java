package com.ssafy.pjt.model.dao;

import java.util.List;

import com.ssafy.pjt.model.dto.DiaryDto;
import com.ssafy.pjt.model.dto.DiaryQueryDto;

public interface DiaryDao {

	public List<DiaryDto> selectMany(DiaryQueryDto diaryList);

	public DiaryDto selectOne(DiaryQueryDto diaryOne);

	public int insertDiary(DiaryDto diary);

	public int deleteDiary(int id);

	public int updateDiary(DiaryDto diary);
}
