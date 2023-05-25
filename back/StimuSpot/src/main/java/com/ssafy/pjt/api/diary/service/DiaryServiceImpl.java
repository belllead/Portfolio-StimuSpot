package com.ssafy.pjt.api.diary.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.pjt.model.dao.DiaryDao;
import com.ssafy.pjt.model.dao.DiaryPartDao;
import com.ssafy.pjt.model.dao.UserPartDao;
import com.ssafy.pjt.model.dto.DiaryDto;
import com.ssafy.pjt.model.dto.DiaryQueryDto;
import com.ssafy.pjt.model.dto.PartDto;

@Service
public class DiaryServiceImpl implements DiaryService{

	@Autowired
	DiaryDao diaryDao;
	
	@Autowired
	DiaryPartDao diaryPartDao;
	
	@Autowired
	UserPartDao userPartDao;

	@Override
	public List<DiaryDto> getDiaryList(DiaryQueryDto diaryList) {
		return diaryDao.selectMany(diaryList);
	}

	@Override
	public DiaryDto readDiary(DiaryQueryDto diaryOne) {
		DiaryDto result = diaryDao.selectOne(diaryOne);
		List<PartDto> parts = diaryPartDao.selectDiaryPart(result.getDiaryId());
		
		List<String> partList = new ArrayList<>();
		
		for (int i=0; i<parts.size(); i++) {
			partList.add(parts.get(i).getPartName());
		}
		
		result.setPartNames(partList);
		return result;
	}

	@Override
	public boolean writeDiary(DiaryDto diary) {
		int result = diaryDao.insertDiary(diary);
		
		for (int i=0; i<diary.getPartIds().size(); i++) {
			diaryPartDao.insertDiaryPart(diary.getDiaryId(), diary.getPartIds().get(i));
			
			String currentLastWorkout = userPartDao.getLastWorkout(diary.getUserNum(), diary.getPartIds().get(i));
			
//			System.out.println(currentLastWorkout.replace("-", ""));
//			System.out.println(diary.getDiaryRegdate());
			int curr = 0;
			
			try {
				curr = Integer.parseInt(currentLastWorkout.replace("-", "")); 
			} catch (Exception e) {
				curr = 0;
			}

			int neww = 0;
			try {
				neww = Integer.parseInt(diary.getDiaryRegdate());
			} catch (Exception e) {
				neww = Integer.parseInt(diary.getDiaryRegdate().replace("-", ""));
			}
//			System.out.println(curr < neww);
			
			if (curr < neww) {
				userPartDao.updateLastWorkout(diary.getUserNum(), diary.getPartIds().get(i), diary.getDiaryRegdate());
//				System.out.println("executed" + i);
			}
		}
		
		return result > 0;
	}

	@Override
	public boolean removeDiary(int diaryId) {
		int result = diaryPartDao.deleteDiaryPart(diaryId);
		result = Math.min(result, diaryDao.deleteDiary(diaryId));
		return result > 0;
	}

	@Override
	public boolean modifyDiary(DiaryDto diary) {
		int result = diaryPartDao.deleteDiaryPart(diary.getDiaryId());
		
		for (int i=0; i<diary.getPartIds().size(); i++)
			result = Math.min(result, diaryPartDao.insertDiaryPart(diary.getDiaryId(), diary.getPartIds().get(i)));
		
		return diaryDao.updateDiary(diary) > 0;
	}

}
